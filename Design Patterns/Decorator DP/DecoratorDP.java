public class Main {

    public static void main(String[] args) {

        // Step 1: Create Plain Pizza
        Pizza pizza = new PlainPizza();

        System.out.println(
                pizza.getDescription()
                        + " = ₹"
                        + pizza.getCost()
        );

        // Step 2: Add Cheese
        pizza = new CheeseDecorator(pizza);

        System.out.println(
                pizza.getDescription()
                        + " = ₹"
                        + pizza.getCost()
        );

        // Step 3: Add Mushroom
        pizza = new MushroomDecorator(pizza);

        System.out.println(
                pizza.getDescription()
                        + " = ₹"
                        + pizza.getCost()
        );
    }
}

/*
 * Component
 */
interface Pizza {

    String getDescription();

    int getCost();
}

/*
 * Concrete Component
 */
class PlainPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public int getCost() {
        return 100;
    }
}

/*
 * Base Decorator
 */
abstract class PizzaDecorator implements Pizza {

    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

/*
 * Concrete Decorator
 */
class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()
                + ", Cheese";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 20;
    }
}

/*
 * Concrete Decorator
 */
class MushroomDecorator extends PizzaDecorator {

    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()
                + ", Mushroom";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 30;
    }
}
