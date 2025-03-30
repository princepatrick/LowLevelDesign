package mediumdifficulty.elevatorsystem;

import java.util.ArrayList;

public class Elevator {

    int capacity;
    int elevatorDirection;
    boolean isElevatorAvailableInMotion;
    int currentElevatorFloor;
    int currentUsers;
    private ElevatorSystem elevatorSystem;
    ArrayList<Floor> targetFloorList;

    public Elevator(int capacity, ElevatorSystem elevatorSystem){
        this.capacity = capacity;
        this.elevatorDirection = 0;
        this.isElevatorAvailableInMotion = true;
        this.elevatorSystem = elevatorSystem;
        this.currentElevatorFloor = 0;
        this.currentUsers = 0;
        this.targetFloorList = new ArrayList<>();
    }

    public int getCapacity(){
        return capacity;
    }

    public int getElevatorDirection(){
        return elevatorDirection;
    }

    public boolean isElevatorAvailableInMotion(){
        return isElevatorAvailableInMotion;
    }

    public int getCurrentElevatorFloor(){
        return currentElevatorFloor;
    }

    public void addFloorTargetList(Floor targetFloor){
        targetFloorList.add(targetFloor);
    }

}
