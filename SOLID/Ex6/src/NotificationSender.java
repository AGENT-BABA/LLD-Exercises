public abstract class NotificationSender {
    protected final AuditLog audit;
    
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    
    public final void send(Notification n){
    
        if (n==null) {
            audit.add("send failed");
            throw new IllegalArgumentException("notification cannot be null");
        }
    
        validate(n);
        doSend(n);
    };

    protected abstract void doSend(Notification n);
    protected abstract void validate(Notification n);
}
