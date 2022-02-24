/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure.condition;

import org.springframework.boot.autoconfigure.AutoConfigurationMetadata;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type;
import org.springframework.boot.web.reactive.context.ConfigurableReactiveWebEnvironment;
import org.springframework.boot.web.reactive.context.ReactiveWebApplicationContext;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.ConfigurableWebEnvironment;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

/**
 * {@link Condition} that checks for the presence or absence of
 * {@link WebApplicationContext}.
 *
 * @author Dave Syer
 * @author Phillip Webb
 * @see ConditionalOnWebApplication
 * @see ConditionalOnNotWebApplication
 */
@Order(Ordered.HIGHEST_PRECEDENCE + 20)
class OnWebApplicationCondition extends FilteringSpringBootCondition {

	private static final String SERVLET_WEB_APPLICATION_CLASS = "org.springframework.web.context.support.GenericWebApplicationContext";
	private static final String REACTIVE_WEB_APPLICATION_CLASS = "org.springframework.web.reactive.HandlerResult";

    @Override // 来自 FilteringSpringBootCondition 抽象类
	protected ConditionOutcome[] getOutcomes(String[] autoConfigurationClasses, AutoConfigurationMetadata autoConfigurationMetadata) {
        // 创建 outcomes 结果数组
		ConditionOutcome[] outcomes = new ConditionOutcome[autoConfigurationClasses.length];
		// 遍历 autoConfigurationClasses 数组，执行匹配
		for (int i = 0; i < outcomes.length; i++) {
		    // 获得配置类
			String autoConfigurationClass = autoConfigurationClasses[i];
			if (autoConfigurationClass != null) {
			    // 执行匹配
				outcomes[i] = getOutcome(autoConfigurationMetadata.get(autoConfigurationClass,  "ConditionalOnWebApplication")); // 获得 @ConditionalOnWebApplication 注解
			}
		}
		return outcomes;
	}

	private ConditionOutcome getOutcome(String type) {
		if (type == null) {
			return null;
		}
		ConditionMessage.Builder message = ConditionMessage.forCondition(ConditionalOnWebApplication.class);
		// 如果要求 SERVLET 类型，结果不存在 SERVLET_WEB_APPLICATION_CLASS 类，返回不匹配
		if (ConditionalOnWebApplication.Type.SERVLET.name().equals(type)) {
			if (!ClassNameFilter.isPresent(SERVLET_WEB_APPLICATION_CLASS, getBeanClassLoader())) {
				return ConditionOutcome.noMatch(message.didNotFind("servlet web application classes").atAll());
			}
		}
		// 如果要求 REACTIVE 类型，结果不存在 REACTIVE_WEB_APPLICATION_CLASS 类，返回不匹配
		if (ConditionalOnWebApplication.Type.REACTIVE.name().equals(type)) {
			if (!ClassNameFilter.isPresent(REACTIVE_WEB_APPLICATION_CLASS, getBeanClassLoader())) {
				return ConditionOutcome.noMatch(message.didNotFind("reactive web application classes").atAll());
			}
		}
		// 如果 SERVLET_WEB_APPLICATION_CLASS 和 REACTIVE_WEB_APPLICATION_CLASS 都不存在，返回不匹配
		if (!ClassNameFilter.isPresent(SERVLET_WEB_APPLICATION_CLASS, getBeanClassLoader())
				&& !ClassUtils.isPresent(REACTIVE_WEB_APPLICATION_CLASS, getBeanClassLoader())) {
			return ConditionOutcome.noMatch(message.didNotFind("reactive or servlet web application classes").atAll());
		}
		return null;
	}

