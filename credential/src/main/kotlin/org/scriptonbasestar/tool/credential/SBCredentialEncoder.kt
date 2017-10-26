package org.scriptonbasestar.tool.credential

import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

/**
 * @author archmagece
 * @since 2017-10-19
 * 기본옵션 des + base64
 */
class SBCredentialEncoder {

	private val map:HashMap<String,String> = HashMap()

	private val cipher:Cipher

	constructor(desKey: SecretKey){
		cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
		cipher.init(Cipher.ENCRYPT_MODE, desKey)
	}

	fun add(key0:String,val0:String) : SBCredentialEncoder{
		map.put(key0, val0)
		return this
	}

	fun encode():ByteArray{
		var sb = StringBuilder()
		map.forEach { t, u ->  sb.append(t).append(":").append(u).append(";") }

		var text =  sb.toString().toByteArray()
		var textEncrypted = cipher.doFinal(text)

		return textEncrypted
	}

}
