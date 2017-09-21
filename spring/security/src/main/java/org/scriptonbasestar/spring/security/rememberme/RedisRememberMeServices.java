package org.scriptonbasestar.spring.security.rememberme;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.authentication.rememberme.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author archmagece
 * @CreatedAt 2016-07-19 18
 */
@Slf4j
public class RedisRememberMeServices extends AbstractRememberMeServices {

	private final RedisRememberMeTokenRepository tokenRepository;
	private final SecureRandom random;

	public static final int DEFAULT_SERIES_LENGTH = 16;
	public static final int DEFAULT_TOKEN_LENGTH = 16;

	private int seriesLength = DEFAULT_SERIES_LENGTH;
	private int tokenLength = DEFAULT_TOKEN_LENGTH;

	public RedisRememberMeServices(String cookieKey, UserDetailsService userDetailsService, RedisRememberMeTokenRepository tokenRepository) {
		super(cookieKey, userDetailsService);
		this.tokenRepository = tokenRepository;
		random = new SecureRandom();
	}


	public RedisRememberMeServices(String cookieKey, UserDetailsService userDetailsService, @Qualifier RedisTemplate<String, RedisRememberMeToken> redisTemplate) {
		super(cookieKey, userDetailsService);
		tokenRepository = new RedisRememberMeTokenRepository(redisTemplate);
		random = new SecureRandom();
	}

	@Override
	protected void onLoginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication successfulAuthentication) {
		String username = successfulAuthentication.getName();

		logger.debug("Creating new persistent login for user " + username);

		RedisRememberMeToken rememberMeToken = new RedisRememberMeToken(username, generateSeriesData(), generateTokenData(), new Date());
		try {
			tokenRepository.storeToken(username, rememberMeToken);
			addCookie(rememberMeToken, request, response);
		}
		catch (Exception e) {
			logger.error("Failed to save persistent token ", e);
		}
	}

	@Override
	protected UserDetails processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request, HttpServletResponse response) throws RememberMeAuthenticationException, UsernameNotFoundException {

		if (cookieTokens.length != 2) {
			throw new InvalidCookieException("Cookie token did not contain " + 2 + " tokens, but contained '" + Arrays.asList(cookieTokens) + "'");
		}

		final String presentedSeries = cookieTokens[0];
		final String presentedToken = cookieTokens[1];

		RedisRememberMeToken token = tokenRepository
				.getToken(presentedSeries);

		if (token == null) {
			// No series match, so we can't authenticate using this cookie
			throw new RememberMeAuthenticationException(
					"No persistent token found for series id: " + presentedSeries);
		}

		// We have a match for this user/series combination
		if (!presentedToken.equals(token.getTokenValue())) {
			// Token doesn't match series value. Delete all logins for this user and throw
			// an exception to warn them.
			tokenRepository.removeToken(token.getUsername());

			throw new CookieTheftException(
					messages.getMessage(
							"PersistentTokenBasedRememberMeServices.cookieStolen",
							"Invalid remember-me token (Series/token) mismatch. Implies previous cookie theft attack."));
		}

		if (token.getDate().getTime() + getTokenValiditySeconds() * 1000L < System
				.currentTimeMillis()) {
			throw new RememberMeAuthenticationException("Remember-me login has expired");
		}

		// Token also matches, so login is valid. Update the token value, keeping the
		// *same* series number.
		if (logger.isDebugEnabled()) {
			logger.debug("Refreshing persistent login token for user '"
					+ token.getUsername() + "', series '" + token.getUsername() + "'");
		}

		RedisRememberMeToken newToken = new RedisRememberMeToken(token.getUsername(), token.getSeries(), generateTokenData(), new Date());

		if(!tokenRepository.exists(newToken.getUsername())){
			tokenRepository.storeToken(newToken.getUsername(), newToken);
			addCookie(newToken, request, response);
		}else{
			logger.error("Failed to update token: Token Already Exists");
			throw new RememberMeAuthenticationException("Autologin failed due to data access problem");
		}

		return getUserDetailsService().loadUserByUsername(token.getUsername());
	}

	private void addCookie(RedisRememberMeToken token, HttpServletRequest request, HttpServletResponse response) {
		setCookie(new String[] { token.getUsername(), token.getTokenValue() }, getTokenValiditySeconds(), request, response);
	}

	protected String generateSeriesData() {
		byte[] newSeries = new byte[seriesLength];
		random.nextBytes(newSeries);
		return new String(Base64.encode(newSeries));
	}

	protected String generateTokenData() {
		byte[] newToken = new byte[tokenLength];
		random.nextBytes(newToken);
		return new String(Base64.encode(newToken));
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
		super.logout(request, response, authentication);
		String username = authentication.getName();
		tokenRepository.removeToken(username);
	}

}
