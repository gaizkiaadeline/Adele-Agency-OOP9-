package model;

import interfaceFolder.Singing;

public class Singer extends Agency implements Singing {

	public Singer(String iD, String name, String gender, Integer age, String artistType, Integer popularityRank) {
		super(iD, name, gender, age, artistType, popularityRank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void concert() {
		
		System.out.println(this.getName() + " is doing a concert");
	}

	@Override
	public void makeSong() {

		System.out.println(this.getName() + " is composing a song");
	}

	@Override
	public void recordSong() {

		System.out.println(this.getName() + " is recording a song");
	}

	
}
