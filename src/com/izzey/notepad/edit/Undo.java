package com.izzey.notepad.edit;
import com.izzey.notepad.Notepad;

import javax.swing.KeyStroke;
import javax.swing.undo.CannotUndoException;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Undo extends EditAction{
    public Undo(Notepad notepad){
        super(notepad);
        keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK);
        textArea.getInputMap().put(keyStroke, "undo");// set keyboard shortcut
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(!clicked)
                undoManager.undo();
            else
                undoManager.redo();
        }catch(CannotUndoException ignored) {}
        update();
    }
}
