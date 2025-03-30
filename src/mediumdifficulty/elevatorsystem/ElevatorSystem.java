package mediumdifficulty.elevatorsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ElevatorSystem {

    int numElevators;
    int numFloors;
    int totalUsersInTheElevators;

    ArrayList<Elevator> elevatorList;
    private ArrayList<Floor> floorList;

    public ElevatorSystem( int numElevators, int numFloors ){
        System.out.println("Creating an elevator system with " + numElevators + " elevators and with " + numFloors + " Floors.");
        this.numElevators = numElevators;
        this.numFloors = numFloors;
        this.totalUsersInTheElevators = 0;
        elevatorList = new ArrayList<>();
        floorList = new ArrayList<>();
        createAndDefineElevators(this);
        createAndDefineFloors();
        System.out.println("Successfully created an elevator system with " + this.numElevators + " elevators and " + this.numFloors + " floors.");
    }

    private void createAndDefineElevators(ElevatorSystem elevatorSystem){
        int elevatorCount = this.numElevators;
        Scanner scanner = new Scanner(System.in);

        for( int i=0 ; i<elevatorCount ; i++ ){
            System.out.println("Define the capacity of Elevator" + i+1 + ": ");
            int userEnteredElevatorCapacity = scanner.nextInt();

            Elevator elevator = new Elevator(userEnteredElevatorCapacity, elevatorSystem);

            System.out.println("Created an elevator with the capacity of " + userEnteredElevatorCapacity);

            elevatorList.add(elevator);
        }

        System.out.println("Created " + elevatorCount + " Elevators");
    }

    private void createAndDefineFloors(){
        int floorCount = this.numFloors;

        for( int i=0 ; i<floorCount ; i++ ){
            Floor floor = new Floor();

            floorList.add(floor);
        }

        System.out.println("Created " + floorCount + " Floors");
    }

    public ArrayList<Elevator> getElevatorList(){
        return elevatorList;
    }

    public int getNumElevators(){
        return numElevators;
    }

    public int getNumFloors(){
        return numFloors;
    }

    public ArrayList<Floor> getFloorList(){
        return floorList;
    }

    public int getTotalUsersInTheElevators(){
        return totalUsersInTheElevators;
    }

}
