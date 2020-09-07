package duke;

public class Event extends Task{
    protected String at;

    public Event(String description, int taskNumber, String at) {
        super(description, taskNumber);
        this.at = at;
    }

    @Override
    public void showAdded() {
        System.out.println("\tGot it! I've added this task:");
        System.out.println("\t\t[E]["+getStatusIcon()+"]"+description+" (at:"+at+")");
        System.out.println("\tNow you have "+taskNumber+" tasks in the list.");
    }

    @Override
    public void printTask() {
        System.out.println("\t"+taskNumber+".[E]["+getStatusIcon()+"] "+description+" (at:"+at+")");
    }
}
