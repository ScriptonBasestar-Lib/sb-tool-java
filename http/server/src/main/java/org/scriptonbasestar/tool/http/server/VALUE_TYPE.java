package org.scriptonbasestar.tool.http.server;

/**
 * 들어오는 파일의 종류. 종류는 더 많지만 api로 제공되는 방식은 두가지다.
 * 파일로 제공 or 데이터텍스트 제공. txt가 아니라 data인 이유는 라임(운율)을 맞추기 위해.
 * @author archmagece@gmail.com
 *
 */
public enum VALUE_TYPE {
	file, data
}
