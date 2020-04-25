package post.letter;

import static org.junit.Assert.*;

import org.junit.*;

import post.content.*;

public class BillOfExchangeTest extends LetterTest {

	public Letter<?> createLetter() {
		return new BillOfExchange(super.sender, super.receiver, new ContentMoney(10f));
	}

	public Letter<?> createMockLetter() {
		return new MockLetter(super.sender, super.receiver, null);
	}
	
	@Test
	public void getCostTest() {
		assertEquals((1f + (0.01f * super.letter.getContent().getAmount())), super.letter.getCost(), 0);
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Lettre de change", super.letter.toString());
	}

}
