package bg.sofia.uni.fmi.mjt.stylechecker;

public class LengthCheck extends StyleCheck {

	private final static String COMMENT = "// FIXME Length of line should not exceed 100 characters";
	private final static int LIMIT = 100;

	public LengthCheck() {
		super(COMMENT);
	}

	@Override
	public boolean hasError(String line) {
		String trimLine = line.trim();
		if (trimLine.startsWith("import ")) {
			return false;
		}

		return (LIMIT < trimLine.length());

	}

}
