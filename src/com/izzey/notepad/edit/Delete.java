package com.izzey.notepad.edit;

import com.izzey.notepad.Notepad;
import java.awt.event.ActionEvent;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

public class Delete extends EditAction {
    private Robot robot;
    public Delete(Notepad notepad) {
        super(notepad);
        try {
            robot = new Robot();
        }catch(AWTException ignored)
        {}
    }
    @Override
    public void actionPerformed(ActionEvent e )
    {
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
    }
}
