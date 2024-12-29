package com.izzey.notepad.edit;
import com.izzey.notepad.Notepad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;

public class EditAction extends AbstractAction {
    protected JTextArea textArea;
    protected UndoManager undoManager;
    protected Document doc;
    protected KeyStroke keyStroke;
    Notepad notepad;
    protected EditAction(Notepad notepad)
    {
        this.notepad = notepad;
        textArea = notepad.getArea();
        undoManager = new UndoManager();
        doc = textArea.getDocument();
        doc.addUndoableEditListener( new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
