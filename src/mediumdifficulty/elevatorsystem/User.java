package mediumdifficulty.elevatorsystem;

import java.util.ArrayList;

public class User {
    ElevatorSystem elevatorSystem;
    String username;

    public User(String username, ElevatorSystem elevatorSystem){
        this.elevatorSystem = elevatorSystem;
        this.username = username;
    }

    public void clickForAnElevator(int currentFloor, int destinationFloor){
        ArrayList<Elevator> elevators = elevatorSystem.getElevatorList();
        int elevatorCount = elevatorSystem.getNumElevators();
        int minimumTimeForElevator = Integer.MAX_VALUE;
        int optimalElevatorInd = -1;
        ArrayList<Floor> floors = elevatorSystem.getFloorList();

        for( int i=0 ; i<elevatorCount ; i++ ){
            Elevator elevator = elevators.get(i);
            int elevatorCurrentFloor = elevator.getCurrentElevatorFloor();
            int requiredDirection = findRequiredDirection(currentFloor, elevatorCurrentFloor);
            int elevatorDirection = elevator.getElevatorDirection();
            int timeNeededForElev;
            int currentUsersInElevator = elevator.currentUsers;

            if(elevatorDirection == 0 || requiredDirection == elevatorDirection){
                timeNeededForElev = findWaitTime(currentFloor, elevatorCurrentFloor, currentUsersInElevator, elevatorDirection, true);
            } else {
                timeNeededForElev = findWaitTime(currentFloor, elevatorCurrentFloor, currentUsersInElevator, elevatorDirection, false);
            }

            if(timeNeededForElev < minimumTimeForElevator){
                minimumTimeForElevator = timeNeededForElev;
                optimalElevatorInd = i;
            }
        }

        System.out.println("The user " + username + " needs to wait for " + minimumTimeForElevator + " seconds for the closest elevator number " + optimalElevatorInd+1);

        Elevator optimalElevator = elevators.get(optimalElevatorInd);
        Floor userFloor = floors.get(currentFloor);
        optimalElevator.addFloorTargetList(userFloor);
    }

    int findRequiredDirection( int userFloor, int elevatorFloor ){
        if(userFloor == elevatorFloor){
            return 0;
        } else if(userFloor > elevatorFloor){
            return 1;
        } else if(userFloor < elevatorFloor){
            return -1;
        }

        return 0;
    }

    int findWaitTime(int userFloor, int elevatorFloor, int currentUsersInElevator, int elevatorDirection, boolean isSameDirection){
        int userRequestTime = (currentUsersInElevator * 2) + ((elevatorSystem.getTotalUsersInTheElevators() / 10) * 2);
        int totalWaitTime = 0;

        if(isSameDirection){
            totalWaitTime = (Math.abs(elevatorFloor - userFloor) * 5) + userRequestTime;
        } else {
            int travelTime = elevatorDirection > 0
                    ? ((elevatorSystem.numElevators - 1 - elevatorFloor) * 2 * 5)
                    : (elevatorFloor * 2 * 5);
            travelTime += Math.abs(elevatorFloor - userFloor) * 5;
            totalWaitTime = travelTime + userRequestTime;
        }

        System.out.println("The total wait time with the elevator is " + totalWaitTime);

        return totalWaitTime;
    }

}
