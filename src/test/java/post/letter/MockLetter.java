package post.letter;

import java.util.*;

import post.content.*;
import post.inhabitant.*;

public class MockLetter extends Letter<Content> {
	
	private int cmpt;

	public MockLetter(Inhabitant sender, Inhabitant receiver, Content content) {
		super(sender, receiver, content);
		this.cmpt = 0;
	}

	public void action() {
		this.cmpt++;
	}
	
	public int getCmpt() {
		return this.cmpt;
	}

	public String contentToString() {
		return null;
	}

	public List<Inhabitant> getListInhabitants() {
		return null;
	}

	public float getAmount() {
		return 0;
	}

}
