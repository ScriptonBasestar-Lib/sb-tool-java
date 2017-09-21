package org.scriptonbasestar.spring.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;


/**
 * Used to authenticate against a given
 * {@link SignedUsernamePasswordAuthenticationToken}.
 *
 * @author Mularien
 */
@Slf4j
public class SignedUsernamePasswordAuthenticationProvider
		extends DaoAuthenticationProvider {

	public SignedUsernamePasswordAuthenticationProvider() {

		super();
		setPreAuthenticationChecks(new DefaultPreAuthenticationChecks());
		setPostAuthenticationChecks(new DefaultPostAuthenticationChecks());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.security.authentication.dao.
	 * AbstractUserDetailsAuthenticationProvider#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<? extends Object> authentication) {

		return (SignedUsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.security.authentication.dao.DaoAuthenticationProvider
	 * #
	 * additionalAuthenticationChecks(org.springframework.security.core.userdetails
	 * .UserDetails, org.springframework.security.authentication.
	 * UsernamePasswordAuthenticationToken)
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
												  UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		// super.additionalAuthenticationChecks(userDetails, authentication);

		SignedUsernamePasswordAuthenticationToken signedToken = (SignedUsernamePasswordAuthenticationToken) authentication;

		if (signedToken.getRequestSignature() == null) {
			throw new BadCredentialsException(messages.getMessage(
					"SignedUsernamePasswordAuthenticationProvider.missingSignature", "Missing request signature"));// ,
			// isIncludeDetailsObject() ? userDetails : null);
		}

		// calculate expected signature
		if (!signedToken.getRequestSignature().equals(
				calculateExpectedSignature(signedToken))) {
			throw new BadCredentialsException(messages.getMessage(
					"SignedUsernamePasswordAuthenticationProvider.badSignature", "Invalid request signature"));// ,
			// isIncludeDetailsObject() ? userDetails : null);
		}
	}

	/**
	 * Given a signed token, calculates the signature value expected to be
	 * suppliled.
	 *
	 * @param signedToken the signed token to evaluate
	 * @return the expected signature
	 */
	private String calculateExpectedSignature(SignedUsernamePasswordAuthenticationToken signedToken) {

		return signedToken.getPrincipal() + "|+|" + signedToken.getCredentials();
	}

	/**
	 * @author archmagece
	 * <p/>
	 * AbtractUserDetailsAuthenticate 어쩌고 하는거 수정
	 */
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		// return super.authenticate(authentication);

		Assert.isInstanceOf(
				UsernamePasswordAuthenticationToken.class, authentication, messages.getMessage(
						"AbstractUserDetailsAuthenticationProvider.onlySupports",
						"Only UsernamePasswordAuthenticationToken is supported"));

		// Determine username
		String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();

		boolean cacheWasUsed = true;
		UserDetails user = super.getUserCache().getUserFromCache(
				username);

		if (user == null) {
			cacheWasUsed = false;

			try {
				user = retrieveUser(
						username, (UsernamePasswordAuthenticationToken) authentication);
			} catch (UsernameNotFoundException notFound) {
				log.debug("User '" + username + "' not found");

				/*
				 * if (hideUserNotFoundExceptions) { throw new
				 * BadCredentialsException(messages.getMessage(
				 * "AbstractUserDetailsAuthenticationProvider.badCredentials",
				 * "Bad credentials"));
				 */
				if (hideUserNotFoundExceptions) {
					throw new BadCredentialsException(messages.getMessage(
							"AbstractUserDetailsAuthenticationProvider.badCredentials", "fucku"));
				} else {
					throw notFound;
				}
				// throw notFound;
			}

			Assert.notNull(
					user, "retrieveUser returned null - a violation of the interface contract");
		}

		try {
			super.getPreAuthenticationChecks().check(
					user);
			additionalAuthenticationChecks(
					user, (UsernamePasswordAuthenticationToken) authentication);
		} catch (AuthenticationException exception) {
			if (cacheWasUsed) {
				// There was a problem, so try again after checking
				// we're using latest data (i.e. not from the cache)
				cacheWasUsed = false;
				user = retrieveUser(
						username, (UsernamePasswordAuthenticationToken) authentication);
				super.getPreAuthenticationChecks().check(
						user);
				additionalAuthenticationChecks(
						user, (UsernamePasswordAuthenticationToken) authentication);
			} else {
				throw exception;
			}
		}

		super.getPostAuthenticationChecks().check(
				user);

		if (!cacheWasUsed) {
			super.getUserCache().putUserInCache(
					user);
		}

		Object principalToReturn = user;

		if (super.isForcePrincipalAsString()) {
			principalToReturn = user.getUsername();
		}

		return createSuccessAuthentication(
				principalToReturn, authentication, user);
	}

	@Override
	public void setPasswordEncoder(Object passwordEncoder) {

		super.setPasswordEncoder(passwordEncoder);
	}

	@Override
	public void setSaltSource(SaltSource saltSource) {

		super.setSaltSource(saltSource);
	}

	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {

		super.setUserDetailsService(userDetailsService);
	}

	private class DefaultPreAuthenticationChecks implements UserDetailsChecker {
		public void check(UserDetails user) {
			if (!user.isAccountNonLocked()) {
				log.debug("User account is locked");

				throw new LockedException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.locked",
						"User account is locked") + user.toString());
			}

			if (!user.isEnabled()) {
				log.debug("User account is disabled");

				throw new DisabledException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.disabled",
						"User is disabled") + user.toString());
			}

			if (!user.isAccountNonExpired()) {
				log.debug("User account is expired");

				throw new AccountExpiredException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.expired",
						"User account has expired") + user.toString());
			}
		}
	}

	private class DefaultPostAuthenticationChecks implements UserDetailsChecker {
		public void check(UserDetails user) {
			if (!user.isCredentialsNonExpired()) {
				log.debug("User account credentials have expired");

				throw new CredentialsExpiredException(messages.getMessage(
						"AbstractUserDetailsAuthenticationProvider.credentialsExpired",
						"User credentials have expired") + user.toString());
			}
		}
	}

}
