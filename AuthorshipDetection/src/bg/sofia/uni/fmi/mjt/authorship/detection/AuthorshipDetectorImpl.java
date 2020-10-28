package bg.sofia.uni.fmi.mjt.authorship.detection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bg.sofia.uni.fmi.mjt.authorship.detection.feature.FeatureStatistic;

public class AuthorshipDetectorImpl implements AuthorshipDetector {


	private List<LinguisticSignature> signatures;
	private double[] weights;

	public AuthorshipDetectorImpl(InputStream signaturesDataset, double[] weights) {
		
		this.weights = weights;
		this.signatures = new LinkedList<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(signaturesDataset))) {
			this.signatures = reader.lines()
					.map(LinguisticSignature::new)
					.collect(Collectors.toList());
			
		} catch (IOException e) {
			throw new RuntimeException("IOException: Signatures could not be loaded", e);
		}
	}

	@Override
	public LinguisticSignature calculateSignature(InputStream mysteryText) {
		if (mysteryText == null) {
			throw new IllegalArgumentException("Null argument passed as mystery text");
		}

		FeatureStatistic statistic;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(mysteryText))) {

			statistic = new FeatureStatistic(reader);

		} catch (IOException e) {
			throw new RuntimeException("IOException: Problem reading from mysteryText", e);
		}
		
		return new LinguisticSignature(statistic.generateFeatures());
	}

	@Override
	public double calculateSimilarity(LinguisticSignature firstSignature, LinguisticSignature secondSignature) {
		if (firstSignature == null || secondSignature == null) {
			throw new IllegalArgumentException("Null argument passed as signature");
		}

		double similarity = 0.0;
		Map<FeatureType, Double> firstFeatures = firstSignature.getFeatures();
		Map<FeatureType, Double> secondFeatures = secondSignature.getFeatures();
		for (FeatureType ft : FeatureType.values()) {
			similarity += Math.abs(firstFeatures.get(ft) - secondFeatures.get(ft)) * weights[ft.ordinal()];
		}

		return similarity;
	}

	@Override
	public String findAuthor(InputStream mysteryText) {
		if (mysteryText == null) {
			throw new IllegalArgumentException("Null argument passed as mystery text");
		}

		LinguisticSignature signature = calculateSignature(mysteryText);
		return signatures.stream()
				.sorted(Comparator.comparing(c -> calculateSimilarity(c, signature)))
				.findFirst()
				.get()
				.getAuthor();
	}

}
