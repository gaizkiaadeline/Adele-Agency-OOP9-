package model;

import java.util.ArrayList;

public class Agency {
	
	private final String ID; //di set final agar tidak bisa diubah
	private String name;
	private String gender;
	private Integer age;
	private String artistType;
	private Integer popularityRank; //rank popularitas artis

	public Agency(String iD, String name, String gender, Integer age, String artistType, Integer popularityRank) {
		super();
		ID = iD;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.artistType = artistType;
		this.popularityRank = popularityRank;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getArtistType() {
		return artistType;
	}

	public void setArtistType(String artistType) {
		this.artistType = artistType;
	}

	public Integer getPopularityRank() {
		return popularityRank;
	}

	public void setPopularityRank(Integer popularityRank) {
		this.popularityRank = popularityRank;
	}

	public String getID() {
		return ID;
	}
	


}
