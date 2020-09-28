package duke;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Duke {

    Scanner in = new Scanner(System.in);
    private String commands;
    ArrayList<Task> tasks = new ArrayList<>();
    File f = new File("duke.txt");
    int taskIndex = 0;


    Duke() {
        System.out.println("Hello, I am Duke!");
        System.out.println("What can I do for you?");
    }

    void processFile() {

        try{
            if(f.createNewFile()){
                System.out.println("The file is not found.");
                System.out.println("I have created this file now.");

            }else{
                Scanner s = new Scanner(f);
                taskIndex = 0;
                while(s.hasNextLine()){
                    String[] words = s.nextLine().split(",");
                    if(words[0].equals("T")){
                        tasks.add(taskIndex, new Task(words[2]));
                        if(words[1].equals("1")) tasks.get(taskIndex).isDone = true;
                        if(words[1].equals("0")) tasks.get(taskIndex).isDone = false;
                        taskIndex++;
                    }
                    if(words[0].equals("D")){
                        tasks.add(taskIndex, new Deadline(words[2], words[3]));
                        if(words[1].equals("1")) tasks.get(taskIndex).isDone = true;
                        if(words[1].equals("0")) tasks.get(taskIndex).isDone = false;
                        taskIndex++;
                    }
                    if(words[0].equals("E")){
                        tasks.add(taskIndex, new Event(words[2], words[3]));
                        if(words[1].equals("1")) tasks.get(taskIndex).isDone = true;
                        if(words[1].equals("0")) tasks.get(taskIndex).isDone = false;
                        taskIndex++;
                    }
                }

            }

        }catch (IOException e){
            System.out.println("Some errors occurred.");
        }

    }

    void appendToFile(File file, String text) throws IOException {
        FileWriter fw = new FileWriter(file,true);
        fw.write(text);
        fw.close();
    }

    void writeToFile(File file, String text) throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.close();
    }

    void updateFile() {
        try {
            writeToFile(f,"");
            for (Task task : tasks) {
                appendToFile(f, task.toFileFormat() + System.lineSeparator());
            }
        } catch (IOException e){
            System.out.println("Some errors occurred.");
        }
    }

    void processCommands() {

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
            updateFile();
        }
    }

    void processList() {
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
        tasks.add(i, new Task(commands.trim()));
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

        tasks.add(i, new Deadline(commands.trim(), by.trim()));
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

        tasks.add(i, new Event(commands.trim(), at.trim()));
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
        d1.processFile();
        d1.processCommands();
    }

}
