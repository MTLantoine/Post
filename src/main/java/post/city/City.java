package post.city;

import java.util.*;

import post.inhabitant.*;
import post.letter.*;

public class City {

	/** the name of the city */
	private String name;
	
	/** the list of the inhabitants in the city */
	private List<Inhabitant> listInhabitants;
	
	/** the mail box of the city */
	private List<Letter<?>> mailbox;
	
	/** the victims of the fool letter */
	private List<Inhabitant> foolLetterVictims;
	
	/**
	 * 
	 * @param name the name of the city
	 */
	public City(String name) {
		this.name = name;
		this.listInhabitants = new ArrayList<Inhabitant>();
		this.mailbox = new ArrayList<Letter<?>>();
		this.foolLetterVictims = new ArrayList<Inhabitant>();
	}

	/**
	 * 
	 * @return the name of the city
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * 
	 * @param newName set a new name for the city
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * 
	 * @return return the list of the inhabitants in the city
	 */
	public List<Inhabitant> getListInhabitants() {
		return this.listInhabitants;
	}
	
	/**
	 * 
	 * @param inhabitant the inhabitant to add in the city
	 */
	public void addInhabitant(Inhabitant inhabitant) {
		this.listInhabitants.add(inhabitant);
	}
	
	/**
	 * 
	 * @return the mailbox of the city
	 */
	public List<Letter<?>> getMailbox() {
		return this.mailbox;
	}
	
	/**
	 * 
	 * @param letter the letter to add in the mailbox of the city
	 */
	public void addLetter(Letter<?> letter) {
		this.mailbox.add(letter);
	}
	
	/**
	 * 
	 * distributes each letter to its receiver in the city
	 */
	public void distributeLetter() {
		List<Letter<?>> temporaryMailbox = new ArrayList<Letter<?>>();
		temporaryMailbox.addAll(this.getMailbox());
		this.mailbox.clear();
		for (Letter<?> letter : temporaryMailbox) {
			letter.getReceiver().receiveLetter(letter);
		}
	}
	
	/**
	 * 
	 * @return a random inhabitant from the list of inhabitant in the city
	 */
	public Inhabitant getRandomInhabitant() {
		Random random = new Random();
		int number = random.nextInt(this.getListInhabitants().size());
		return this.getListInhabitants().get(number);
	}
	
	/**
	 * 
	 * @param inhabitant the inhabitant to add in the list of victims of the fool letter
	 */
	public void addVictim(Inhabitant inhabitant) {
		this.foolLetterVictims.add(inhabitant);
	}
	
	/**
	 * 
	 * @return the victims of the fool letter
	 */
	public List<Inhabitant> getVictims() {
		return this.foolLetterVictims;
	}
	
	/**
	 * 
	 * @return the richest inhabitant from the city
	 */
	public Inhabitant getRichestInhabitant() {
		Inhabitant theRichest = this.getListInhabitants().get(0);
		for (Inhabitant inhabitant : this.getListInhabitants()) {
			if (inhabitant.getBA().getAmount() >= theRichest.getBA().getAmount()) {
				theRichest = inhabitant;
			}
		}
		return theRichest;
	}
	
	/**
	 * 
	 * @param sender the sender we don't want to send a letter
	 * @param number the number of victims we would like to get
	 */
	public void selectVictims(Inhabitant sender, int number) {
		this.foolLetterVictims = new ArrayList<Inhabitant>();
		int cmpt = 0;
		Inhabitant inhabitant;
		if (number >= this.getListInhabitants().size()) {
			this.foolLetterVictims.addAll(this.getListInhabitants());
			this.foolLetterVictims.remove(sender);
		} else {
			while (cmpt != number) {
				inhabitant = this.getRandomInhabitant();
				if (this.getVictims().contains(inhabitant) || inhabitant == sender) {
					continue;
				} else {
					this.addVictim(inhabitant);
					cmpt++;
				}
			}
		}
	}
	
}
