package bg.sofia.uni.fmi.mjt.stylechecker;

public class SingleStatementCheck extends StyleCheck {

	private final static String COMMENT = "// FIXME Only one statement per line is allowed";

	public SingleStatementCheck() {
		super(COMMENT);
	}

	@Override
	public boolean hasError(String line) {
		String trimLine = line.trim();
		int len = trimLine.length();
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			if (trimLine.charAt(i) == ';') {
				if (i > 0 && cnt > 0 && trimLine.charAt(i - 1) != ';') {
					return true;
				}

				cnt++;
			}
		}

		return false;

	}

}
