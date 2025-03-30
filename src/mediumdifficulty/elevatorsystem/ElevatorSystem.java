package mediumdifficulty.elevatorsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ElevatorSystem {

    private int numElevators;
    private int numFloors;

    private ArrayList<Elevator> elevatorList;
    private ArrayList<Floor> floorList;

    public ElevatorSystem( int numElevators, int numFloors ){
        System.out.println("Creating an elevator system with " + numElevators + " elevators and with " + numFloors + " Floors.");
        this.numElevators = numElevators;
        this.numFloors = numFloors;
        createAndDefineElevators();
        createAndDefineFloors();
        System.out.println("Successfully created an elevator system with " + this.numElevators + " elevators and " + this.numFloors + " floors.");
    }

    private void createAndDefineElevators(){
        int elevatorCount = this.numElevators;
        Scanner scanner = new Scanner(System.in);

        for( int i=0 ; i<elevatorCount ; i++ ){
            System.out.println("Define the capacity of Elevator" + i+1 + ": ");
            int userEnteredElevatorCapacity = scanner.nextInt();

            Elevator elevator = new Elevator();

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

}
