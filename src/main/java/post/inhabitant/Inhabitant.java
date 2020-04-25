package post.inhabitant;

import post.city.*;
import post.letter.*;

public class Inhabitant {
	
	/** the name of the inhabitant */
	private String name;
	
	/** the city where the inhabitant lives */
	private City city;
	
	/** the bank account of the inhabitant */
	private BankAccount ba;
	
	/**
	 * 
	 * @param name the name of the inhabitant
	 * @param city the city where the inhabitant lives
	 * @param ba the bank account of the inhabitant
	 */
	public Inhabitant(String name, City city, BankAccount ba) {
		this.name = name;
		this.city = city;
		this.ba = ba;
		city.addInhabitant(this);
	}
	
	/**
	 * 
	 * @param letter the letter to send
	 * @param inhabitant the inhabitant who will receive the letter
	 */
	public void sendLetter(Letter<?> letter, Inhabitant inhabitant) {
		if ((letter.getSender().getBA().getAmount() - (letter.getCost() + letter.getContent().getAmount())) >= 0) {
			inhabitant.getCity().addLetter(letter);
			System.out.println(">>> " + this.getName() + " envoie " + letter.toString() + " (cout:" + letter.getCost() + ") à " + inhabitant.getName());
		} else {
			System.out.println(">>> " + this.getName() + " hasn't money anymore, and can not send letter yet.");
		}
	}
	
	/**
	 * 
	 * @param letter the letter that will be received
	 */
	public void receiveLetter(Letter<?> letter) {
		System.out.println(letter.toString() + " (cout:" + letter.getCost() + ") [" + letter.getContent().contentToString() + "] envoyé par " + letter.getSender().getName() + " reçu par " + letter.getReceiver().getName());
		letter.action();
	}
	
	/**
	 * 
	 * @return the name of the inhabitant
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @param newName the new name to set to the inhabitant
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * 
	 * @return the city where the inhabitant lives
	 */
	public City getCity() {
		return this.city;
	}
	
	/**
	 * 
	 * @return the bank account of the inhabitant
	 */
	public BankAccount getBA() {
		return this.ba;
	}

}
