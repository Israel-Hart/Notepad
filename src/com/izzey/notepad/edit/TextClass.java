package com.izzey.notepad.edit;
import com.izzey.notepad.Notepad;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Arrays;

public class TextClass extends JFrame {
    UndoManager undoManager;
    KeyStroke undoStroke, redoStroke, limitedStroke;    TextClass() {
        undoManager = new UndoManager();
        undoStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK);
        redoStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK);
        limitedStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK);
        addPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    void addPanel() {
         JPanel panel = new JPanel(), wrapper_panel = new JPanel();
         JTextArea textArea = new JTextArea();
         JButton btn = new JButton("Undo"), btn_two = new JButton("Redo");
         UndoAction undoAction = new UndoAction();
         RedoAction redoAction = new RedoAction();
         LimitedAction limitedAction = new LimitedAction();

         textArea.setFont(new Font("Serif", Font.PLAIN, 16));
         textArea.setForeground(Color.white);
         textArea.setForeground(Color.blue);
         textArea.setPreferredSize(new Dimension(490, 340));
         textArea.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)) ;
         textArea.revalidate();
         textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
             @Override
             public void undoableEditHappened(UndoableEditEvent ue) {
                undoManager.addEdit(ue.getEdit());
             }
         });
//        textArea.getInputMap(JComponent.WHEN_FOCUSED).put(undoStroke, "undo");
//        textArea.getInputMap(JComponent.WHEN_FOCUSED).put(redoStroke, "redo");
        textArea.getInputMap(JComponent.WHEN_FOCUSED).put(limitedStroke, "limited");
//         textArea.getActionMap().put("undo",undoAction );
//         textArea.getActionMap().put("redo", redoAction);
         textArea.getActionMap().put("limited", limitedAction);

         styleButton(btn);
         styleButton(btn_two);
         btn.addActionListener(limitedAction);
         btn_two.addActionListener(redoAction);

         panel.setPreferredSize(new Dimension(500,50));
         wrapper_panel.setLayout(new BorderLayout());
         wrapper_panel.add(btn, BorderLayout.WEST);
         wrapper_panel.add(btn_two, BorderLayout.EAST);

         panel.setPreferredSize(new Dimension(500,400));
         panel.setBackground(Color.lightGray);
         panel.setBorder(BorderFactory.createEmptyBorder());

         panel.add(textArea);
         panel.add(wrapper_panel);

         add(panel);
    }
    void styleButton(JButton btn) {
        btn.setBackground(Color.black);
        btn.setForeground(Color.white);
        btn.setFont(new Font("Arial", Font.BOLD, 15));
        btn.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        btn.setFocusPainted(false);
        btn.setFocusable(false);
    }

    public static void main(String[] args) {
        new TextClass();
    }
    class UndoAction extends AbstractAction {
        ActionEvent e;
        @Override
        public void actionPerformed(ActionEvent e) {
            this.e = e;
            try {
                undoManager.undo();
            }catch(CannotUndoException ignore) {}
        }
        public void update(){
            JButton btn = (JButton) e.getSource();
            btn.setEnabled(undoManager.canUndo());
            putValue(Action.NAME, undoManager.getRedoPresentationName());
        }
    }
    class RedoAction extends AbstractAction {
        ActionEvent e;
        @Override
        public void actionPerformed(ActionEvent e) {
            this.e = e;
            try {
                undoManager.redo();
            }catch(CannotRedoException ignore) {}
        }
        public void update(){
            JButton btn = (JButton) e.getSource();
            btn.setEnabled(undoManager.canRedo());
            putValue(Action.NAME, undoManager.getRedoPresentationName());
        }
    }
    class LimitedAction extends AbstractAction {
        private ActionEvent e;
        private boolean clicked;
        LimitedAction() {
            clicked = false;
        }
        @Override
        public void actionPerformed(ActionEvent e ) {
            this.e = e;
            try {
                if(!clicked)
                    undoManager.undo();
                else
                    undoManager.redo();
            }catch(CannotUndoException | CannotRedoException ignored) {}
            update();
        }

        public void update(){
//            JButton btn = (JButton) e.getSource();
//            btn.setEnabled(undoManager.canRedo());
            putValue(Action.NAME, undoManager.getRedoPresentationName());
            clicked = !clicked;
        }
    }
}

