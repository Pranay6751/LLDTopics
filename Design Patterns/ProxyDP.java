               +----------------+
               |    Image       |
               +----------------+
               | + display()    |
               +----------------+
                    ▲
          ------------------------
          |                      |
          |                      |
+--------------------+    +-------------------+
| ProxyImage         |    | RealImage         |
+--------------------+    +-------------------+
| RealImage image    |    | filename          |
+--------------------+    +-------------------+
| display()          |    | display()         |
+--------------------+    +-------------------+

interface Image {
    void display();
}

// Real Object
class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}

// Proxy Object
class ProxyImage implements Image {

    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {

        // Lazy Initialization
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}

// Client
public class ProxyPatternDemo {

    public static void main(String[] args) {

        Image image = new ProxyImage("vacation.jpg");

        System.out.println("Proxy object created");
        System.out.println();

        System.out.println("First call:");
        image.display();

        System.out.println();

        System.out.println("Second call:");
        image.display();
    }
}
