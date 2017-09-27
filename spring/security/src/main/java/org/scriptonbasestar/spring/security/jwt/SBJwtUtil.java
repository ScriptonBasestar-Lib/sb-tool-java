package org.scriptonbasestar.spring.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.experimental.UtilityClass;

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
@UtilityClass
public class SBJwtUtil {

	public static String generateToken(String signingKey, Claims claims) {
		return Jwts.builder().signWith(SignatureAlgorithm.HS256, signingKey)
				.setClaims(claims)
				.compact();
	}

	public static SBUserClaims getBody(String signingKey, String token) {
		Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
		return new SBUserClaims(claims);
	}

	public static SBUserClaims getBody(String signingKey, SBJwtHandler JwtHandler, String token) {
		Claims claims = Jwts.parser().setSigningKey(signingKey).parse(token, JwtHandler);
		return new SBUserClaims(claims);
	}

}
