package parser;

import command.*;
import data.Deadline;
import data.Event;
import data.Todo;
import DukeExceptions.DukeExceptions;
import ui.Ui;

public class Parser {

    public Command parse(String commandWord) throws DukeExceptions {

        String[] words = commandWord.split(" ");

        switch (words[0]) {
            case "list": return new ListCommand();
            case "exit": return new ExitCommand();
            case "todo": return new AddCommand(processTodo(commandWord));
            case "deadline": return new AddCommand(processDeadline(commandWord));
            case "event": return new AddCommand(processEvent(commandWord));
            case "done": return new DoneCommand(Integer.parseInt(words[1]));
            case "delete": return new DeleteCommand(Integer.parseInt(words[1]));
            default: throw new DukeExceptions();
        }

    }

    Todo processTodo(String commandWord) throws ArrayIndexOutOfBoundsException{

        commandWord = commandWord.substring("todo".length());
        if(commandWord.isBlank()) throw new ArrayIndexOutOfBoundsException();
        return new Todo(commandWord.trim());

    }

    Deadline processDeadline(String commandWord) throws DukeExceptions {

        if(commandWord.substring("deadline".length()).isBlank()) {
            throw new DukeExceptions();
        }

        if (!commandWord.contains("/by")){
            throw new DukeExceptions();
        }

        String by = commandWord.substring(commandWord.indexOf("/by") + "/by".length());

        if (by.isBlank()) {
            throw new DukeExceptions();
        }

        commandWord = commandWord.substring("deadline".length(), commandWord.indexOf("/by") - 1);

        if (commandWord.isBlank()){
            throw new DukeExceptions();
        }

        return new Deadline(commandWord.trim(), by.trim());

    }

    Event processEvent(String commandWord) throws DukeExceptions {

        if(commandWord.substring("event".length()).isBlank()) {
            throw new DukeExceptions();
        }

        if (!commandWord.contains("/at")){
            throw new DukeExceptions();
        }

        String at = commandWord.substring(commandWord.indexOf("/at") + "/at".length());

        if (at.isBlank()) {
            throw new DukeExceptions();
        }

        commandWord = commandWord.substring("event".length(), commandWord.indexOf("/at") - 1);

        if (commandWord.isBlank()){
            throw new DukeExceptions();
        }

        return new Event(commandWord.trim(), at.trim());

    }




}
