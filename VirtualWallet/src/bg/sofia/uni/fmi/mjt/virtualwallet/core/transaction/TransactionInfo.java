package bg.sofia.uni.fmi.mjt.virtualwallet.core.transaction;
import java.time.LocalDateTime;

import bg.sofia.uni.fmi.mjt.virtualwallet.core.payment.PaymentInfo;

public class TransactionInfo {

	private String cardName;
	private LocalDateTime dateInfo;
	private PaymentInfo paymentInfo;
	
	public TransactionInfo(String cardName, LocalDateTime dateInfo, PaymentInfo paymentInfo) {
		this.cardName = cardName;
		this.dateInfo = dateInfo;
		this.paymentInfo = paymentInfo;
	}
	public LocalDateTime getDateInfo() {
		return dateInfo;
	}
	
	public String getCardName() {
		return cardName;
	}
	
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

}