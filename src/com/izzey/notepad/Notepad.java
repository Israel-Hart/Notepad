package com.izzey.notepad;

import com.izzey.notepad.fileactions.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
public class Notepad {
    private JFrame window;
    private JPanel panel, scrollPanel;
    private final Font UI_FONT  = new Font("arial", Font.PLAIN, 12);
    private JMenu fileMenu, editMenu, formatMenu, viewMenu, helpMenu;
    private ArrayList<JMenuItem> menuItems, fileMenuItems, editMenuItems, formatMenuItems, viewMenuItems, helpMenuItems;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private String[] fileItems, editItems, formatItems, viewItems, helpItems;
    private ArrayList<JSeparator> separators ;
    private JMenu[] menus;
    private char[] fileShortcuts, editShortcuts;
    JMenuItem newItem, newWindowItem, openItem, saveItem, saveAsItem;
    private ActionListener fileMenuListener;
    private String snap;

    private boolean fileSaved;
    public Notepad() {
        init();
        addListeners();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    void init() {
        this.fileSaved = false;
        window = new JFrame("Notepad");
        menuBar = new JMenuBar();
        textArea = new JTextArea();
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
        menuItems = new ArrayList<>();  // will be used to reference menu Items
        fileMenuItems = new ArrayList<>();
        editMenuItems = new ArrayList<>();
        formatMenuItems = new ArrayList<>();
        viewMenuItems = new ArrayList<>();
        helpMenuItems = new ArrayList<>();
        panel = new JPanel();
        menus = new JMenu[]{fileMenu, editMenu, formatMenu,viewMenu,helpMenu};
        separators = new ArrayList<>();


        //generate menuItems
        for (int i = 0; i < fileItems.length; i++) {  // fileMenu
            JMenuItem item = new JMenuItem(fileItems[i]);
            if(i == 5 || i == 7)
            {
                JSeparator sp = new JSeparator(SwingConstants.HORIZONTAL);
                fileMenu.add(sp);
                separators.add(sp);
            }
            item.addActionListener(fileMenuListener);
            fileMenuItems.add(item);
            fileMenu.add(item);
            menuItems.add(item);
        }
        for (int i = 0; i < editItems.length; i++) { //editMenu
            JMenuItem item = new JMenuItem(editItems[i]);
            if(i == 1 || i == 5 || i == 10)
            {
                JSeparator sp = new JSeparator(SwingConstants.HORIZONTAL);
                editMenu.add(sp);
                separators.add(sp);
            }
            editMenu.add(item);
            menuItems.add(item);
        }
        for (int i = 0; i < formatItems.length; i++) { //formatMenu
            JMenuItem item = new JMenuItem(formatItems[i]);
            formatMenu.add(item);
            menuItems.add(item);
        }
        for (int i = 0; i < viewItems.length; i++) { //viewMenu
            JMenuItem item = new JMenuItem(viewItems[i]);
            viewMenu.add(item);
            menuItems.add(item);
        }
        for (int i = 0; i < helpItems.length; i++) { // helpMenu
            JMenuItem item = new JMenuItem(helpItems[i]);
            if(i == 3)
            {   
                JSeparator sp = new JSeparator(SwingConstants.HORIZONTAL);
                helpMenu.add(sp);
                separators.add(sp);
            }
            helpMenu.add(item);
            menuItems.add(item);
        }
        //Menubar
        menuBar.setBorder(BorderFactory.createEmptyBorder());
        menuBar.setBackground(Color.white);
        //style menus
        for(JMenu m : menus) {
            m.setFont(UI_FONT);
            JPopupMenu popup = m.getPopupMenu();
            popup.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        }
        //style separators
        for(JSeparator sp : separators) { //make sure all separators can be styled
            sp.setForeground(Color.lightGray);
            sp.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
            Dimension size = sp.getSize();
            sp.setSize((int) (size.getWidth() -10), (int) size.getHeight());
        }
        //style menuItems
        for (JMenuItem item : menuItems) {
            item.setFont(UI_FONT);
//            item.setBorder(BorderFactory.createEmptyBorder());
            item.setBorder(BorderFactory.createEmptyBorder(4,30,4,10));
            item.setFocusable(false);
        }
            textArea.setFont(UI_FONT);
            scrollPane.setPreferredSize(new Dimension(800, 400));
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
            JScrollBar xBar = scrollPane.getHorizontalScrollBar(), yBar = scrollPane.getVerticalScrollBar();
            xBar.setBorder(BorderFactory.createEmptyBorder());
            yBar.setBorder(BorderFactory.createEmptyBorder());

            menuBar.add(fileMenu);
            menuBar.add(editMenu);
            menuBar.add(formatMenu);
            menuBar.add(viewMenu);
            menuBar.add(helpMenu);
            window.setJMenuBar(menuBar);
            panel.add(scrollPane);
            window.add(panel);
        }
    void addListeners() {
        newItem = fileMenuItems.get(0);
        newWindowItem = fileMenuItems.get(1);
        openItem = fileMenuItems.get(2);
        saveItem = fileMenuItems.get(3);
        saveAsItem = fileMenuItems.get(4);

        openItem.setAction(new OpenFile(this, fileItems[2]));
        openItem.setText(fileItems[2]); // bug fix for disappearing text on menu item after Action is set

        saveItem.setAction(new SaveFile(this, fileItems[3]));
        saveItem.setText(fileItems[3]);
        saveAsItem.setAction(new SaveFileAs(this, fileItems[4]));
        saveAsItem.setText(fileItems[4]);

        newItem.setAction(new CreateNewFile(this, fileItems[0]));
        newItem.setText(fileItems[0]);
        newWindowItem.setAction(new CreateNewWindow(this, fileItems[1]));
        newWindowItem.setText(fileItems[1]);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    public void recordSaveOperation() {
        fileSaved = true;
        fileMenuItems.get(3).setEnabled(false); // disable save button
    }
    public boolean getSaveState(){
        return fileSaved;
    }

    public void updateSaveState(boolean state) { fileSaved = state; }

    public void updateArea () {
        textArea.revalidate();
    }

    public JFrame getFrame() { return window;};
    public JTextArea getArea() { return textArea;}

    public void enableSave(){
        fileMenuItems.get(3).setEnabled(true);
    }

    public void takeSnap() {
        snap = getArea().getText();
    }

    public String getSnap() {return snap;}
    public void callSaveAction() {
        saveItem.doClick();
    }
}
