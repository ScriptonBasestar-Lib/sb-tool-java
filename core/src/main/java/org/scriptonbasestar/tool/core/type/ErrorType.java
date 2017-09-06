package org.scriptonbasestar.tool.core.type;

/**
 * @author archmagece
 * @date 2016-03-23
 */
public enum ErrorType {
	/**
	 * 에러없음
	 */
	NONE,
	/**
	 * 요청오류
	 * 값의 형태가 잘못되거나, 중복요청이라던가
	 */
	REQUEST,
	/**
	 * 데이터오류
	 * notfound,duplicate...
	 */
	DATA,
	/**
	 * 서버 오류
	 */
	SERVER,
	/**
	 * 네트워크 오류
	 * 타임아웃,속도느림
	 */
	NETWORK,
	/**
	 * 파일IO
	 */
	IO,
	/**
	 * 인증권한오류
	 */
	AUTH,
	/**
	 * 아직 정의되지 않음.
	 * 정의해서 추가할 필요
	 */
	UNDEFINED,
}
