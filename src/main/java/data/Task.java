package data;

public class Task{

    public boolean isDone;
    public String description;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * @return correct or wrong symbols.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * @return the string in formal format.
     */
    public String toStringFormat() {
        return "["+getStatusIcon()+"] "+description;
    }

    /**
     * @return the string in file format.
     */
    public String toFileFormat() {
        if(isDone) {
            return "1,"+description;
        }else {
            return "0,"+description;
        }
    }


}