package Rate_Limiting_System.strategy;

import Rate_Limiting_System.model.RateLimitConfig;
import Rate_Limiting_System.model.TokenBucket;
import Rate_Limiting_System.storage.InMemoryStorage;

public class TokenBucketStrategy implements RateLimitingStrategy {

    private final RateLimitConfig config;
    private final InMemoryStorage storage;

    public TokenBucketStrategy(RateLimitConfig config, InMemoryStorage storage) {
        this.config = config;
        this.storage = storage;
    }

    @Override
    public boolean allowRequest(String clientId) {
        TokenBucket bucket = storage.getBucket(clientId);

        if (bucket == null) {
            bucket = new TokenBucket(config.getCapacity(), config.getRefillRate());
            storage.putBucket(clientId, bucket);
        }

        return bucket.tryConsume(1);
    }
}