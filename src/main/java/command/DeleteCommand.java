package command;

import data.Task;
import data.TaskList;
import storage.Storage;
import ui.Ui;

public class DeleteCommand extends Command {

    int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        Task t = tasks.getTask(taskIndex-1);
        tasks.deleteTask(taskIndex-1);
        ui.showTaskDeleted();
        System.out.println("\t"+t.toStringFormat());
        System.out.println("The number of tasks is: "+tasks.getSize());
        storage.updateFile();
    }
}
