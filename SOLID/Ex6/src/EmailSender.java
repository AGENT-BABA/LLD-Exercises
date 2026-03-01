public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { 
        super(audit); 
    }

    @Override
    protected void validate(Notification n) {
        if (n.body.length() > 100) {
            throw new IllegalArgumentException("Email body too long");  
        }
    }

    @Override
    protected void doSend(Notification n) {
        // LSP smell: truncates silently, changing meaning
        
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
    }
}
