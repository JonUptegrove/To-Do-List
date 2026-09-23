/*
This class loads the tasks saved in Tasks.txt
It reads the file line by line and adds it back into the taskPane
 */
import javax.swing.*;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

public class LoadClass {
    public void load(JPanel taskPanel){
        //removes the tasks in the current panel
        WindowCreator.taskPanel.removeAll();
        //set the selected task to null and updates the GUI
        WindowCreator.selectedTask = null;
        WindowCreator.taskPanel.revalidate();
        WindowCreator.taskPanel.repaint();

        try {
            //creates a file reader and a buffer reader
            FileReader reader = new FileReader("Tasks.txt");
            BufferedReader buffreader = new BufferedReader(reader);
            //creates and saves a single line of code
            String line = buffreader.readLine();
            //Loops through while the line has content in it
            while (line != null) {
                //Checks if next line is empty to catch possible error
                if(line.isEmpty()){
                    line = buffreader.readLine();
                }
                //checks if the line is null after the blank line
                if(line == null){
                    break;
                }
                //creates the task label, description, checkbox and single task
                JLabel taskLabel;
                JLabel descriptionLabel;
                JCheckBox complete = new JCheckBox("Complete");
                JPanel singleTask = new JPanel();

                //creates a hashmap for the strikethrough font
                Map<TextAttribute, Object> attributes = new HashMap<>();
                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);

                //sets the layout for the single task
                singleTask.setLayout(
                        new BoxLayout(singleTask, BoxLayout.Y_AXIS)
                );
                //reads the line and saves it, also deletes the prefix "Task: "
                String task = line.substring("Task: ".length());
                taskLabel = new JLabel(task);
                //moves to the next line in Tasks.txt
                line = buffreader.readLine();

                //creates the font
                Font font  = taskLabel.getFont();
                Font strike = font.deriveFont(attributes);

                //reads the line and saves it, also deletes the prefix "description: "
                String description = line.substring("Description: ".length());
                descriptionLabel = new JLabel(description);
                //moves to the next line in Tasks.txt
                line = buffreader.readLine();

                //creates the checkbox and checks if it is checked
                if(line.matches("Complete")){
                    //puts a checkmark in the checkbox
                    complete.setSelected(true);
                    //Adds the strike font to the task and description
                    taskLabel.setFont(strike);
                    descriptionLabel.setFont(strike);
                }
                complete.addActionListener(e-> {
                    //checks if the checkbox is checked
                    //If the checkbox is checked it changes the font to strike
                    if(complete.isSelected()){
                        taskLabel.setFont(strike);
                        descriptionLabel.setFont(strike);
                    }
                    else{
                        taskLabel.setFont(font);
                        descriptionLabel.setFont(font);
                    }
                });
                //calls the border class if the task is selected
                new SelectedBorderCreator().border(singleTask);

                //moves to the next line
                line = buffreader.readLine();

                //Indents the description
                descriptionLabel.setBorder(
                        BorderFactory.createEmptyBorder(
                                0, 30, 0, 0
                        )
                );


                //Adds all the components to the singleTask pane
                singleTask.add(taskLabel);
                singleTask.add(descriptionLabel);
                singleTask.add(complete);

                //adds singleTask to taskPanel
                taskPanel.add(singleTask);
            }
            //Updates the GUI
            taskPanel.revalidate();
            taskPanel.repaint();
            //closes reader and buffer reader
            buffreader.close();
            reader.close();
        }
        //catches and exception if there is an error
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
