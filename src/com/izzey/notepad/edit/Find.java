package com.izzey.notepad.edit;

import com.izzey.notepad.Notepad;

public class Find extends EditAction{

    protected Find(Notepad notepad) {
        super(notepad);
    }
    public static void actionPerformed(String[] args)
    {
        new FindBox();
    }
}
