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
	private BarkRecognizer recognizer;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void init() {
		door = new DogDoor();
		initializeAllowedBarks();
		recognizer = new BarkRecognizer(door);
		remote = new Remote(door);
		setupStream();
	}
	
	@After
	public void destory() {
		System.setOut(null);
	}
	
	@Test
	public void testRemoteSimulation() {
		// 피도가 나가기 위해 짖는다.
		// 토드 또는 지나가 피도가 짖는 것을 듣는다.
		remote.pressButton(); // 토드 또는 지나가 리모콘의 버튼을 누른다.
		assertEquals(outContent.toString(), "Pressing the remote control button...\nThe dog door opens.\n");
		outContent.reset();
		
		try {
			Thread.sleep(6000); // 피도가 나가서, 볼 일을 보고, 논다.
			// 문이 자동으로 닫힌다. 5초 후..
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(outContent.toString(), "The dog door closes.\n");
		outContent.reset();
		
		// 피도가 들어오기 위해 짖는다.
		// 토드 또는 지나가 피도가 짖는 것을 듣는다.
		remote.pressButton(); // 토드 또는 지나가 리모콘의 버튼을 누른다.
		assertEquals(outContent.toString(), "Pressing the remote control button...\nThe dog door opens.\n");
		outContent.reset();
		
		try {
			Thread.sleep(6000); // 피도가 들어온다.
			// 문이 자동으로 닫힌다. 5초 후..
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(outContent.toString(), "The dog door closes.\n");
	}
	
	@Test
	public void testBarkRecognizerSimulation() {
		// 피도가 나가기 위해 짖는다.
		// 소리 인식기가 피도가 짖는 소리를 인식한다.
		recognizer.recognize(new Bark("rowlf")); // 소리 인식기가 문을 열라는 신호를 보낸다.
		assertEquals(outContent.toString(), "BarkRecognizer: Heard a 'rowlf'\nThe dog door opens.\n");
		outContent.reset();
		
		try {
			Thread.sleep(6000); // 피도가 나가서, 볼 일을 보고, 논다.
			// 문이 자동으로 닫힌다. 5초 후..
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(outContent.toString(), "The dog door closes.\n");
		outContent.reset();
		
		// 다른 강아지가 짖는다.
		// 소리 인식기가 다른 강아지가 짖는 소리를 인식한다.
		recognizer.recognize(new Bark("yip")); // 소리 인식기가 다른 강아지가 짖는 소리라는 메시지를 출력한다.
		assertEquals(outContent.toString(), "BarkRecognizer: Heard a 'yip'\nThis dog is not allowed.\n");
		outContent.reset();
		
		// 피도가 들어오기 위해 짖는다.
		// 소리 인식기가 피도가 짖는 소리를 인식한다.
		recognizer.recognize(new Bark("rooowlf")); // 소리 인식기가 문을 열라는 신호를 보낸다.
		assertEquals(outContent.toString(), "BarkRecognizer: Heard a 'rooowlf'\nThe dog door opens.\n");
		outContent.reset();
		
		try {
			Thread.sleep(6000); // 피도가 들어온다.
			// 문이 자동으로 닫힌다. 5초 후..
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(outContent.toString(), "The dog door closes.\n");
	}
	
	private void setupStream() {
		System.setOut(new PrintStream(outContent));
	}
	
	private void initializeAllowedBarks() {
		door.addAllowedBark(new Bark("rowlf"));
		door.addAllowedBark(new Bark("rooowlf"));
		door.addAllowedBark(new Bark("rawlf"));
		door.addAllowedBark(new Bark("woof"));
	}

}
