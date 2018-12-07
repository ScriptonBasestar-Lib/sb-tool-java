package org.scriptonbasestar.tool.core.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Identify {

	public static boolean isGetter(Method method) {
		// if (!method.getName().matches("[g][e][t]*")) { return false; }
		if (!method.getName().startsWith("get")) {
			return false;
		}
		if (method.getParameterTypes().length != 0) {
			return false;
		}
		if (void.class.equals(method.getReturnType())) {
			return false;
		}
		return true;
	}

	public static boolean isSetter(Method method) {
		if (!method.getName().startsWith("set")) {
			return false;
		}
		if (method.getParameterTypes().length != 1) {
			return false;
		}
		return true;
	}

	public static void setStringNulField(Class<?> vo)
		throws
		NoSuchFieldException,
		IllegalAccessException {
		for (Field f : vo.getFields()) {
			f.set(vo, "0.00");
		}
	}

}
