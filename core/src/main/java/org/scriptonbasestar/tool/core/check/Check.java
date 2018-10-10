package org.scriptonbasestar.tool.core.check;

import lombok.experimental.UtilityClass;

import java.util.Collection;

/**
 * @author archmagece
 * @since 2015-05-30
 */
@UtilityClass
public final class Check {

	/*
	======================= not =======================
	 */
	public static <T> T notNull(T a, String message) {
		if (a != null) {
			return a;
		}
		throw new IllegalArgumentException(message);
	}

	/**
	 * null이 아닌데 empty인거. null은 허용
	 * null but empty. allow null
	 *
	 * @param a
	 * @param message
	 * @return
	 */
	public static String notEmptyString(String a, String message) {
		if (a != null && a.trim().isEmpty()) {
			throw new IllegalArgumentException(message);
		}
		return a;
	}

	public static <T> T[] notEmpty(T[] a, String message) {
		if (a != null && a.length > 0) {
			return a;
		}
		throw new IllegalArgumentException(message);
	}

	public static <T> Collection<T> notEmpty(Collection<T> a, String message) {
		if (a != null && !a.isEmpty()) {
			return a;
		}
		throw new IllegalArgumentException(message);
	}

	/*
	======================= must =======================
	 */
	public static boolean mustEqualValue(boolean source, boolean compare, String message) {
		if (source==compare) {
			return source;
		}
		throw new IllegalArgumentException(message);
	}
	public static long mustEqualValue(long source, long compare, String message) {
		if (source==compare) {
			return source;
		}
		throw new IllegalArgumentException(message);
	}
	public static double mustEqualValue(double source, double compare, String message) {
		if (source==compare) {
			return source;
		}
		throw new IllegalArgumentException(message);
	}
	public static byte mustEqualValue(byte source, byte compare, String message) {
		if (source==compare) {
			return source;
		}
		throw new IllegalArgumentException(message);
	}
	public static String mustEqualValue(String source, String compare, String message) {
		if (source.equals(compare)) {
			return source;
		}
		throw new IllegalArgumentException(message);
	}


	/*
	======================= Pattern =======================
	 */
	public static void customPattern(String a, String pattern, String message) {
		if (a != null && a.matches(pattern)) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

	/*
	======================= compare =======================
	 */
	public static void compareAgtB(long a, long b, String message) {
		if (a > b) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

	public static void compareAgtB(double a, double b, String message) {
		if (a > b) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

	public static void compareAgtB(byte a, byte b, String message) {
		if (a > b) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

	public static void compareAltB(long a, long b, String message) {
		if (a < b) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

	public static void compareAltB(double a, double b, String message) {
		if (a < b) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

	public static void compareAltB(byte a, byte b, String message) {
		if (a < b) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

	/*
	======================= range =======================
	 */
//	public static void rangeAwithB(long arg, long rangeA, long rangeB, String message){
//		assert rangeA <= arg && arg <= rangeB : message;
//	}
	public static void rangeAwithB(double arg, double rangeA, double rangeB, String message) {
		if (rangeA <= arg && arg <= rangeB) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

}
