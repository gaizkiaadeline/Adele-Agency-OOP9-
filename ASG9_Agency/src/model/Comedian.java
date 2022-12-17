package model;

import interfaceFolder.Joking;

public class Comedian extends Agency implements Joking{
	
	public Comedian(String iD, String name, String gender, Integer age, String artistType, Integer popularityRank) {
		super(iD, name, gender, age, artistType, popularityRank);
	}

//	meng-override abstract method yg ada pada class Acting (interface)
//	dan kita isi body nya sesuai yang diinginkan
	@Override
	public void standUpComedy() {
		System.out.println(this.getName() + " is doing a stand-up comedy");
	}

	@Override
	public void skit() {
		System.out.println(this.getName() + " is a comedy skit at comedy show");
	}

	@Override
	public void roasting() {
		System.out.println(this.getName() + " is roasting someone");
	}

	@Override
	public void punchLine() {
		System.out.println(this.getName() + " made a punch line in today's show");
	}


}
