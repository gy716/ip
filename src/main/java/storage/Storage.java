package storage;

import data.Deadline;
import data.Event;
import data.Task;
import data.Todo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    int taskIndex = 0;
    String filepath;
    ArrayList<Task> tasks = new ArrayList<>();

    public Storage(String filepath){
        this.filepath = filepath;
    }

    /**
     * Creates the task file if the file does not exit
     * and loads the task file.
     *
     * @return a task list with the content of the task file.
     * @throws IOException if the file cannot be created for some reasons.
     */
    public ArrayList<Task> load() throws IOException {

        File f = new File(filepath);

        if(f.createNewFile()){
            System.out.println("OOPS!! I cannot find the input file!");
            System.out.println("Let me create the file for you!");
        }else {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String[] words = s.nextLine().split(",");
                if (words[0].equals("T")) {
                    tasks.add(taskIndex, new Todo(words[2]));
                    if (words[1].equals("1")) tasks.get(taskIndex).isDone = true;
                    if (words[1].equals("0")) tasks.get(taskIndex).isDone = false;
                    taskIndex++;
                }
                if (words[0].equals("D")) {
                    tasks.add(taskIndex, new Deadline(words[2], LocalDate.parse(words[3], DateTimeFormatter.ofPattern("yyyy-M-d"))));
                    if (words[1].equals("1")) tasks.get(taskIndex).isDone = true;
                    if (words[1].equals("0")) tasks.get(taskIndex).isDone = false;
                    taskIndex++;
                }
                if (words[0].equals("E")) {
                    tasks.add(taskIndex, new Event(words[2], LocalDate.parse(words[3], DateTimeFormatter.ofPattern("yyyy-M-d"))));
                    if (words[1].equals("1")) tasks.get(taskIndex).isDone = true;
                    if (words[1].equals("0")) tasks.get(taskIndex).isDone = false;
                    taskIndex++;
                }
            }
        }
        return tasks;

    }

    /**
     * Appends to a file other than overwrites it.
     *
     * @param file the file be appended to.
     * @param text the text to be added.
     * @throws IOException if the file cannot be written for some reasons.
     */
    public void appendToFile(File file, String text) throws IOException {
        FileWriter fw = new FileWriter(file,true);
        fw.write(text);
        fw.close();
    }


    /**
     * Overwrites a file.
     *
     * @param file the file be overwritten.
     * @param text the text to be added.
     * @throws IOException if the file cannot be written for some reasons.
     */
    public void writeToFile(File file, String text) throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.close();
    }

    /**
     * Clears all the content of a file and adds tasks to it
     */
    public void updateFile() {
        try {
            File f = new File(filepath);
            writeToFile(f,"");
            for (Task task : tasks) {
                appendToFile(f, task.toFileFormat() + System.lineSeparator());
            }
        } catch (IOException e){
            System.out.println("Sorry! Some errors occurred and I cannot update tasks to file!");
        }
    }


}
