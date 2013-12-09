package socket;

import java.net.ServerSocket;

public class Serveur {

	private static final int PORT = 5000;
	private static ServerSocket s;
	
	public static void main(String[] zero) {
		
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
