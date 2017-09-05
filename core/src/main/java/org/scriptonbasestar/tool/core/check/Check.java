package org.scriptonbasestar.tool.core.check;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * @author archmagece
 * @since 2015-05-30
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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

	public static String notNullOrEmptyString(String a, String message) {
		if (a != null && !a.trim().isEmpty()) {
			return a;
		}
		throw new IllegalArgumentException(message);
	}

	public static <T> T[] notNullOrEmpty(T[] a, String message) {
		if (a != null && a.length > 0) {
			return a;
		}
		throw new IllegalArgumentException(message);
	}

	public static void notNullOrEmpty(Collection a, String message) {
		if (a != null && !a.isEmpty()) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

	/*
	======================= should =======================
	 */
	public static void shouldTrue(boolean a, String message) {
		if (a) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

	public static void shouldFalse(boolean a, String message) {
		if (!a) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

	/*
	======================= Pattern =======================
	 */
	public static void urlDomainPattern(String a, String message) {
		if (a != null && a.matches(MatchPattern.urlDomainHttp)) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

	public static void urlCustomPattern(String a, String message) {
		if (a != null && a.matches(MatchPattern.urlCustom)) {
			return;
		}
		throw new IllegalArgumentException(message);
	}

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
