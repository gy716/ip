import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Hello, I am Duke!");
        System.out.println("What can I do for you?");
        String commands;
        while(true) {
            commands = in.next();
            if(commands.equals("list")) {
                System.out.println("    "+"Here is the list: ");
            }else if(commands.equals("blah")){
                System.out.println("    "+"blah");
            }else if(commands.equals("exit")) {
                System.out.println("    "+"Good bye! Hope to see you again soon!");
                break;
            }
        }


    }
}
