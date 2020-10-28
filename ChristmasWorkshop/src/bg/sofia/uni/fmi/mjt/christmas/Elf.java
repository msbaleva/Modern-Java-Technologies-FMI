package bg.sofia.uni.fmi.mjt.christmas;

public class Elf extends Thread {
	
	private int id;
	private Workshop workshop;
	private int totalGiftsCrafted;
	
	public Elf(int id, Workshop workshop) {
        this.id = id;
        this.workshop = workshop;
    }

    /**
    * Gets a wish from the backlog and creates the wanted gift.
    **/
    public void craftGift() {
        Gift gift;
        while ((gift = workshop.nextGift()) != null) {
        	try {
				Thread.sleep(gift.getCraftTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	
        	totalGiftsCrafted++;
        }
        
        System.out.println("Elf " + id + ": " + totalGiftsCrafted + " gifts");
    }

    /**
    * Returns the total number of gifts that the given elf has crafted.
    **/
    public int getTotalGiftsCrafted() {
        return totalGiftsCrafted;
    }
    
    @Override
	public void run() {
		craftGift();
	}


}
