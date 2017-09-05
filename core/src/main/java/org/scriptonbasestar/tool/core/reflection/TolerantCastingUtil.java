package org.scriptonbasestar.tool.core.reflection;

import lombok.experimental.UtilityClass;
import org.scriptonbasestar.tool.core.check.Check;

/**
 * @Author archmagece
 * @CreatedAt 2016-10-30 12
 */
@UtilityClass
public class TolerantCastingUtil {

	public static <T> T casting(Object source, Class<T> clazz) {
		Check.notNull(source, "TolerantCastingUtil : not allow null");

		if (clazz.isInstance(source)) {
			return clazz.cast(source);
		}
		return null;
	}

	public static String castingString(Object source) {
		Check.notNull(source, "TolerantCastingUtil : not allow null");

		if (source instanceof String) {
			return source.toString().trim();
		}
		return null;
	}

	public static Integer castingInt(Object source) {
		Check.notNull(source, "TolerantCastingUtil : not allow null");

		if (source instanceof Integer) {
			return (Integer) source;
		} else if (source instanceof String) {
			return Integer.parseInt(source.toString().trim());
		}
		return null;
	}

	public static Long castingLong(Object source) {
		Check.notNull(source, "TolerantCastingUtil : not allow null");

		if (source instanceof Long) {
			return (Long) source;
		} else if (source instanceof String) {
			return Long.parseLong(source.toString().trim());
		}
		return null;
	}

	public static Float castingFloat(Object source) {
		Check.notNull(source, "TolerantCastingUtil : not allow null");

		if (source instanceof Float) {
			return (Float) source;
		} else if (source instanceof String) {
			return Float.parseFloat(source.toString().trim());
		}
		return null;
	}

	public static Double castingDouble(Object source) {
		Check.notNull(source, "TolerantCastingUtil : not allow null");

		if (source instanceof Double) {
			return (Double) source;
		} else if (source instanceof String) {
			return Double.parseDouble(source.toString().trim());
		}
		return null;
	}

	public static Character castingChar(Object source) {
		Check.notNull(source, "TolerantCastingUtil : not allow null");

		if (source instanceof Character) {
			return (Character) source;
		} else if (source instanceof String) {
			if (source.toString().trim().length() > 0) {
				return source.toString().trim().charAt(0);
			}
		}
		return null;
	}
}
