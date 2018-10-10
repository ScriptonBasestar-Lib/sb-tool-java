package org.scriptonbasestar.tool.core.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SBStringUtil {
	public static boolean isStartsWith(String source, String... compares) {
		for (String compare : compares) {
			if (source.startsWith(compare)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isEmpty(String source) {
		return source == null || source.isEmpty();
	}

}
