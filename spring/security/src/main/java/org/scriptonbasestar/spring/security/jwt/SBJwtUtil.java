package org.scriptonbasestar.spring.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.experimental.UtilityClass;
import org.scriptonbasestar.spring.security.jwt.dto.SBAuthorizedUserClaims;

/**
 * @author archmagece
 * @since 2017-09-19
 */
@UtilityClass
public class SBJwtUtil {

	public static String generateToken(String signingKey, Claims claims) {
		return Jwts.builder().signWith(SignatureAlgorithm.HS256, signingKey)
				.setClaims(claims)
				.compact();
	}

	public static SBAuthorizedUserClaims getBody(String signingKey, String token) {
		Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
		return new SBAuthorizedUserClaims(claims, true, true, true, true);
	}

	public static SBAuthorizedUserClaims getBody(String signingKey, SBJwtHandler JwtHandler, String token) {
		Claims claims = Jwts.parser().setSigningKey(signingKey).parse(token, JwtHandler);
		return new SBAuthorizedUserClaims(claims, true, true, true, true);
	}

}
