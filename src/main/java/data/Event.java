package data;

public class Event extends Task{

    String at;

    public Event(String description, String at){
        super(description);
        this.at = at;
    }

    @Override
    public String toStringFormat() {
        return "[E]"+super.toStringFormat()+" (at: "+at+")";
    }

    @Override
    public String toFileFormat() {
        return "E,"+super.toFileFormat()+","+at;
    }

}