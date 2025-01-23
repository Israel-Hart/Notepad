package com.izzey.notepad.fileactions;
import java.awt.event.ActionEvent;
import java.io.*;
import com.izzey.notepad.Notepad;
import javax.swing.*;

public class SaveFile extends FileAction{
    public SaveFile(Notepad note, String name)
    {
        super(note,name);
    }
    public void actionPerformed(ActionEvent e) {
        save();
    }

    public void save(){
        int saveDialog = chooser.showSaveDialog(note.getFrame());
        if (saveDialog != JFileChooser.APPROVE_OPTION)
            return;
        file = chooser.getSelectedFile();
        file = new File(file.getAbsoluteFile() + ".txt");
        if (!note.isSaved())
            note.updateState();
        writeFile(file);
        note.takeSnap();
    }
    public void save_and_close() {
        save();
        note.getFrame().dispose();
    }
    public void save_and_clear() {
        save();
        note.getArea().setText("");
    }
}
