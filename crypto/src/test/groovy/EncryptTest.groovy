import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.binary.StringUtils
import org.junit.Assert
import org.junit.Test
import org.scriptonbasestar.tool.crypto.symmetry.ISBSymmetryService
import org.scriptonbasestar.tool.crypto.symmetry.SymmetryAlgorithm
import org.scriptonbasestar.tool.crypto.symmetry.SymmetryServiceImpl

class EncryptTest {
	@Test
	void rc2test() {
		String stringIn = "testtext111"
		println("stringIn string: $stringIn")
		byte[] bytesIn = stringIn.getBytes("UTF-8")
		println("bytesIn byte[]: $bytesIn")

		ISBSymmetryService byteEncryptor = new SymmetryServiceImpl(SymmetryAlgorithm.RC2_40, "r390prifk0p2i03082")
		byte[] bytesEncrypted = byteEncryptor.encrypt(bytesIn)
		println("bytesEncrypted byte[]:  $bytesEncrypted")
		println("bytesEncrypted 변환 string: ${Hex.encodeHexString(bytesEncrypted)}")

		byte[] bytesDecrypted = byteEncryptor.decrypt(bytesEncrypted)
		println("bytesDecrypted byte[]: $bytesDecrypted")
		String stringDecrypted = StringUtils.newStringUtf8(bytesDecrypted)
		println("stringDecrypted string: $stringDecrypted")

		Assert.assertArrayEquals(bytesIn, bytesDecrypted)
		Assert.assertEquals(stringIn, stringDecrypted)
	}
}
