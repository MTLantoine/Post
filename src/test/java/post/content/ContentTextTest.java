package post.content;

import static org.junit.Assert.*;

import org.junit.*;

public class ContentTextTest extends ContentTest {
	
	protected Content createContent() {
		return new ContentText("blablabla");
	}
	
	@Test
	public void getListInhabitantsTest() {
		assertNull(super.content.getListInhabitants());
	}

}
