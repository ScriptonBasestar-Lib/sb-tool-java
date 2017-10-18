package org.scriptonbasestar.spring.security

/**
 * @author chaeeung.e
 * @since 2017-10-10
 */
class SBBearerTest {

	static void main(String[] args) {
		def authheader0 = "Bearer j0j9030jf3909f03290r90j"
		def authheader1 = "BEARER j0j9030jf3909f03290r90j"
		def authheader2 = "BEARER  j0j9030jf3909f03290r90j"

		println authheader0.matches("^(?i)Bearer\\s+.+")

		println authheader0.split("(?i)Bearer\\s+")
		println authheader1.split("(?i)Bearer\\s+")
		println authheader2.split("(?i)Bearer\\s+")

	}
}
