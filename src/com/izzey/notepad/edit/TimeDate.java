package com.izzey.notepad.edit;
import com.izzey.notepad.Notepad;

import javax.swing.JTextArea;
public class TimeDate extends EditAction{
    JTextArea area;

    public TimeDate(Notepad notepad){
        super(notepad);
        area = notepad.getArea();
    }
}
