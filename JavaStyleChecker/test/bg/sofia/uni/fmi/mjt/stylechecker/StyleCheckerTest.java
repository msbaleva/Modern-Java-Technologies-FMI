package bg.sofia.uni.fmi.mjt.stylechecker;

import static org.junit.Assert.assertEquals;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

public class StyleCheckerTest {

	private StyleChecker checker;

	private static final int TEN = 10;

	@Before
	public void setup() {
		checker = new StyleChecker();
	}

	@Test
	public void testWildcardImportCheck() {
		Reader input = new StringReader("import java.util.*;");
		Writer output = new StringWriter();

		checker.checkStyle(input, output);
		String actual = output.toString();

		assertEquals("// FIXME Wildcards are not allowed in import statements" + System.lineSeparator()
				+ "import java.util.*;", actual.strip());
	}

	@Test
	public void testPackageCheck() {
		Reader input = new StringReader("package NASA.dfg;");
		Writer output = new StringWriter();

		checker.checkStyle(input, output);
		String actual = output.toString();

		assertEquals("// FIXME Package name should not contain upper-case letters or underscores"
				+ System.lineSeparator() + "package NASA.dfg;", actual.strip());
	}

	@Test
	public void testBracketsCheck() {
		Reader input = new StringReader("{");
		Writer output = new StringWriter();

		checker.checkStyle(input, output);
		String actual = output.toString();

		assertEquals("// FIXME Opening brackets should be placed on the same line as the declaration"
				+ System.lineSeparator() + "{", actual.strip());
	}

	@Test
	public void testLengthCheck() {
		StringBuilder oneH = new StringBuilder("0");
		for (int i = 0; i < TEN; i++) {
			oneH.append("1234567890");
		}
		String str = oneH.toString();
		Reader input = new StringReader(str);
		Writer output = new StringWriter();

		checker.checkStyle(input, output);
		String actual = output.toString();

		assertEquals("// FIXME Length of line should not exceed 100 characters" + System.lineSeparator() + str,
				actual.strip());
	}

	@Test
	public void testSingleStatementCheck() {
		Reader input = new StringReader("hasError();hasErrors();");
		Writer output = new StringWriter();

		checker.checkStyle(input, output);
		String actual = output.toString();

		assertEquals(
				"// FIXME Only one statement per line is allowed" + System.lineSeparator() + "hasError();hasErrors();",
				actual.strip());
	}

}
