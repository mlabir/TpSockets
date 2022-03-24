package server;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws Exception {
		
		// la création de l'objet ServerSocket
		ServerSocket ss = new ServerSocket(1234);		
		
		// Attendre une connexion d'un client
		System.out.println("J'attend la connexion...");
		Socket s = ss.accept();
		
		/*
		 * Après la connexion on va créer les objets 
		 * InputStream : pour lire un octet envoyée par le client
		 * OutputStream : pour envoie une réponse à le client 
		 */
		
		System.out.println("Connexion d'un client "+s.getRemoteSocketAddress());
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		
		// Lire un octet envoyée par le client
		System.out.println("Jattend que le client envoie un octet..");
		int nb = is.read();			
		
		System.out.println("J'ai reçu un nombre "+nb);
		int res = nb*5;
		
		// J'envoie la réponse à le client
		System.out.println("J'envoie la réponse "+res);
		os.write(res);
		
		// fermer le blocage de Socket
		s.close();
		
		/*
		 * - pour lire un caractère envoyée par le client
		 * 		InputStream is = s.getInputStream();
		 * 		InputStreamReder isr = new InputStreamReder(is);		 
		 * - pour lire une chaine de caractère
		 * 		BufferedReader br = new BufferedReader(isr);
		 * 		String s = br.readLine();
		 * - pour envoyer une chaine de caractère au client
		 * 		OutputStream os = s.getOutputStream();
		 * 		PrintWriter pw = new PrintWriter(os, true);
		 * 		pw.println("chaine de caratères");
		 */

	}

}
