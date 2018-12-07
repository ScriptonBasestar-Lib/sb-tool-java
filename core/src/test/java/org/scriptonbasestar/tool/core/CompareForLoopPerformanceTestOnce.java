package org.scriptonbasestar.tool.core;

import lombok.Data;
import org.junit.Test;

import java.lang.reflect.Field;

public class CompareForLoopPerformanceTestOnce {

	@Data
	class Dog {
		private String name;
		private String height;
		private String weight;
		private String weight2;
		private String weight3;
		private String weight4;
		private String weight5;
		private String weight6;
		private String weight7;
		private String weight8;
		private String weight11;
		private String weight12;
		private String weight13;
		private String weight15;
		private String weight123;
		private String weight12312;
		private String weight512;
		private String weight61;
		private String weight51;
		private String weight66;
		private String weight71;
		private String weight72;
	}

	public static final Field[] fields = Dog.class.getDeclaredFields();

	@Test
	public void forintloop() {
		Field fieldResult;
		for (int i = 0; i < 10000000; i++) {
			for (int j = 0; j < fields.length; j++) {
				fieldResult = fields[j];
			}
		}
	}

	@Test
	public void foreachloop() {
		Field fieldResult;
		for (int i = 0; i < 10000000; i++) {
			for (Field field : fields) {
				fieldResult = field;
			}
		}
	}
}
