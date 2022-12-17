package main;

import java.util.Scanner;

public class Utility {

	private static Scanner s = new Scanner(System.in);
	
	public static void enter() {
		System.out.println("Press Enter to Continue...");
		s.nextLine();
	}

	public static void CLS() {
		for(int i=0; i<50; i++) {
			System.out.println("");
		}
	}
}
