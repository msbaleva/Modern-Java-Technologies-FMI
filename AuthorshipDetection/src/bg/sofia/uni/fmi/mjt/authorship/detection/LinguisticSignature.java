package bg.sofia.uni.fmi.mjt.authorship.detection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinguisticSignature {

	private Map<FeatureType, Double> features;
	private String author;

	public LinguisticSignature(Map<FeatureType, Double> features) {
		this.features = features;
		this.author = "unknown";
	}
	
	public LinguisticSignature(String line) {
		features = new LinkedHashMap<>();
		String[] tokens = line.split(", ");
		this.author = tokens[0];
		for (FeatureType ft : FeatureType.values()) {
			features.put(ft, Double.valueOf(tokens[ft.ordinal() + 1]));
		}
	}

	public Map<FeatureType, Double> getFeatures() {
		return features;
	}
	
	public String getAuthor() {
		return author;
	}

}
