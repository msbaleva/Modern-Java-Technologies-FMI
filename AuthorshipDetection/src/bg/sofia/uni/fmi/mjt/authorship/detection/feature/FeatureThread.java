package bg.sofia.uni.fmi.mjt.authorship.detection.feature;

import java.util.LinkedList;
import java.util.List;

public class FeatureThread extends Thread {

	private FeatureStatistic statistic;

	public FeatureThread(FeatureStatistic statistic) {
		this.statistic = statistic;
	}

	/**
	 * Goes through the given paragraph and counts characters, words, phrases and
	 * sentences, then modifies them in the statistic.
	 */
	public void calculate() {
		String paragraph;
		while ((paragraph = statistic.read()) != null) {
			String[] tokens = paragraph.split("\\s+");
			int phraseCount = 0;
			int sentenceCount = 0;
			int charCount = 0;
			int wordCount = 0;
			List<String> words = new LinkedList<>();
			String lastSign = ".";
			int len = tokens.length;
			for (int i = 0; i < len; i++) {
				String cleaned = cleanUp(tokens[i]);
				if (endsPhrase(tokens[i])) {
					lastSign = ",";
					phraseCount++;
				} else if (endsSentence(tokens[i])) {
					if (endsPhrase(lastSign)) {
						lastSign = ".";
						phraseCount++;
					}

					if (!cleaned.equals("") || (i > 0 && !endsSentence(tokens[i - 1]))) {
						sentenceCount++;
					}
				}

				if (!cleaned.equals("")) {
					charCount += tokens[i].length();
					wordCount++;
					words.add(cleaned);
				}

			}

			statistic.modifyWords(charCount, wordCount, words);
			statistic.modifySentences(sentenceCount, phraseCount);
		}

	}

	/**
	 * 
	 * @param token
	 * @return true if token contains a character, which ends a sentence.
	 */
	public boolean endsSentence(String token) {
		return token.contains("!") || token.contains("?") || token.contains(".");
	}

	/**
	 * 
	 * @param token
	 * @return true if token contains a character, which ends a phrase.
	 */
	public boolean endsPhrase(String token) {
		return token.contains(",") || token.contains(":") || token.contains(";");
	}

	/**
	 * 
	 * @param word
	 * @return lower-cased string with removed punctuation
	 */
	public static String cleanUp(String word) {
		return word.toLowerCase().replaceAll(
				"^[!.,:;\\-?<>#\\*\'\"\\[\\(\\]\\)\\n\\t\\\\]+|[!.,:;\\-?<>#\\*\'\"\\[\\(\\]\\)\\n\\t\\\\]+$", "");
	}

	@Override
	public void run() {
		calculate();
	}

}
