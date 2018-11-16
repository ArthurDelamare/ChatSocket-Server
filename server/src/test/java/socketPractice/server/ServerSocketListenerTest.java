package socketPractice.server;

import junit.framework.TestCase;

public class ServerSocketListenerTest extends TestCase {

	public void testServerCreation() {
		Thread thread = new Thread(new ServerSocketListener());
		thread.start();
	}
	
}
