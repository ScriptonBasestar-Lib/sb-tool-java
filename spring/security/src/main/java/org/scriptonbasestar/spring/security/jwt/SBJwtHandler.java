package org.scriptonbasestar.spring.security.jwt;

import io.jsonwebtoken.*;
import org.scriptonbasestar.spring.security.jwt.dto.SBAuthorizedUserClaims;

/**
 * @author archmagece
 * @since 2017-09-21
 */
public class SBJwtHandler implements JwtHandler<SBAuthorizedUserClaims> {
	@Override
	public SBAuthorizedUserClaims onPlaintextJwt(Jwt<Header, String> jwt) {
		return fromString(jwt.getBody());
	}

	@Override
	public SBAuthorizedUserClaims onPlaintextJws(Jws<String> jws) {
		return fromString(jws.getBody());
	}

//	private Gson gson = new
	private SBAuthorizedUserClaims fromString(String jwtBody){
//		Gson
//		SBAuthorizedUserClaims result = new SBAuthorizedUserClaims()
//		return result;
		return null;
	}

	@Override
	public SBAuthorizedUserClaims onClaimsJwt(Jwt<Header, Claims> jwt) {
		return fromClaims(jwt.getBody());
	}

	@Override
	public SBAuthorizedUserClaims onClaimsJws(Jws<Claims> jws) {
		return fromClaims(jws.getBody());
	}

	private SBAuthorizedUserClaims fromClaims(Claims claims){
		claims.put(SBAuthorizedUserClaims.USER_ID, new Long(((Integer) claims.get("uid")).intValue()));
		return new SBAuthorizedUserClaims(claims, true, true, true, true);
	}
}
