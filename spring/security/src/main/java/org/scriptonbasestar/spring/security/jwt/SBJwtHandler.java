package org.scriptonbasestar.spring.security.jwt;

import io.jsonwebtoken.*;
import org.scriptonbasestar.spring.security.jwt.dto.SBUserClaims;

/**
 * @author chaeeung.e
 * @since 2017-09-21
 */
public class SBJwtHandler implements JwtHandler<SBUserClaims> {
	@Override
	public SBUserClaims onPlaintextJwt(Jwt<Header, String> jwt) {
		return fromString(jwt.getBody());
	}

	@Override
	public SBUserClaims onPlaintextJws(Jws<String> jws) {
		return fromString(jws.getBody());
	}

//	private Gson gson = new
	private SBUserClaims fromString(String jwtBody){
//		Gson
//		SBUserClaims result = new SBUserClaims()
//		return result;
		return null;
	}

	@Override
	public SBUserClaims onClaimsJwt(Jwt<Header, Claims> jwt) {
		return fromClaims(jwt.getBody());
	}

	@Override
	public SBUserClaims onClaimsJws(Jws<Claims> jws) {
		return fromClaims(jws.getBody());
	}

	private SBUserClaims fromClaims(Claims claims){
		claims.put(SBUserClaims.USER_ID, new Long(((Integer) claims.get("uid")).intValue()));
		return new SBUserClaims(claims, true, true, true, true);
	}
}
