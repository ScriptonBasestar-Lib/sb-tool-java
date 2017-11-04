package org.scriptonbasestar.tool.core.reflection;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.scriptonbasestar.tool.core.exception.runtime.SBReflectionException;
import org.scriptonbasestar.tool.core.util.StringUtil;

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

	private static final char[] get = "get".toCharArray();
	private static final char[] set = "set".toCharArray();
	private static final char[] is = "is".toCharArray();

	private static String createGeneratedName(char[] typeArr, char[] nameArr) {
		nameArr[0] = Character.toUpperCase(nameArr[0]);
		nameArr = new char[typeArr.length + nameArr.length];
		return new String(nameArr);
	}

	public static String createGetterName(String fieldName) {
		return createGeneratedName(get, fieldName.toCharArray());
	}

	public static String createSetterName(String fieldName) {
		return createGeneratedName(set, fieldName.toCharArray());
	}

	public static String createIsGetterName(String fieldName) {
		return createGeneratedName(is, fieldName.toCharArray());
	}

	public static String createFieldName(String getterName) {
		StringBuilder sb = new StringBuilder(getterName);
		if (getterName.startsWith("get")) {
			sb.delete(0,3);
			sb.setCharAt(0,Character.toLowerCase(sb.charAt(0)));
		}else if(getterName.startsWith("is")){
			sb.delete(0,2);
			sb.setCharAt(0,Character.toLowerCase(sb.charAt(0)));
		}
		return sb.toString();
	}

	public static String[] extractFieldNames(Object source) {
		Field[] fields = source.getClass().getDeclaredFields();
		Set<String> fieldNames = new HashSet<>();
		for (Field field : fields) {
			//java this$0
			//groovy [name, height, weight, $staticClassInfo, __$stMC, metaClass, $staticClassInfo$, $callSiteArray]
			if (StringUtil.isStartsWith(field.getName(), "$", "__$", "metaClass", "this$0")) {
				continue;
			}
			fieldNames.add(field.getName());
		}
		return fieldNames.toArray(new String[fieldNames.size()]);
	}

	public static String[] extractGetterNames(Object source) {
		Method[] methods = source.getClass().getMethods();
		Set<String> resultGetterNames = new HashSet<>();
		for (Method m : methods) {
			String name = m.getName();
			if(StringUtil.isStartsWith(name, "getClass", "getProperty", "getMetaClass")) {
				continue;
			}
			if (name.startsWith("get") || name.startsWith("is")) {
				resultGetterNames.add(name);
			}
		}
		return resultGetterNames.toArray(new String[resultGetterNames.size()]);
	}

	public static Method[] extractGetterMethods(Object source) {
		Method[] methods = source.getClass().getMethods();
		Set<Method> resultMethods = new HashSet<>();
		for (Method m : methods) {
			String name = m.getName();
			if(StringUtil.isStartsWith(name, "getClass", "getProperty", "getMetaClass")) {
				continue;
			}
			if (name.startsWith("get") || name.startsWith("is")) {
				resultMethods.add(m);
			}
		}
		return resultMethods.toArray(new Method[resultMethods.size()]);
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


	public static Map<String, Object> mappingDtoField2Map(Object source){
		Map<String, Object> result = new HashMap<>();
		for(String fieldName : extractFieldNames(source)){
			result.put(fieldName, getValue(source, fieldName));
		}
		return result;
	}

	public static Map<String, Object> mappingGetterDto2Map(Object source){
		Map<String, Object> result = new HashMap<>();
		for(Method m : extractGetterMethods(source)){
			try {
				result.put(createFieldName(m.getName()), m.invoke(source));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				throw new SBReflectionException("NoSuchFieldException is occurred");
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				throw new SBReflectionException("NoSuchFieldException is occurred");
			}
		}
		return result;
	}
//	public static Map<String, Object> mappingGetterDto2Map(Object source){
//		Method[] methods = source.getClass().getMethods();
//		Map<String, String> fieldNames = new HashMap<>();
//		for(Field field : source.getClass().getDeclaredFields()){
//			fieldNames.put(field.getName().toUpperCase(), field.getName());
//		}
//		Map<String, Object> result = new HashMap<>();
//		for (Method m : methods) {
//			String name = m.getName();
//			if(name.startsWith("getClass") || name.startsWith("getProperty") || name.startsWith("getMetaClass")){
//				continue;
//			}
//			if (name.startsWith("get")) {
//				try {
//					name = name.substring(3);
//					if(fieldNames.containsKey(name.toUpperCase())){
//						result.put(fieldNames.get(name.toUpperCase()), m.invoke(source));
//					}
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//					throw new SBReflectionException("NoSuchFieldException is occurred");
//				} catch (InvocationTargetException e) {
//					e.printStackTrace();
//					throw new SBReflectionException("NoSuchFieldException is occurred");
//				}
//			}
//		}
//		return result;
//	}

}
