package org.scriptonbasestar.spring.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.junit.Test
import org.scriptonbasestar.spring.security.jwt.dto.SBAuthorizedUserClaims
import org.scriptonbasestar.tool.collection.builder.MapBuilder
import org.scriptonbasestar.tool.collection.builder.SetBuilder
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

/**
 * @author archmagece
 * @since 2017-09-28
 */
class SBUserClaimsTest {

	private static final String SIGNING_KEY = "u90rtf2w903eptrfiu29o34eitrf02i0tr5f2i0wq"

	@Test
	void 'token serialization - deserialization test'() {
		Claims claims = new SBAuthorizedUserClaims(
				-1,
				"MASTER",
				"MASTER",
				SetBuilder.create(String.class).add("ROLE_RESOURCE_MASTER").build(),
				true,true,true,true
//				SetBuilder.create(GrantedAuthority.class).add(new SimpleGrantedAuthority("ROLE_RESOURCE_USER")).build()
		)
//		Map<String,String[]> userRoles = new HashMap<>()
//		userRoles.put("ROLE_BRIDGE_USER", ["AUTH_READ","AUTH_WRITE","AUTH_EXECUTE"])

		String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
				.setClaims(claims)
				.compact()
		println(token)

		claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody()
		println(claims)
	}
}
