package com.izzey.notepad.edit;

import com.izzey.notepad.Notepad;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;

public class Paste extends EditAction {
    public Paste(Notepad notepad) {
        super(notepad);
    }
    @Override
    public void actionPerformed(ActionEvent e) {textArea.paste();}
}
