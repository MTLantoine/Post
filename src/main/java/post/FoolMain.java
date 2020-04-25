package post;

import java.util.*;

import post.city.*;
import post.content.*;
import post.exception.*;
import post.inhabitant.*;
import post.letter.*;

public class FoolMain {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IncorrectNumberInTheListException {
		
		City city = new City("City");
		
		Inhabitant antoine = new Inhabitant("Antoine", city, new BankAccount(1000f));
		Inhabitant alexandre = new Inhabitant("Alexandre", city, new BankAccount(1000f));
		Inhabitant martin = new Inhabitant("Martin", city, new BankAccount(1000f));
		Inhabitant pierre = new Inhabitant("Pierre", city, new BankAccount(1000f));
		Inhabitant cedrid = new Inhabitant("Cedrid", city, new BankAccount(1000f));
		Inhabitant valentin = new Inhabitant("Valentin", city, new BankAccount(1000f));
		Inhabitant cathy = new Inhabitant("Cathy", city, new BankAccount(1000f));
		Inhabitant marion = new Inhabitant("Marion", city, new BankAccount(1000f));
		Inhabitant pierrette = new Inhabitant("Pierrette", city, new BankAccount(1000f));
		Inhabitant zoe = new Inhabitant("Zoe", city, new BankAccount(1000f));
		Inhabitant lilas = new Inhabitant("Lilas", city, new BankAccount(1000f));
		Inhabitant pascal = new Inhabitant("Pascal", city, new BankAccount(1000f));
		Inhabitant veronique = new Inhabitant("Veronique", city, new BankAccount(1000f));
		Inhabitant frederic = new Inhabitant("Frederic", city, new BankAccount(1000f));
		Inhabitant christelle = new Inhabitant("Christelle", city, new BankAccount(1000f));
		Inhabitant camille = new Inhabitant("Camille", city, new BankAccount(1000f));
		Inhabitant sophie = new Inhabitant("Sophie", city, new BankAccount(1000f));
		Inhabitant elizabeth = new Inhabitant("Elizabeth", city, new BankAccount(1000f));
		Inhabitant yann = new Inhabitant("Yann", city, new BankAccount(1000f));
		Inhabitant patricia = new Inhabitant("Patricia", city, new BankAccount(1000f));
		
		List<Inhabitant> firstVictims = new ArrayList<Inhabitant>();
		city.selectVictims(antoine, 4);
		firstVictims.addAll(city.getVictims());
		
		int jour = 1;
		
		System.out.println("______________________________________________________________________________________________________________");
		System.out.println("Jour " + jour);
		jour++;
		FoolLetter foolLetter = new FoolLetter(antoine, alexandre, new ContentListInhabitant(firstVictims));

		foolLetter.getSender().sendLetter(foolLetter, foolLetter.getReceiver());
		while (!city.getMailbox().isEmpty()) {
			System.out.println("______________________________________________________________________________________________________________");
			System.out.println("Jour " + jour);
			city.distributeLetter();
			jour++;
		}
		
		System.out.println("______________________________________________________________________________________________________________");
		System.out.println();
		System.out.println(jour + " days has past, no more Fool Letter is sent.");
		System.out.println("Everybody starded with 1000 euros,");
		System.out.println("The richest person in this city now is :");
		System.out.println(city.getRichestInhabitant().getName() + " with " + city.getRichestInhabitant().getBA().getAmount() + " euros !");
		
	}
	
}
