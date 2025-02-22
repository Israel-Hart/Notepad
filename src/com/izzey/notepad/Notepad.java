package com.izzey.notepad;

import com.izzey.notepad.file.*;
import com.izzey.notepad.edit.*;

import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

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
    private ArrayList<JMenuItem> responsiveMenus;
    private boolean actionStete;
    private ArrayList<JSeparator> separators ;
    private JMenu[] menus;
    JMenuItem newItem, newWindowItem, openItem, saveItem, saveAsItem, printItem, exitItem;
    private ActionListener fileMenuListener;
    private String snap;
    private boolean isSaved;
    private boolean actionState;
    public static final int SAVE_FROM_NEWFILE = 0;
    public static final int SAVE_FROM_EXIT = 1;
    private PageSetup pageSetup;
    public Notepad() {
        init();
        addListeners();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    void init() {
        responsiveMenus = new ArrayList<>();
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
        editItems = new String[]{"Undo","Cut", "Paste", "Delete", "Find", "Find Next", "Find Previous",
                                    "Replace", "Goto", "Select All", "Time/Date"};
        formatItems = new String[]{"Word Wrap", "Font..."};
        menuBar.setBorder(BorderFactory.createEmptyBorder());
        menuBar.setBackground(Color.white);
        //style menus
        for(JMenu m : menus) {
            m.setFont(UI_FONT);
            JPopupMenu popup = m.getPopupMenu();
            popup.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        }
        viewItems = new String[]{"Zoom", "Status Bar"};
        helpItems = new String[]{"Get Help", "Send Feedback", "About Notepad"};
        menuItems = new ArrayList<>();  // will be used to reference menu Items
        fileMenuItems = new ArrayList<>();
        editMenuItems = new ArrayList<>();
        formatMenuItems = new ArrayList<>();
        viewMenuItems = new ArrayList<>();
        helpMenuItems = new ArrayList<>();
        panel = new JPanel();
        menus = new JMenu[]{fileMenu, editMenu, formatMenu,viewMenu,helpMenu};
        separators = new ArrayList<>();
        isSaved = false;
        actionState = false;
        pageSetup = new PageSetup(this,"Page Setup");

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
            editMenuItems.add(item);
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
        void updateActionState() {
        actionState = !actionState;
             updateMenuItem();
        }
        void updateMenuItem(){
            for(JMenuItem item : menuItems) {
                if(actionState)
                {
                    item.setEnabled(false);
                }
            }
        }
    void addListeners() {
        addListener(new CreateNewFile(this, fileItems[0]), 0); //new item
        addListener(new CreateNewWindow(this, fileItems[1]), 1); //new swing item
        addListener(new OpenFile(this, fileItems[2]), 2); //open item
        addListener(new SaveFile(this, fileItems[3]), 3); //save item
        addListener(new SaveFileAs(this, fileItems[4]), 4); //save item as
        addListener(pageSetup, 5); //page setup item
        addListener(new PrintFile(this, fileItems[6]), 6); //print item
        addListener(new Exit(this, fileItems[7]), 7); //exit item/*

        addEditListener(new Undo(this),  0);
        addEditListener(new Cut(this),  1);
        addEditListener(new Paste(this),  2);
        addEditListener(new Delete(this),  3);
        addEditListener(new Delete(this),  3);
        addEditListener(new SelectAll(this), 9);
        addEditListener(new TimeDate(this), 10);


        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateActionState();
                checkEmptyState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }
            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    void checkEmptyState() {
        if(!textArea.getText().isEmpty())
            return;

    }

    void toggleMenuItemState(JMenuItem item){
        item.setEnabled(!item.isEnabled());
    }

    void addListener(AbstractAction a, int index) {
        JMenuItem item = fileMenuItems.get(index);
        item.addActionListener(a);
        item.setText(fileItems[index]);
    }
    void addEditListener(AbstractAction a, int index) {
        JMenuItem item = editMenuItems.get(index);
        item.addActionListener(a);
        item.setText(editItems[index]);
    }
    public boolean isChanged() {
        String then = getSnap();
        String now = getArea().getText();
        System.out.println("Now: " + now);
        System.out.println("Then: " + then);
        if (now.equals(then) || now.isEmpty())
            return false;
        return true;
    }
    public int initiateSave(int type) {
            int confirmation = -1;
          if(type == Notepad.SAVE_FROM_NEWFILE) {
               confirmation = JOptionPane.showConfirmDialog(getFrame(), "You made some changes, would you like to save them?", "Save?", JOptionPane.YES_NO_CANCEL_OPTION);
              if (confirmation == JOptionPane.YES_OPTION) {
                  callSaveAction(Notepad.SAVE_FROM_NEWFILE);
              }
          }else if (type == Notepad.SAVE_FROM_EXIT) {
               confirmation = JOptionPane.showConfirmDialog(getFrame(), "You made some changes, would you like to save them?", "Save?", JOptionPane.YES_NO_CANCEL_OPTION);
              if (confirmation == JOptionPane.YES_OPTION) {
                  callSaveAction(Notepad.SAVE_FROM_EXIT);
              }else if(confirmation == JOptionPane.NO_OPTION) {
                  getFrame().dispose();
              }
          }
            return confirmation;
    }
    public void updateArea () {
        textArea.revalidate();
    }
    public JFrame getFrame() { return window;};
    public JTextArea getArea() { return textArea;}
    public PageSetup getPageSetup() {
        return pageSetup;
    }
    public void enableSave(){
        fileMenuItems.get(3).setEnabled(true);
    }
    public void takeSnap() {
        snap = getArea().getText();
    }
    public String getSnap() {return snap;}
    public void callSaveAction(int type) {
        if(type == Notepad.SAVE_FROM_NEWFILE)
        {
            new SaveFile(this,"save and close").save_and_clear();
        }else if(type == Notepad.SAVE_FROM_EXIT) {
            new SaveFile(this,"save and close").save_and_close();
        }
    }
    public void updateState() {isSaved = !isSaved;}
    public boolean isSaved() { return isSaved;}
}