package socketPractice.server;

import java.nio.charset.Charset;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Cypher {
	
	public static String Encode(String str, SecretKeySpec keySpec) {
		try {
			Cipher cipher = Cipher.getInstance(keySpec.getAlgorithm());
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);
			return Base64.getUrlEncoder().encodeToString(cipher.doFinal(str.getBytes(Charset.forName("UTF-8"))));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static String Decode(String str, SecretKeySpec keySpec) {
		try {
			Cipher cipher = Cipher.getInstance(keySpec.getAlgorithm());
			cipher.init(Cipher.DECRYPT_MODE, keySpec);
			byte[] data =  Base64.getEncoder().encode(str.getBytes());
			return new String(cipher.doFinal(Base64.getDecoder().decode(data)), Charset.forName("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
