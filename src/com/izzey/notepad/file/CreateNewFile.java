package com.izzey.notepad.file;
import com.izzey.notepad.Notepad;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

public class CreateNewFile extends FileAction {

    int user_input;
    public CreateNewFile(Notepad note, String name) {
        super(note, name);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Click is working");
        //check for changes in file
         if(note.isChanged()){
             user_input = note.initiateSave(Notepad.SAVE_FROM_NEWFILE);
             if(user_input == JOptionPane.NO_OPTION)
                 note.getArea().setText("");
         }
    }
}
