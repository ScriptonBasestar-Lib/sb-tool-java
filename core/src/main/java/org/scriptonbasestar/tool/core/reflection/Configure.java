package org.scriptonbasestar.tool.core.reflection;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

public class Configure {
	public static LinkedHashMap<String, Object> dtoData2Map(Object bean)
			throws
			IntrospectionException,
			IllegalArgumentException,
			IllegalAccessException,
			InvocationTargetException {

		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		Method[] methods = bean.getClass().getMethods();

		for (int i = 0; i < methods.length; i++) {
			if (Identify.isGetter(methods[i])) {
				Object result = methods[i].invoke(bean);
				map.put(methods[i].getName(), result);
			}
		}

		// BeanInfo info = Introspector.getBeanInfo(bean.getClass(),
		// Object.class);
		// PropertyDescriptor[] props = info.getPropertyDescriptors();
		// for (PropertyDescriptor pd : props) {
		// String name = pd.getName();
		// Method getter = pd.getReadMethod();
		// Class<?> type = pd.getPropertyType();
		//
		// Object value = getter.invoke(bean);
		// map.put(name,(Object)value);
		// System.out.println(name + " = " + value + "; type = " + type);
		// }

		return map;
	}


	public static ParamMap dtoData2ParamMap(Object bean)
			throws
			IntrospectionException,
			IllegalArgumentException,
			IllegalAccessException,
			InvocationTargetException {

		ParamMap map = new ParamMap();
		Method[] methods = bean.getClass().getMethods();

		for (int i = 0; i < methods.length; i++) {
			if (Identify.isGetter(methods[i])) {
				Object result = methods[i].invoke(bean);
				map.put(methods[i].getName(), result);
			}
		}

		// BeanInfo info = Introspector.getBeanInfo(bean.getClass(),
		// Object.class);
		// PropertyDescriptor[] props = info.getPropertyDescriptors();
		// for (PropertyDescriptor pd : props) {
		// String name = pd.getName();
		// Method getter = pd.getReadMethod();
		// Class<?> type = pd.getPropertyType();
		//
		// Object value = getter.invoke(bean);
		// map.put(name,(Object)value);
		// System.out.println(name + " = " + value + "; type = " + type);
		// }

		return map;
	}

	public static <T> T dtoDataFromMap(Class<T> clazz, LinkedHashMap<String, Object> map)
			throws
			IllegalArgumentException,
			IllegalAccessException,
			InvocationTargetException,
			InstantiationException {
		// T bean = null;
		T bean = clazz.newInstance();
		Method[] methods = bean.getClass().getMethods();

		for (int i = 0; i < methods.length; i++) {
			if (Identify.isSetter(methods[i])) {
				Object result = methods[i].invoke(bean, map.get(methods[i].getName()));
				map.put(methods[i].getName(), result);
			}
		}

		return bean;
	}
}
