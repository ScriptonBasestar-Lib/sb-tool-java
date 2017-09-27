package org.scriptonbasestar.spring.security.jwt;

import io.jsonwebtoken.*;

/**
 * @author chaeeung.e
 * @since 2017-09-21
 */
public class SBJwtHandler implements JwtHandler<SBClaimsDto> {
	@Override
	public SBClaimsDto onPlaintextJwt(Jwt<Header, String> jwt) {
		return null;
	}

	@Override
	public SBClaimsDto onClaimsJwt(Jwt<Header, Claims> jwt) {
		Claims claims = jwt.getBody();
		claims.put(SBClaimsDto.USER_ID, new Long(((Integer) claims.get("uid")).intValue()));
		return new SBClaimsDto();
	}

	@Override
	public SBClaimsDto onPlaintextJws(Jws<String> jws) {
		return null;
	}

	@Override
	public SBClaimsDto onClaimsJws(Jws<Claims> jws) {
		Claims claims = jws.getBody();
		claims.put(SBClaimsDto.USER_ID, new Long(((Integer) claims.get("uid")).intValue()));
		return new SBClaimsDto(jws.getBody());
	}
}
