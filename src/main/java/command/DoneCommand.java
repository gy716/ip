package command;

import data.Task;
import data.TaskList;
import storage.Storage;
import ui.Ui;

public class DoneCommand extends command.Command {

    int taskIndex;

    public DoneCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.getTask(taskIndex-1).isDone = true;
        ui.showTaskCompleted();
        System.out.println("\t\t"+tasks.getTask(taskIndex-1).toStringFormat());
        storage.updateFile();
    }

}
