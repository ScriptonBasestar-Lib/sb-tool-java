package org.scriptonbasestar.tool.data.jpa

import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.binary.StringUtils
import org.scriptonbasestar.tool.crypto.symmetry.ISBSymmetryService
import org.scriptonbasestar.tool.crypto.symmetry.SymmetryServiceImpl

String DEFAULT_PASSWORD = "r390prifk0p2i03082"
String PLAIN_STRING_SAMPLE = "안녕 한글아"

def "utf-8 encrypt decrypt test"(PLAIN_STRING_SAMPLE) {
	byte[] barrPlain = StringUtils.getBytesUtf8(PLAIN_STRING_SAMPLE)
	println(barrPlain)
	String recovered = StringUtils.newStringUtf8(barrPlain)
	println(recovered)
}

"utf-8 encrypt decrypt test"(PLAIN_STRING_SAMPLE)


def "rc2test"(DEFAULT_PASSWORD, PLAIN_STRING_SAMPLE) {
	final ISBSymmetryService byteEncryptor = new SymmetryServiceImpl(DEFAULT_PASSWORD)

	//byte[] barrPlain = StringUtils.getBytesUtf8(PLAIN_STRING_SAMPLE)
	byte[] barrPlain = PLAIN_STRING_SAMPLE.getBytes()
	println("barrPlain:" + barrPlain)

	byte[] barrEncrypted = byteEncryptor.encrypt(barrPlain)
	println("barrEncrypted:" + barrEncrypted)

	//String strEncrypted = StringUtils.newStringIso8859_1(barrEncrypted)
	//String strEncrypted = StringUtils.getStringFromBytes(barrEncrypted)
	String strEncrypted = Hex.encodeHexString(barrEncrypted)
	//String strEncrypted = new String(barrEncrypted)
	println("strEncrypted:" + strEncrypted)
	println("strEncrypted length :" + strEncrypted.length())

	//dbdb
	//byte[] barrDecrypted = byteEncryptor.decrypt(StringUtils.getBytesIso8859_1(strEncrypted))
	//byte[] barrDecrypted = byteEncryptor.decrypt(StringUtils.getBytesIso8859_1(strEncrypted))
	byte[] barrDecrypted = byteEncryptor.decrypt(Hex.decodeHex(strEncrypted.toCharArray()))
	//byte[] barrDecrypted = byteEncryptor.decrypt(strEncrypted.getBytes())
	println(StringUtils.newStringUtf8(barrDecrypted))
	//println(new String(barrDecrypted))
}

"rc2test"(DEFAULT_PASSWORD, PLAIN_STRING_SAMPLE)

