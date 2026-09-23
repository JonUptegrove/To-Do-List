/*
This Class creates and add all the buttons to the ribbon
 */

import javax.swing.*;


public class Buttons {


    public Buttons(JPanel ribbon){
        //Creates global button methods
        JButton newPage = new JButton("New List");
        JButton edit = new JButton("Edit");
        JButton task = new JButton("Add Task");
        JButton delete = new JButton("Delete");
        JButton save = new JButton("Save");
        JButton load = new JButton("Load");

        //Adds the buttons to the ribbon
        ribbon.add(newPage);
        ribbon.add(edit);
        ribbon.add(delete);
        ribbon.add(task);
        ribbon.add(save);
        ribbon.add(load);

        //Calls the taskCreator and passes it the taskPanel
        task.addActionListener(e->{
            new TaskCreator().TaskWindow(WindowCreator.taskPanel);
        });

        //Clears the task Panel when the button is clicked
        newPage.addActionListener(e->{
            WindowCreator.taskPanel.removeAll();

            WindowCreator.selectedTask = null;
            WindowCreator.taskPanel.revalidate();
            WindowCreator.taskPanel.repaint();
        });

        //Checks to see if a task is selected and then calls the EditTask class
        edit.addActionListener(e->{
            if(WindowCreator.selectedTask != null){
                new EditTask().editTask(WindowCreator.taskPanel, WindowCreator.selectedTask);
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Please select a task to edit.");
            }
        });

        //Has the user select a task to delete, if no task is selected it displays a message alerting the user
        //Then calls the delete task class and function
        delete.addActionListener(e->{
            if(WindowCreator.selectedTask != null){
                new DeleteTask().deleteTask(WindowCreator.selectedTask, WindowCreator.taskPanel);
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Please select a task to delete.");
            }

        });

        //Saves the task written in the taskPanel to a text file
        save.addActionListener(e->{
            int num = WindowCreator.taskPanel.getComponentCount();
            new SaveClass().save(num, WindowCreator.taskPanel);

        });

        //Loads the task.txt file that was written
        load.addActionListener(e->{
            new LoadClass().load(WindowCreator.taskPanel);
        });
    }

}
