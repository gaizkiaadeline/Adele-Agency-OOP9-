package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.ActorActrees;
import model.Agency;

public class Main {
//	25019724943
//	Gaizkia Adeline Atmaka
//	Assignment Session 9 
	
	Scanner s = new Scanner(System.in);
	ArrayList<Agency> artistList = new ArrayList<>(); 

	public Main() {
		MainMenu();
	
	}
	
	void MainMenu() {
		int in = 0;
		
		do {
			System.out.println("~Adele Entertaiment~");
			System.out.println("--------------------");
			System.out.println("1. View All Artist");
			System.out.println("2. Hire Artist");
			System.out.println("3. Fire Artist");
			System.out.println("4. Delete Artist");
			System.out.println("5. Update Profile Artist");
			System.out.println("6. Exit");
			
			System.out.print("\nChoose :");
			in = s.nextInt(); s.nextLine();
			
			switch (in) {
			case 1:
				viewArtist();
				break;
			case 2:
				recruitArtist();
				break;
			case 3:
				fireArtist();
				break;		
			case 4:
				deleteArtist();
				break;
			case 5:
				updateProfileArtist();
				break;
			case 6:
				System.out.println("GoodBye..");
				break;				
				}
			
		} while (in!=6);
		
	}
	
	String generateArtistID() {
		String ID = "";
//		if()
		
		
		return ID;
	}
	
	void viewArtist() {
		
		Utility.CLS();
		
		System.out.println("===== ARTIST =====\n");
		
		for (Agency i : artistList) {
			System.out.println("\n>>>>> " + i.getName() + " <<<<<");
			System.out.println("ID : " + i.getID());
			System.out.println("Type : " + i.getArtistType());
			System.out.println("Popularity Rank : " + i.getPopularityRank());
			System.out.println("Gender : " + i.getGender());
			System.out.println("Age : " + i.getAge());
			
		}
		
		Utility.enter();
		
	}
	
	void recruitArtist() {
		Utility.CLS();
		
		System.out.println("===== HIRE ARTIST =====\n");
	
//		private final String ID;
//		private Integer age;
//		private String artistType;
//		private Integer popularityRank;
		
		String artistID = "";
		String name = "", gender = "", artistType = "";
		Integer age = 0, popularityRank = 0, height = 0, weight = 0;
		
		do {
			System.out.print("Input Name : ");
			name = s.nextLine();
		} while (name.length() < 1);
		
		do {
			System.out.print("Input Gender : ");
			gender = s.nextLine();
		} while (!gender.equals("Female") && !gender.equals("Male"));
		
		do {
			System.out.print("Input Age : ");
			age = s.nextInt(); s.nextLine();
		} while (age < 1);
		
		do {
			System.out.print("Input Artist Type : ");
			artistType = s.nextLine();
		} while (!artistType.equals("Actor") && !artistType.equals("Actrees") && !artistType.equals("Singer") 
				&& !artistType.equals("Model") && !artistType.equals("Comedian"));
		
		do {
			System.out.print("Input Popularity Rank : ");
			popularityRank = s.nextInt(); s.nextLine();
		} while (popularityRank < 0 || popularityRank > 100);
		
		artistID = generateArtistID();
		
		if(artistType.equals("Actor")  || artistType.equals("Actrees")) {
			do {
				System.out.print("Input Height : ");
				height = s.nextInt(); s.nextLine();
			} while (height < 100);
			
			do {
				System.out.print("Input Weight : ");
				weight = s.nextInt(); s.nextLine();
			} while (weight < 5);
			
			artistList.add(new ActorActrees(artistID, name, gender, age, artistType, popularityRank, height, weight));
			
		}
		
		if(artistType.equals("Model")) {
			do {
				System.out.print("Input Height : ");
				height = s.nextInt(); s.nextLine();
			} while (height < 100);
			
			do {
				System.out.print("Input Weight : ");
				weight = s.nextInt(); s.nextLine();
			} while (weight < 5);
			
		}
		
		Utility.enter();
		
		
	
		
	}
	void fireArtist() {
		Utility.CLS();
		
	}
	void deleteArtist() {
		Utility.CLS();
		
	}
	void updateProfileArtist() {
		Utility.CLS();
		
	}
	
	
	
	public static void main(String[] args) {
		new Main();
	}

}
