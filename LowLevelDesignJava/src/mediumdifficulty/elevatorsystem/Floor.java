package mediumdifficulty.elevatorsystem;

import java.util.ArrayList;

public class Floor {

    ArrayList<User> users;
    ElevatorSystem elevatorSystem;

    public Floor(ElevatorSystem elevatorSystem){
        this.users = new ArrayList<>();
        this.elevatorSystem = elevatorSystem;
    }

    public void addUsers(Elevator elevator){
        ArrayList<User> elevatorUsers = elevator.users;

        for(int i=0 ; i<users.size() ; i++){
            User user = users.get(i);

            int elevatorUserCount = elevator.currentUsers;

            if(elevatorUserCount + 1 <= elevator.getCapacity()){
                System.out.println("The user is added into the elevator");
                elevator.currentUsers = elevatorUserCount + 1;
                elevatorSystem.totalUsersInTheElevators = elevatorSystem.totalUsersInTheElevators + 1;
                elevatorUsers.add(user);
            } else {
                System.out.println("The elevator is out of capacity");
            }
        }
    }

}
