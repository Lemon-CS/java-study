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

package org.springframework.boot.env;

import org.springframework.boot.origin.Origin;
import org.springframework.boot.origin.OriginLookup;
import org.springframework.boot.origin.OriginTrackedValue;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

/**
 * {@link OriginLookup} backed by a {@link Map} containing {@link OriginTrackedValue
 * OriginTrackedValues}.
 *
 * @author Madhura Bhave
 * @author Phillip Webb
 * @since 2.0.0
 * @see OriginTrackedValue
 */
public final class OriginTrackedMapPropertySource extends MapPropertySource
		implements OriginLookup<String> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public OriginTrackedMapPropertySource(String name, Map source) {
		super(name, source);
	}

	@Override
	public Object getProperty(String name) {
	    // 获得属性值
		Object value = super.getProperty(name);
		// 如果是 OriginTrackedValue 封装类型，则返回其真实的值
		if (value instanceof OriginTrackedValue) {
			return ((OriginTrackedValue) value).getValue();
		}
		return value;
	}

	@Override
	public Origin getOrigin(String name) {
        // 获得属性值
        Object value = super.getProperty(name);
        // 如果是 OriginTrackedValue 封装类型，则返回其 Origin
		if (value instanceof OriginTrackedValue) {
			return ((OriginTrackedValue) value).getOrigin();
		}
		return null;
	}

}