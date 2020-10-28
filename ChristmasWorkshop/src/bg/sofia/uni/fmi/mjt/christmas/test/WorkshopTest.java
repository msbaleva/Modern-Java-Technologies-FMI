package bg.sofia.uni.fmi.mjt.christmas.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import bg.sofia.uni.fmi.mjt.christmas.Elf;
import bg.sofia.uni.fmi.mjt.christmas.Kid;
import bg.sofia.uni.fmi.mjt.christmas.Workshop;

public class WorkshopTest {
	public static Workshop workshop;
	public static final int NUM_OF_KIDS = 1000;
	public static final int XMAS_TIME = 3000;
	static Thread[] kids;
	
	@BeforeClass
	public static void setup() {
		workshop = new Workshop();
		kids = new Thread[NUM_OF_KIDS];
		for (int i = 0; i < kids.length; i++) {
			kids[i] = new Thread(new Kid(workshop));
			kids[i].start();
		}

		try {
			Thread.sleep(XMAS_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (workshop) {
			workshop.christmasTime();
		}

		for (int i = 0; i < kids.length; i++) {
			try {
				kids[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Test
	public void testWishCount() {
		assertEquals(workshop.getWishCount(), NUM_OF_KIDS); 
	}
	
	@Test 
	public void testGiftCount() {
		int total = Arrays.stream(workshop.getElves())
				.mapToInt(Elf::getTotalGiftsCrafted)
				.sum();
		assertEquals(total, NUM_OF_KIDS); 
	}
}
