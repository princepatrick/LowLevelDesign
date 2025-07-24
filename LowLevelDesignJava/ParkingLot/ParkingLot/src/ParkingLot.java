import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static ParkingLot parkingLotObj;

    private ArrayList<Level> levels;

    private ParkingLot(){
        levels = new ArrayList<>();
    }

    public static ParkingLot getInstance(){
        if( parkingLotObj == null ){
            parkingLotObj = new ParkingLot();
        }

        return parkingLotObj;
    }

    public void addLevel(int capacity){
        Level level = new Level(capacity);
        levels.add(level);
    }

    public void removeLevel(){
        levels.remove( levels.size() - 1 );
    }

    int findLeastBusyLevel(){
        double minVacancyRate = 0.0;
        int level = -1;

        for( int i=0 ; i<levels.size() ; i++ ){
            int vacantSpots = levels.get(i).getParkingSpots();
            int capacity = levels.get(i).getCapacity();

            double vacancyRate = (double) vacantSpots / (double) capacity;

            if( vacancyRate > minVacancyRate ){
                minVacancyRate = vacancyRate;
                level = i;
            }

        }

        if( minVacancyRate == 0.0 ) return -1;

        return level;
    }

    public void addVehicle(Vehicle vehicle ){
        int leastBusyLevel = findLeastBusyLevel();

        if( leastBusyLevel == -1 ){
            System.out.println("There are no vacant parking spot");
        } else {
            levels.get(leastBusyLevel).addVehicle(vehicle);
        }
    }

    public void removeVehicle(Vehicle vehicle){

        for( int i=0 ; i<levels.size() ; i++ ){
            levels.get(i).removeVehicle(vehicle);
        }

    }

    public void displayInformation(){

        for( int i=0 ; i<levels.size() ; i++ ){
            Level level = levels.get(i);

            int capacity = level.getCapacity();
            int vacantSpots = level.getParkingSpots();

            System.out.println("Level: " + i + " details are Capacity: "
                    + capacity + " and number of vacant spots are " + vacantSpots );
        }

    }
}
