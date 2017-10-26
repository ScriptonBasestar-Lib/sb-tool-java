package org.scriptonbasestar.spring.security.auth;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author archmagece
 * @since 2017-09-27
 */
public interface SBFindUserAuthorityService {

	/**
	 * SSO에 연동된 서비스 중 사용자에게 허용된 서비스 도메인
	 * 추가2차 : 이번에 요청이 들어온 서비스
	 *
	 * @param userId
	 * @return
	 */
	Collection<String> findUserComponent(Long userId);

	Collection<GrantedAuthority> findGrantedAuthority(String ... roles);

	Collection<String> findUserRole(Long userId);

	Collection<String> findUserPrincipal(Long userId);

	Collection<String> findPrincipalByRoleName(String roleName);


}
