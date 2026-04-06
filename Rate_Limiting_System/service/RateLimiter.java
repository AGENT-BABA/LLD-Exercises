package Rate_Limiting_System.service;


import Rate_Limiting_System.strategy.RateLimitingStrategy;

public class RateLimiter {

    private final RateLimitingStrategy strategy;

    public RateLimiter(RateLimitingStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean allowRequest(String clientId) {
        return strategy.allowRequest(clientId);
    }
}
