/*
 * Copyright (C) 2015 Adam Huang <poisondog@gmail.com>
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
package poisondog.demo;

import java.lang.Class;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adam Huang <poisondog@gmail.com>
 */
public class Demo {
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getName());
		return builder.toString();
	}
	private static List<String> getMethods(Class clz) {
		List<String> publics = new ArrayList<String>();
		List<String> protecteds = new ArrayList<String>();
		List<String> privates = new ArrayList<String>();
		while (clz != null) {
			for (Method method : clz.getDeclaredMethods()) {
				int modifiers = method.getModifiers();
				if (Modifier.isPrivate(modifiers)) {
					privates.add(method.toString());
				}
				if (Modifier.isProtected(modifiers)) {
					protecteds.add(method.toString());
				}
				if (Modifier.isPublic(modifiers)) {
					publics.add(method.toString());
				}
			}
			clz = clz.getSuperclass();
		}
		List<String> result = new ArrayList<String>();
		result.addAll(privates);
		result.addAll(protecteds);
		result.addAll(publics);
		return result;
	}

	public static void main (String [] args){
		System.out.println(System.currentTimeMillis());
		Demo de = new Demo();
		System.out.println("getName(): " + Demo.class.toString());
		System.out.println(new Hello());
		for (int in = 0; in < 100; in++) {
			System.out.println("08:" + (int)(Math.random() * 25 + 30) + " → " + String.format("18:%02d", (int)(Math.random() * 12)));
		}
		System.out.println("1,00abj20hw".replaceAll("\\D", ""));
		for (String line : getMethods(Demo.class)) {
			System.out.println(line);
		}

	}
}
