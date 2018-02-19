package org.scriptonbasestar.spring.security;

/**
 * @author archmagece
 * @since 2014. 8. 6.
 */
public interface IChangePassword {

	boolean changePassword(Long id, String newPassword);
}
