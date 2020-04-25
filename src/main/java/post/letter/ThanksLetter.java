package post.letter;

import post.content.*;
import post.inhabitant.*;

public class ThanksLetter extends SimpleLetter {
	
	/** the message of the thanks letter */
	private ContentText message;

	/**
	 * 
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 */
	public ThanksLetter(Inhabitant sender, Inhabitant receiver) {
		super(sender, receiver);
		this.setMessage(new ContentText("Thank you for your letter !"));
	}
	
	/**
	 * 
	 * @param newMessage the new message to set in the letter
	 */
	public void setMessage(ContentText newMessage) {
		this.message = newMessage;
	}
	
	/**
	 * 
	 * @return the message content in the letter
	 */
	public ContentText getMessage() {
		return this.message;
	}
	
	/**
	 * 
	 * the action of the letter when it is distributed
	 */
	public void action() {
		super.action();
	}
	
	/**
	 * 
	 * @return the message content in the letter
	 */
	public ContentText getContent() {
		return this.message;
	}
	
	/**
	 * 
	 * describes the letter
	 */
	public String toString() {
		return super.toString() + " de remerciement";
	}

}
