package duke;

public class Deadline extends Task{
    protected String by;

    public Deadline(String description, int taskNumber, String by) {
        super(description, taskNumber);
        this.by = by;
    }

    public void showAdded() {
        System.out.println("\tGot it! I've added this task:");
        System.out.println("\t\t[D]["+getStatusIcon()+"] "+description+" (by: "+by+")");
        System.out.println("\tNow you have "+taskNumber+" tasks in the list.");
    }

    public void list() {
        System.out.println("\t"+taskNumber+".[D]["+getStatusIcon()+"] "+description+" (by: "+by+")");
    }
}
