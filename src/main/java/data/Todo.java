package data;

public class Todo extends Task{

    public Todo(String description){
        super(description);
    }

    @Override
    public String toStringFormat() {
        return "[T]"+super.toStringFormat();
    }

    @Override
    public String toFileFormat() {
        return "T,"+super.toFileFormat();
    }
}
