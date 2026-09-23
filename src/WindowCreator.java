/*
This class creates the window and sets its bounds
It also adds the panel and buttons to the window
*/
import javax.swing.*;
import java.awt.*;

public class WindowCreator {
    static JPanel taskPanel = new JPanel();
    static JPanel selectedTask = null;
    public static void window(){
        //Creating the window
        JFrame window = new JFrame("To-Do List");
        window.setSize(500,400);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Creating the top panel
        JPanel ribbon = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 2));
        ribbon.setPreferredSize(new Dimension(500,30));
        ribbon.setBackground(Color.GRAY);
        window.add(ribbon, BorderLayout.NORTH);

        //Calls the Buttons class and passes the ribbon to it
        new Buttons(ribbon);

        //Creates a Panel for the tasks to be created and added to
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        window.add(taskPanel, BorderLayout.CENTER);


        window.setVisible(true);
    }

}
