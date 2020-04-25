package post.letter;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import post.city.*;
import post.inhabitant.*;

public abstract class LetterTest {

	protected Letter<?> letter;
	protected Letter<?> mockLetter;
	protected abstract Letter<?> createLetter();
	protected abstract Letter<?> createMockLetter();
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected Inhabitant inhabitant1;
	protected Inhabitant inhabitant2;
	private City city;
	protected List<Inhabitant> listInhabitants;

	@Before
	public void initObjects() {
		this.city = new City("Lille");
		this.sender = new Inhabitant("Antoine", this.city, null);
		this.receiver = new Inhabitant("Alexandre", this.city, null);
		this.inhabitant1 = new Inhabitant("inhabitant1", this.city, null);
		this.inhabitant2 = new Inhabitant("inhabitant2", this.city, null);
		this.letter = this.createLetter();
		this.mockLetter = this.createMockLetter();
		this.listInhabitants = new ArrayList<Inhabitant>();
		this.city.selectVictims(null, 4);
		this.listInhabitants.addAll(this.city.getVictims());
	}

	@Test
	public void getSenderTest() {
		assertEquals(this.sender, this.letter.getSender());
	}
	
	@Test
	public void getReceiverTest() {
		assertEquals(this.receiver, this.letter.getReceiver());
	}
	
	@Test
	public void actionTest() {
		assertEquals(0, this.mockLetter.getCmpt());
		this.mockLetter.action();
		assertEquals(1, this.mockLetter.getCmpt());
	}	 

}
