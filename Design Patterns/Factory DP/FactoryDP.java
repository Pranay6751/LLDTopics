public class Main {

    public static void main(String[] args) {

        Vehicle vehicle1 =
                VehicleFactory.getVehicle("CAR");

        vehicle1.drive();

        Vehicle vehicle2 =
                VehicleFactory.getVehicle("BIKE");

        vehicle2.drive();
    }
}

/*
 * Product
 */
interface Vehicle {
    void drive();
}

/*
 * Concrete Product
 */
class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving Car");
    }
}

/*
 * Concrete Product
 */
class Bike implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving Bike");
    }
}

/*
 * Factory
 */
class VehicleFactory {

    public static Vehicle getVehicle(
            String vehicleType) {

        if ("CAR".equalsIgnoreCase(vehicleType)) {
            return new Car();
        }

        if ("BIKE".equalsIgnoreCase(vehicleType)) {
            return new Bike();
        }

        throw new IllegalArgumentException(
                "Invalid vehicle type"
        );
    }
}
