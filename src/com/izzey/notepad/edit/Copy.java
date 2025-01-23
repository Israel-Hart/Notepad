package com.izzey.notepad.edit;

import com.izzey.notepad.Notepad;
import java.awt.event.ActionEvent;

public class Copy extends EditAction {
    public Copy(Notepad notepad) {
        super(notepad);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.copy();
        update();
    }
}
