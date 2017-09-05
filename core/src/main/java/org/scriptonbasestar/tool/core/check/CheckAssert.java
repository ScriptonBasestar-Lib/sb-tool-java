package org.scriptonbasestar.tool.core.check;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * @author archmagece
 * @since 2015-05-30
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CheckAssert {

	/*
	======================= not =======================
	 */
	public static void notNull(Object a, String message) {
		assert a != null : message;
	}

	public static void notNullOrEmpty(String a, String message) {
		assert a != null && !a.isEmpty() : message;
	}

	public static <T> void notNullOrEmpty(T[] a, String message) {
		assert a != null && a.length == 0 : message;
	}

	public static void notNullOrEmpty(Collection a, String message) {
		assert a != null && !a.isEmpty() : message;
	}

	/*
	======================= should =======================
	 */
	public static void shouldTrue(boolean a, String message) {
		assert a : message;
	}

	public static void shouldFalse(boolean a, String message) {
		assert !a : message;
	}

	/*
	======================= Pattern =======================
	 */
	public static void urlPattern(String a, String message) {
		assert a.matches(MatchPattern.urlDomainHttp) : message;
	}

	/*
	======================= compare =======================
	 */
	public static void compareAgtB(long a, long b, String message) {
		assert a > b : message;
	}

	public static void compareAgtB(double a, double b, String message) {
		assert a > b : message;
	}

	public static void compareAgtB(byte a, byte b, String message) {
		assert a > b : message;
	}

	public static void compareAltB(long a, long b, String message) {
		assert a < b : message;
	}

	public static void compareAltB(double a, double b, String message) {
		assert a < b : message;
	}

	public static void compareAltB(byte a, byte b, String message) {
		assert a < b : message;
	}

	/*
	======================= range =======================
	 */
//	public static void rangeAwithB(long arg, long rangeA, long rangeB, String message){
//		assert rangeA <= arg && arg <= rangeB : message;
//	}
	public static void rangeAwithB(double arg, double rangeA, double rangeB, String message) {
		assert rangeA <= arg && arg <= rangeB : message;
	}

}
