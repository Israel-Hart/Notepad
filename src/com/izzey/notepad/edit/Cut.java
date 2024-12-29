package com.izzey.notepad.edit;

import com.izzey.notepad.Notepad;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;

public class Cut extends EditAction{
    public Cut(Notepad notepad) {
        super(notepad);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        textArea.cut();
    }
}
