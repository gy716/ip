# User Guide 
Duke is a desktop app for **managing different tasks for a user who is in favour of 
Command Line Interface (CLI).** 

## Quick Start
1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest Duke.jar.
3. Copy the file to the folder you want to use as the home folder for your app.
4. Double-click the file to start the app. 
5. Type in the command and press Enter to execute it.
6. Refer to the Features below for details of each command.


## Features
> Notes about the command format:
> * Words in `UPPER_CASE` are the parameters to be supplied by the user.
> eg. in `todo TASK`, `TASK` is a parameter which can be used as `todo borrow book`.
- - -

### Adding a task
Add a task to the task list of Duke.
> Duke supports for managing three types of class: 
   * Type `todo`: Normal tasks without any dates or times attached to it.
      eg.  go to lab for the project.
   * Type `deadline`: tasks that need to be done before a specific date/time. 
      eg.  submit essay by 11/10/2019 5pm.
   * Type `event`: tasks that start at a specific time and ends at a specific time.
      eg.  team project meeting on 2/10/2019 2-4pm.    




* **Adding a `todo` task**
    Command format: `todo TASK`
    Examples:
        `todo borrow book`.
        `todo go to theme park`.




* **Adding a `deadline` task**
    Command format: `deadline TASK /by TIME`
    
    > Notes about the TIME format:
    >
    > **The TIME must strictly follow this format: `yyyy-mm-ddThr:mm`**, which indicates
    > that the **month, date, hour, minute must be 2 digit.**
    > Correct format: eg. `2020-09-30T12:18`, `2020-12-03T03:05`
    >
    > Wrong format: eg. `2020-9-30T12:18`, `2020-12-3T3:05`

    Examples: 
        `deadline assignment /by 2020-10-02T23:59`.
        `deadline submit lab report /by 2020-09-30T18:00`.




* **Adding a `event` task**

    Command format: `event TASK /at TIME`
    Examples: 
        `event team meeting /at 2020-11-03T16:00`

    > Note that the TIME format is the same as mentioned in `deadline`.
- - -

### Listing tasks
Show the task list of Duke.

Command format: `list`
Example: `list`


- - -

### Deleting a task
Delete a specific task by task index.

Command format: `delete NUMBER`
Examples:
    `delete 1`
    `delete 5`


- - -

### Finding a task
Find the tasks that match with the keyword input by users.

Command format: `find KEYWORD`
Examples: 
    `find book`
    `find meeting`

- - -

### Exiting the app
Exit the app

Command format: `exit`.
Example: `exit`.

- - -

## Command Summary
|Action|Format | Examples|
| :---: | :--- |:---|
|add a `todo` task|`todo TASK`  | `todo visit theme park` |
|add a `deadline` task|`deadline TASK /by TIME`  | `deadline submit assignment /by 2020-09-30T18:00`  |
|add a `event` task|`event TASK /by TIME` | `event submit assignment /at 2020-09-30T18:00` |
|list the tasks|`list`|`list`|
|delete a task|`delete NUMBER`|`delete 4`|
|find the tasks|`find KEYWORD`|`find book`|
|exit the app|`exit`|`exit`|



