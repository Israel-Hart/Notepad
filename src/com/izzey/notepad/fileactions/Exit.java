package com.izzey.notepad.fileactions;

import com.izzey.notepad.Notepad;

import java.awt.event.ActionEvent;

public class Exit extends FileAction{
    public Exit(Notepad note, String name) {
        super(note, name);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(note.isSaved())
            note.getFrame().dispose();
        else {
            note.initiateSave(Notepad.SAVE_FROM_EXIT);
        }
    }
}
