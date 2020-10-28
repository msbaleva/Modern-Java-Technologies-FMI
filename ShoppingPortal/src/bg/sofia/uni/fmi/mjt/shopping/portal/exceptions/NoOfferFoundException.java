package bg.sofia.uni.fmi.mjt.shopping.portal.exceptions;

public class NoOfferFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4125827537212412364L;

	public NoOfferFoundException() {
		// Empty body
	}

	public NoOfferFoundException(String message) {
		super(message);
	}

}
