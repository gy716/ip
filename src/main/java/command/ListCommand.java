package command;

import data.TaskList;
import storage.Storage;
import ui.Ui;

public class ListCommand extends command.Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        for(int i = 0; i < tasks.getSize(); i++) {
            System.out.println("\t"+(i+1)+" "+tasks.getTask(i).toStringFormat());
        }
    }
}
