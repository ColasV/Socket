package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Files {
	
	FileWriter fichier;
	
	
	public Files(String name) {
		try {
			fichier = new FileWriter(System.getProperty("user.dir" ) + "/" + name, true);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void write(String s) throws IOException {
		fichier.write(s);
	}
	
	public void close() throws IOException {
		fichier.close();
	}
	
}
