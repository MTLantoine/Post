package post.letter;

import post.content.*;
import post.inhabitant.*;

public abstract class Letter<C extends Content> implements Content {

	/** the sender of the letter */
	private Inhabitant sender;
	
	/** the receiver of the letter */
	private Inhabitant receiver;
	
	/** the content of the letter */
	protected C content;
	
	/** the content of the letter */
	private float cost;
	
	/**
	 * 
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 * @param content the content of the letter
	 */
	public Letter(Inhabitant sender, Inhabitant receiver, C content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}

	/**
	 * 
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 */
	public Letter(Inhabitant sender, Inhabitant receiver) {
		this.sender = sender;
		this.receiver = receiver;
	}
	
	/**
	 * 
	 * @param content the content of the letter
	 */
	public Letter(C content) {
		this.content = content;
	}
	
	/**
	 * 
	 * @return the sender of the letter
	 */
	public Inhabitant getSender() {
		return this.sender;
	}
	
	/**
	 * 
	 * @return the receiver of the letter
	 */
	public Inhabitant getReceiver() {
		return this.receiver;
	}
	
	/**
	 * 
	 * @return the content of the letter
	 */
	public C getContent() {
		return this.content;
	}
	
	/**
	 * 
	 * the action of the letter when it is distributed
	 */
	public abstract void action();

	/**
	 * 
	 * @return the cost of the letter
	 */
	public float getCost() {
		return this.cost;
	}
	
	/**
	 * 
	 * @param newCost the new cost to set to the letter
	 */
	public void setCost(float newCost) {
		this.cost = newCost;
	}
	
	/**
	 * 
	 * describes the letter
	 */
	public String toString() {
		return "Lettre";
	}

	/**
	 * 
	 * @return the counter for the mock letter
	 */
	public int getCmpt() {
		return 0;
	}

}
