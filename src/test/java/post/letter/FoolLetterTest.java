package post.letter;

import static org.junit.Assert.*;

import org.junit.*;

public class FoolLetterTest extends LetterTest {

	public Letter<?> createLetter() {
		return new FoolLetter(super.sender, super.receiver, null);
	}
	
	public Letter<?> createMockLetter() {
		return new MockLetter(super.sender, super.receiver, null);
	}
	
	@Test
	public void getCostTest() {
		assertEquals(0, super.letter.getCost(), 0);
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Lettre du naïf", super.letter.toString());
	}

}
