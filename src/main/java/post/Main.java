package post;

import java.util.*;

import post.city.*;
import post.content.*;
import post.inhabitant.*;
import post.letter.*;

public class Main {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		City city = new City("City");
		
		Inhabitant antoine = new Inhabitant("Antoine", city, new BankAccount(100f));
		Inhabitant alexandre = new Inhabitant("Alexandre", city, new BankAccount(100f));
		Inhabitant martin = new Inhabitant("Martin", city, new BankAccount(100f));
		Inhabitant pierre = new Inhabitant("Pierre", city, new BankAccount(100f));
		Inhabitant cedrid = new Inhabitant("Cedrid", city, new BankAccount(100f));
		Inhabitant valentin = new Inhabitant("Valentin",city, new BankAccount(100f));
		Inhabitant cathy = new Inhabitant("Cathy", city, new BankAccount(100f));
		Inhabitant marion = new Inhabitant("Marion", city, new BankAccount(100f));
		Inhabitant pierrette = new Inhabitant("Pierrette", city, new BankAccount(100f));
		Inhabitant zoe = new Inhabitant("Zoe", city, new BankAccount(100f));
		Inhabitant lilas = new Inhabitant("Lilas", city, new BankAccount(100f));
		Inhabitant pascal = new Inhabitant("Pascal", city, new BankAccount(100f));
		Inhabitant veronique = new Inhabitant("Veronique", city, new BankAccount(100f));
		Inhabitant frederic = new Inhabitant("Frederic", city, new BankAccount(100f));
		Inhabitant christelle = new Inhabitant("Christelle", city, new BankAccount(100f));
		Inhabitant camille = new Inhabitant("Camille", city, new BankAccount(100f));
		Inhabitant sophie = new Inhabitant("Sophie", city, new BankAccount(100f));
		Inhabitant elizabeth = new Inhabitant("Elizabeth", city, new BankAccount(100f));
		Inhabitant yann = new Inhabitant("Yann", city, new BankAccount(100f));
		Inhabitant patricia = new Inhabitant("Patricia", city, new BankAccount(100f));
		
		Random random = new Random();
		
		List<Letter<?>> listLettersChoice = new ArrayList<Letter<?>>();
		
		SimpleLetter simpleLetter = new SimpleLetter(city.getRandomInhabitant(), city.getRandomInhabitant(), new ContentText("Bla bla bla ..."));
		listLettersChoice.add(simpleLetter);
		BillOfExchange billOfExchange = new BillOfExchange(city.getRandomInhabitant(), city.getRandomInhabitant(), new ContentMoney(random.nextInt(20)));
		listLettersChoice.add(billOfExchange);
		RegisteredLetter registeredLetter = new RegisteredLetter(listLettersChoice.get(random.nextInt(listLettersChoice.size())));
		listLettersChoice.add(registeredLetter);
		UrgentLetter urgentLetter = new UrgentLetter(listLettersChoice.get(random.nextInt(listLettersChoice.size())));
		listLettersChoice.add(urgentLetter);
		
		List<Letter<?>> listLetters = new ArrayList<Letter<?>>();
		
		int k = random.nextInt(11) + 20;
		
		int jour;
		
		for (jour = 1; jour <= k + 2; jour++) {
			
			if (jour <= k) {
				for (int i = 0; i < random.nextInt(listLettersChoice.size() - 1) + 1; i++) {
					listLetters.add(listLettersChoice.get(random.nextInt(listLettersChoice.size())));
				}
			}
			
			System.out.println("______________________________________________________________________________________________________________");
			System.out.println("Jour " + jour);
			city.distributeLetter();
			for (Letter<?> letter : listLetters) {
				letter.getSender().sendLetter(letter, letter.getReceiver());
			}
			if (city.getMailbox().isEmpty()) {
				break;
			}
			listLetters.clear();
		}
		
		System.out.println("______________________________________________________________________________________________________________");
		System.out.println();
		System.out.println(jour + " days has past, no more Letter is sent.");
		System.out.println("This, was a simulation of an exchange of letters between a few inhabitants.");
		
	}
	
}
