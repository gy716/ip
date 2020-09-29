package data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    LocalDateTime by;

    public Deadline(String description, LocalDateTime by){
        super(description);
        this.by = by;
    }

    @Override
    public String toStringFormat() {
        return "[D]"+super.toStringFormat()+" (by: "+by.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm"))+")";
    }

    @Override
    public String toFileFormat() {
        return "D,"+super.toFileFormat()+","+by;
    }
}