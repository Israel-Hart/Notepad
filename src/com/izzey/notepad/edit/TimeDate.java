package com.izzey.notepad.edit;
import com.izzey.notepad.Notepad;

import javax.swing.JTextArea;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
public class TimeDate extends EditAction{
    JTextArea area;
    public TimeDate(Notepad notepad){
        super(notepad);
        area = notepad.getArea();
    }


    private String getDate() {
        return LocalDateTime.now().toString();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            area.append(getDate());
        }catch(DateTimeException ignored){

        }
    }
}
