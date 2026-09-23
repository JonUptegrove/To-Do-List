/*
This class creates the border and lets it be used in other classes
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SelectedBorderCreator {
    public void border(JPanel singleTask){
        // Make the task selectable and outline it
        Border border= BorderFactory.createLineBorder(Color.BLACK);
        singleTask.addMouseListener(

                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            java.awt.event.MouseEvent e) {

                        //if there is no task selected when one is selected it adds the outline
                        if(WindowCreator.selectedTask == null){
                            WindowCreator.selectedTask = singleTask;
                            WindowCreator.selectedTask.setBorder(border);
                        }
                        else{
                            //gets rid of the old border on the previously selected task
                            WindowCreator.selectedTask.setBorder(null);
                            //creates the new border
                            WindowCreator.selectedTask = singleTask;
                            WindowCreator.selectedTask.setBorder(border);
                        }


                    }
                }
        );
    }
}
