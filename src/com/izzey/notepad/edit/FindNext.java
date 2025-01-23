package com.izzey.notepad.edit;

import com.izzey.notepad.Notepad;

public class FindNext extends EditAction {
    protected FindNext(Notepad notepad) {
        super(notepad);
        new FindBox();
    }
}
