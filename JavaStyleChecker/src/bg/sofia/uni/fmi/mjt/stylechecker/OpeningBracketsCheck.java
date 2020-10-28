package bg.sofia.uni.fmi.mjt.stylechecker;

public class OpeningBracketsCheck extends StyleCheck {

	private final static String COMMENT = 
			"// FIXME Opening brackets should be placed on the same line as the declaration";

	public OpeningBracketsCheck() {
		super(COMMENT);
	}

	@Override
	public boolean hasError(String line) {
		if (line.trim().startsWith("{")) {
			return true;
		}

		return false;

	}

}
