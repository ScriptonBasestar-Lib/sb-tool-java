package org.scriptonbasestar.spring.security.jwt.filter;

import org.scriptonbasestar.spring.security.jwt.SBJwtCookieUtil;
import org.scriptonbasestar.tool.core.exception.compiletime.SBTextExtractException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
public class SBJwtAuthCookieFilter extends SBJwtAbstractFilter {

	@Override
	protected String extractTokenString(HttpServletRequest request, HttpServletResponse response) throws SBTextExtractException {
		String token = SBJwtCookieUtil.tokenFromCookie(request, serviceName, signingKey);
		if (token == null) {
			throw new SBTextExtractException("쿠키가 존재하지 않습니다.");
		}
		return token;
	}

}
