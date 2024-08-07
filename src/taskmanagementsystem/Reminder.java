package taskmanagementsystem;

public class Reminder {

    private String reminderText;
    private User createdUser;

    public Reminder( String theReminderText, User createdUser ){
        reminderText = theReminderText;
        createdUser = createdUser;
    }
}
