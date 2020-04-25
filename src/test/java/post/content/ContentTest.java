package post.content;

import static org.junit.Assert.*;

import org.junit.*;

public abstract class ContentTest {
	
	protected Content content;
	protected abstract Content createContent();
	
	@Before
	public void initObjects() {
		this.content = this.createContent();
	}

	@Test
	public void getAmountTest() {
		assertEquals(0, this.content.getAmount(), 0);
	}

}
