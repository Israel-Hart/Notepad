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
    protected boolean clicked;
    Notepad notepad;
    protected EditAction(Notepad notepad)
    {
        clicked = false;
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
    protected void update(){
//            JButton btn = (JButton) e.getSource();
//            btn.setEnabled(undoManager.canRedo());
        putValue(Action.NAME, undoManager.getRedoPresentationName());
        clicked = !clicked;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
