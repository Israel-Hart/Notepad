package com.izzey.notepad.fileactions;
import java.awt.event.ActionEvent;
import java.io.*;
import com.izzey.notepad.Notepad;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveFile extends FileAction{
    public SaveFile(Notepad note, String name)
    {
        super(note,name);
    }
    public void actionPerformed(ActionEvent e) {
        int saveDialog = chooser.showSaveDialog(note.getFrame());
        if (saveDialog != JFileChooser.APPROVE_OPTION)
            return;
        file = chooser.getSelectedFile();
        file = new File(file.getAbsoluteFile() + ".txt");
        if (!note.getSaveState())
            note.updateSaveState(true);
        writeFile(file);
    }

}
