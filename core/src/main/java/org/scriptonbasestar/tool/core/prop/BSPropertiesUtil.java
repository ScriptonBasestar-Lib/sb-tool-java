package org.scriptonbasestar.tool.core.prop;

import org.scriptonbasestar.tool.core.check.Check;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author archmagece
 * @since 2015-02-22
 * <p>
 * jar파일내에 포함된 설정파일을 이용해서 프로퍼티 만드는 메서드들
 */
public class BSPropertiesUtil {

	/**
	 * 사용 예)
	 * String sourcePath1 = "META-INF/conf/domain.jdbc.local.mysql.properties";
	 * return BSPropertiesUtil.propertiesMaker(DomainJdbcProfileConfig.class, sourcePath1);
	 * <p>
	 * jar파일내의 경로
	 *
	 * @param clazz .jar 파일내에 있는 클래스 암꺼나 가능.하지만 설정파일을 사용 권장
	 * @param paths .jar 파일내에서의  .properties 파일 경로
	 * @return
	 */
	public static Properties propertiesMaker(Class clazz, String... paths) {
		Check.notNullOrEmpty(paths, "null or empty");
		InputStream[] inputStreamArr = new InputStream[paths.length];
		for (int i = 0; i < paths.length; i++) {
			inputStreamArr[i] = clazz.getClassLoader().getResourceAsStream(paths[i]);
		}
		if (inputStreamArr == null) {
			throw new NullPointerException("file not found");
		}
		return propertiesMaker(new Properties(), inputStreamArr);
	}

	/**
	 * .properties 파일의 InputStream 을 입력해서 Properties 받음
	 *
	 * @param inputStreams .properties 파일을 읽은 InputStream
	 * @return
	 */
	public static Properties propertiesMaker(InputStream... inputStreams) {
		return propertiesMaker(new Properties(), inputStreams);
	}

	/**
	 * 특정 properties 파일에 properteis의 inputstream을 추가입력
	 *
	 * @param prop         기 생성된 Properties 인스턴스
	 * @param inputStreams .properties 파일의 InputStream
	 * @return
	 */
	public static Properties propertiesMaker(Properties prop, InputStream... inputStreams) {
		for (InputStream inputStream : inputStreams) {
			try {
				prop.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

}
