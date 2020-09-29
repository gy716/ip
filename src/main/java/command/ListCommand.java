package command;

import data.TaskList;
import storage.Storage;
import ui.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){

        if(tasks.getSize() == 0) {
            System.out.println("There are no tasks in the list");
        }else {
            for (int i = 0; i < tasks.getSize(); i++) {
                System.out.println((i + 1) + " " + tasks.getTask(i).toStringFormat());
            }
        }
    }
}
