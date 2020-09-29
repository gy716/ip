package data;

public class Task{

    public boolean isDone;
    public String description;


    public Task(String description) {
        this.description = description;
        this.isDone = false;

    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String toStringFormat() {
        return "["+getStatusIcon()+"] "+description;
    }

    public String toFileFormat() {
        if(isDone) {
            return "1,"+description;
        }else {
            return "0,"+description;
        }
    }


}