package data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task{

    LocalDateTime at;

    public Event(String description, LocalDateTime at){
        super(description);
        this.at = at;
    }

    @Override
    public String toStringFormat() {
        return "[E]"+super.toStringFormat()+" (at: "+at.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm"))+")";
    }

    @Override
    public String toFileFormat() {
        return "E,"+super.toFileFormat()+","+at;
    }

}