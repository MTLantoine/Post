package post.letter;

import java.util.*;

import post.content.*;
import post.exception.*;
import post.inhabitant.*;

public class FoolLetter extends Letter<ContentListInhabitant> {
	
	/** the list of inhabitants involved in the fool letter */
	private List<Inhabitant> listInhabitants;
	
	/** <code>true</code> if the fool letter is the first sent, <code>false</code> then */
	private static boolean firstSent = true;
	
	/** a counter of sent */
	private static int cmpt = 0;
	
	/** the probability of answer from the receiver */
	private static int bound = 15;

	/**
	 * 
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 * @param content the content of the letter
	 */
	public FoolLetter(Inhabitant sender, Inhabitant receiver, ContentListInhabitant content) {
		super(sender, receiver, content);
		this.listInhabitants = new ArrayList<Inhabitant>();
	}

	/**
	 * 
	 * the action of the letter when it is distributed
	 */
	public void action() {
		double d = Math.random()*100;
		if (d < bound || firstSent == true) {
			super.getReceiver().getBA().credit(5f);
			try {
				this.execute();
			} catch (IncorrectNumberInTheListException e) {
				e.getMessage();
			}	
		} else {
			System.out.println(">>> " + super.getReceiver().getName() + " décide de ne pas répondre.");
		}
		firstSent = false;
		cmpt++;
		if (cmpt > 100000) {
			bound = 10;
		}
	}
	
	/**
	 * 
	 * execute the action of the letter
	 * @throws IncorrectNumberInTheListException if the number of wanted inhabitant is incorrect
	 */
	public void execute() throws IncorrectNumberInTheListException {
		this.listInhabitants.addAll(super.getContent().getListInhabitants());
		for (Inhabitant inhabitant : this.listInhabitants) {
			super.getReceiver().sendLetter(new BillOfExchange(super.getReceiver(), inhabitant, new ContentMoney(5f)), inhabitant);
		}
		this.listInhabitants.remove(listInhabitants.get(0));
		this.listInhabitants.add(super.getReceiver());
		super.getReceiver().getCity().selectVictims(super.getReceiver(), 10);
		this.sendPeople();
	}
	
	/**
	 * 
	 * send a fool letter to the victims of the chain in the city selected
	 * @throws IncorrectNumberInTheListException if the number of wanted inhabitant is incorrect
	 */
	public void sendPeople() throws IncorrectNumberInTheListException {
		for (Inhabitant victim : super.getReceiver().getCity().getVictims()) {
			super.getReceiver().sendLetter(new FoolLetter(super.getReceiver(), victim, new ContentListInhabitant(this.listInhabitants)), victim);
		}
	}
	
	/**
	 * 
	 * describes the letter
	 */
	public String toString() {
		return super.toString() + " du naïf";
	}
	
	/**
	 * 
	 * @return the informations of the letter
	 */
	public String contentToString() {
		return null;
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
