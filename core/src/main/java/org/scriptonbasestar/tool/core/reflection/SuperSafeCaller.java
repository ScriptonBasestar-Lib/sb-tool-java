package org.scriptonbasestar.tool.core.reflection;

import java.lang.reflect.Method;

/**
 * @author archmagece
 * @with sb-tool-java
 * @since 2014-09-15-16
 */
public class SuperSafeCaller {

	public static boolean call(Object targetClass, String methodName, Class<?>[] parameterTypes, Object[] paramValues) {
		try {
			Method method = targetClass.getClass().getMethod(methodName, parameterTypes);
			method.invoke(targetClass, paramValues);
		} catch (Exception e) {
			//Do nothing
			return false;
		}
		return true;
	}

	public static boolean callNoParams(Object targetClass, String methodName) {
		try {
			Method method = targetClass.getClass().getMethod(methodName);
			method.invoke(targetClass);
		} catch (Exception e) {
			//Do nothing
			return false;
		}
		return true;
	}
}
