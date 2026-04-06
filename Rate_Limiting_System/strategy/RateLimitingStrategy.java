package Rate_Limiting_System.strategy;

public interface RateLimitingStrategy {
    boolean allowRequest(String clientId);
}
