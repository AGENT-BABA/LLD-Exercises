package Rate_Limiting_System.storage;

import Rate_Limiting_System.model.TokenBucket;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStorage {

    private final ConcurrentHashMap<String, TokenBucket> bucketMap = new ConcurrentHashMap<>();

    public TokenBucket getBucket(String clientId) {
        return bucketMap.get(clientId);
    }

    public void putBucket(String clientId, TokenBucket bucket) {
        bucketMap.put(clientId, bucket);
    }
}
