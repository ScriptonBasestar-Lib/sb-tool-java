package org.scriptonbasestar.tool.core.reflection;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scriptonbasestar.tool.core.exception.runtime.SBReflectionException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

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

	public static String createGetterName(String name) {
		char[] charArr = name.toCharArray();
		charArr[0] = Character.toUpperCase(charArr[0]);
		return new StringBuilder(get).append(charArr).toString();
	}

	public static String createSetterName(String name) {
		return set + name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	public static String createIsGetterName(String name) {
		return is + name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	public static String[] extractFieldNames(Object source) {
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

	public static String[] extractGetterNames(Object source) {
		Method[] methods = source.getClass().getMethods();
		Set<String> getterNames = new HashSet<>();
		for (Method m : methods) {
			String name = m.getName();
			if(name.startsWith("getClass") || name.startsWith("getProperty") || name.startsWith("getMetaClass")){
				continue;
			}
			if (m.getName().startsWith("get")) {
				getterNames.add(m.getName());
			}
		}
		return getterNames.toArray(new String[getterNames.size()]);
	}

	public static <T> T copyValueTo(Object source, T target) {
		return copyValueTo(source, target, extractFieldNames(source));
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
				throw new SBReflectionException("NoSuchFieldException is occurred");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				throw new SBReflectionException("NoSuchFieldException is occurred");
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
	public static <T> T getValue(Object source, String fieldName) {
		Class sourceClass = source.getClass();
		Field field;
		try {
			field = sourceClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			return (T) field.get(source);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			throw new SBReflectionException("NoSuchFieldException is occurred");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new SBReflectionException("NoSuchFieldException is occurred");
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
			throw new SBReflectionException("NoSuchFieldException is occurred");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new SBReflectionException("NoSuchFieldException is occurred");
		}
	}


	public static Map<String, Object> mappingFieldDto2Map(Object source){
		Map<String, Object> result = new HashMap<>();
		for(String fieldName : extractFieldNames(source)){
			result.put(fieldName, getValue(source, fieldName));
		}
		return result;
	}

	public static Map<String, Object> mappingGetterDto2Map(Object source){
		Method[] methods = source.getClass().getMethods();
		Map<String, String> fieldNames = new HashMap<>();
		for(Field field : source.getClass().getDeclaredFields()){
			fieldNames.put(field.getName().toUpperCase(), field.getName());
		}
		Map<String, Object> result = new HashMap<>();
		for (Method m : methods) {
			String name = m.getName();
			if(name.startsWith("getClass") || name.startsWith("getProperty") || name.startsWith("getMetaClass")){
				continue;
			}
			if (name.startsWith("get")) {
				try {
					name = name.substring(3);
					if(fieldNames.containsKey(name.toUpperCase())){
						result.put(fieldNames.get(name.toUpperCase()), m.invoke(source));
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					throw new SBReflectionException("NoSuchFieldException is occurred");
				} catch (InvocationTargetException e) {
					e.printStackTrace();
					throw new SBReflectionException("NoSuchFieldException is occurred");
				}
			}
		}
		return result;
	}

}
