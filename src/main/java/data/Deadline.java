package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    LocalDate by;

    public Deadline(String description, LocalDate by){
        super(description);
        this.by = by;
    }

    @Override
    public String toStringFormat() {
        return "[D]"+super.toStringFormat()+" (by: "+by.format(DateTimeFormatter.ofPattern("MMM dd yyyy"))+")";
    }

    @Override
    public String toFileFormat() {
        return "D,"+super.toFileFormat()+","+by;
    }
}