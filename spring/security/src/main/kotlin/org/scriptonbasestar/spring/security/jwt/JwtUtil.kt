package org.scriptonbasestar.spring.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

/**
 * @author chaeeung.e
 * @since 2017-09-19
 */
class JwtUtil {
	companion object {
		fun generateToken(signingKey:String, claims:Claims):String{
			return Jwts
					.builder()
					.signWith(SignatureAlgorithm.ES256, signingKey)
					.setClaims(claims)
					.compact()
		}
		fun extractClaims(signingKey: String, token:String):Claims{
			return Jwts.parser()
					.setSigningKey(signingKey)
					.parseClaimsJws(token)
					.body
		}
	}
}