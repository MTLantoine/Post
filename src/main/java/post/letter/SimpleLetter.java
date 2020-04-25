package post.letter;

import java.util.List;

import post.content.*;
import post.inhabitant.*;

public class SimpleLetter extends Letter<ContentText> {

	/**
	 * 
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 * @param content the content of the letter
	 */
	public SimpleLetter(Inhabitant sender, Inhabitant receiver, ContentText content) {
		super(sender, receiver, content);
		super.setCost(0.5f);
	}
	
	/**
	 * 
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 */
	public SimpleLetter(Inhabitant sender, Inhabitant receiver) {
		super(sender, receiver);
		super.setCost(0.5f);
	}
	
	/**
	 * 
	 * the action of the letter when it is distributed
	 */
	public void action() {
		super.getSender().getBA().debit(super.getCost());
	}
	
	/**
	 * 
	 * describes the letter
	 */
	public String toString() {
		return super.toString() + " simple";
	}

	/**
	 * 
	 * @return the informations of the letter
	 */
	public String contentToString() {
		return super.getContent().contentToString();
	}

	/**
	 * 
	 * @return list of chosen inhabitants for the fool letter
	 */
	public List<Inhabitant> getListInhabitants() {
		return null;
	}

	/**
	 * 
	 * @return the amount of the content of the letter
	 */
	public float getAmount() {
		return 0;
	}

}
