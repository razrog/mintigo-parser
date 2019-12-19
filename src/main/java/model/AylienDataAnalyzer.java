package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AylienDataAnalyzer {

    private Map<String, Integer> keyWordsCountMap;
    private List<String> invalidUrls;

    public AylienDataAnalyzer() {
        this.keyWordsCountMap = new ConcurrentHashMap<>();
        invalidUrls = new ArrayList<>();
    }


    public void addNewKeyWord(String keyWord) {
        if (keyWordsCountMap.containsKey(keyWord)) {
            Integer numberOfAppearances = keyWordsCountMap.get(keyWord) + 1;
            keyWordsCountMap.put(keyWord, numberOfAppearances);
        } else {
            keyWordsCountMap.put(keyWord, 1);
        }
    }

    public Map<String, Integer> getTopKeywords() {
        //todo - analyzed the map and get the 20% top results
        return keyWordsCountMap;
    }

    public Map<String, Double> getAvgKeyWordAppearnces() {
        //todo - calculate the average of each key words, return a map contains keyWord -> average
        return null;
    }

    public List<String> getInvalidUrls() {
        return invalidUrls;
    }


}
