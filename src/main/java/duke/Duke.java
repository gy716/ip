package duke;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    Scanner in = new Scanner(System.in);
    private String commands;
    ArrayList<Task> tasks = new ArrayList<>();

    Duke() {
        System.out.println("Hello, I am Duke!");
        System.out.println("What can I do for you?");
    }

    void processCommands() {

        int taskIndex = 0;

        while(true) {

            commands = in.nextLine();
            String[] words = commands.split(" ");

            if (commands.equals("list")) {

                processList();

            } else if (commands.equals("exit")) {

                processExit();
                break;

            } else if (words[0].equals("todo")) {

                try {
                    processTodo(taskIndex);
                    taskIndex++;
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                }

            } else if (words[0].equals("deadline")) {

                try {
                    processDeadline(taskIndex);
                    taskIndex++;
                } catch (TimeIsEmptyException e){
                    System.out.println("☹ OOPS!!! The time of deadline cannot be empty.");
                } catch (TaskIsEmptyException e){
                    System.out.println("☹ OOPS!!! The task of deadline cannot be empty.");
                }

            } else if (words[0].equals("event")) {

                try {
                    processEvent(taskIndex);
                    taskIndex++;
                } catch (TimeIsEmptyException e){
                    System.out.println("☹ OOPS!!! The time of event cannot be empty.");
                } catch (TaskIsEmptyException e){
                    System.out.println("☹ OOPS!!! The task of event cannot be empty.");
                }

            } else if(words[0].equals("done")){

                try {
                    processDone(words);
                } catch (IndexOutOfBoundsException e){
                    System.out.println("☹ OOPS!!! I cannot find this task in the list.");
                }

            } else if(words[0].equals("delete")){

                try {
                    processDelete(words, taskIndex);
                    taskIndex--;
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("☹ OOPS!!! The task cannot be empty");
                } catch (IndexOutOfBoundsException e){
                    System.out.println("☹ OOPS!!! I cannot find this task in the list.");
                }

            }
            else {

                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");

            }
        }
    }

    void processList() {
        System.out.println("\tHere are the list:");
        for(int i = 0; i < tasks.size(); i++){
            System.out.print("\t\t"+(i+1)+" ");
            tasks.get(i).printTask();
        }
    }

    void processExit() {
        System.out.println("\tGood Bye! Hope to see you again");
    }

    void processTodo(int i) throws ArrayIndexOutOfBoundsException{
        commands = commands.substring(4);
        if(commands.isBlank()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        tasks.add(i, new Task(commands));
        tasks.get(i).showAdded();
        System.out.println("\tNow you have "+(i+1)+" tasks in the list");
    }

    void processDeadline(int i) throws TimeIsEmptyException, TaskIsEmptyException {

        if(commands.substring(8).isBlank()) {
            throw new TaskIsEmptyException();
        }

        if (!commands.contains("/by")){
            throw new TimeIsEmptyException();
        }

        String by = commands.substring(commands.indexOf("/by") + 3);

        if (by.isBlank()) {
            throw new TimeIsEmptyException();
        }

        commands = commands.substring(8, commands.indexOf("/by") - 1);

        if (commands.isBlank()){
            throw new TaskIsEmptyException();
        }

        tasks.add(i, new Deadline(commands, by));
        tasks.get(i).showAdded();
        System.out.println("\tNow you have "+(i+1)+" tasks in the list");

    }

    void processEvent(int i) throws TimeIsEmptyException, TaskIsEmptyException{

        if(commands.substring(5).isBlank()) {
            throw new TaskIsEmptyException();
        }

        if (!commands.contains("/at")){
            throw new TimeIsEmptyException();
        }

        String at = commands.substring(commands.indexOf("/at") + 3);

        if (at.isBlank()) {
            throw new TimeIsEmptyException();
        }

        commands = commands.substring(5, commands.indexOf("/at") - 1);

        if (commands.isBlank()){
            throw new TaskIsEmptyException();
        }

        tasks.add(i, new Event(commands, at));
        tasks.get(i).showAdded();
        System.out.println("\tNow you have "+(i+1)+" tasks in the list");

    }

    void processDone(String[] words) {
        int doneIndex = Integer.parseInt(words[1]);
        tasks.get(doneIndex-1).isDone = true;
        System.out.println("\tNice! I've marked this work as done:");
        System.out.println("\t\t[\u2713] "+tasks.get(doneIndex-1).description);
    }

    void processDelete(String[] words, int i) {
        int deleteIndex = Integer.parseInt(words[1]);
        tasks.get(deleteIndex-1).showDeleted();
        System.out.println("\tNow you have "+(i-1)+" tasks in the list");
        tasks.remove(deleteIndex-1);
    }

    public static void main(String[] args) {
        Duke d1 = new Duke();
        d1.processCommands();
    }

}
