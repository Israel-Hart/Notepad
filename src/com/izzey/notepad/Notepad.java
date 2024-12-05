package com.izzey.notepad;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
public class Notepad {
    private JFrame window;
    private JPanel panel, scrollPanel;
    private final Font UI_font  = new Font("san-serif", Font.PLAIN, 12);
    private JMenu fileMenu, editMenu, formatMenu, viewMenu, helpMenu;
    private ArrayList<JMenuItem> menuItems;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private String[] fileItems, editItems, formatItems, viewItems, helpItems;
    private char[] fileShortcuts, editShortcuts;
    private ActionListener fileMenuListener;
    Notepad() {
        createListeners();
        init();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    void init() {
        window = new JFrame("Notepad");
        menuBar = new JMenuBar();
        textArea = new JTextArea("This is test sentence.");
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        formatMenu = new JMenu("Format");
        viewMenu = new JMenu("View");
        helpMenu = new JMenu("Help");
        fileItems = new String[]{"New \t Ctrl+N", "New Window \t Ctrl+Shift+N", "Open \t Ctrl+O", "Save \t Ctrl+S", "Save As\t Ctrl+Shift+S",
                                    "Page Setup", "Print \t Ctrl+P", "Exit"};
        editItems = new String[]{"Undo \t Ctrl+Z", "Cut \t Ctrl+X", "Paste \t Ctrl+V", "Delete \t Del", "Find \t Ctrl+F", "Find Next \t F3", "Find Previous \t Shift+F3",
                                    "Replace \t Ctrl+H", "Goto \t Ctrl+G", "Select All \t Ctrl+A", "Time/Date \t F5"};
        formatItems = new String[]{"Word Wrap", "Font..."};
        viewItems = new String[]{"Zoom", "Status Bar"};
        helpItems = new String[]{"Get Help", "Send Feedback", "About Notepad"};
        fileShortcuts = new char[]{'N', 'N', 'O', 'S', 'S','s','d','b'};
        editShortcuts = new char[]{'Z', 'C', 'X', 'C', 'V'};
        menuItems = new ArrayList<>();  // will be used to style menu Items
        panel = new JPanel();

        //generate menuItems
        for (int i = 0; i < fileItems.length; i++) {
            JMenuItem item = new JMenuItem(fileItems[i]);
            item.addActionListener(fileMenuListener);
            fileMenu.add(item);
            menuItems.add(item);
        }
        for (int i = 0; i < editItems.length; i++) {
            JMenuItem item = new JMenuItem(editItems[i]);
            editMenu.add(item);
            menuItems.add(item);
        }
        for (int i = 0; i < formatItems.length; i++) {
            JMenuItem item = new JMenuItem(formatItems[i]);
            formatMenu.add(item);
            menuItems.add(item);
        }
        for (int i = 0; i < viewItems.length; i++) {
            JMenuItem item = new JMenuItem(viewItems[i]);
            viewMenu.add(item);
            menuItems.add(item);
        }
        for (int i = 0; i < helpItems.length; i++) {
            JMenuItem item = new JMenuItem(helpItems[i]);
            helpMenu.add(item);
            menuItems.add(item);
        }

        //style menus
        fileMenu.setFont(UI_font);
        editMenu.setFont(UI_font);
        formatMenu.setFont(UI_font);
        viewMenu.setFont(UI_font);
        helpMenu.setFont(UI_font);
        //style menuItems
        for (JMenuItem item : menuItems) {
            item.setFont(UI_font);
        }
            textArea.setFont(UI_font);
            scrollPane.setPreferredSize(new Dimension(800, 400));

            menuBar.add(fileMenu);
            menuBar.add(editMenu);
            menuBar.add(formatMenu);
            menuBar.add(viewMenu);
            menuBar.add(helpMenu);
            window.setJMenuBar(menuBar);
            panel.add(scrollPane);
            window.add(panel);

        }
    void createListeners() {
        fileMenuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JMenuItem src = (JMenuItem) e.getSource();

                //new file action

            }
        };
    }
}
