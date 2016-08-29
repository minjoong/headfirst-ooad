package dogdoor;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DogDoorSimulator {
	
	private DogDoor door;
	private Remote remote;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void init() {
		door = new DogDoor();
		remote = new Remote(door);
		setupStream();
	}
	
	@After
	public void destory() {
		System.setOut(null);
	}
	
	@Test
	public void test() {
		remote.pressButton();
		assertEquals(outContent.toString(), "Pressing the remote control button...\nThe dog door opens.\n");
		
		outContent.reset();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(outContent.toString(), "The dog door closes.\n");
	}
	
	private void setupStream() {
		System.setOut(new PrintStream(outContent));
	}

}
