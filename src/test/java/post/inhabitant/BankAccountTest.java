package post.inhabitant;

import static org.junit.Assert.*;

import org.junit.*;

public class BankAccountTest {
	
	private BankAccount ba;

	@Before
	public void initObjects() {
		this.ba = new BankAccount(300f);
	}
	
	@Test
	public void getAmountTest() {
		assertEquals(300f, this.ba.getAmount(), 0);
	}
	
	@Test
	public void creditTest() {
		this.ba.credit(50f);
		assertEquals(350f, this.ba.getAmount(), 0);
	}
	
	@Test
	public void debitTest() {
		this.ba.debit(50f);
		assertEquals(250f, this.ba.getAmount(), 0);
	}

}
