import vehicles.Vehicle;
import vehicles.VehicleType;

import java.util.ArrayList;

public class Level {

    int levCapacity;

    ArrayList<ParkingSpot> parkingSpots;

    public Level( int capacity ){

        levCapacity = capacity;
        parkingSpots = new ArrayList<ParkingSpot>(capacity);

        ArrayList<VehicleType> typeOfVehicles = new ArrayList<>();
        typeOfVehicles.add(VehicleType.CAR);
        typeOfVehicles.add(VehicleType.MOTORCYCLE);
        typeOfVehicles.add(VehicleType.RESIDENTIALVEHICLE);

        for( int i=0 ; i<capacity ; i++ ){
            parkingSpots.get(i).setType(typeOfVehicles.get(i%3));
        }

    }

    public void addVehicle(Vehicle vehicle ){

        for( int i=0 ; i<parkingSpots.size() ; i++ ){
            ParkingSpot parkSpot = parkingSpots.get(i);

            if( parkSpot.isAvailable() && parkSpot.getType() == vehicle.getType() ){
                parkSpot.addVehicle( vehicle );
            }
        }

    }

    public void removeVehicle(Vehicle vehicle ){

        for( int i=0 ; i<parkingSpots.size() ; i++ ){
            ParkingSpot parkSpot = parkingSpots.get(i);

            if( !parkSpot.isAvailable() && parkSpot.getType() == vehicle.getType() ){
                parkSpot.removeVehicle();
            }
        }

    }

    public int getCapacity(){

        return levCapacity;

    }

    public int getParkingSpots(){

        int count = 0;

        for( int i=0 ; i<parkingSpots.size() ; i++ ){
            ParkingSpot parkSpot = parkingSpots.get(i);

            if( parkSpot.isAvailable() ){
                count++;
            }
        }

        return count;

    }


}
