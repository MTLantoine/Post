package post.content;

import java.util.List;

import post.inhabitant.*;

public interface Content {
	
	/**
	 * 
	 * @return the informations of the letter
	 */
	public String contentToString();
	
	/**
	 * 
	 * @return list of chosen inhabitants for the fool letter
	 */
	public List<Inhabitant> getListInhabitants();
	
	/**
	 * 
	 * @return the amount of the content of the letter
	 */
	public float getAmount();
	
}
