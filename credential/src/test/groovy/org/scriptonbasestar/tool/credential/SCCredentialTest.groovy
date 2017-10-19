package org.scriptonbasestar.tool.credential

import org.junit.Test

import javax.crypto.KeyGenerator

/**
 * @author chaeeung.e
 * @since 2017-10-19
 */
class SCCredentialTest {



	@Test
	void 'des encrypt-decrypt test'(){
		def keyGenerator = KeyGenerator.getInstance("DES")
		def desKey = keyGenerator.generateKey()

		def encoder = new SBCredentialEncoder(desKey)
		encoder.add("db.url", "jdbc:mysql://mysqladdr/dbd")
		encoder.add("db.user", "rootroot")
		encoder.add("db.pass", "4gt4rtgf")
		byte[] encodedArr = encoder.encode()
		println(encodedArr)
		println(new String(encodedArr))
		byte[] base64Arr = new byte[100]
		Base64.encoder.encode(encodedArr, base64Arr)
		println(new String(base64Arr))

		def encodedText = encoder.encode()
		def decoder = new SBCredentialDecoder(desKey)
		byte[] decodedArr = decoder.decode(encodedText)
		println(decodedArr)
		println(new String(decodedArr))

	}
}
