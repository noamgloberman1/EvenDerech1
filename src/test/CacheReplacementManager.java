package test;

interface CacheReplacementPolicy {
    void add(String word);

    String remove();
}