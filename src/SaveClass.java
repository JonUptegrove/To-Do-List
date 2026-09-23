//This Class saves the task window to a text file

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;


public class SaveClass {
    public void save(int index, JPanel taskPanel){
        //Trys to open a FileWriter
        try{
            FileWriter writer = new FileWriter("Tasks.txt");
            //For loop go through the task individually
            for(int i = 0; i < index; i++){
                //Updates the tasks individually and saves their name, description, and completion status
                JPanel singleTask = (JPanel) taskPanel.getComponent(i);
                JLabel taskName = (JLabel) singleTask.getComponent(0);
                JLabel taskDescription = (JLabel) singleTask.getComponent(1);
                JCheckBox checkBox = (JCheckBox) singleTask.getComponent(2);

                //Writes the name Description in the file
                writer.write("Task: " + taskName.getText() + "\n");
                writer.write("Description: " + taskDescription.getText() +"\n");

                //Checks the checkBox to see if it is checked or not
                if(checkBox.isSelected()){
                    //Writes complete in the file if it is checked
                    writer.write("Complete\n\n");

                }
                else{
                    //Writes incomplete in the file if it is unchecked
                    writer.write("Incomplete\n\n");
                }
            }

            //Closes the writer
            writer.close();
        }
        //Catches if there is an error
        catch(IOException e){
            System.out.println("Could not write to file.");
        }
    }
}
