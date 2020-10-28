package bg.sofia.uni.fmi.mjt.shopping.portal.exceptions;

public class OfferAlreadySubmittedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5188503100634100928L;

	public OfferAlreadySubmittedException() {
		// Empty body
	}

	public OfferAlreadySubmittedException(String message) {
		super(message);
	}

}
