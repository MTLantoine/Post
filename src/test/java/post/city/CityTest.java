package post.city;

import static org.junit.Assert.*;

import org.junit.*;

import post.inhabitant.*;
import post.letter.*;

public class CityTest {
	
	private City city;
	private Inhabitant inhabitant;
	private BankAccount ba;

	@Before
	public void initObjects() {
		this.city = new City("Lille");
		this.ba = new BankAccount(200f);
		this.inhabitant = new Inhabitant("Antoine", this.city, this.ba);
	}
	
	@Test
	public void getNameTest() {
		assertEquals("Lille", this.city.getName());
	}
	
	@Test
	public void setNameTest() {
		this.city.setName("Ronchin");
		assertEquals("Ronchin", this.city.getName());
	}
	
	@Test
	public void getListInhabitantsTest() {
		assertEquals(1, this.city.getListInhabitants().size());
	}
	
	@Test
	public void addInhabitantTest() {
		new Inhabitant("Alexandre", this.city, null);
		/* ce constructeur appelle addInhabitant() */
		assertEquals(2, this.city.getListInhabitants().size());
	}
	
	@Test
	public void getMailboxTest() {
		assertTrue(this.city.getMailbox().isEmpty());
	}
	
	@Test
	public void addLetterTest() {
		this.city.addLetter(new ThanksLetter(this.inhabitant, this.inhabitant));
		assertEquals(1, this.city.getMailbox().size());
	}
	
	@Test
	public void distributeLetterTest() {
		assertTrue(this.city.getMailbox().isEmpty());
		this.city.addLetter(new ThanksLetter(this.inhabitant, this.inhabitant));
		assertEquals(1, this.city.getMailbox().size());
		this.city.distributeLetter();
		assertTrue(this.city.getMailbox().isEmpty());
	}
	
	@Test
	public void getRandomInhabitantTest() {
		assertEquals(this.inhabitant, this.city.getRandomInhabitant());
	}
	
	@Test
	public void addVictimTest() {
		assertTrue(this.city.getVictims().isEmpty());
		this.city.addVictim(this.inhabitant);
		assertEquals(1, this.city.getVictims().size());
	}
	
	@Test
	public void getRichestInhabitantTest() {
		Inhabitant inhabitant2 = new Inhabitant("RichGuy", this.city, new BankAccount(2000f));
		new Inhabitant("PoorGuy", this.city, new BankAccount(20f));
		assertEquals(inhabitant2, this.city.getRichestInhabitant());
	}
	
	@Test
	public void selectVictimsTest() {
		new Inhabitant("Victim", this.city, new BankAccount(2f));
		this.city.selectVictims(this.inhabitant, 1);
		assertEquals(1, this.city.getVictims().size());
		for (Inhabitant victim : this.city.getVictims()) {
			assertTrue(this.city.getListInhabitants().contains(victim));
			assertNotEquals(this.inhabitant, victim);
		}
	}

}
