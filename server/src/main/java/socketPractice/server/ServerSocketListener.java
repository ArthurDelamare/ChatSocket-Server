package socketPractice.server;

import java.awt.List;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import socketPractice.server.keyManagement.AESKeyFactory;

public class ServerSocketListener implements Runnable {

	@Override
	public void run(){
		try {
			ServerSocket serverSocket = new ServerSocket(9898);
			Map<Integer, IClient> clientsList = new HashMap<Integer, IClient>();
			int clientCounter = 1;
			AESKeyFactory aesKeyFactory = new AESKeyFactory();
			SecretKeySpec keySpec = aesKeyFactory.generateKey();
			
			while (true) {
				ClientThread clientThread = new ClientThread(clientCounter, serverSocket.accept(), keySpec);
				clientsList.put(clientCounter, clientThread);
				new Thread(clientThread).start();
				clientCounter++;
			}
		} catch (Exception e) {
			Logger.WriteLog("Erreur lors du démarrage du serveur: " + e.getMessage());
		}
	}
	
	
}
