package org.scriptonbasestar.tool.core;

import org.junit.Test;

/**
 * @author chaeeung.e
 * @since 2017-11-02
 *
 * 문자열 합치는 코드. 혹시나 해서 돌려봄
 */
public class StringAppendPerformanceTestOnce {

	private static final String get = "get";
	private static final char[] getchar = "get".toCharArray();

	public static String createGetterName(String name) {
//		return get + name.substring(0, 1).toUpperCase() + name.substring(1);
		return new StringBuilder(get).append(name.substring(0, 1).toUpperCase()).append(name.substring(1)).toString();
	}

	public static String createGetterName1(String name) {
		char[] charArr = name.toCharArray();
		charArr[0] = Character.toUpperCase(charArr[0]);
//		return get + charArr;
		return new StringBuilder(get).append(charArr).toString();
	}

	public static String createGetterName2(String name) {
		char[] charArr = name.toCharArray();
		charArr[0] = Character.toUpperCase(charArr[0]);
		charArr = new char[getchar.length + charArr.length];
		return new String(charArr);
	}

	public static final String formatString = "get%s%s";
	public static String createGetterName3(String name) {
		return String.format(formatString, name.substring(0, 1).toUpperCase(), name.substring(1));
	}

	@Test
	public void test(){
		for(int i=0;i<10000000;i++){
			createGetterName("name");
		}
	}
	@Test
	public void test1(){
		for(int i=0;i<10000000;i++){
			createGetterName1("name");
//			createGetterName1_1(new String("name"));
		}
	}
	@Test
	public void test2(){
		for(int i=0;i<10000000;i++){
			createGetterName2("name");
//			createGetterName1_2(new String("name"));
		}
	}

	@Test
	public void test3(){
		for(int i=0;i<1000000;i++){
			createGetterName3("name");
		}
	}

}
