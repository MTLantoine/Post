package post.letter;

import java.util.List;

import post.inhabitant.*;

public class UrgentLetter extends Letter<Letter<?>> {

	/**
	 * 
	 * @param content the content of the letter
	 */
	public UrgentLetter(Letter<?> content) {
		super(content);
		super.setCost(super.getContent().getCost() * 2f);
	}

	/**
	 * 
	 * the action of the letter when it is distributed
	 */
	public void action() {
		super.getContent().action();
		super.getContent().getSender().getBA().debit(super.getContent().getCost());
	}
	
	/**
	 * 
	 * @return the sender of the letter
	 */
	public Inhabitant getSender() {
		return super.getContent().getSender();
	}
	
	/**
	 * 
	 * @return the receiver of the letter
	 */
	public Inhabitant getReceiver() {
		return super.getContent().getReceiver();
	}
	
	/**
	 * 
	 * describes the letter
	 */
	public String toString() {
		return super.getContent().toString() + " URGENT";
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
