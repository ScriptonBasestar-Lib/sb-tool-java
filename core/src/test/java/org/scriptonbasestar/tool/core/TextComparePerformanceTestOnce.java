package org.scriptonbasestar.tool.core;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * 텍스트 비교가 여러개일 때 성능체크
 */
public class TextComparePerformanceTestOnce {

	public static String[] extractFieldNamesCompareStartWith(Object source) {
		Class sourceClass = source.getClass();
		Set<String> fieldNames = new HashSet<>();
		Field[] fields = sourceClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			//java this$0
			//groovy [name, height, weight, $staticClassInfo, __$stMC, metaClass, null, $staticClassInfo$, $callSiteArray]
			if (fields[i].getName().startsWith("$") ||
				fields[i].getName().startsWith("__$") ||
				fields[i].getName().startsWith("metaClass") ||
				fields[i].getName().startsWith("this$0")
			) {
				continue;
			}
			fieldNames.add(fields[i].getName());
		}
		return fieldNames.toArray(new String[fieldNames.size()]);
	}

	//java this$0
	//groovy [name, height, weight, $staticClassInfo, __$stMC, metaClass, null, $staticClassInfo$, $callSiteArray]
	private static final String pattern = "$($)(__$)(metaClass)(this$0)";

	public static String[] extractFieldNamesCompareRegex(Object source) {
		Class sourceClass = source.getClass();
		Set<String> fieldNames = new HashSet<>();
		Field[] fields = sourceClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().matches(pattern)) {
				continue;
			}
			fieldNames.add(fields[i].getName());
		}
		return fieldNames.toArray(new String[fieldNames.size()]);
	}

	@Data
	class Dog {
		private String name;
		private String height;
		private String weight;
	}

	@Test
	public void test1() {
		for (int i = 0; i < 10000; i++) {
			Dog dog = new Dog();
			dog.setName("kkkkk1");
			dog.setHeight("kkkkk2");
			dog.setHeight("kkkkk3");
			extractFieldNamesCompareStartWith(dog);
		}
	}

	@Test
	public void test2() {
		for (int i = 0; i < 10000; i++) {
			Dog dog = new Dog();
			dog.setName("kkkkk1");
			dog.setHeight("kkkkk2");
			dog.setHeight("kkkkk3");
			extractFieldNamesCompareRegex(dog);
		}
	}

}
