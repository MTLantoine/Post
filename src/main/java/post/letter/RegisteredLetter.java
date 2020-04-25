package post.letter;

import java.util.List;

import post.content.*;
import post.inhabitant.*;

public class RegisteredLetter extends Letter<Letter<?>> {

	/**
	 * 
	 * @param content the content of the letter
	 */
	public RegisteredLetter(Letter<?> content) {
		super(content);
		super.setCost(super.getContent().getCost() * 1.15f);
	}

	/**
	 * 
	 * the action of the letter when it is distributed
	 */
	public void action() {
		super.getContent().action();
		super.getContent().getSender().getBA().debit(super.getContent().getCost() * 0.15f);
		SimpleLetter simpleLetter = new SimpleLetter(super.getContent().getReceiver(), super.getContent().getSender(), new ContentText("I well received your registered mail."));
		super.getContent().getReceiver().sendLetter(simpleLetter, simpleLetter.getReceiver());
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
		return super.getContent().toString() + " en recommendé";
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
