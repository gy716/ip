public class Task {
    protected String description;
    protected boolean isDone;
    protected int taskNumber;

    public Task(String description, int taskNumber) {
        this.description = description;
        this.isDone = false;
        this.taskNumber = taskNumber;
    }

    public void showPrompt() {
        System.out.println("    "+description+" added");
    }

    public void list() {
        System.out.println("    "+taskNumber+". "+description);
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }


}
