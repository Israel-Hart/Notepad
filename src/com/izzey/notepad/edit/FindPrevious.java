package com.izzey.notepad.edit;
import com.izzey.notepad.Notepad;

public class FindPrevious extends EditAction{
    public FindPrevious(Notepad notepad) {
        super(notepad);
        new FindBox();
    }
}
