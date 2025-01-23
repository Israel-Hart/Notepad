package com.izzey.notepad;

import javax.swing.UIManager;

public class Main {
    public static void main(String[] args)
    {
        String windowsLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(windowsLookAndFeelClassName);
        } catch (Exception e) {
            System.out.println("Error setting Windows L&F: " + e.getMessage());
        }
        new Notepad();
    }
}
