package ui;

import java.util.Scanner;

public class Ui {

    /**
     * Gets the user input.
     *
     * @return the user input.
     */
    public String readCommand() {
        Scanner in = new Scanner(System.in);
        String userCommand = in.nextLine();
        return userCommand;
    }

    public void showWelcome() {
        System.out.println("Hello, I am Duke!");
        System.out.println("What can I do for you?");
    }

    public void showLine() {
        System.out.println("---------------------------------------------------------------");
    }

    public void showTaskAdded() {
        System.out.println("Got it! I've added this task in the list:");
    }

    public void showTaskCompleted() {
        System.out.println("Nice! I've marked this work as done:");
    }

    public void showTaskDeleted() {
        System.out.println("Noted! I've removed this task:");
    }

    /**
     * Indicates the user command is not correct.
     */
    public void showCommandError() {
        System.out.println("OOPS!! Your input has something wrong.");
    }

    public void showGoodBye() {
        System.out.println("Good Bye! Hope to see you again!");
    }

    /**
     * Indicates the time of deadline or event is not in the required format.
     */
    public void showTimeError() {
        System.out.println("OOPS!! The time format is incorrect!");
    }

    /**
     * Indicates that the task file does not exist and canno tbe created for some reasons,
     */
    public void showLoadingError() {
        System.out.println("OOPS!! The input file does not exist and I cannot create it!");
        System.out.println("Please seek for further assistance.");
    }
}
