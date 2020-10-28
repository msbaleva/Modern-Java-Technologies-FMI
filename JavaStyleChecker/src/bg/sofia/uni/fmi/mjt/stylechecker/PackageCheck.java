package bg.sofia.uni.fmi.mjt.stylechecker;

public class PackageCheck extends StyleCheck {

	private final static String COMMENT = "// FIXME Package name should not contain upper-case letters or underscores";
	private final static int FROM = 8;

	public PackageCheck() {
		super(COMMENT);
	}

	@Override
	public boolean hasError(String line) {
		if (line.startsWith("package ")) {
			String trimLine = line.trim();
			int len = line.length();
			for (int i = FROM; i < len - 1; i++) {
				if (trimLine.charAt(i) == '_' || (trimLine.charAt(i) >= 'A' && trimLine.charAt(i) <= 'Z')) {
					return true;
				}
			}
		}

		return false;

	}

}
