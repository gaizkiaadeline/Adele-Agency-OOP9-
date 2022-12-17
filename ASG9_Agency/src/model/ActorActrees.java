package model;

import interfaceFolder.Acting;

public class ActorActrees extends Agency implements Acting {

	private Integer height;
	private Integer weight;
	
	public ActorActrees(String iD, String name, String gender, Integer age, String artistType, Integer popularityRank,
			Integer height, Integer weight) {
		super(iD, name, gender, age, artistType, popularityRank);
		this.height = height;
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

//	meng-override abstract method yg ada pada class Acting (interface)
//	dan kita isi body nya sesuai yang diinginkan
	@Override
	public void filmingMovie() {

		System.out.println(this.getName() + " is filming a movie");
	}

	@Override
	public void filmingDrama() {

		System.out.println(this.getName() + " is filming a drama");
	}

	@Override
	public void scriptPractice() {

		System.out.println(this.getName() + " is practicing the script with co-worker");
	}
	
	
}
