package Distributed_Cache.service;

import Distributed_Cache.cluster.CacheCluster;
import Distributed_Cache.node.CacheNode;

public class CacheService {

    private final CacheCluster cluster;

    public CacheService(CacheCluster cluster) {
        this.cluster = cluster;
    }

    public void put(String key, String value) {
        CacheNode node = cluster.getNode(key);
        if (node != null) {
            node.put(key, value);
        }
    }

    public String get(String key) {
        CacheNode node = cluster.getNode(key);
        return node != null ? node.get(key) : null;
    }

    public void delete(String key) {
        CacheNode node = cluster.getNode(key);
        if (node != null) {
            node.delete(key);
        }
    }
}
