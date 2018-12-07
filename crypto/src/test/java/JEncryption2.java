import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class JEncryption2 {
	public static void main(String[] argv) {

		try {
			KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
			SecretKey myDesKey = keygenerator.generateKey();

			Cipher desCipher1 = Cipher.getInstance("DES/ECB/PKCS5Padding");
			// Initialize the cipher for encryption
			desCipher1.init(Cipher.ENCRYPT_MODE, myDesKey);

			//sensitive information
			byte[] text = "No body can see me".getBytes();

			System.out.println("Text [Byte Format] : " + text);
			System.out.println("Text : " + new String(text));

			// Encrypt the text
			byte[] textEncrypted = desCipher1.doFinal(text);

			System.out.println("Text Encryted : " + textEncrypted);


			Cipher desCipher2 = Cipher.getInstance("DES/ECB/PKCS5Padding");
			// Initialize the same cipher for decryption
			desCipher2.init(Cipher.DECRYPT_MODE, myDesKey);

			// Decrypt the text
			byte[] textDecrypted = desCipher2.doFinal(textEncrypted);

			System.out.println("Text Decryted : " + new String(textDecrypted));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

	}
}
