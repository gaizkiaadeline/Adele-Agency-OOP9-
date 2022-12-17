package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.ActorActrees;
import model.Agency;
import model.Comedian;
import model.Model;
import model.Singer;

public class Main {
//	25019724943
//	Gaizkia Adeline Atmaka
//	Assignment Session 9 
	
	Scanner s = new Scanner(System.in);
	ArrayList<Agency> artistList = new ArrayList<>(); 
	
	String artistID = "";
	String name = "", gender = "", artistType = "", fire, update;
	Integer age = 0, popularityRank = 0, height = 0, weight = 0;

	public Main() {
		MainMenu();
	
	}
	
	void MainMenu() {
		int in = 0;
		
		do {
			Utility.CLS();
			
			System.out.println("~Adele Entertaiment~");
			System.out.println("--------------------");
			System.out.println("1. View All Artist");
			System.out.println("2. Hire Artist");
			System.out.println("3. Delete Artist");
			System.out.println("4. Update Profile Artist");
			System.out.println("5. Artist Activity");
			System.out.println("6. Exit");
			
			System.out.print("\nChoose :");
			in = s.nextInt(); s.nextLine();
			
			switch (in) {
			case 1:
				viewArtist();
				Utility.enter();
				break;
			case 2:
				recruitArtist();
				Utility.enter();
				break;
			case 3:
				deleteArtist();
				Utility.enter();
				break;
			case 4:
				updateProfileArtist();
				Utility.enter();
				break;
			case 5:
				artistActivity();
				Utility.enter();
				break;	
			case 6:
				System.out.println("GoodBye..");
				break;				
				}
			
		} while (in!=6);
		
	}
	

//	method untuk menampilkan semua data artist
	void viewArtist() {
		
		Utility.CLS();
		
		System.out.println("===== ARTIST =====\n");
		
		if (artistList.isEmpty()) {
			System.out.println("No Artist...");
		}
		
		for (Agency i : artistList) {
			System.out.println("\n>>>>> " + i.getName() + " <<<<<");
			System.out.println("ID : " + i.getID());
			System.out.println("Type : " + i.getArtistType());
			System.out.println("Popularity Rank : " + i.getPopularityRank());
			System.out.println("Gender : " + i.getGender());
			System.out.println("Age : " + i.getAge());
			
//			kita downcasting agar attribut yg ada di childclass tersebut bisa kita akses
//			caranya dengan melakukan typecast
			if(i instanceof ActorActrees) {
				System.out.println("Height : " + ((ActorActrees) i).getHeight() + " cm");
				System.out.println("Weight : " + ((ActorActrees) i).getWeight() + " kg");
			}

			if(i instanceof Model) {
				System.out.println("Height : " + ((Model) i).getHeight() + " cm");
				System.out.println("Weight : " + ((Model) i).getWeight() + " kg");
			}
			
		}
		
	}
	
//	method untuk memasukkan (add) artist
	void recruitArtist() {
		Utility.CLS();
		
		System.out.println("===== HIRE ARTIST =====\n");
		
//		nama artist di beri kondisi minimal 1 huruf
		do {
			System.out.print("Input Name : ");
			name = s.nextLine();
		} while (name.length() < 1);
		
//		kondisi harus Female / Male
//		Case Sensitive
		do {
			System.out.print("Input Gender : ");
			gender = s.nextLine();
		} while (!gender.equals("Female") && !gender.equals("Male"));
		
//		kondisi age minimal 1 tahun
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
		
//		artistID didapatkan dari method generateArtistID
		artistID = generateArtistID(artistType);
		
		if(artistType.equals("Actor")  || artistType.equals("Actrees")) {
			do {
				System.out.print("Input Height : ");
				height = s.nextInt(); s.nextLine();
			} while (height < 100);
			
			do {
				System.out.print("Input Weight : ");
				weight = s.nextInt(); s.nextLine();
			} while (weight < 5);
			
//			kita add langsung berdasarkan type nya agar tidak perlu membuat objek
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
			
			artistList.add(new Model(artistID, name, gender, age, artistType, popularityRank, height, weight));
		}

		if(artistType.equals("Comedian")) {
			
			artistList.add(new Comedian(artistID, name, gender, age, artistType, popularityRank));
		}
		
		if(artistType.equals("Singer")) {
			artistList.add(new Singer(artistID, name, gender, age, artistType, popularityRank));
		}
		
		System.out.println("\nArtist succesfully added");
		
	}
	
//	method untuk generate ID artist berdasarkan artistType
//	ID : 5 digit
//	2 digit pertama diambil dari initial artistType
//	3 digit berikutnya adalah angka random 0-9
	String generateArtistID(String artistType) {
		String ID = "";
		
		if (artistType.equals("Model")) {
			ID = "MO";
		}
		if (artistType.equals("Actor") || artistType.equals("Actrees")) {
			ID = "AC";
		}
		if (artistType.equals("Singer")) {
			ID = "SI";
		}
		if (artistType.equals("Comedian")) {
			ID = "CO";
		}
		
		for (int i = 0; i < 3; i++) {
			int temp;
//			Math.random() * (max-min) + min + 1
			temp = (int)Math.random() * (9 - 0) + 0 + 1;
			ID += temp;
		}
		
		return ID;
	}
	
//	method untuk mendelete artist berdasarkan arstist ID yang diinput
	void deleteArtist() {
		viewArtist();
		
		System.out.println("\n===== FIRE ARTIST =====");
		
		do {
			System.out.print("Input Artist ID : ");
			fire = s.nextLine();
		} while (fire.length() != 5);
		
		
		for (int i = 0; i < artistList.size(); i++) {
			if (fire.equals(artistID.charAt(i))) {
				artistList.remove(i);
			}
			else {
				System.out.println("Input ID is wrong. Try Again!");
			}
		}
	}
	
//	method untuk meng-update artist berdasarkan arstist ID yang diinput
	void updateProfileArtist() {
		viewArtist();
		
		do {
			System.out.print("Input Artist ID to update: ");
			update = s.nextLine();
		} while (update.length() != 5);
		
		int updatein;
		
		for (Agency i : artistList) {
			if (update.equals(artistID)) {
				System.out.println("\n===== UPDATE ARTIST =====\n");
				System.out.println("1. Name");
				System.out.println("2. Age");
				System.out.println("3. Popularity Rank");
				
				do {
					System.out.print("Choose : ");
					updatein = s.nextInt(); s.nextLine();
				} while (updatein < 1 || updatein > 5);
				
				switch (updatein) {
				case 1:
					do {
						System.out.print("Input Name : ");
						name = s.nextLine();
					} while (name.length() < 1);
					
					i.setName(name);
					break;

				case 2:
					do {
						System.out.print("Input Age : ");
						age = s.nextInt(); s.nextLine();
					} while (age < 1);
					
					i.setAge(age);
					break;
				case 3:
					do {
						System.out.print("Input Popularity Rank : ");
						popularityRank = s.nextInt(); s.nextLine();
					} while (popularityRank < 0 || popularityRank > 100);
					
					i.setPopularityRank(popularityRank);
					break;
				}
			}
			
			else {
				System.out.println("Input ID is wrong. Try Again!");
			}
		}

		System.out.println("\nArtist succesfully updated");
		
	}
	
//	method untuk memview aktivitas dari semua artist di agency
	public void artistActivity() {
		Utility.CLS();
		System.out.println("===== ACTIVITY =====\n");
		
		for (Agency i : artistList) {
			
			System.out.printf(">>>>> %s <<<<<\n", i.getName());
			
			if(i instanceof Model) {
				((Model) i).fashionShow();
			}
			else if(i instanceof ActorActrees) {
				((ActorActrees) i).filmingMovie();
				((ActorActrees) i).filmingDrama();
				((ActorActrees) i).scriptPractice();
			}
			else if(i instanceof Comedian) {
				((Comedian) i).standUpComedy();
				((Comedian) i).skit();
				((Comedian) i).roasting();
				((Comedian) i).punchLine();
			}
			else if(i instanceof Singer) {
				((Singer) i).concert();
				((Singer) i).makeSong();
				((Singer) i).recordSong();
			}
			
			System.out.println("");
			
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
