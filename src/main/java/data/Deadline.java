package data;

public class Deadline extends Task{
    String by;

    public Deadline(String description, String by){
        super(description);
        this.by = by;
    }

    @Override
    public String toStringFormat() {
        return "[D]"+super.toStringFormat()+" (by: "+by+")";
    }

    @Override
    public String toFileFormat() {
        return "D,"+super.toFileFormat()+","+by;
    }
}