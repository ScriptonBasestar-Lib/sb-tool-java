package org.scriptonbasestar.tool.core.prop;

import java.io.*;

/**
 * @author archmagece
 * <p>
 * jar에 설정파일을 포함시키는 경우(maven 모듈)
 */
public class ResourceReader {

	/**
	 * 리소스 root 경로 찾기
	 *
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	public static String resourceRootPath(Class<?> clazz) throws IOException {
		return clazz.getProtectionDomain().getCodeSource().getLocation().getPath();
	}

	/**
	 * 클래스의 파일이 있는 경로
	 *
	 * @param clazz
	 * @param filePathToAppend
	 * @return
	 * @throws IOException
	 */
	public static String resourcePath(Object clazz, String filePathToAppend) throws IOException {
		return resourcePath(clazz.getClass(), filePathToAppend);
	}

	public static String resourcePath(Class<?> clazz, String filePathToAppend) throws IOException {
		return new File(clazz.getProtectionDomain().getCodeSource().getLocation().getPath(), filePathToAppend).getPath();
	}

	public static InputStream resourceInputStream(Class<?> clazz, String filePathToAppend) throws IOException {

		String resourcePath = clazz.getProtectionDomain().getCodeSource().getLocation().getPath() + filePathToAppend;
		File file = new File(resourcePath);
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		return inputStream;
	}

	/**
	 * 리소스를 읽어서 스트링으로 가져옴
	 *
	 * @param clazz
	 * @param filePathToAppend
	 * @return
	 * @throws IOException
	 */
	public static String resourceString(Class<?> clazz, String filePathToAppend) throws IOException {

		String resourcePath = clazz.getProtectionDomain().getCodeSource().getLocation().getPath() + filePathToAppend;
		File file = new File(resourcePath);
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		return stringFromInputStream(inputStream, "UTF-8");
	}

	/**
	 * input stream 받아서 string으로 만들기
	 * IOUtils 대체
	 * <p>
	 * String html = IOUtils.toString(
	 * inputStream,
	 * "UTF-8"
	 * );
	 *
	 * @param is
	 * @param encoding
	 * @return
	 */
	private static String stringFromInputStream(InputStream is, String encoding) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is, encoding));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
