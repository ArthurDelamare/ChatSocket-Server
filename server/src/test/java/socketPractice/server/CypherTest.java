package socketPractice.server;


import javax.crypto.spec.SecretKeySpec;
import junit.framework.TestCase;
import socketPractice.server.Cypher.Cypher;
import socketPractice.server.keyManagement.AESKeyFactory;

public class CypherTest extends TestCase{

	SecretKeySpec keySpec;
	
	public void setUp() throws Exception {
		keySpec = new AESKeyFactory().generateKey();
	}

	public void testEncode() {
		String result = Cypher.Encode("Test", keySpec);
		assertNotNull(result);
		assertNotSame("Test", result);
	}
	
	public void testDecode() {
		String value = Cypher.Encode("Test", keySpec);
		assertNotNull(value);
		assertNotSame("Test", value);
		String result = Cypher.Decode(value, keySpec);	
		assertNotNull(result);
		assertEquals("Test", result);
	}

}
