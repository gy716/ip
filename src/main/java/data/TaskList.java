package data;

import java.util.ArrayList;

public class TaskList {

    ArrayList<Task> taskArrayList;

    public TaskList() {
        this.taskArrayList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskArrayList = taskList;
    }

    public void addTask(Task task) {
        taskArrayList.add(task);
    }

    public void deleteTask(int taskIndex) {
        taskArrayList.remove(taskIndex);
    }

    public Task getTask(int taskIndex) {
        return taskArrayList.get(taskIndex);
    }

    public int getSize() {
        return taskArrayList.size();
    }

}
