package parser;

import command.*;
import data.Deadline;
import data.Event;
import data.Todo;
import DukeExceptions.DukeExceptions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parser {

    /**
     * Identifies the type of commands
     * and sends them to command class for further execution.
     *
     * @param commandWord the user's input.
     * @return different new instances of command class.
     * @throws DukeExceptions if the user's input is invalid.
     */
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

    /**
     * Gets the description of a to-do task.
     *
     * @param commandWord the user's input.
     * @return a new to-do task.
     * @throws ArrayIndexOutOfBoundsException if the description is empty.
     */
    Todo processTodo(String commandWord) throws ArrayIndexOutOfBoundsException{
        commandWord = commandWord.substring("todo".length());
        if(commandWord.isBlank()) throw new ArrayIndexOutOfBoundsException();
        return new Todo(commandWord.trim());
    }

    /**
     * Gets the description and the time of a deadline task.
     *
     * @param commandWord the user's input.
     * @return a new deadline task.
     * @throws DukeExceptions if the user's input misses out the description or the time.
     * @throws DateTimeException if the time is not in the required format.
     */
    Deadline processDeadline(String commandWord) throws DukeExceptions, DateTimeException {

        if(commandWord.substring("deadline".length()).isBlank()) {
            throw new DukeExceptions();
        }

        if (!commandWord.contains("/by")){
            throw new DukeExceptions();
        }

        String by = commandWord.substring(commandWord.indexOf("/by") + "/by".length());
        LocalDateTime newBy = LocalDateTime.parse(by.trim(), DateTimeFormatter.ofPattern("yyyy-M-d H:mm"));

        if (by.isBlank()) {
            throw new DukeExceptions();
        }

        commandWord = commandWord.substring("deadline".length(), commandWord.indexOf("/by") - 1);

        if (commandWord.isBlank()){
            throw new DukeExceptions();
        }

        return new Deadline(commandWord.trim(), newBy);

    }

    /**
     * Gets the description and the time of an event task.
     *
     * @param commandWord the user's input.
     * @return a new event task.
     * @throws DukeExceptions if the user's input misses out the description or the time.
     * @throws DateTimeException if the time is not in the required format.
     */
    Event processEvent(String commandWord) throws DukeExceptions, DateTimeException {

        if(commandWord.substring("event".length()).isBlank()) {
            throw new DukeExceptions();
        }

        if (!commandWord.contains("/at")){
            throw new DukeExceptions();
        }

        String at = commandWord.substring(commandWord.indexOf("/at") + "/at".length());
        LocalDateTime newAt = LocalDateTime.parse(at.trim(), DateTimeFormatter.ofPattern("yyyy-M-d H:mm"));

        if (at.isBlank()) {
            throw new DukeExceptions();
        }

        commandWord = commandWord.substring("event".length(), commandWord.indexOf("/at") - 1);

        if (commandWord.isBlank()){
            throw new DukeExceptions();
        }

        return new Event(commandWord.trim(), newAt);

    }




}
