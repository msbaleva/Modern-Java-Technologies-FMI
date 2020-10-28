package bg.sofia.uni.fmi.mjt.authorship.detection;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Test;

public class AuthorshipDetectorTest {
	
	private static AuthorshipDetector detector;
	private static LinguisticSignature firstSignature;
	private static LinguisticSignature secondSignature;
	private static LinguisticSignature newSignature;
	private static LinguisticSignature firstGrimSignature;
	private static LinguisticSignature secondGrimSignature;
	private static LinguisticSignature probeSignature;
	private static String author;
	private static final double[] WEIGHTS = { 11, 33, 50, 0.4, 4 };
	private static final double ZERO = 0.0;
	private static final double PRECISION = 0.01;
	private static final double SIGNATURE_SIMILARITY = 13.27;
	//private static final double SIMILARITY_FROM_FILE = 4.16;
	private static final double SIMILARITY_BETWEEN_GRIM = 3.61;
	private static final int FIRST_TEXT = 1;
	private static final int SECOND_TEXT = 2;
	private static final int THIRD_TEXT = 3;
	private static final String EXCEPTION_MESSAGE = "IOException: Reading from mystery text";
	private static final String PROBE_SIGNATURE = 
			"unknown, 4.140845070422535, 0.7605633802816901, 0.6056338028169014, 35.5, 3.0";
	private static final String SIGNATURE = 
			"Brothers Grim, 3.96868608302, 0.0529378997714, 0.0208217283571, 22.2267197987, 3.4129614094";
	private static final String AUTHOR = "Brothers Grim";
	
	@BeforeClass
	public static void setUp() {
		try (InputStream knownSignatures = SignatureDatasetInitializer.initSignatureDataset()) {
			detector = new AuthorshipDetectorImpl(knownSignatures, WEIGHTS);
			firstSignature = new LinguisticSignature(SIGNATURE);
			secondSignature = new LinguisticSignature(SIGNATURE);
			probeSignature = new LinguisticSignature(PROBE_SIGNATURE);
		} catch (IOException e) {
			throw new RuntimeException("IOException: Reading from signature dataset", e);
		}
	}

	@Test
	public void testCalculateSignatureProbe() {
		try (InputStream mysteryText = MysteryTextInitializer.initMysteryText(THIRD_TEXT)) {
			newSignature = detector.calculateSignature(mysteryText);
		} catch (IOException e) {
			throw new RuntimeException(EXCEPTION_MESSAGE, e);
		}
		
		String assertMessage = "Signature calculation of a small text.";
		double similarity = detector.calculateSimilarity(newSignature, probeSignature);
		assertEquals(assertMessage, similarity, ZERO, PRECISION);
	}
	
	@Test
	public void testCalculateSignatureExcerpt() {
		try (InputStream mysteryText = MysteryTextInitializer.initMysteryText(FIRST_TEXT)) {
			newSignature = detector.calculateSignature(mysteryText);
		} catch (IOException e) {
			throw new RuntimeException(EXCEPTION_MESSAGE, e);
		}

		String assertMessage = "Signature calculation of an excerpt.";
		double similarity = detector.calculateSimilarity(newSignature, firstSignature);
		assertEquals(assertMessage, similarity, SIGNATURE_SIMILARITY, PRECISION);
	}
	
	/*
	
	@Test
	public void testCalculateSignatureFromFile() {
		try (InputStream mysteryText = new FileInputStream("resources/mystery5.txt")) {
			newSignature = detector.calculateSignature(mysteryText);
		} catch (IOException e) {
			throw new RuntimeException(EXCEPTION_MESSAGE, e);
		}
		
		String assertMessage = "Signature calculation of a whole text.";
		double similarity = detector.calculateSimilarity(newSignature, firstSignature);
		assertEquals(assertMessage, similarity, SIMILARITY_FROM_FILE, PRECISION);
	}
	
	*/

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateSignatureIfNull() {
		InputStream is = null;
		detector.calculateSignature(is);
	}

	@Test
	public void testCalculateSimilarityIfEqual() {
		String assertMessage = "Similarity calculation for two signatures with the same text.";
		double similarity = detector.calculateSimilarity(firstSignature, secondSignature);
		assertEquals(assertMessage, similarity, ZERO, PRECISION);
	}
	
	@Test
	public void testCalculateSimilaritySameAuthor() {
		try (InputStream firstMysteryText = MysteryTextInitializer.initMysteryText(FIRST_TEXT);
				InputStream secondMysteryText = MysteryTextInitializer.initMysteryText(SECOND_TEXT)) {
			firstGrimSignature = detector.calculateSignature(firstMysteryText);
			secondGrimSignature = detector.calculateSignature(secondMysteryText);
		} catch (IOException e) {
			throw new RuntimeException(EXCEPTION_MESSAGE, e);
		}
		String assertMessage = "Similarity calculation for two signatures of excerpts from the same author.";
		double similarity = detector.calculateSimilarity(firstGrimSignature, secondGrimSignature);
		assertEquals(assertMessage, similarity, SIMILARITY_BETWEEN_GRIM, PRECISION);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateSimilarityIfNull() {
		LinguisticSignature ls = null;
		detector.calculateSimilarity(ls, secondSignature);
	}

	@Test
	public void testFindAuthorExceprt() {
		try (InputStream mysteryText = MysteryTextInitializer.initMysteryText(FIRST_TEXT)) {
			author = detector.findAuthor(mysteryText);
		} catch (IOException e) {
			throw new RuntimeException(EXCEPTION_MESSAGE, e);
		}
		String assertMessage = "Find author of a given excerpt.";
		assertEquals(assertMessage, author, AUTHOR);

	}
	
	/*
	
	@Test
	public void testFindAuthorFromFile() {
		try (InputStream mysteryText = new FileInputStream("resources/mystery5.txt")) {
			author = detector.findAuthor(mysteryText);
		} catch (IOException e) {
			throw new RuntimeException(EXCEPTION_MESSAGE, e);
		}
		String assertMessage = "Find author of a given text.";
		assertEquals(assertMessage, author, AUTHOR);

	}
	
    */
	
	@Test(expected = IllegalArgumentException.class)
	public void testFindAuthorIfNull() {
		InputStream is = null;
		detector.findAuthor(is);
	}

}
