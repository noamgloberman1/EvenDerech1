package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class LFU implements CacheReplacementPolicy {

    HashMap<String, Integer> wordStock = new HashMap<>();

    public String remove() {
        Collection<Integer> values = wordStock.values();
        int min = values.stream().min(Integer::compareTo).get();
        String leastFrequentlyUsed = wordStock.entrySet().stream()
                .filter(entry -> entry.getValue() == min)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        wordStock.remove(min);
        return leastFrequentlyUsed;
    }

    public void add(String word) {
        if (wordStock.containsKey(word)) {
            int count = wordStock.get(word) + 1;
            wordStock.put(word, count);
        } else {
            wordStock.put(word, 1);
        }
    }
}