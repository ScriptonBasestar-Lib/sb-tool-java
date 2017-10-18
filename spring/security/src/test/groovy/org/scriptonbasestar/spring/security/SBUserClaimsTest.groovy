package org.scriptonbasestar.spring.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.junit.Test
import org.scriptonbasestar.spring.security.jwt.dto.SBAuthorizedUserClaims
import org.scriptonbasestar.tool.collection.builder.MapBuilder

/**
 * @author chaeeung.e
 * @since 2017-09-28
 */
class SBUserClaimsTest {

	private static final String SIGNING_KEY = "jr092j0309r203rj032"

	@Test
	void 'token serialization - deserialization test'() {
		SBAuthorizedUserClaims claims = new SBAuthorizedUserClaims()
//		Map<String,String[]> userRoles = new HashMap<>()
//		userRoles.put("ROLE_BRIDGE_USER", ["AUTH_READ","AUTH_WRITE","AUTH_EXECUTE"])
		claims.put("uro", MapBuilder.create(String.class, String[].class).add("ROLE_BRIDGE_USER", ["AUTH_READ","AUTH_WRITE","AUTH_EXECUTE"]).build())

		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
				.setClaims(claims)
				.compact()

		claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody()
		println(claims)
	}
}
