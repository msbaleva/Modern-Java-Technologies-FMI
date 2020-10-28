package bg.sofia.uni.fmi.mjt.stylechecker;

public class WildcardImportCheck extends StyleCheck {

	private final static String COMMENT = "// FIXME Wildcards are not allowed in import statements";

	public WildcardImportCheck() {
		super(COMMENT);
	}

	@Override
	public boolean hasError(String line) {
		if (line.trim().endsWith(".*;")) {
			return true;
		}

		return false;

	}

}
