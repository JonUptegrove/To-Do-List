/*
This class creates a completed checkbox
When the checkbox is checked as completed it changes the font to cross it out
 */

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class TaskCompleted {
    public void checkboxCreator(JPanel singletask,JLabel taskreturn, JLabel descriptionreturn){
        //Creates the checkbox
        JCheckBox checkBox = new JCheckBox("Complete");

        //Creates a hashmap that creates the strikethrough font
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);

        //Saves the original font in font
        //Saves the strikeThrough font in strike
        Font font  = taskreturn.getFont();
        Font strike = font.deriveFont(attributes);

        checkBox.addActionListener(e-> {
            //checks if the checkbox is checked
            //If the checkbox is checked it changes the font to strike
            if(checkBox.isSelected()){
                taskreturn.setFont(strike);
                descriptionreturn.setFont(strike);
            }
            else{
                taskreturn.setFont(font);
                descriptionreturn.setFont(font);
            }
        });

        singletask.add(checkBox);
    }
}
