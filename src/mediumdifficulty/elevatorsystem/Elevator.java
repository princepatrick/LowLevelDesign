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
    ArrayList<User> users;
    int pendingTravelTime;
    int pendingUserMovementTime;

    public Elevator(int capacity, ElevatorSystem elevatorSystem){
        this.capacity = capacity;
        this.elevatorDirection = 0;
        this.isElevatorAvailableInMotion = true;
        this.elevatorSystem = elevatorSystem;
        this.currentElevatorFloor = 0;
        this.currentUsers = 0;
        this.targetFloorList = new ArrayList<>();
        this.pendingTravelTime = 0;
        this.pendingUserMovementTime = 0;
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

    public int removeUserAndFindMovementTime(int floorInd){
        int outgoingUsers = 0;

        for(int i=0 ;i<users.size() ; i++ ){
            User user = users.get(i);
            if(user.destinationFloor == floorInd){
                users.remove(user);
                i--;
                outgoingUsers++;
            }
        }

        System.out.println("There are " + outgoingUsers + " Outgoing users and they will take " + outgoingUsers * 2 + " seconds.");
        return 2 * outgoingUsers;
    }



}
