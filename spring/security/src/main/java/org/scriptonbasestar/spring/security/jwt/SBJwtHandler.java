package org.scriptonbasestar.spring.security.jwt;

import io.jsonwebtoken.*;

/**
 * @author chaeeung.e
 * @since 2017-09-21
 */
public class SBJwtHandler implements JwtHandler<SBUserClaims> {
	@Override
	public SBUserClaims onPlaintextJwt(Jwt<Header, String> jwt) {
		return null;
	}

	@Override
	public SBUserClaims onClaimsJwt(Jwt<Header, Claims> jwt) {
		Claims claims = jwt.getBody();
		claims.put(SBUserClaims.USER_ID, new Long(((Integer) claims.get("uid")).intValue()));
		return new SBUserClaims();
	}

	@Override
	public SBUserClaims onPlaintextJws(Jws<String> jws) {
		return null;
	}

	@Override
	public SBUserClaims onClaimsJws(Jws<Claims> jws) {
		Claims claims = jws.getBody();
		claims.put(SBUserClaims.USER_ID, new Long(((Integer) claims.get("uid")).intValue()));
		return new SBUserClaims(jws.getBody());
	}
}
