package com.scriptonbasestar.spring.security.auth.app;


/**
 * @author archmagece
 * @since 2015-01-26-11
 */
public interface AppAuthKeyManager {

	/**
	 * 키 발행, DB에 저장.
	 * secret은 적당히 긴 의미없는 암호문
	 *
	 * @param username
	 * @return 완성된 @see AppAuthKeyDto object 반환
	 */
	AppAuthKeyDto issue(String username);
	AppAuthKeyDto show(String username);
	AppAuthKeyDto refresh(String username, Long newExpirationTime);

	/**
	 * 이메일과 secret을 받아서 base64 decode 1차확인 후
	 * repository에서 정보를 받아 2차확인
	 * @param username
	 * @param secret
	 * @return
	 */
	boolean check(String username, String secret);

	/**
	 * 쓸모없어진 secret 삭제
	 * @param username
	 */
	void remove(String username);
}
