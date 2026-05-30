public class Main {

    public static void main(String[] args) {

        ShapeFactory factory =
                new CircleFactory();

        factory.renderShape();

        System.out.println();

        factory =
                new RectangleFactory();

        factory.renderShape();
    }
}

/*
 * Product
 */
interface Shape {
    void draw();
}

/*
 * Concrete Products
 */
class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

/*
 * Creator
 */
abstract class ShapeFactory {

    // Factory Method
    abstract Shape createShape();

    public void renderShape() {

        Shape shape = createShape();

        shape.draw();
    }
}

/*
 * Concrete Creator
 */
class CircleFactory extends ShapeFactory {

    @Override
    Shape createShape() {
        return new Circle();
    }
}

/*
 * Concrete Creator
 */
class RectangleFactory extends ShapeFactory {

    @Override
    Shape createShape() {
        return new Rectangle();
    }
}
