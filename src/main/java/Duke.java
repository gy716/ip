import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Hello, I am Duke!");
        System.out.println("What can I do for you?");
        String task;
        while(true) {
            task = in.next();
            if(task.equals("list")) {
                System.out.println("Here is the list: ");
            }else if(task.equals("exit")) {
                System.out.println("Good bye! Hope to see you again soon!");
                break;
            }
        }


    }
}
