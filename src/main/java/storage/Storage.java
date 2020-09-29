package storage;

import data.Deadline;
import data.Event;
import data.Task;
import data.Todo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    int taskIndex = 0;
    String filepath;

    public Storage(String filepath){
        this.filepath = filepath;
    }
    ArrayList<Task> tasks = new ArrayList<>();

    public ArrayList<Task> load() throws IOException {

        Scanner s = new Scanner(Path.of(filepath));

        while(s.hasNextLine()){
            String[] words = s.nextLine().split(",");
            if(words[0].equals("T")){
                tasks.add(taskIndex, new Todo(words[2]));
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
        return tasks;

    }

    public void appendToFile(File file, String text) throws IOException {
        FileWriter fw = new FileWriter(file,true);
        fw.write(text);
        fw.close();
    }

    public void writeToFile(File file, String text) throws IOException {
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.close();
    }

    public void updateFile() {
        try {
            File f = new File(filepath);
            writeToFile(f,"");
            for (Task task : tasks) {
                appendToFile(f, task.toFileFormat() + System.lineSeparator());
            }
        } catch (IOException e){
            System.out.println("Some errors occurred.");
        }
    }


}
