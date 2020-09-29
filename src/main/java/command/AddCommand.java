package command;

import data.Task;
import data.TaskList;
import storage.Storage;
import ui.Ui;

public class AddCommand extends command.Command {

    Task taskContent;

    public AddCommand(Task taskContent) {
        this.taskContent = taskContent;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskAdded();
        tasks.addTask(taskContent);
        System.out.println("\t\t"+taskContent.toStringFormat());
        System.out.println("\tNow you have "+tasks.getSize()+" tasks in the list");
        storage.updateFile();
    }
}
