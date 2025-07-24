package mediumdifficulty.elevatorsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ElevatorSystem {

    int numElevators;
    int numFloors;
    int totalUsersInTheElevators;

    ArrayList<Elevator> elevatorList;
    private ArrayList<Floor> floorList;

    public ElevatorSystem(int numElevators, int numFloors) {
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

    private void createAndDefineElevators(ElevatorSystem elevatorSystem) {
        int elevatorCount = this.numElevators;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < elevatorCount; i++) {
            System.out.println("Define the capacity of Elevator" + i + 1 + ": ");
            int userEnteredElevatorCapacity = scanner.nextInt();

            Elevator elevator = new Elevator(userEnteredElevatorCapacity, elevatorSystem);

            System.out.println("Created an elevator with the capacity of " + userEnteredElevatorCapacity);

            elevatorList.add(elevator);
        }

        System.out.println("Created " + elevatorCount + " Elevators");
    }

    private void createAndDefineFloors() {
        int floorCount = this.numFloors;

        for (int i = 0; i < floorCount; i++) {
            Floor floor = new Floor(this);

            floorList.add(floor);
        }

        System.out.println("Created " + floorCount + " Floors");
    }

    public ArrayList<Elevator> getElevatorList() {
        return elevatorList;
    }

    public int getNumElevators() {
        return numElevators;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public ArrayList<Floor> getFloorList() {
        return floorList;
    }

    public int getTotalUsersInTheElevators() {
        return totalUsersInTheElevators;
    }

    public void moveTime(int seconds) {
        System.out.println("Move time by " + seconds + " seconds.");
        int currSecondCounter = 0;

        while (seconds > 0) {
            System.out.println("We have completed " + currSecondCounter + " of seconds.");
            for (int i = 0; i < numElevators; i++) {
                Elevator elevator = elevatorList.get(i);
                int currentFloorInd = elevator.currentElevatorFloor;
                Floor currentFloor = floorList.get(currentFloorInd);

                //If elevator's targetList is empty or not
                if (elevator.targetFloorList == null && elevator.isElevatorAvailableInMotion()) {
                    System.out.println("The elevator " + i + 1 + " is idle as it has no requests");
                    elevator.currentUsers = 0;
                    elevator.elevatorDirection = 0;
                    continue;
                }

                //If not empty -
                ArrayList<Floor> elevatorTargetFloors = elevator.targetFloorList;

                for (int j = 0; j < elevatorTargetFloors.size(); j++) {
                    Floor elevTargetFloor = elevatorTargetFloors.get(j);

                    if (currentFloor.equals(elevTargetFloor) && elevator.isElevatorAvailableInMotion()) {
                        System.out.println("The current floor is one of the target floors and the elevator travel will be stopped for the elevator " + i+1);
                        elevTargetFloor.addUsers(elevator);
                        elevatorTargetFloors.remove(elevTargetFloor);
                        elevator.pendingTravelTime = 4;
                        elevator.pendingUserMovementTime = elevator.removeUserAndFindMovementTime(currentFloorInd);
                        elevator.isElevatorAvailableInMotion = false;
                        System.out.println("The elevator no: " + i+1 + " is not suited for movement and the pending travel time is " + elevator.pendingTravelTime + " and the pending user movement time is " + elevator.pendingUserMovementTime);
                    } else if (elevator.isElevatorAvailableInMotion()) {
                        System.out.println("The current floor is not a target floor. Hence need to move");
                        if (elevator.elevatorDirection >= 0) {
                            if (elevator.currentElevatorFloor == numElevators - 1) {
                                System.out.println("The elevator has reached the upper end point. Hence, reversing the direction of elevator");
                                elevator.currentElevatorFloor = elevator.currentElevatorFloor - 1;
                                elevator.elevatorDirection = -1;
                            } else {
                                System.out.println("The elevator has moved into the next level");
                                elevator.currentElevatorFloor = elevator.currentElevatorFloor + 1;
                            }
                        } else {
                            if (elevator.currentElevatorFloor == 0) {
                                System.out.println("The elevator has reached the lower end point. Hence, reversing the direction of elevator");
                                elevator.currentElevatorFloor = elevator.currentElevatorFloor + 1;
                                elevator.elevatorDirection = 1;
                            } else {
                                System.out.println("The elevator has moved into the lower level)");
                                elevator.currentElevatorFloor = elevator.currentElevatorFloor - 1;
                            }
                        }

                        elevator.pendingTravelTime = 4;
                        elevator.isElevatorAvailableInMotion = false;
                        System.out.println("The elevator can move to the next level but need to wait for " + elevator.pendingTravelTime);
                    } else {
                        System.out.println("There is a pending action present in the elevator");
                        if (elevator.pendingTravelTime > 0) {
                            elevator.pendingTravelTime -= 1;
                        } else if (elevator.pendingUserMovementTime > 0) {
                            elevator.pendingUserMovementTime -= 1;
                        }

                        if (elevator.pendingTravelTime == 0 && elevator.pendingUserMovementTime == 0) {
                            System.out.println("The pending travel and movement time is completed and the elevator can move in the next second");
                            elevator.isElevatorAvailableInMotion = true;
                        } else {
                            System.out.println("The elevator no: " + i+1 + " is not suited for movement and the pending travel time is " + elevator.pendingTravelTime + " and the pending user movement time is " + elevator.pendingUserMovementTime);
                        }
                    }
                }
                System.out.println("The elevator number " + i+1 + " is in the floor " + elevator.currentElevatorFloor + " for the current second counter " + currSecondCounter);
            }
            currSecondCounter++;
            seconds--;
            System.out.println("It has completed " + currSecondCounter +" seconds");
        }
    }
}
//If current floor is the target floor - then pick the user into the elevator
                    //Picking the user is removing the user from the floor and adding the user count into the elevator
                    //Increment user count in elevator and in elevator system as well
                // check current direction - if 0 or 1 then move one step up
                // If -1 then move one step down
                //After each step if one or the other end is reached then we switch the direction and increase the count

