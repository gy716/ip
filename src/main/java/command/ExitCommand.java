package command;

import data.TaskList;
import storage.Storage;
import ui.Ui;

public class ExitCommand extends command.Command {

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodBye();
    }

}
