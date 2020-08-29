package Duke;
public class Task {
    protected String description;
    protected boolean isDone;
    protected int taskNumber;

    public Task(String description, int taskNumber) {
        this.description = description;
        this.isDone = false;
        this.taskNumber = taskNumber;
    }

    public void showAdded() {
        System.out.println("\tGot it! I've added this task:");
        System.out.println("\t\t[T]["+getStatusIcon()+"] "+description);
        System.out.println("\tNow you have "+taskNumber+" tasks in the list.");
    }

    public void list() {
        System.out.println("\t"+taskNumber+".[T]["+getStatusIcon()+"] "+description);
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }


}
