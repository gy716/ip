package Duke;
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

                System.out.println("    Here are the list:");

                if (tasks[0] != null) {

                    for (int k = 0; k < i; k++) {
                        tasks[k].list();
                    }

                } else {
                    System.out.println();
                }

            } else if (commands.equals("exit")) {

                System.out.println("    Good Bye! Hope to see you again");
                break;

            } else if (words[0].equals("Todo")) {

                commands = commands.replaceAll("Todo ", "");
                tasks[i] = new Task(commands, i + 1);
                tasks[i].showAdded();
                i++;

            } else if (words[0].equals("deadline")) {

                String by = commands.substring(commands.indexOf("/by") + 4);
                commands = commands.substring(9, commands.indexOf("/by") - 1);
                tasks[i] = new Deadline(commands, i + 1, by);
                tasks[i].showAdded();
                i++;

            } else if (words[0].equals("event")) {

                String at = commands.substring(commands.indexOf("/at") + 4);
                commands = commands.substring(6, commands.indexOf("/at") - 1);
                tasks[i] = new Event(commands, i + 1, at);
                tasks[i].showAdded();
                i++;

            } else if(words[0].equals("done")){

                int taskIndex = Integer.parseInt(words[1]);
                tasks[taskIndex-1].isDone = true;
                System.out.println("    Nice! I've marked this work as done:");
                System.out.println("        [\u2713] "+tasks[taskIndex-1].description);

            }

        }
    }


    public static void main(String[] args) {
        Duke d1 = new Duke();
        d1.processCommands();
    }

}
