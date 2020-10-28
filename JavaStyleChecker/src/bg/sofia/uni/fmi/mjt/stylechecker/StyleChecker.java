package bg.sofia.uni.fmi.mjt.stylechecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

/**
 * Checks adherence to Java style guidelines.
 */
public class StyleChecker {

	private Set<StyleCheck> allChecks;

	public StyleChecker() {
		allChecks = new HashSet<StyleCheck>();
		allChecks.add(new LengthCheck());
		allChecks.add(new OpeningBracketsCheck());
		allChecks.add(new PackageCheck());
		allChecks.add(new SingleStatementCheck());
		allChecks.add(new WildcardImportCheck());
	}

	/**
	 * For each line from the given {@code source} performs code style checks and
	 * writes to the {@code output} 1. a comment line for each style violation in
	 * the input line, if any 2. the input line itself.
	 * 
	 * @param source
	 * @param output
	 */
	public void checkStyle(Reader source, Writer output) {
		try (BufferedReader reader = new BufferedReader(source); PrintWriter writer = new PrintWriter(output, true)) {

			String line;
			while ((line = reader.readLine()) != null) {
				for (StyleCheck c : allChecks) {
					if (c.hasError(line)) {
						writer.println(c.getComment());
					}
				}
				writer.println(line);
			}

		} catch (IOException e) {
			throw new RuntimeException("Could not check style", e);
		}
	}

}