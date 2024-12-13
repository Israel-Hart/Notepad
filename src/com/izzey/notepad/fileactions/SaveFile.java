package com.izzey.notepad.fileactions;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.izzey.notepad.Notepad;

import javax.swing.*;

public class SaveFile extends FileAction{
    public SaveFile(Notepad note, String name)
    {
        super(note,name);
    }
    public void actionPerformed(ActionEvent e)
    {
        int saveDialog = chooser.showSaveDialog(note.getFrame());
        if(saveDialog != JFileChooser.APPROVE_OPTION)
            return;

        file = chooser.getSelectedFile();
//        file = new File(file.getAbsolutePath() + file.getName());

        try(BufferedWriter outFile = new BufferedWriter(new FileWriter(file));)
        {
            note.getArea().write(outFile);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
