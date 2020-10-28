package bg.sofia.uni.fmi.mjt.youtube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bg.sofia.uni.fmi.mjt.youtube.model.TrendingVideo;

public class YoutubeTrendsExplorer {
	
	private List<TrendingVideo> videos;
	private final static int HUNDRED_THOUSAND = 100000;
	private final static int THREE = 3;

    /**
     * Loads the dataset from the given {@code dataInput} stream.
     */
    public YoutubeTrendsExplorer(InputStream dataInput) {
    	try (BufferedReader reader = new BufferedReader(new InputStreamReader(dataInput))) {
    		reader.readLine();
            videos = reader.lines()
                    .map(TrendingVideo::createTrendingVideo)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not load dataset", e);
        }
    }

    /**
     * Returns all videos loaded from the dataset.
     **/
    public Collection<TrendingVideo> getTrendingVideos() {
        return videos;
    }

    // Other methods ...
    
    public String findIdOfLeastLikedVideo() {
    	return videos.stream()
    			.min(Comparator.comparing(x -> x.getLikes()))
    			.get()
    			.getId();
    }
    
    public String findIdOfMostLikedLeastDislikedVideo() {
    	return videos.stream()
    			.max(Comparator.comparing(v -> v.getLikes() - v.getDislikes()))
    			.get()
    			.getId();
    }
    
    public List<String> findDistinctTitlesOfTop3VideosByViews() {
    	return videos.stream()
    			.distinct()
                .sorted((v1, v2) ->Long.compare(v2.getViews(), v1.getViews()))
                .limit(THREE)
                .map(TrendingVideo::getTitle)
                .collect(Collectors.toList());
    }

    public String findIdOfMostTaggedVideo() {
    	return videos.stream()
    	        .max(Comparator.comparing(v -> v.getTags().size()))
    			.get()
    			.getId();
    }
    
    public String findTitleOfFirstVideoTrendingBefore100KViews() {
    	return videos.stream()
    			.sorted((v1, v2) -> v1.getPublishDate().compareTo(v2.getPublishDate()))
                .filter(v -> v.getViews() < HUNDRED_THOUSAND)
                .findFirst()
                .get()
                .getTitle();
    }
    
    public String findIdOfMostTrendingVideo() {
    	return videos.stream()
                .collect(Collectors.groupingBy(TrendingVideo::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(v -> v.getValue()))
                .get()
                .getKey();
    }

}