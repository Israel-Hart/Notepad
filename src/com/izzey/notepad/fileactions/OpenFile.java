package com.izzey.notepad.fileactions;
import com.izzey.notepad.Notepad;
import javax.swing.*;
import java.awt.event.*;
public class OpenFile extends FileAction {
    public OpenFile(Notepad note, String name)
    {
        super(note, name);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int option = chooser.showOpenDialog(note.getFrame());
        if(option == JFileChooser.APPROVE_OPTION)
        {
            file = chooser.getSelectedFile();
            readFile(file,note.getArea());
        }

    }
}
