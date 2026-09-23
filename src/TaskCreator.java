/*
This Class creates a task which gives a changeable header
It also allows for a description to be added
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TaskCreator {
    public void TaskWindow(JPanel taskPanel) {

        // Creates a task window
        JFrame taskWindow = new JFrame("Create a Task");
        taskWindow.setSize(300, 400);
        taskWindow.setLayout(new FlowLayout());
        taskWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Creates the label that prompts the user to enter the Task name
        JLabel taskLabel = new JLabel("Task: ");
        JTextField taskText = new JTextField(25);

        // Creates the label that prompts the user to enter a description
        JLabel descriptionLabel = new JLabel("Description: ");
        JTextArea description = new JTextArea(8, 25);

        // Creates a button to complete a task
        JButton createTask = new JButton("Create Task");

        // Adds everything to the window
        taskWindow.add(taskLabel);
        taskWindow.add(taskText);

        taskWindow.add(descriptionLabel);
        taskWindow.add(description);

        taskWindow.add(createTask);

        // Complete button
        createTask.addActionListener(e -> {
            String task = taskText.getText();
            String taskdescription = description.getText();
            if(task.isEmpty()){
                JOptionPane.showMessageDialog(null,
                        "Please enter a task name.");
            }
            else if(taskdescription.isEmpty()){
                JOptionPane.showMessageDialog(null,
                        "Please enter a task description.");
            }
            else{
                // Create a panel for this individual task
                JPanel singleTask = new JPanel();

                singleTask.setLayout(
                        new BoxLayout(singleTask, BoxLayout.Y_AXIS)
                );

                // Create labels
                JLabel taskreturn = new JLabel(task);
                JLabel descriptionReturn = new JLabel(taskdescription);

                // Indent description
                descriptionReturn.setBorder(
                        BorderFactory.createEmptyBorder(
                                0, 30, 0, 0
                        )
                );

                // Add labels to individual task panel
                singleTask.add(taskreturn);
                singleTask.add(descriptionReturn);
                new TaskCompleted().checkboxCreator(singleTask, taskreturn, descriptionReturn);

                // Make the task selectable and outline it
                new SelectedBorderCreator().border(singleTask);

                // Add task to main task panel
                taskPanel.add(singleTask);

                taskPanel.revalidate();
                taskPanel.repaint();

                taskWindow.dispose();}


        });

        taskWindow.setVisible(true);
    }
    }