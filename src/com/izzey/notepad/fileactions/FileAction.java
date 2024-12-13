package com.izzey.notepad.fileactions;

import com.izzey.notepad.Notepad;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.nio.file.Path;

class FileAction extends AbstractAction {
    protected JFileChooser chooser;
    protected String actionName;
    protected Notepad note;
    protected File file;

    protected BufferedReader reader;
    protected BufferedWriter writer;
    protected FileReader fileReader;


    FileAction(Notepad note, String name) {
        this.chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        this.note = note;
        this.actionName = name;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    protected void readFile(File file, JTextArea destination) {
        try{
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null)
            {
                destination.append(line + "\n");
            }
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    protected void writeFile(File file, Path path)
    {

    }


    private String getActionName(){ return actionName; }
    protected void getLocation() { // returns location selected by user

    }
}
