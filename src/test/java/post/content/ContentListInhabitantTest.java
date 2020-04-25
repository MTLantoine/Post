package post.content;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import post.city.*;
import post.exception.*;
import post.inhabitant.*;

public class ContentListInhabitantTest extends ContentTest {
	
	protected Content createContent() {
		List<Inhabitant> listInhabitants = new ArrayList<Inhabitant>();
		listInhabitants.add(new Inhabitant(null, new City("city"), null));
		listInhabitants.add(new Inhabitant(null, new City("city"), null));
		listInhabitants.add(new Inhabitant(null, new City("city"), null));
		listInhabitants.add(new Inhabitant(null, new City("city"), null));
		try {
			return new ContentListInhabitant(listInhabitants);
		} catch (IncorrectNumberInTheListException e) {
			e.getMessage();
		}
		return null;
	}
	
	@Test
	public void getListInhabitantsTest() {
		assertEquals(4, super.content.getListInhabitants().size());
	}

}
