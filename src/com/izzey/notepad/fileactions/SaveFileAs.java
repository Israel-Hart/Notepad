package com.izzey.notepad.fileactions;
import java.awt.event.ActionEvent;
import com.izzey.notepad.Notepad;
import java.nio.file.Path;

import javax.swing.*;

public class SaveFileAs extends FileAction{
    public SaveFileAs(Notepad note, String name, Path path)
    {
        super(note,name) ;
    }
    public void actionPerformed(ActionEvent e)
    {
        int option = chooser.showSaveDialog(note.getFrame());
    }
}
