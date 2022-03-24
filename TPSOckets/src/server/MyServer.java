package server;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws Exception {
		
		// la cr�ation de l'objet ServerSocket
		ServerSocket ss = new ServerSocket(1234);		
		
		// Attendre une connexion d'un client
		System.out.println("J'attend la connexion...");
		Socket s = ss.accept();
		
		/*
		 * Apr�s la connexion on va cr�er les objets 
		 * InputStream : pour lire un octet envoy�e par le client
		 * OutputStream : pour envoie une r�ponse � le client 
		 */
		
		System.out.println("Connexion d'un client "+s.getRemoteSocketAddress());
		InputStream is = s.getInputStream();
		OutputStream os = s.getOutputStream();
		
		// Lire un octet envoy�e par le client
		System.out.println("Jattend que le client envoie un octet..");
		int nb = is.read();			
		
		System.out.println("J'ai re�u un nombre "+nb);
		int res = nb*5;
		
		// J'envoie la r�ponse � le client
		System.out.println("J'envoie la r�ponse "+res);
		os.write(res);
		
		// fermer le blocage de Socket
		s.close();
		
		/*
		 * - pour lire un caract�re envoy�e par le client
		 * 		InputStream is = s.getInputStream();
		 * 		InputStreamReder isr = new InputStreamReder(is);		 
		 * - pour lire une chaine de caract�re
		 * 		BufferedReader br = new BufferedReader(isr);
		 * 		String s = br.readLine();
		 * - pour envoyer une chaine de caract�re au client
		 * 		OutputStream os = s.getOutputStream();
		 * 		PrintWriter pw = new PrintWriter(os, true);
		 * 		pw.println("chaine de carat�res");
		 */

	}

}
