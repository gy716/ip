package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task{

    LocalDate at;

    public Event(String description, LocalDate at){
        super(description);
        this.at = at;
    }

    @Override
    public String toStringFormat() {
        return "[E]"+super.toStringFormat()+" (at: "+at.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))+")";
    }

    @Override
    public String toFileFormat() {
        return "E,"+super.toFileFormat()+","+at;
    }

}