    @Override // 来自 SpringBootCondition 抽象类
	public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 通过是否有 @ConditionalOnWebApplication 注解，判断是否要求在 Web 环境下
		boolean required = metadata.isAnnotated(ConditionalOnWebApplication.class.getName());
		// 判断是否匹配 Web 环境
		ConditionOutcome outcome = isWebApplication(context, metadata, required);
		// 如果要求，结果不匹配 Web 环境，返回最终不匹配
		if (required && !outcome.isMatch()) {
			return ConditionOutcome.noMatch(outcome.getConditionMessage());
		}
		// 如果不要求，结果匹配 Web 环境，返回最终不匹配
		if (!required && outcome.isMatch()) {
			return ConditionOutcome.noMatch(outcome.getConditionMessage());
		}
		// 返回匹配
		return ConditionOutcome.match(outcome.getConditionMessage());
	}

	private ConditionOutcome isWebApplication(ConditionContext context, AnnotatedTypeMetadata metadata, boolean required) {
		switch (deduceType(metadata)) { // 获得要求的 Web 类型
            case SERVLET:
                return isServletWebApplication(context); // 判断是否 Servlet Web 环境
            case REACTIVE:
                return isReactiveWebApplication(context); // 判断是否 Reactive Web 环境
            default:
                return isAnyWebApplication(context, required); // 判断是否为任意 Web 环境
		}
	}

	private ConditionOutcome isAnyWebApplication(ConditionContext context, boolean required) {
		ConditionMessage.Builder message = ConditionMessage.forCondition(ConditionalOnWebApplication.class, required ? "(required)" : "");
		// 如果是 Servlet 环境，并且要求 WEB 环境，返回匹配
		ConditionOutcome servletOutcome = isServletWebApplication(context);
		if (servletOutcome.isMatch() && required) {
			return new ConditionOutcome(servletOutcome.isMatch(), message.because(servletOutcome.getMessage()));
		}
        // 如果是 Reactive 环境，并且要求 WEB 环境，返回匹配
        ConditionOutcome reactiveOutcome = isReactiveWebApplication(context);
		if (reactiveOutcome.isMatch() && required) {
			return new ConditionOutcome(reactiveOutcome.isMatch(), message.because(reactiveOutcome.getMessage()));
		}
		// 根据情况，返回是否匹配
		return new ConditionOutcome(servletOutcome.isMatch() || reactiveOutcome.isMatch(), // 要求 Servlet 环境 or Reactive 环境，其中有一个匹配
				message.because(servletOutcome.getMessage()).append("and").append(reactiveOutcome.getMessage()));
	}

	private ConditionOutcome isServletWebApplication(ConditionContext context) {
		ConditionMessage.Builder message = ConditionMessage.forCondition("");
		// 如果不存在 SERVLET_WEB_APPLICATION_CLASS 类，返回不匹配
		if (!ClassNameFilter.isPresent(SERVLET_WEB_APPLICATION_CLASS, context.getClassLoader())) {
			return ConditionOutcome.noMatch(message.didNotFind("servlet web application classes").atAll());
		}
		if (context.getBeanFactory() != null) {
		    // 如果不存在 session scope ，返回不匹配
			String[] scopes = context.getBeanFactory().getRegisteredScopeNames();
			if (ObjectUtils.containsElement(scopes, "session")) {
				return ConditionOutcome.match(message.foundExactly("'session' scope"));
			}
		}
		// 如果 environment 是 ConfigurableWebEnvironment 类型，返回匹配！！！
		if (context.getEnvironment() instanceof ConfigurableWebEnvironment) {
			return ConditionOutcome.match(message.foundExactly("ConfigurableWebEnvironment"));
		}
		// 如果 resourceLoader 是 WebApplicationContext 类型，返回匹配！！！
		if (context.getResourceLoader() instanceof WebApplicationContext) {
			return ConditionOutcome.match(message.foundExactly("WebApplicationContext"));
		}
		// 如果 resourceLoader 不是 WebApplicationContext 类型，返回不匹配
		return ConditionOutcome.noMatch(message.because("not a servlet web application"));
	}

	private ConditionOutcome isReactiveWebApplication(ConditionContext context) {
		ConditionMessage.Builder message = ConditionMessage.forCondition("");
        // 如果不存在 REACTIVE_WEB_APPLICATION_CLASS 类，返回不匹配
		if (!ClassNameFilter.isPresent(REACTIVE_WEB_APPLICATION_CLASS, context.getClassLoader())) {
			return ConditionOutcome.noMatch(message.didNotFind("reactive web application classes").atAll());
		}
        // 如果 environment 是 ConfigurableReactiveWebEnvironment 类型，返回匹配
		if (context.getEnvironment() instanceof ConfigurableReactiveWebEnvironment) {
			return ConditionOutcome.match(message.foundExactly("ConfigurableReactiveWebEnvironment"));
		}
        // 如果 resourceLoader 是 ConfigurableReactiveWebEnvironment 类型，返回匹配
        if (context.getResourceLoader() instanceof ReactiveWebApplicationContext) {
			return ConditionOutcome.match(message.foundExactly("ReactiveWebApplicationContext"));
		}
        // 返回不匹配
		return ConditionOutcome.noMatch(message.because("not a reactive web application"));
	}

	private Type deduceType(AnnotatedTypeMetadata metadata) {
		Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnWebApplication.class.getName());
		if (attributes != null) {
			return (Type) attributes.get("type");
		}
		return Type.ANY;
	}

}
