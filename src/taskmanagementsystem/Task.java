package taskmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Task {

    private String title;
    private String description;
    private Priority priority;
    private String deadline;
    private List<Reminder> reminderList;

    public Task( String theTitle, String theDescription, Priority priority, String theDeadline ){
        System.out.println("Creating a new Task in Task class");
        title = theTitle;
        description = theDescription;
        priority = priority;
        deadline = theDeadline;
        reminderList = new ArrayList<>();
    }

    public void addReminder( Reminder rem ){
        System.out.println("Adding a new reminder in addReminder() in Task class");
        reminderList.add(rem);
    }

    public void updateTitle( String newTitle ){
        System.out.println("Updating title in updateTitle() in Task class");
        title = newTitle;
    }

    public void updateDescription( String newDesc ){
        description = newDesc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

}
