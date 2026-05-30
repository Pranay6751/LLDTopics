import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Subject
        YouTubeChannel channel = new YouTubeChannel();

        // Observers
        Observer user1 = new MobileUser("Pranay");
        Observer user2 = new MobileUser("Rohith");
        Observer user3 = new EmailUser("pranay@gmail.com");

        // Subscribe
        channel.addObserver(user1);
        channel.addObserver(user2);
        channel.addObserver(user3);

        // Event occurs
        channel.uploadVideo("Observer Design Pattern");

        System.out.println();

        // Unsubscribe one user
        channel.removeObserver(user2);

        channel.uploadVideo("Dependency Inversion Principle");
    }
}

/*
 * Observer Interface
 */
interface Observer {
    void update(String message);
}

/*
 * Concrete Observer
 */
class MobileUser implements Observer {

    private final String name;

    public MobileUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(
                "Mobile Notification to "
                        + name + " : "
                        + message
        );
    }
}

/*
 * Concrete Observer
 */
class EmailUser implements Observer {

    private final String email;

    public EmailUser(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println(
                "Email sent to "
                        + email + " : "
                        + message
        );
    }
}

/*
 * Subject Interface
 */
interface Subject {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

/*
 * Concrete Subject
 */
class YouTubeChannel implements Subject {

    private final List<Observer> observers =
            new ArrayList<>();

    private String latestVideo;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update(
                    "New video uploaded: "
                            + latestVideo
            );
        }
    }

    public void uploadVideo(String videoName) {

        System.out.println(
                "Uploading video: " + videoName
        );

        this.latestVideo = videoName;

        notifyObservers();
    }
}
