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

    }

}
