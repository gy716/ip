package duke;

public class Event extends Task{
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public void showAdded() {
        System.out.println("\tGot it! I've added this task:");
        System.out.println("\t\t[E]["+getStatusIcon()+"] "+description+" (at: "+at+")");
    }

    @Override
    public void showDeleted() {
        System.out.println("\tNoted! I've removed this task:");
        System.out.println("\t\t[E]["+getStatusIcon()+"] "+description+" (at: "+at+")");
    }

    @Override
    public void printTask() {
        System.out.println("[E]"+"["+getStatusIcon()+"] "+description+" (at: "+at+")");
    }

    @Override
    public String toFileFormat() {
        if(isDone) {
            return "E,1,"+description+","+at;
        }else {
            return "E,0,"+description+","+at;
        }
    }
}
