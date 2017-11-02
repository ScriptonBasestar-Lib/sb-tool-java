package org.scriptonbasestar.spring.security.jwt.filter;

import org.scriptonbasestar.tool.core.exception.compiletime.SBTextExtractException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author archmagece
 * @since 2017-09-19
 */
public class SBJwtAuthHeaderFilter extends SBJwtAbstractFilter {

	@Override
	protected String extractTokenString(HttpServletRequest request, HttpServletResponse response) throws SBTextExtractException {
		String authHeader = request.getHeader("Authorization");
		if (authHeader == null) {
			throw new SBTextExtractException("인증 헤더가 없습니다.");
		}
		if (!authHeader.matches("^(?i)Bearer\\s+.+")) {
			throw new SBTextExtractException("JWT 인증 헤더가 아닙니다.");
		}
		return authHeader.split("(?i)Bearer\\s+")[1];
	}

}
