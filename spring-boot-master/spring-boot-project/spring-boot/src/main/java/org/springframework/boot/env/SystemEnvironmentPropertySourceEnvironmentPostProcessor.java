/*
 * Copyright 2012-2017 the original author or authors.
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

package org.springframework.boot.env;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.origin.Origin;
import org.springframework.boot.origin.OriginLookup;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.env.SystemEnvironmentPropertySource;

import java.util.Map;

/**
 * An {@link EnvironmentPostProcessor} that replaces the systemEnvironment
 * {@link SystemEnvironmentPropertySource} with an
 * {@link OriginAwareSystemEnvironmentPropertySource} that can track the
 * {@link SystemEnvironmentOrigin} for every system environment property.
 *
 * @author Madhura Bhave
 * @since 2.0.0
 */
public class SystemEnvironmentPropertySourceEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {

	/**
     * 默认的 {@link #order} 的排序
	 * The default order for the processor.
	 */
	public static final int DEFAULT_ORDER = SpringApplicationJsonEnvironmentPostProcessor.DEFAULT_ORDER - 1;

    /**
     * 排序
     */
	private int order = DEFAULT_ORDER;

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		// 获得 systemEnvironment 对应的 PropertySource 属性源
	    String sourceName = StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME;
		PropertySource<?> propertySource = environment.getPropertySources().get(sourceName);
		// 将原始的 PropertySource 对象，替换成 OriginAwareSystemEnvironmentPropertySource 对象
		if (propertySource != null) {
			replacePropertySource(environment, sourceName, propertySource);
		}
	}

	@SuppressWarnings("unchecked")
	private void replacePropertySource(ConfigurableEnvironment environment, String sourceName, PropertySource<?> propertySource) {
		Map<String, Object> originalSource = (Map<String, Object>) propertySource.getSource();
		// 创建 SystemEnvironmentPropertySource 对象
		SystemEnvironmentPropertySource source = new OriginAwareSystemEnvironmentPropertySource(sourceName, originalSource);
		// 进行替换
		environment.getPropertySources().replace(sourceName, source);
	}

	@Override
	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * {@link SystemEnvironmentPropertySource} that also tracks {@link Origin}.
	 */
	protected static class OriginAwareSystemEnvironmentPropertySource
			extends SystemEnvironmentPropertySource implements OriginLookup<String> {

		OriginAwareSystemEnvironmentPropertySource(String name, Map<String, Object> source) {
			super(name, source);
		}

		@Override
		public Origin getOrigin(String key) {
		    // 解析 key 对应的 property
			String property = resolvePropertyName(key);
			// 判断是否存在 property 对应的值。如果存在，则返回 SystemEnvironmentOrigin 对象
			if (super.containsProperty(property)) {
				return new SystemEnvironmentOrigin(property);
			}
			// 不存在，则返回 null
			return null;
		}

	}

}
