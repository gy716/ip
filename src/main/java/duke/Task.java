package duke;
public class Task {
    protected String description;
    protected boolean isDone;


    public Task(String description) {
        this.description = description;
        this.isDone = false;

    }

    public void showAdded() {
        System.out.println("\tGot it! I've added this task:");
        System.out.println("\t\t[T]["+getStatusIcon()+"] "+description);
    }

    public void showDeleted() {
        System.out.println("\tNoted! I've removed this task:");
        System.out.println("\t\t[T]["+getStatusIcon()+"] "+description);
    }

    public void printTask() {
        System.out.println("[T]"+"["+getStatusIcon()+"]"+description);
    }


    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }


}
