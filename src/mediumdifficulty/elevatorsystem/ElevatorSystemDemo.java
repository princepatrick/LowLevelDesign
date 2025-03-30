package mediumdifficulty.elevatorsystem;

import java.util.Scanner;

public class ElevatorSystemDemo {

    public static void run(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elevators the elevator system should consist: ");
        int elevatorCount = scanner.nextInt();

        System.out.println("Enter the number of floors the elevator  system should consist: ");
        int floorCount = scanner.nextInt();

        ElevatorSystem elevatorSystem = new ElevatorSystem(elevatorCount, floorCount);

        User u1 = new User( "UserNo1", elevatorSystem);
        u1.clickForAnElevator(2, 6);

        elevatorSystem.moveTime(3);

        User u2 = new User("UserNo2", elevatorSystem);
        u2.clickForAnElevator(5, 7);

        elevatorSystem.moveTime(5);

    }

}
