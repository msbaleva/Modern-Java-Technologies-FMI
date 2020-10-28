package bg.sofia.uni.fmi.mjt.christmas;

import java.util.Random;

public class Kid implements Runnable {
	
	private Workshop workshop;
	private static Random kidRand = new Random();
	private static final int TIME = 1000;
	
	public Kid(Workshop workshop) {
        this.workshop = workshop;
    }	

	private void sendWish() {
		workshop.postWish(Gift.getGift());
	}
	 
	@Override
	public void run() {
		try {
			Thread.sleep(kidRand.nextInt(TIME));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		sendWish();
	
	}
}
