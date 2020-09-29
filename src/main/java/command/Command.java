package command;

import data.TaskList;
import storage.Storage;
import ui.Ui;

public abstract class Command {

    /**
     * Checks if the command is exit.
     * @return the result of the check.
     */
    public boolean isExit() {
        return false;
    }

    /**
     * Executes the commands of different types.
     *
     * @param tasks the task list of tasks.
     * @param ui the user interface.
     * @param storage the task file in the hard disk.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) {

    }
}
