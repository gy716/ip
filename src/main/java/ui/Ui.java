package ui;

import data.Task;

import java.util.Scanner;

public class Ui {

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
        System.out.println("\tGot it! I've added this task in the list:");
    }

    public void showTaskCompleted() {
        System.out.println("\tNice! I've marked this work as done:");
    }

    public void showTaskDeleted() {
        System.out.println("\tNoted! I've removed this task:");
    }

    public void showCommandError() {
        System.out.println("OOPS!! Your input or the file loaded has something wrong.");
    }

    public void showGoodBye() {
        System.out.println("Good Bye! Hope to see you again!");
    }
}
