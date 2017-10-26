package org.scriptonbasestar.tool.credential

import javax.crypto.Cipher
import javax.crypto.SecretKey

/**
 * @author archmagece
 * @since 2017-10-19
 */
class SBCredentialDecoder {

	private val cipher: Cipher

	constructor(desKey: SecretKey){
		cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
		cipher.init(Cipher.DECRYPT_MODE, desKey)
	}

	fun decode(textEncrypted:ByteArray):ByteArray{
		var textDecrypted = cipher.doFinal(textEncrypted)
		return textDecrypted
	}

}
