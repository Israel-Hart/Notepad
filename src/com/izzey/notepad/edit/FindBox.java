package com.izzey.notepad.edit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import java.awt.Dimension;
public class FindBox extends JFrame {
    private JButton findNext, cancel ;
    private JPanel panel;
    private JCheckBox upCheckBox, downCheckBox;
    private JTextField findField;
    private JLabel findLabel, upLabel, downLabel, matchLabel, wrapLabel;
    public FindBox() {
        findNext = new JButton("Find Next");
        cancel = new JButton("Cancel");
        upCheckBox = new JCheckBox();
        downCheckBox = new JCheckBox();
        findField = new JTextField();
        findLabel = new JLabel("Find what");
        upLabel = new JLabel("Up");
        downLabel = new JLabel("Down");
        matchLabel = new JLabel("Match case");
        wrapLabel = new JLabel("Wrap around");
        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(300,200));
        panel.setBorder(BorderFactory.createEmptyBorder());
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FindBox();
    }
}
