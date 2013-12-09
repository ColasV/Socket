package socket;

import java.net.ServerSocket;

/**
 * Classe Serveur qui creer une instance de serveur et ecoute sur le port 5000
 *  
 * @author Nicolas Vignes
 *
 */

public class Serveur {

	private static final int PORT = 5000;
	private static ServerSocket s;
	
	/**
	 * Fonction principale qui ecoute sur le port 5000
	 * Creer un Thread pour dialoguer avec le serveur pour chaque connexion reçu
	 * 
	 */
	
	public void createServeur() {
		
		try {
			s = new ServerSocket(PORT);
			
			System.out.println("listening on port " + PORT);
			
			while(true) {
				new ServeurThread(s.accept());
			}
			
		} catch (Exception e) {
			System.out.println("Petite erreur");
		}

		
	}
		
}
