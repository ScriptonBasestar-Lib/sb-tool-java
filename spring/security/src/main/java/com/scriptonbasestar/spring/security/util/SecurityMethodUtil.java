package com.scriptonbasestar.spring.security.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.beansugar.base.spring.security.domain.SaltedUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.Principal;

/**
 * @author archmagece
 * @since 2015-12-26
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SecurityMethodUtil {

	public static Authentication getAuthentication() {
		return SecurityContextHolder
				.getContext()
				.getAuthentication();
	}

	public static Principal getPrincipal() {
		Authentication authentication = getAuthentication();
		if(authentication==null){
			return null;
		}
		return (Principal)authentication.getPrincipal();
	}

	public static String getUsername() {
		Authentication authentication = getAuthentication();
		if(authentication==null){
			return null;
		}
		return authentication.getName();
	}

	public static SaltedUser getSaltedUser() {
		Authentication authentication = getAuthentication();
		if(authentication==null){
			return null;
		}
		Object principal = authentication.getPrincipal();
		//or instanceof string
		return principal instanceof SaltedUser ? ((SaltedUser) principal) : null;
	}

	public static Long getAccountId() {
		Authentication authentication = getAuthentication();
		if(authentication==null){
			return null;
		}
		Object principal = authentication.getPrincipal();
		return principal instanceof SaltedUser ? ((SaltedUser) principal).getAccountId() : null;
	}

	public static String getUserLocale() {
		Authentication authentication = getAuthentication();
		if(authentication==null){
			return null;
		}
		Object principal = authentication.getPrincipal();
		return principal instanceof SaltedUser ? ((SaltedUser) principal).getLocale() : null;
	}

	public static void loginProcess(UserDetailsService userDetailsService, String username){
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
	}

	public static void loginProcess(UserDetails userDetails){
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()));
	}

}
