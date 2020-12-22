/*
 * Copyright (C) 2020 Adam Huang <poisondog@gmail.com>
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
package poisondog.servlet;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam Huang
 * @since 2020-12-22
 */
@RestController
@RequestMapping("/api/demo")
public class RestDemo {
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "{\"id\":\"1\",\"name\":\"1111111111\"}";
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String get(@PathVariable("id") Integer id) {
		return "{\"id\":\"" + id + "\",\"name\":\"get path variable id\"}";
	}
	@RequestMapping(method = RequestMethod.PUT)
	public String put() {
		return "{\"id\":\"3\",\"name\":\"3333333333\"}";
	}
	@RequestMapping(method = RequestMethod.DELETE)
	public String delete() {
		return "{\"id\":\"4\",\"name\":\"4444444444\"}";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String post() {
		return "{\"id\":\"2\",\"name\":\"2222222222\"}";
	}
}
