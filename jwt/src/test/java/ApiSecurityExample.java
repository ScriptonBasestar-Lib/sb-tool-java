import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author chaeeung.e
 * @since 2017-10-27
 *
 * eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ
 */
public class ApiSecurityExample {

	final static String secret = "secret";
	final static String header = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
	final static String payload = "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9";
	final static String signature = "TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ";

	public static void main(String[] args) {
		try {
			System.out.println("=============== header ===============");
			String result_header1 = new String(Base64.decodeBase64(header));
			String result_header2 = new String(java.util.Base64.getDecoder().decode(header));
			System.out.println(result_header1);
			System.out.println(result_header2);

			System.out.println("=============== result ===============");
			String result_payload = new String(Base64.decodeBase64(payload));
			System.out.println(result_payload);

			System.out.println("=============== signature ===============");
			String result_signature = hmacDecoder(secret);
			System.out.println(result_signature);

			System.out.println(result_signature.equals(signature));
		}
		catch (Exception e){
			System.err.println("Error");
		}
	}

	static String hmacDecoder(String secret) throws NoSuchAlgorithmException, InvalidKeyException {
		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
		sha256_HMAC.init(secret_key);

		return Base64.encodeBase64String(sha256_HMAC.doFinal(String.format("%s.%s", header, payload).getBytes()));
	}
}