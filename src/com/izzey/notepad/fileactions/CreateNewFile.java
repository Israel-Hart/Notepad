package com.izzey.notepad.fileactions;

import com.izzey.notepad.Notepad;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CreateNewFile extends FileAction {
    public CreateNewFile(Notepad note, String name) {
        super(note, name);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Click is working");
        //check for changes in file
        String then = note.getSnap();
        String now = note.getArea().getText();
        System.out.println("Now: " + now);
        System.out.println("Then: " + then);

            if (now.equals(then) || now.isEmpty()) {
                note.getArea().setText("");
            } else {
                int confirmation = JOptionPane.showConfirmDialog(note.getFrame(),"You made some changes, would you like to save them?");
                if(confirmation == JOptionPane.YES_OPTION){
                    note.callSaveAction();
                }
            }
    }
}
