package post.inhabitant;

import static org.junit.Assert.*;

import org.junit.*;

import post.city.*;
import post.letter.*;

public class InhabitantTest {

	private Inhabitant inhabitant1;
	private Inhabitant inhabitant2;
	private City lille;
	private City ronchin;
	private BankAccount ba1;
	private BankAccount ba2;
	private ThanksLetter letter;
	private MockInhabitant mockInhabitant;

	@Before
	public void initObjects() {
		this.lille = new City("Lille");
		this.ronchin = new City("Ronchin");
		this.ba1 = new BankAccount(100f);
		this.ba2 = new BankAccount(0.3f);
		this.inhabitant1 = new Inhabitant("Antoine", this.ronchin, this.ba1);
		this.inhabitant2 = new Inhabitant("Alexandre", this.lille, this.ba2);
		this.letter = new ThanksLetter(this.inhabitant1, this.inhabitant2);
		this.mockInhabitant = new MockInhabitant(null, this.lille, null);
	}
	
	@Test
	public void sendLetterTest() {
		assertTrue(this.inhabitant2.getCity().getMailbox().isEmpty());
		this.inhabitant1.sendLetter(this.letter, this.letter.getReceiver());
		assertEquals(1, this.inhabitant2.getCity().getMailbox().size());
	}
	
	@Test
	public void receiveLetterTest() {
		assertEquals(0, this.mockInhabitant.getCmpt());
		this.mockInhabitant.receiveLetter(this.letter);
		assertEquals(1, this.mockInhabitant.getCmpt());
	}
	
	@Test
	public void getNameTest() {
		assertEquals("Antoine", this.inhabitant1.getName());
		assertEquals("Alexandre", this.inhabitant2.getName());
	}
	
	@Test
	public void setNameTest() {
		this.inhabitant1.setName("Yann");
		assertEquals("Yann", this.inhabitant1.getName());
	}
	
	@Test
	public void getCityTest() {
		assertEquals(this.ronchin, this.inhabitant1.getCity());
		assertEquals(this.lille, this.inhabitant2.getCity());
	}
	
	@Test
	public void getBATest() {
		assertEquals(this.ba1, this.inhabitant1.getBA());
		assertEquals(this.ba2, this.inhabitant2.getBA());
	}

}
