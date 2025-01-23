package com.izzey.notepad.fileactions;

import com.izzey.notepad.Notepad;

import java.awt.event.ActionEvent;

public class CreateNewWindow extends FileAction{
    public CreateNewWindow(Notepad note, String name) {
        super(note, name);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        new Notepad();
    }
}
