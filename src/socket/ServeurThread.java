package socket;

import java.io.*;
import java.net.*;
//import java.util.*;

/**
 * Classe ServeurThread qui s'occupe de communiquer avec un client
 * 
 * @author Nicolas Vignes
 *
 */


public class ServeurThread implements Runnable {

    Socket ns;
	
	public ServeurThread(Socket s) {

        try {
        	this.ns = s;
        	Thread t = new Thread(this);
        	t.start();
        	
        } catch (Exception e) {
			System.err.println("not an integer");
		} 
    }
	

	@Override
	public void run() {
		System.out.println("ServeurThread demarre");
		
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(this.ns.getInputStream()));
			char[] cbuf = new char[100];
			String v = new String(cbuf, 0, r.read(cbuf, 0, cbuf.length));
			System.out.println("got: " + v);	
			int i = Integer.parseInt(v);
			i = i*i;
			
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(this.ns.getOutputStream()));
			w.write(String.valueOf(i));
			w.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
	    {
	      try
	      {
	      	ns.close();
	      }
	      catch (IOException e){ }
	    }
		
		
		
		
	}
	
	
}
