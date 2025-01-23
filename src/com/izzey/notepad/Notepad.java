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

    //Refactor Code
    private JMenuItem newFileItem, newWindowItem, exitItem, openFileItem,
            pageSetupItem, printFileItem, saveFileItem, saveAsitem;

    private JMenuItem copyItem, cutItem, deleteItem, findItem, findNextItem, findPreviousItem,
            pasteItem, redoItem, selectAllItem, timeDateItem, undoItem, gotoItem, replaceItem;

    private JMenuItem fontItem, wordWrapItem;

    private JMenuItem zoomItem, statusBarItem;

    private viewHelpItem, sendFeedbackItem, aboutNotepadItem;

    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private String[] fileItems, editItems, formatItems, viewItems, helpItems;
    private ArrayList<JSeparator> separators ;
    private JMenu[] menus;
    private char[] fileShortcuts, editShortcuts;
    private JMenuItem newItem, newWindowItem, openItem, saveItem, saveAsItem, printItem, exitItem;
    private ActionListener fileMenuListener;
    private String snap;
    private boolean isSaved;
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

        //Refactor Code Starts
        //File Items
        assignMenuItem(newFileItem, "New \t Ctrl+N", fileMenuItems);
        assignMenuItem(newWindowItem, "New Window \t Ctrl+Shift+N", fileMenuItems);
        assignMenuItem(opeFileItem, "Open \t Ctrl+O", fileMenuItems);
        assignMenuItem(saveItem, "Save \t Ctrl+S", fileMenuItems);
        assignMenuItem(saveAsItem, "Save As\t Ctrl+Shift+S", fileMenuItems);
        assignMenuItem(pageSetupItem, "Page Setup", fileMenuItems);
        assignMenuItem(printFileItem, "Print \t Ctrl+P", fileMenuItems);
        assignMenuItem(exitItem, "\"Exit", fileMenuItems);

        //Edit Items
        assignMenuItem(copyItem, "Copy \t Ctrl+C", editMenuItems);
        assignMenuItem(cutItem, "Cut \t Ctrl+X", editMenuItems);
        assignMenuItem(deleteItem, "Delete \t Del", editMenuItems);
        assignMenuItem(findItem, "Find \t Ctrl+F", editMenuItems);
        assignMenuItem(findNextItem, "Find Next \t F3", editMenuItems);
        assignMenuItem(findPreviousItem, "Find Previous \t Shift+F3", editMenuItems);
        assignMenuItem(pasteItem, "Paste \t Ctrl+V", editMenuItems);
        assignMenuItem(redoItem, "Redo \t Ctrl+D", editMenuItems);
        assignMenuItem(selectAllItem, "Select All \t Ctrl+A",editMenuItems);
        assignMenuItem(timeDateItem, "Time/Date \t F5", editMenuItems);
        assignMenuItem(undoItem, "Undo \t Ctrl+Z", editMenuItems);
        assignMenuItem(gotoItem, "Goto \t Ctrl+G", editMenuItems);
        assignMenuItem(replaceItem, "Replace \t Ctrl+H" editMenuItems);

        //Format
        assignMenuItem(fontItem, "Font...", formatMenuItems);
        assignMenuItem(wordWrapItem, "Word Wrap", formatMenuItems);

        //View
        assignMenuItem(zoomItem,"Zoom", viewMenuItems);
        assignMenuItem(statusBarItem, "Status Bar", viewMenuItems);

        //Help
        assignMenuItem(viewHelpItem, "Get Help", helpMenuItems);
        assignMenuItem(sendFeedbackItem, "Send Feedback", helpMenuItems);
        assignMenuItem(aboutNotepadItem, "About Notepad", helpMenuItems);
        //Refactor Code Ends

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
        isSaved = false;
        pageSetup = new PageSetup(this,"Page Setup");


        //Refactor Code Starts
        /* Style Menu Items */

        //File Items
        for(JMenuItem item : fileMenuItems){
            styleMenuItem(item);
        }
        //Edit Items
        for(JMenuItem item : editMenuItems){
            styleMenuItem(items);
        }

        //Format Items
        for(JMenuItem item : formatMenuItems){
            styleMenuItem(items);
        }
        //View Items
        for(JMenuItem item : viewMenuItems){
            styleMenuItem(items);
        }
        //Help Items
        for(JMenuItem item : helpMenuItems){
            styleMenuItem(items);
        }

        //Refactor Code Ends

        //generate menuItems
        /*
        for (int i = 0; i < fileItems.length; i++) {  // fileMenu
            JMenuItem item = new JMenuItem(fileItems[i]);
            if(i == 5 || i == 7)
            {
                JSeparator sp = new JSeparator(SwingConstants.HORIZONTAL);
                fileMenu.add(sp);
                separators.add(sp);
            }
//            item.addActionListener(fileMenuListener);
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

        */

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
        /*
        //style menuItems
        for (JMenuItem item : menuItems) {
            item.setFont(UI_FONT);
//            item.setBorder(BorderFactory.createEmptyBorder());
            item.setBorder(BorderFactory.createEmptyBorder(4,30,4,10));
            item.setFocusable(false);
        }

         */
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
        void styleMenuItem(JMenuItem item ) {
            item.setFont(UI_FONT);
//            item.setBorder(BorderFactory.createEmptyBorder());
            item.setBorder(BorderFactory.createEmptyBorder(4,30,4,10));
            item.setFocusable(false);
        }
    void assignMenuItem(JMenuItem item, String text, ArrayList<JMenuItem> itemList)
    {
        item = new JMenuItem(text);
        itemList.add(item);
    }

    void coupleMenus() {
        //File Menu
        assembleMenuItems(fileMenu, fileMenuItems, new int[]{1,7});
        assembleMenuItems(editMenu, editMenuItems, new int[]{1,5,10});
        assembleMenuItems(formatMenu, formatMenuItems, null) ;
        assembleMenuItems(viewMenu, viewMenuItems, null);
        assembleMenuItems(helpMenu, helpMenuItems, new int[]{3});
    }
    void assembleMenuItems(JMenu menu, ArrayList<JMenuItem> list,  int[] posArr) {
        int idx = 1;
        for(JMenuItem item : list)
        {
            if(!(posArr == null)) { // position isn't empty
                for(int pos ; posArr)
                    if(pos == idx) {
                        JSeparator sp = new JSeparator(SwingConstant.HORIZONTAL);
                        separators.add(sp);
                        menu.add(sp);
                    }
            }
            menu.add(item);
            idx++;
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
        addListener(new Exit(this, fileItems[7]), 7); //exit item


        addListener(new CreateNewFile(this, newFileItem, newFileItem.getText())); //new item
        addListener(new CreateNewWindow(this, newWindowItem), newWindowItem.getText() ); //new swing item
        addListener(new OpenFile(this, openFileItem, openFileItem.getText())); //open item
        addListener(new SaveFile(this, saveFileItem), saveFileItem.getText()); //save item
        addListener(new SaveFileAs(this, saveFileAsItem), saveFileAsItem.getText()); //save item as
        addListener(new pageSetup(this, pageSetupItem), pageSetupItem.getText()); //page setup item
         addListener(new PrintFile(this, printFileItem), printFileitem.getText()); //print item
        addListener(new Exit(this, exitItem), exitItem.getText()); //exit item
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

    void addListener(AbstractAction a, int index) {
        JMenuItem item = fileMenuItems.get(index);
        item.addActionListener(a);
        item.setText(fileItems[index]);
    }

    void addListener(AbstractAction a, JMenuItem item) {
        String clone = item.getText();
        item.addActionListener(a);
        item.setText(clone);
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