package taskmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementSystem {

    public static TaskManagementSystem tms;

    List<User> userList;

    public TaskManagementSystem(){
        System.out.println("Initializing the TMS");
        userList = new ArrayList<>();
    }

    public static synchronized TaskManagementSystem getInstance(){
        System.out.println("Attempting to create a synchronized instance of TaskManagementSystem");
        if( tms == null ){
            System.out.println("Creating a new instance of TaskManagementSystem");
            tms = new TaskManagementSystem();
        }

        return tms;
    }

    public void addUser( User u ){
        System.out.println("Adding a new user into the TMS");
        userList.add(u);
    }

    public void removeUser( User u ){
        System.out.println("Removing an user from the TMS");
        userList.remove(u);
    }

    public void removeLastUser(){
        System.out.println("Removing the last user from the TMS");
        userList.removeLast();
    }

    public User findUser( User u ){

        System.out.println("Finding an user from the TMS");

        for( User user : userList ){
            if( user == u ){
                System.out.println("Found the user");
                return user;
            }
        }

        System.out.println("The user is not found");
        return null;
    }

}
