import java.util.Scanner;

public class Duke {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Hello, I am Duke!");
        System.out.println("What can I do for you?");

        String commands;
        Task[] tasks = new Task[100];

        int i = 0;
        while(true) {
            commands = in.nextLine();

            if(commands.equals("list")) {

                System.out.println("    Here are the list:");

                if(tasks[0] != null) {

                    for (int k = 0; k < i; k++) {
                        tasks[k].list();
                    }

                }else{
                    System.out.println();
                }

            }else if(commands.equals("exit")) {

                System.out.println("    Good Bye! Hope to see you again");
                break;

            }else{

                tasks[i] = new Task(commands, i+1);
                tasks[i].showPrompt();
                i++;

            }
        }
    }
}
