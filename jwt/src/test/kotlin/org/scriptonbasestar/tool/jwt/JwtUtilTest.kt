package org.scriptonbasestar.tool.jwt

import org.junit.Test

/**
 * @author chaeeung.e
 * @since 2017-10-30
 */
class JwtUtilTest {
	@Test
	fun jwtUtil1(){
		JwtUtil.encodedToken("{\n" +
				"         \"alg\": \"HS256\",\n" +
				"  \"typ\": \"JWT\"\n" +
				"       }", "")
	}
}