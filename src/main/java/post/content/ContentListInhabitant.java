package post.content;

import post.exception.*;
import post.inhabitant.*;

import java.util.*;


public class ContentListInhabitant implements Content {
	
	/** the list of inhabitant content in the letter */
	private List<Inhabitant> listInhabitants;

	/**
	 * 
	 * @param listInhabitants the list of inhabitant content in the letter
	 * @throws IncorrectNumberInTheListException if the number of wanted inhabitant is incorrect
	 */
	public ContentListInhabitant(List<Inhabitant> listInhabitants) throws IncorrectNumberInTheListException {
		if (this.assertGreatList(4, listInhabitants)) {
			this.listInhabitants = listInhabitants;			
		} else {
			throw new IncorrectNumberInTheListException();
		}
	}
	
	/**
	 * 
	 * @param i the number chosen
	 * @param list the list to compare it's size with the number i
	 * @return true if the size of the list equals the number i, false else
	 */
	private boolean assertGreatList(int i, List<Inhabitant> list) {
		return i == list.size();
	}

	/**
	 * 
	 * @return list of chosen inhabitants for the fool letter
	 */
	public List<Inhabitant> getListInhabitants() {
		return this.listInhabitants;
	}
	
	/**
	 * 
	 * @return the amount of the content of the letter
	 */
	public float getAmount() {
		return 0;
	}
	
	/**
	 * 
	 * @return the informations of the letter
	 */
	public String contentToString() {
		return "Here is my fool letter ! Are you in ?";
	}

}
