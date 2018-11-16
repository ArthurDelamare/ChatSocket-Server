package socketPractice.server;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

public class LoggerTest extends TestCase {
	
	public void testFullPathPropery() {
		assertNotNull(Logger.RELATIVE_DIRECTORY_PATH);
		String expected = Logger.RELATIVE_DIRECTORY_PATH + Logger.FILE_NAME;
		assertEquals(expected, Logger.FULL_PATH);
		System.out.println(expected);
	}
	
	public void testWrite() throws IOException {
		Logger.WriteLog("Test");
		assertTrue(new File(Logger.FULL_PATH).exists());
	}

}
