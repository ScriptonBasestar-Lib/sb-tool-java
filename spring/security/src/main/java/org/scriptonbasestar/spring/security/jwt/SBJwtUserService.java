package org.scriptonbasestar.spring.security.jwt;

import java.util.Collection;

/**
 * @author chaeeung.e
 * @since 2017-09-27
 */
public interface SBJwtUserService {

	/**
	 * SSO에 연동된 서비스 중 사용자에게 허용된 서비스
	 * 추가2차 : 이번에 요청이 들어온 서비스
	 *
	 * @param id
	 * @return
	 */
	Collection<String> findService(Long id);

}
