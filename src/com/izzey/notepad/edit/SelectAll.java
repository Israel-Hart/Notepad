package com.izzey.notepad.edit;
import com.izzey.notepad.Notepad;

import javax.swing.JTextArea;
import java.awt.event.ActionEvent;

public class SelectAll extends EditAction{
    JTextArea area;
    public SelectAll(Notepad notepad) {
        super(notepad);
        area = notepad.getArea();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        area.requestFocusInWindow();
        area.selectAll();
    }
}
