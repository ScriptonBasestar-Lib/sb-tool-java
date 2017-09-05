package org.scriptonbasestar.tool.core.reflection;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scriptonbasestar.tool.core.exception.BSReflectionException;

import java.lang.reflect.Field;

/**
 * @author archmagece
 * @with beansugar-sso-parent
 * @since 2014-11-21-20
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReflectionUtil {

	private static final String get = "get";
	private static final String set = "set";
	private static final String is = "is";

	public static String commonGetterNameCreator(String name) {
		return get + name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	public static String commonSetterNameCreator(String name) {
		return set + name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	public static String isGetterNameCreator(String name) {
		return is + name.substring(0, 1).toUpperCase() + name.substring(1);
	}


	public static <T> T copyValueTo(Object source, T target) {
		Class sourceClass = source.getClass();
		Class targetClass = target.getClass();

		String[] fieldNames = new String[sourceClass.getDeclaredFields().length];
		Field[] fields = sourceClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().equals("this$0")) {
				continue;
			}
			fieldNames[i] = fields[i].getName();
		}
		return copyValueTo(source, target, fieldNames);
	}

	public static <T> T copyValueTo(Object source, T target, String... fieldNames) {
		Class sourceClass = source.getClass();
		Class targetClass = target.getClass();
		Field sourceField;
		Field targetField;
		for (String fieldName : fieldNames) {
			try {
				sourceField = sourceClass.getDeclaredField(fieldName);
				sourceField.setAccessible(true);
				targetField = targetClass.getDeclaredField(fieldName);
				targetField.setAccessible(true);
				targetField.set(target, sourceField.get(source));
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return target;
	}


	/**
	 * source에서 fieldName을 가진 필드가 getter가 있을 경우 값을 리턴.
	 *
	 * @param source
	 * @param fieldName
	 * @return
	 */
	public static <T> T getValue(Object source, String fieldName, Class<T> clazz) {
		return (T) getValue(source, fieldName);
	}

	public static Object getValue(Object source, String fieldName) {
		Class sourceClass = source.getClass();
		Field field;
		try {
			field = sourceClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(source);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			throw new BSReflectionException("NoSuchFieldException is occurred");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new BSReflectionException("NoSuchFieldException is occurred");
		}
	}


	public static void setValue(Object source, String fieldName, Object value) {
		Class sourceClass = source.getClass();
		Field field;
		try {
			field = sourceClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(source, value);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			throw new BSReflectionException("NoSuchFieldException is occurred");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new BSReflectionException("NoSuchFieldException is occurred");
		}
	}
}
