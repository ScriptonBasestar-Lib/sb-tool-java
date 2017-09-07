package com.scriptonbasestar.spring.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author archmagece
 * @since 2014-10-22-14
 */
public interface IUserDetailsCreator {

	UserDetails loadUserById(Long id);
}
