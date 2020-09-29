package duke;

import command.Command;
import data.TaskList;
import parser.Parser;
import DukeExceptions.DukeExceptions;
import storage.Storage;
import ui.Ui;

import java.io.File;
import java.io.IOException;

public class Duke{

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) throws IOException {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.load());
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = new Parser().parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeExceptions | IndexOutOfBoundsException e) {
                ui.showCommandError();
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Duke("duke.txt").run();
    }

}