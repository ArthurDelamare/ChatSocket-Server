package socketPractice.server;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class AESKeyFactory implements IKeyFactory {
	
	public SecretKeySpec generateKey() {
		KeyGenerator keyGenerator;
		SecretKeySpec keySpec = null;
		try {
			keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			byte[] key = keyGenerator.generateKey().getEncoded();
			keySpec = new SecretKeySpec(key, "AES");
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return keySpec;
	}

}
