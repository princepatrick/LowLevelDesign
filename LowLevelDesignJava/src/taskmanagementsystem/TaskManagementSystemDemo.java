package taskmanagementsystem;

public class TaskManagementSystemDemo {

    public static void run(){
        TaskManagementSystem tms;

        tms = TaskManagementSystem.getInstance();

        Address add1 = new Address( "Street Addr line 1", "Street Addr Line 2", "City", "State", 33175 );
        UserProfile up1 = new UserProfile( "Random Guy", "SDE1", "Naples Tech Ltd", add1 );
        User u1 = new User( up1 );

        tms.addUser( u1 );

        Address add2 = new Address( "Giga complex", "Stewart street", "Minepol", "State", 33172 );
        UserProfile up2 = new UserProfile( "Richie Rich", "SDE2", "Naples Tech Ltd", add2 );
        User u2 = new User( up2 );

        tms.addUser( u2 );

        Address add3 = new Address( "Status", "Boulevard", "Knackle", "State", 33174 );
        UserProfile up3 = new UserProfile( "Richard Parker", "Tester", "Naples Tech Ltd", add3 );
        User u3 = new User( up3 );

        tms.addUser( u3 );

        Task task1 = new Task( "Complete 1 LLD Question", "Try to solve atleast 1 LLD question",
                Priority.HIGH, "08/07/2024" );
        tms.findUser( u2 ).addTask( task1 );

        Task task2 = new Task( "Complete 3 Leetcode Hards", "This is equally important to the first task",
                Priority.HIGH, "08/07/2024" );
        tms.findUser( u2 ).addTask( task2 );

        Reminder rem1 = new Reminder("Please see the remainder", u3 );

        tms.findUser( u2 ).addReminder( task1, rem1);

        tms.findUser( u3 ).addTask( task2 );

        Task task3 = new Task( "Dummy", "Dummy",
                Priority.LOW, "Dummy" );

        tms.findUser( u2 ).removeTask( task3 );

        tms.findUser( u2 ).removeTask( task2 );

        tms.findUser( u1 ).addTask( task3 );

        task3.setTitle("Network with people today");
        task3.setDescription("Networking is very crucial in today's world");

        tms.findUser( u1 ).updateTask( task3, Priority.LOW );
    }



}
