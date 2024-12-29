package com.izzey.notepad.edit;
import com.izzey.notepad.Notepad;

import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Redo extends EditAction{
    public Redo(Notepad notepad) {
        super(notepad);
        keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK);
        textArea.getInputMap().put(keyStroke, "redo");// set keyboard shortcut
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            undoManager.redo();
        }catch(CannotUndoException ignored) {}
    }
}
