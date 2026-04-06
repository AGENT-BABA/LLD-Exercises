package Distributed_Cache;
import Distributed_Cache.cluster.CacheCluster;
import Distributed_Cache.cluster.ConsistentHashing;
import Distributed_Cache.eviction.LRUEvictionPolicy;
import Distributed_Cache.node.CacheNode;
import Distributed_Cache.service.CacheService;
import Distributed_Cache.storage.InMemoryCacheStorage;

public class Main {

    public static void main(String[] args) {

        ConsistentHashing hashing = new ConsistentHashing();
        CacheCluster cluster = new CacheCluster(hashing);

        CacheNode node1 = new CacheNode(
                "node1",
                new InMemoryCacheStorage(3, new LRUEvictionPolicy())
        );

        CacheNode node2 = new CacheNode(
                "node2",
                new InMemoryCacheStorage(3, new LRUEvictionPolicy())
        );

        cluster.addNode(node1);
        cluster.addNode(node2);

        CacheService service = new CacheService(cluster);

        service.put("A", "Apple");
        service.put("B", "Ball");
        service.put("C", "Cat");

        System.out.println(service.get("A"));
        System.out.println(service.get("B"));
    }
}
