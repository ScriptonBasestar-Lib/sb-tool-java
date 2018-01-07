import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.binary.StringUtils
import org.junit.Test
import org.scriptonbasestar.tool.crypto.symmetry.RC2
import org.scriptonbasestar.tool.crypto.symmetry.SBSymmetryService

class EncryptTest {
	@Test
	void rc2test(){
		SBSymmetryService byteEncryptor = new RC2("r390prifk0p2i03082")
		byte[] bytesIn = byteEncryptor.encrypt("test".getBytes("UTF-8"))
		println(bytesIn)
//		println(StringUtils.newStringUtf8(bytesIn))
		def hexByte = Hex.encodeHexString(bytesIn)
		println(hexByte)

		println(Hex.decodeHex(hexByte.chars))
		byte[] bytesOut = byteEncryptor.decrypt(Hex.decodeHex(hexByte.chars))
		println(bytesOut)
		println(StringUtils.newStringUtf8(bytesOut))
	}
}
