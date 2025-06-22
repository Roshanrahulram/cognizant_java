interface Notifier {
    void send(String message);
}
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email messages: " + message);
    }
}
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}
class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS messages: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Sending Slack messages: " + message);
    }
}

public class Decorator {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        
        // Adding SMS and Slack notification capabilities
        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);
        
        // Sending the notification
        notifier.send("Your order has been processed successfully!");
    }
}
