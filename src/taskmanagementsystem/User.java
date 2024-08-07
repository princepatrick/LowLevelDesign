package taskmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class User {

    private UserProfile userProfile;
    private List<Task> taskList;

    public User( UserProfile up1 ){
        System.out.println("Creating a new user");
        userProfile = up1;
        taskList = new ArrayList<>();
    }

    public void addTask( Task t ){
        System.out.println("Adding a new task in addTask() in User Class");
        taskList.add(t);
    }

    public void addReminder( Task t, Reminder rem ){
        System.out.println("Adding a new reminder in addReminder() in User Class");
        for( Task task : taskList ){
            if( task == t ){
                task.addReminder( rem );
            }
        }
    }

    public void removeTask( Task t ){
        System.out.println("Removing a task in removeTask() in User Class");
        for( int i=0 ; i<taskList.size() ; i++ ){
            if( taskList.get(i) == t ){
                System.out.println("The task is found for removal");
                taskList.remove(i);
            }
        }
    }

    public void updateTask( Task t, Priority priority ){
        System.out.println("Updating a priority in updateTask() in User Class");
        for( Task task : taskList ){
            if( task == t ){
                t.setPriority( priority );
            }
        }
    }

    public void updateTask( Task t, String newTitle, String newDescription, Priority newPriority ){
        System.out.println("Updating a title, description and priority in updateTask() in User Class");
        for( Task task : taskList ){
            if( task == t ){
                t.setTitle(newTitle);
                t.setDescription(newDescription);
                t.setPriority( newPriority );
            }
        }
    }

}
