package Distributed_Cache.storage;

public interface CacheStorage {
    void put(String key, String value);
    String get(String key);
    void delete(String key);
    boolean contains(String key);
}
