package duke;

import command.Command;
import data.TaskList;
import parser.Parser;
import DukeExceptions.DukeExceptions;
import storage.Storage;
import ui.Ui;
import java.io.IOException;
import java.time.DateTimeException;

public class Duke{

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        try{
            storage = new Storage(filePath);
            tasks = new TaskList(storage.load());
        }catch (IOException e){
            ui.showLoadingError();
            System.exit(0);
        }catch (DateTimeException e){
            ui.showTimeError();
        }
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
            } catch (DateTimeException e){
                ui.showTimeError();
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke("duke.txt").run();
    }

}