package bg.sofia.uni.fmi.mjt.authorship.detection.feature;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import bg.sofia.uni.fmi.mjt.authorship.detection.FeatureType;

public class FeatureStatistic {

	private Queue<String> lines;
	private FeatureThread[] threads;
	private static final int THREADS_COUNT = 5;
	private Set<String> newWords;
	private Set<String> uniqueWords;
	private int wordCount;
	private int charCount;
	private int sentenceCount;
	private int phraseCount;

	public FeatureStatistic(BufferedReader reader) {
		this.lines = new LinkedList<>();
		generateLines(reader);
		this.newWords = new HashSet<>();
		this.uniqueWords = new HashSet<>();
		this.threads = new FeatureThread[THREADS_COUNT];
		for (int i = 0; i < THREADS_COUNT; i++) {
			threads[i] = new FeatureThread(this);
			threads[i].start();
		}
	}

	/**
	 * Reads lines from reader and merges them into paragraphs,
	 * then adds them to a queue.
	 * @param reader
	 */
	public void generateLines(BufferedReader reader) {
		String line = "";
		boolean reachedEndOfParagraph = false;
		boolean isValidSentence = false;
		StringBuilder builder = new StringBuilder();
		try {
			while ((line = reader.readLine()) != null) {
				String temp = line.trim();
				if (temp.equals("")) {
					if (isValidSentence && reachedEndOfParagraph) {
						lines.add(builder.toString());
						builder = new StringBuilder();
						reachedEndOfParagraph = false;
					} 
					continue;
				}
				isValidSentence = temp.endsWith(".") || temp.endsWith("!") || temp.endsWith("?");
				reachedEndOfParagraph = true;
				builder.append(temp + " ");
			}
			lines.add(builder.toString());
		} catch (IOException e) {
			throw new RuntimeException("IOException: Problem reading from reader", e);
		}

		
	}
	
	/**
	 * 
	 * @return the first paragraph from lines
	 */
	public synchronized String read() {
		return lines.poll();
	}

	/**
	 * Updates the number of words and characters, written from a thread.
	 * @param charCnt
	 * @param wordCnt
	 * @param words
	 */
	public synchronized void modifyWords(int charCnt, int wordCnt, List<String> words) {
		wordCount += wordCnt;
		charCount += charCnt;
		words.stream().forEach(word -> addWords(word));
	}
	
	/**
	 * Adds word to newWords. If it's not already present there,
	 * adds it to uniqueWords, otherwise removes it.
	 * @param word
	 * @return true
	 */
	public synchronized boolean addWords(String word) {
		return newWords.add(word) ? uniqueWords.add(word) : uniqueWords.remove(word);
	}

	/**
	 * Updates the number of phrases and sentences, read by a thread.
	 * @param sentenceCnt
	 * @param phraseCnt
	 */
	public synchronized void modifySentences(int sentenceCnt, int phraseCnt) {
		sentenceCount += sentenceCnt;
		phraseCount += phraseCnt;
	}

	/**
	 * Waits for all threads to finish work, then calculates the features.
	 * @return map of features
	 */
	public Map<FeatureType, Double> generateFeatures() {
		for (int i = 0; i < THREADS_COUNT; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				throw new RuntimeException("InterruptedException", e);
			}
		}
		
		Map<FeatureType, Double> features = new LinkedHashMap<>();
		Double[] values = { (double) charCount / wordCount, (double) newWords.size() / wordCount,
			(double) uniqueWords.size() / wordCount, (double) wordCount / sentenceCount,
			(double) phraseCount / sentenceCount };
		for (FeatureType ft : FeatureType.values()) {
			features.put(ft, values[ft.ordinal()]);
		}

		return features;
	}

}
