package bg.sofia.uni.fmi.mjt.virtualwallet.core.card;

public abstract class Card {
	
	private String name;
	private double amount;
	public Card(String name) {
		this.name=name;
    }
	
    public abstract boolean executePayment(double cost);
    
    public boolean validate(double cost) {
    	return (getAmount() >= cost) ? true : false;    		
    }
    public String getName() {
    	return name;
    }
	
    public double getAmount() {
    	return amount;
    }
    
    public boolean changeAmount(double amount) {
    	this.amount += amount;
    	return true;
    }

}
