# Java Swing To-Do List

A desktop To-Do List application built with **Java Swing**. This project was created as a learning project to practice Java, object-oriented programming, GUI development, event handling, and file I/O.

## Features

* Create tasks with a name and description
* Select tasks with a visual border
* Edit existing tasks
* Delete tasks
* Mark tasks as complete
* Strikethrough completed tasks
* Create a new list
* Save tasks to a text file
* Load saved tasks from a text file
* Preserve task completion status when loading

## Technologies

* Java
* Java Swing
* IntelliJ IDEA
* File I/O
* Git & GitHub

## Project Structure

The application is separated into several classes, with each class handling a specific part of the application.

Some of the main classes include:

* `WindowCreator` — Creates and manages the main application window
* `Buttons` — Creates the toolbar buttons and their actions
* `TaskCreator` — Creates new tasks
* `EditTask` — Handles editing existing tasks
* `DeleteTask` — Handles deleting tasks
* `TaskCompleted` — Handles task completion and strikethrough formatting
* `SelectedBorderCreator` — Handles task selection
* `SaveClass` — Saves tasks to `Tasks.txt`
* `LoadClass` — Loads tasks from `Tasks.txt`

## Saving and Loading

Tasks are stored in a `Tasks.txt` file in the project directory.

Each task stores:

* Task name
* Description
* Completion status

Example:

```text
Task: Complete Java project
Description: Finish the To-Do List application
Complete
```

## How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Make sure a Java JDK is configured.
4. Run the application's main class.
5. Use the toolbar to create and manage tasks.

## What I Learned

This project helped me practice:

* Java classes and objects
* Methods and constructors
* Swing components
* Layout managers
* Event listeners
* Lambda expressions
* File reading and writing
* Exception handling
* Working with `JPanel`, `JLabel`, `JButton`, and `JCheckBox`
* Managing GUI state
* Debugging Java applications
* Using Git and GitHub

## Future Improvements

Possible improvements for future versions include:

* Better task organization
* Due dates
* Task priorities
* Search functionality
* Categories
* A more advanced data format
* Improved UI styling
* Database storage

## License

This project is licensed under the MIT License.
