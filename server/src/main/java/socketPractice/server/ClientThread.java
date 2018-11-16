package socketPractice.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;

import javax.crypto.spec.SecretKeySpec;

public class ClientThread implements IClient, Runnable {

	private int clientID;
	private SecretKeySpec keySpec;
	private Socket socket;
	
	public ClientThread(int clientID, Socket socket, SecretKeySpec keySpec) {
		this.clientID = clientID;
		this.socket = socket;
		this.keySpec = keySpec;
	}
	
	public void run() {
		
		try {
			
			BufferedReader input = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), Charset.forName("UTF-8")));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			output.print("Bienvenue, vous êtes le client numéro " + this.clientID);
			
			while (input.ready()) {
				String content = input.readLine();
				Logger.WriteLog("[Client" + clientID + "] " + content);
			}
			
		} catch (IOException e) {
			Logger.WriteLog("Erreur lors de la gestion du client numéro " + this.clientID);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				Logger.WriteLog("Impossible de couper la connexion du socket du client numéro " + this.clientID);
			}
			Logger.WriteLog("La connexion avec le client numéro " + this.clientID + " est maintenant fermé.");
		}
		
	}

}
