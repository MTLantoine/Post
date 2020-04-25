package post.inhabitant;

import post.city.*;
import post.letter.*;

public class MockInhabitant extends Inhabitant {
	
	private int cmpt;

	public MockInhabitant(String name, City city, BankAccount ba) {
		super(name, city, ba);
		this.cmpt = 0;
	}
	
	public void receiveLetter(Letter<?> letter) {
		this.cmpt++;
	}
	
	public int getCmpt() {
		return this.cmpt;
	}

}
