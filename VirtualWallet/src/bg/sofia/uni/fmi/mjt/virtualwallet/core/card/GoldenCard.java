package bg.sofia.uni.fmi.mjt.virtualwallet.core.card;

public class GoldenCard extends Card {
	public GoldenCard(String name) {
		super(name);
    }
	
	@Override
    public boolean executePayment(double cost) {
    	if(cost < 0) {return false;}
    	if (validate(cost)) {
    		changeAmount(-(0.85*cost));
    		return true;
    	}
    	return false;
    }
    


}
