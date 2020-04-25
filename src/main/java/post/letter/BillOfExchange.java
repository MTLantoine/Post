package post.letter;

import java.util.List;

import post.content.*;
import post.inhabitant.*;

public class BillOfExchange extends Letter<ContentMoney> {

	/**
	 * 
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 * @param content the content of the letter
	 */
	public BillOfExchange(Inhabitant sender, Inhabitant receiver, ContentMoney content) {
		super(sender, receiver, content);
		super.setCost(1f + (0.01f * content.getAmount()));
	}
	
	/**
	 * 
	 * the action of the letter when it is distributed
	 */
	public void action() {
		super.getSender().getBA().debit(super.getCost() + super.getContent().getAmount());
		super.getReceiver().getBA().credit(super.getContent().getAmount());
		ThanksLetter thanksLetter = new ThanksLetter(super.getReceiver(), super.getSender());
		thanksLetter.getSender().sendLetter(thanksLetter, thanksLetter.getReceiver());
	}
	
	/**
	 * 
	 * describes the letter
	 */
	public String toString() {
		return super.toString() + " de change";
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
