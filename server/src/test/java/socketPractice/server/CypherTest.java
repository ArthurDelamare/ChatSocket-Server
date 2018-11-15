package socketPractice.server;

import static org.junit.Assert.*;

import javax.crypto.spec.SecretKeySpec;

import org.junit.Before;
import org.junit.Test;

public class CypherTest {

	SecretKeySpec keySpec;
	
	@Before
	public void setUp() throws Exception {
		keySpec = new AESKeyFactory().generateKey();
	}

	@Test
	public void testEncode() {
		String result = Cypher.Encode("Test", keySpec);
		assertNotNull(result);
		assertNotEquals("Test", result);
	}
	
	@Test
	public void testDecode() {
		String value = Cypher.Encode("Test", keySpec);
		assertNotNull(value);
		assertNotEquals("Test", value);
		System.out.println(value);
		String result = Cypher.Decode(value, keySpec);	
		assertNotNull(result);
		assertEquals("Test", result);
	}

}
