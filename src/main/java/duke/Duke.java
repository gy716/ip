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

    void processCommands(){

        int i = 0;

        while(true) {

            commands = in.nextLine();
            String[] words = commands.split(" ");

            if (commands.equals("list")) {

                processList(i);

            } else if (commands.equals("exit")) {

                System.out.println("\tGood Bye! Hope to see you again");
                break;

            } else if (words[0].equals("todo")) {

                processTodo(i);
                i++;

            } else if (words[0].equals("deadline")) {

                processDeadline(i);
                i++;

            } else if (words[0].equals("event")) {

                processEvent(i);
                i++;

            } else if(words[0].equals("done")){

                processDone(i, words);

            }

        }
    }

    void processList(int i) {
        System.out.println("\tHere are the list:");
        if (tasks[0] != null) {
            for (int k = 0; k < i; k++) {
                tasks[k].list();
            }
        }
    }

    void processTodo(int i) {
        commands = commands.replaceAll("todo ", "");
        tasks[i] = new Task(commands, i + 1);
        tasks[i].showAdded();
    }

    void processDeadline(int i) {
        String by = commands.substring(commands.indexOf("/by") + 4);
        commands = commands.substring(9, commands.indexOf("/by") - 1);
        tasks[i] = new Deadline(commands, i + 1, by);
        tasks[i].showAdded();
    }

    void processEvent(int i) {
        String at = commands.substring(commands.indexOf("/at") + 4);
        commands = commands.substring(6, commands.indexOf("/at") - 1);
        tasks[i] = new Event(commands, i + 1, at);
        tasks[i].showAdded();
    }

    void processDone(int i, String[] words) {
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
