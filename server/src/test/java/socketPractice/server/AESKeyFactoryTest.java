package socketPractice.server;

import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AESKeyFactoryTest extends TestCase {

	AESKeyFactory keyFactory;
	
	protected void setUp() throws Exception {
		super.setUp();
		keyFactory = new AESKeyFactory();
	}
	
    
    /**
     * Simple Encoding Test
     */
    public void testGenerateKey() 
    {
		SecretKeySpec result = keyFactory.generateKey();
		assertNotNull(result);
		assertEquals(result.getAlgorithm(), "AES");
	}

}
