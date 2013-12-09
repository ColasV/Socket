package main;

import java.util.Scanner;

import files.Files;
import socket.Client;
import socket.Serveur;

public class Start {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		System.out.println("==== Menu =====");
		System.out.println("1. Serveur");
		System.out.println("2. Client");
		String str = sc.nextLine();
		int value = Integer.parseInt(str);
		
		switch (value) {
			case 1:
				new Serveur().createServeur();
				break;
			case 2:
				new Client().createClient();
				break;
			default:
				throw new Exception("Entree utilisateur invalide");
		}
	}

}
