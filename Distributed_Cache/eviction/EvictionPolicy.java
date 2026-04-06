package Distributed_Cache.eviction;

import Distributed_Cache.model.CacheEntry;
import java.util.concurrent.ConcurrentHashMap;


public interface EvictionPolicy {
    String evictKey(ConcurrentHashMap<String, CacheEntry> store);
}
