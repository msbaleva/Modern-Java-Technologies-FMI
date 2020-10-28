package bg.sofia.uni.fmi.mjt.christmas;

import java.util.LinkedList;

public class Workshop {
	
	private Elf[] elves;
	private static final int NUM_OF_ELVES = 20;
	private boolean isChristmasTime;
	private int wishCount;
    LinkedList<Gift> giftBacklog;
    
	public Workshop() {
		giftBacklog = new LinkedList<>();
		this.elves = new Elf[NUM_OF_ELVES];
		for (int i = 0; i < NUM_OF_ELVES; i++) {
			elves[i] = new Elf(i, this);
			elves[i].start();
		}

    }

    /**
    * Adds a gift to the elves' backlog.
    **/
    public synchronized void postWish(Gift gift) {
        giftBacklog.add(gift);
        wishCount++;
        notify();
    }

    /**
    * Returns an array of the elves working in Santa's workshop.
    **/
    public Elf[] getElves() {
        return elves;
    }

    /**
    * Returns the next gift from the elves' backlog that has to be manufactured.
    **/
    public synchronized Gift nextGift() {
        while (giftBacklog.isEmpty() && !isChristmasTime) {
        	try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        return isChristmasTime ? null : giftBacklog.pollFirst();
    }

    /**
    * Returns the total number of wishes sent to Santa's workshop by the kids.
    **/
    public synchronized int getWishCount() {
        return wishCount;
    }
    
    public synchronized void christmasTime() {
    	isChristmasTime = true;
    	notifyAll();
    }
    
}
