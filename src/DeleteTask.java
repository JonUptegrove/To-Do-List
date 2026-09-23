//This class deletes selected tasks then updates the GUI

import javax.swing.*;
import java.awt.*;

public class DeleteTask {
    public void deleteTask(JPanel selectedTask, JPanel taskPanel){
        //removes the task from the panel
        taskPanel.remove(selectedTask);

        //sets the selected task to null
        WindowCreator.selectedTask = null;

        //Refreshes the GUI
        taskPanel.revalidate();
        taskPanel.repaint();
    }
}
