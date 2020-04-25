package post.content;

import java.util.*;

import post.inhabitant.*;

public class ContentMoney implements Content {
	
	/** the amount content in the letter */
	private float amount;
	
	public ContentMoney(float amount) {
		this.amount = amount;
	}
	
	/**
	 * 
	 * @return the amount of the content of the letter
	 */
	public float getAmount() {
		return this.amount;
	}
	
	/**
	 * 
	 * @return the informations of the letter
	 */
	public String contentToString() {
		return "Valeur = " + this.getAmount() + " euros";
	}

	/**
	 * 
	 * @return list of chosen inhabitants for the fool letter
	 */
	public List<Inhabitant> getListInhabitants() {
		return null;
	}
	
}
