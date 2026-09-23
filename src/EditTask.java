import javax.swing.*;
import java.awt.*;

public class EditTask {
    public void editTask(JPanel taskPanel, JPanel selectedTask){

        // Get the existing task labels
        JLabel oldTask =
                (JLabel) selectedTask.getComponent(0);

        JLabel oldDescription =
                (JLabel) selectedTask.getComponent(1);

        // Creates the edit window
        JFrame taskWindow = new JFrame("Edit Task");
        taskWindow.setSize(300, 400);
        taskWindow.setLayout(new FlowLayout());
        taskWindow.setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE
        );

        // Task
        JLabel taskLabel = new JLabel("Task: ");
        JTextField taskText = new JTextField(25);

        // Description
        JLabel descriptionLabel =
                new JLabel("Description: ");

        JTextArea description =
                new JTextArea(8, 25);

        // Put the existing information into the fields
        taskText.setText(oldTask.getText());
        description.setText(oldDescription.getText());

        // Complete button
        JButton createTask = new JButton("Create Task");

        // Add everything to window
        taskWindow.add(taskLabel);
        taskWindow.add(taskText);

        taskWindow.add(descriptionLabel);
        taskWindow.add(description);

        taskWindow.add(createTask);

        // Complete editing
        createTask.addActionListener(e -> {

            String task = taskText.getText();
            String taskdescription = description.getText();

            //Check if the task is empty
            if(task.isEmpty()){
                //Displays error message
                JOptionPane.showMessageDialog(null,
                        "Please enter a task name.");
            }
            //Check if the description is empty
            else if(taskdescription.isEmpty()){
                //displays error message
                JOptionPane.showMessageDialog(null,
                        "Please enter a task description.");
            }
            else{
                // Update the existing labels
                oldTask.setText(task);
                oldDescription.setText(taskdescription);

                // Update the panel
                selectedTask.revalidate();
                selectedTask.repaint();

                taskPanel.revalidate();
                taskPanel.repaint();

                taskWindow.dispose();
            }
        });

        taskWindow.setVisible(true);
    }
}
