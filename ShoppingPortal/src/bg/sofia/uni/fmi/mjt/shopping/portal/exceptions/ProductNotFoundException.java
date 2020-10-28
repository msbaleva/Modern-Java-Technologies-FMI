package bg.sofia.uni.fmi.mjt.shopping.portal.exceptions;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4893061873366081719L;

	public ProductNotFoundException() {
		// Empty body
	}

	public ProductNotFoundException(String message) {
		super(message);
	}

}
