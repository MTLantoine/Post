package post.content;

import java.util.*;

import post.inhabitant.*;

public class ContentText implements Content {
	
	/** the message content in the letter */
	private String message;
	
	/**
	 * 
	 * @param message the message in the letter
	 */
	public ContentText(String message) {
		this.message = message;
	}
	
	/**
	 * 
	 * @return the message content in the letter
	 */
	public String getMessage() {
		return this.message;
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
		return this.getMessage();
	}
	
	/**
	 * 
	 * @return list of chosen inhabitants for the fool letter
	 */
	public List<Inhabitant> getListInhabitants() {
		return null;
	}

}
