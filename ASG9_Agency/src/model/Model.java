package model;

import interfaceFolder.Modeling;

public class Model extends Agency implements Modeling{

	private Integer height;
	private Integer weight;
	
	public Model(String iD, String name, String gender, Integer age, String artistType, Integer popularityRank,
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

//	meng-override abstract method yg ada pada class Modelling (interface)
//	dan kita isi body nya sesuai yang diinginkan
	@Override
	public void fashionShow() {

		System.out.println(this.getName() + " appeared at the fashion show today");
	}
	

}
