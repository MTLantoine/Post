package post.content;

import static org.junit.Assert.*;

import org.junit.*;

public class ContentMoneyTest extends ContentTest {
	
	protected Content createContent() {
		return new ContentMoney(0);
	}

	@Test
	public void getListInhabitantsTest() {
		assertNull(super.content.getListInhabitants());
	}

}
