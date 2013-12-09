package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
    
    public static void main(String[] zero) {
        
        
        Socket socket;
        BufferedReader in;
        PrintWriter out;

        try {
        
        	socket = new Socket(InetAddress.getLocalHost(),5000);   
            System.out.println("Demande de connexion ...");
            
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            w.write(String.valueOf(10));
            w.flush();            
            
            System.out.println("Envoie de la valeur ...");
            System.out.println("Attente de la réponse ...");
            
            in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
            String message_distant = in.readLine();
            int i = Integer.parseInt(message_distant);
            System.out.println("value : " + i);
                
            socket.close();
               
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
