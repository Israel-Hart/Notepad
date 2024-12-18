package com.izzey.notepad.fileactions;
import java.awt.event.ActionEvent;
import com.izzey.notepad.Notepad;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class SaveFileAs extends FileAction{
    public SaveFileAs(Notepad note, String name)
    {
        super(note,name);
    }
    public void actionPerformed(ActionEvent e)
    {
        addFileFilters();
        int saveDialog = chooser.showSaveDialog(note.getFrame());
        if(saveDialog != JFileChooser.APPROVE_OPTION)
            return;
        file = chooser.getSelectedFile();
        if(chooser.getFileFilter() != null) {
            FileFilter ext = chooser.getFileFilter();
            if(ext == txtFilter) {file = new File(file.getAbsoluteFile() + ".txt");}
            if(ext == docFilter) {file = new File(file.getAbsoluteFile() + ".doc");}
            if(ext == pdfFilter) {file = new File(file.getAbsoluteFile() + ".pdf");}
            if(ext == docxFilter) {file = new File(file.getAbsoluteFile() + ".docx");}
        }else {
            file = new File(file.getAbsoluteFile() + ".txt");
        }
        writeFile(file);
    }
}
