package bg.sofia.uni.fmi.mjt.virtualwallet.core;
import java.time.LocalDateTime;

import bg.sofia.uni.fmi.mjt.virtualwallet.core.card.Card;
import bg.sofia.uni.fmi.mjt.virtualwallet.core.payment.PaymentInfo;
import bg.sofia.uni.fmi.mjt.virtualwallet.core.transaction.TransactionInfo;

public class VirtualWallet implements VirtualWalletAPI {
	private int totalNumberOfCards;
	private Card[] cards;
	private int totalNumberOfTransactions;
	private TransactionInfo[] transactions;
	
	public VirtualWallet() {
		cards = new Card[5];
		transactions = new TransactionInfo[10];
    }
	public boolean registerCard(Card card) {
		if(card == null || totalNumberOfCards == 5 || card.getName() == null) {return false;}
		
		for(int i=0;i<totalNumberOfCards;i++) {
			if(cards[i].getName().equals(card.getName())) {
				return false;
			}
		}
		cards[totalNumberOfCards++] = card;
		return true;
	}
    
    public boolean executePayment(Card card, PaymentInfo paymentInfo) {
    	if (card== null || paymentInfo == null) {return false;}
    	for(int i=0;i<totalNumberOfCards;i++) {
			if(cards[i].getName().equals(card.getName())) {
				newTransaction(card,paymentInfo);
				return card.executePayment(paymentInfo.getCost());
			}
		}
    	return false;
    	
    }
    
    public boolean feed(Card card, double amount) {
    	if(amount <0) {return false;}
    	for(int i=0;i<totalNumberOfCards;i++) {
			if(cards[i].getName().equals(card.getName())) {
				return card.changeAmount(amount);
			}
		}
    	return false;
    }
    
    public Card getCardByName(String name) {
    	for(int i=0;i<totalNumberOfCards;i++) {
    		if(cards[i].getName().equals(name)) {
    			return cards[i];
    		}
    	}
    	return null;
    }
   
    public int getTotalNumberOfCards() {
    	return totalNumberOfCards;
    }
    
    public boolean newTransaction(Card card, PaymentInfo paymentInfo) {
    	TransactionInfo temp = new TransactionInfo(card.getName(),LocalDateTime.now(),paymentInfo);    	
    	if (totalNumberOfTransactions==10) {
    		int min = 0;
    		for(int i=0;i<10;i++) {
    			if(transactions[i].getDateInfo().isBefore(transactions[min].getDateInfo())) {
    				min = i;
    			}
    		}
    		transactions[min]=temp;
    	}
    	else {
    		transactions[totalNumberOfTransactions++] = temp;
    	}
    	return true;
    }

}
