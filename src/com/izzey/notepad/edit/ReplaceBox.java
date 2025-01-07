package com.izzey.notepad.edit;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.BorderFactory;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;


public class ReplaceBox extends JFrame {
    private JPanel panel, buttonPanel;
    private JLabel findWhatLabel, replaceLabel, matchLabel, wrapLabel;
    private JTextField findWhatField, replaceField;
    private JButton findNextBtn, replaceBtn,replaceWithAll, cancelBtn;
    private JCheckBox matchCheckBox, wrapCheckBox;
    private final Font font= new Font("callibri", Font.PLAIN, 11);
    public ReplaceBox() {
        panel = new JPanel();
        buttonPanel = new JPanel();

        findWhatLabel = new JLabel("Find what:");
        replaceLabel = new JLabel("Replace with:");
        matchLabel = new JLabel("Match case");
        wrapLabel = new JLabel("Wrap around");

        findWhatField = new JTextField();
        replaceField = new JTextField();

        findNextBtn = new JButton("Find Next");
        replaceBtn = new JButton("Replace");
        replaceWithAll = new JButton("Replace All");
        cancelBtn = new JButton("Cancel");

        matchCheckBox = new JCheckBox();
        wrapCheckBox = new JCheckBox();

        panel.setPreferredSize(new Dimension(350,150));
        panel.setLayout(null);

        findWhatLabel.setBounds(10,18,100,15);
        replaceLabel.setBounds(10,43,100,15);

        findWhatField.setBounds(80, 15, 170, 20);
        replaceField.setBounds(80, 42, 170, 20);

        buttonPanel.setBounds(260, 10, 90, 110);
        buttonPanel.setBackground(Color.yellow);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        setStyle(findWhatField);
        setStyle(findWhatLabel);
        setStyle(replaceLabel);
        setStyle(matchLabel);
        setStyle(wrapLabel);
        setStyleBtn(findNextBtn);
        setStyleBtn(replaceBtn);
        setStyleBtn(replaceWithAll);
        setStyleBtn(cancelBtn);

        buttonPanel.add(findNextBtn);
        buttonPanel.add(replaceBtn);
        buttonPanel.add(replaceWithAll);
        buttonPanel.add(cancelBtn);

        panel.add(findWhatLabel);
        panel.add(replaceLabel);
        panel.add(findWhatField);
        panel.add(replaceField);
        panel.add(buttonPanel);

        add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    void setStyle(JComponent comp) {
        comp.setFont(font);
    }
    void setStyleBtn(JButton btn) {
        setStyle(btn);
        btn.setPreferredSize(new Dimension(100, 40));
    }
    public static void main(String[] args) {
        new ReplaceBox();
    }
}
