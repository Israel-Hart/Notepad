package com.izzey.notepad.file;

import com.izzey.notepad.Notepad;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.filechooser.FileFilter;

class FileAction extends AbstractAction  {
    protected JFileChooser chooser;
    protected String actionName;
    protected Notepad note;
    protected File file;
    protected BufferedReader reader;
    protected BufferedWriter writer;
    protected FileReader fileReader;
    protected FileFilter txtFilter, docFilter, docxFilter, pdfFilter;

    FileAction(Notepad note, String name) {
        this.chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        this.note = note;
        this.actionName = name;
        txtFilter = new FileTypeFilter(".txt", "TextFile");
        docFilter = new FileTypeFilter(".doc", "Word(2007");
        pdfFilter = new FileTypeFilter(".pdf", "Printable Document Format");
        docxFilter = new FileTypeFilter(".docx", "Word File");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {}
    protected void readFile(File file, JTextArea destination)
    {
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
    protected void readFile(File file, String destination)
    {
        JTextArea textArea = new JTextArea();
        readFile(file, textArea);
        String areaText = textArea.getText();
        destination += areaText;
    }

    protected void writeFile(File file)
    {
        try(BufferedWriter outFile = new BufferedWriter(new FileWriter(file));)
        {
            note.getArea().write(outFile);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private String getActionName(){ return actionName; }
    protected void getLocation() { // returns location selected by user

    }
    void addFileFilters() {
        chooser.addChoosableFileFilter(txtFilter);
        chooser.addChoosableFileFilter(docFilter);
        chooser.addChoosableFileFilter(pdfFilter);
        chooser.addChoosableFileFilter(docxFilter);
    }
    void clearTextArea() {
        note.getArea().setText("");
    }

}
