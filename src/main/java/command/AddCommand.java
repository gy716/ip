package command;

import data.Task;
import data.TaskList;
import storage.Storage;
import ui.Ui;

public class AddCommand extends Command {

    Task taskContent;

    public AddCommand(Task taskContent) {
        this.taskContent = taskContent;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskAdded();
        tasks.addTask(taskContent);
        System.out.println("\t"+taskContent.toStringFormat());
        System.out.println("The number of tasks is: "+tasks.getSize());
        storage.updateFile();
    }
}
