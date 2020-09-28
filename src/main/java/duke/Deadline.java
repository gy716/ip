package duke;

public class Deadline extends Task{
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public void showAdded() {
        System.out.println("\tGot it! I've added this task:");
        System.out.println("\t\t[D]["+getStatusIcon()+"] "+description+" (by: "+by+")");
    }

    @Override
    public void showDeleted() {
        System.out.println("\tNoted! I've removed this task:");
        System.out.println("\t\t[D]["+getStatusIcon()+"] "+description+" (by: "+by+")");
    }

    @Override
    public void printTask() {
        System.out.println("[D]"+"["+getStatusIcon()+"]"+description+" (by: "+by+")");
    }
}
