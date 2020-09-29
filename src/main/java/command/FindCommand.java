package command;

import data.TaskList;
import storage.Storage;
import ui.Ui;

public class FindCommand extends Command{

    String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        boolean isKeywordExist = false;
        for(int i = 0; i < tasks.getSize(); i++) {
            if(tasks.getTask(i).description.contains(keyword)) {
                System.out.println("Task Index: "+(i+1));
                System.out.println(tasks.getTask(i).toStringFormat());
                System.out.print("\n");
                isKeywordExist = true;
            }
        }
        if(!isKeywordExist) {
            System.out.println("Sorry! I cannot find this word in the task list.");
        }
    }

}
