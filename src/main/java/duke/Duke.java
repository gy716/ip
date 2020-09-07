package duke;
import java.util.Scanner;

public class Duke {

    Scanner in = new Scanner(System.in);
    private String commands;
    Task[] tasks = new Task[100];

    Duke() {
        System.out.println("Hello, I am Duke!");
        System.out.println("What can I do for you?");
    }

    void processCommands() {

        int i = 0;

        while(true) {

            commands = in.nextLine();
            String[] words = commands.split(" ");

            if (commands.equals("list")) {

                processList(i);

            } else if (commands.equals("exit")) {

                processExit();
                break;

            } else if (words[0].equals("todo")) {

                try {
                    processTodo(i);
                    i++;
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                }

            } else if (words[0].equals("deadline")) {

                try {
                    processDeadline(i);
                    i++;
                } catch (TimeIsEmptyException e){
                    System.out.println("☹ OOPS!!! The time of deadline cannot be empty.");
                } catch (TaskIsEmptyException e){
                    System.out.println("☹ OOPS!!! The task of deadline cannot be empty.");
                }

            } else if (words[0].equals("event")) {

                try {
                    processEvent(i);
                    i++;
                } catch (TimeIsEmptyException e){
                    System.out.println("☹ OOPS!!! The time of event cannot be empty.");
                } catch (TaskIsEmptyException e){
                    System.out.println("☹ OOPS!!! The task of event cannot be empty.");
                }

            } else if(words[0].equals("done")){

                try {
                    processDone(words);
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("☹ OOPS!!! The task number of a done cannot be empty.");
                } catch (NullPointerException e){
                    System.out.println("☹ OOPS!!! I cannot find this task in the list.");
                }

            } else {
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }

    void processList(int i) {
        System.out.println("\tHere are the list:");
        if (tasks[0] != null) {
            for (int k = 0; k < i; k++) {
                tasks[k].printTask();
            }
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
        tasks[i] = new Task(commands, i + 1);
        tasks[i].showAdded();
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

        tasks[i] = new Deadline(commands, i + 1, by);
        tasks[i].showAdded();

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

        tasks[i] = new Event(commands, i + 1, at);
        tasks[i].showAdded();

    }

    void processDone(String[] words) {
        int taskIndex = Integer.parseInt(words[1]);
        tasks[taskIndex-1].isDone = true;
        System.out.println("\tNice! I've marked this work as done:");
        System.out.println("\t\t[\u2713] "+tasks[taskIndex-1].description);
    }

    public static void main(String[] args) {
        Duke d1 = new Duke();
        d1.processCommands();
    }

}
