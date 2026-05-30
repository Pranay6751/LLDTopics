public class Main {

    public static void main(String[] args) {

        NotificationService emailService = new EmailService();

        NotificationManager manager =
                new NotificationManager(emailService);

        manager.sendNotification("Hello from Email!");

        NotificationService smsService = new SmsService();

        manager = new NotificationManager(smsService);

        manager.sendNotification("Hello from SMS!");
    }
}

/*
 * Abstraction
 */
interface NotificationService {
    void send(String message);
}

/*
 * Low-level module
 */
class EmailService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

/*
 * Low-level module
 */
class SmsService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

/*
 * High-level module
 */
class NotificationManager {

    private final NotificationService notificationService;

    public NotificationManager(
            NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification(String message) {
        notificationService.send(message);
    }
}
