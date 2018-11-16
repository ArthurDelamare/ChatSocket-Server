package socketPractice.server.keyManagement;

import javax.crypto.spec.SecretKeySpec;

public interface IKeyFactory {

	 public SecretKeySpec generateKey();
	 
	
}
