import vehicles.Car;
import vehicles.Motorcycle;
import vehicles.Vehicle;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        ParkingLot parkingLot = ParkingLot.getInstance();

        Vehicle vehicle1 = new Car("ASDGHK");

        Vehicle vehicle2 = new Motorcycle("QWERTY");

        parkingLot.addVehicle( vehicle1 );

        parkingLot.addVehicle( vehicle2 );

        parkingLot.displayInformation();

        parkingLot.removeVehicle(vehicle2);

        parkingLot.displayInformation();

    }
}