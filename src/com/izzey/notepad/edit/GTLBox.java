package com.izzey.notepad.edit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridLayout;


public class GTLBox extends JFrame{
    private JPanel panel, buttonPanel;
    private JTextField textField;
    private JButton gotoBtn, cancelBtn;
    private final Font font= new Font("callibri", Font.PLAIN, 11);
    private JLabel label;
    private GridLayout buttonLayout;

    public GTLBox() {
        panel = new JPanel();
        textField = new JTextField();
        label = new JLabel("Line number:");
        gotoBtn = new JButton("Go to");
        cancelBtn = new JButton("Cancel");
        buttonPanel = new JPanel();
        buttonLayout = new GridLayout(1,2);
        buttonLayout.setHgap(5);

        //set component styles
        setStyle(textField);
        setStyle(label);
        setStyleBtn(gotoBtn);
        setStyleBtn(cancelBtn);

        panel.setPreferredSize(new Dimension(270,110));
        panel.setLayout(null);
//        buttonPanel.setPreferredSize(new Dimension(100, 50));
        buttonPanel.setBounds(90,65,170,25);
//        buttonPanel.setBackground(Color.yellow);
        buttonPanel.setLayout(buttonLayout);

        label.setBounds(10, 10, 100,10);
        textField.setBounds(10,30,250,25);

        buttonPanel.add(gotoBtn);
        buttonPanel.add(cancelBtn);
        panel.add(label);
        panel.add(textField);
        panel.add(buttonPanel);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void setStyle(JComponent comp) {
        comp.setFont(font);
    }
    void setStyleBtn(JButton btn) {
        setStyle(btn);
//        btn.setPreferredSize(new Dimension(100, 40));
        btn.setFocusable(false);
        btn.setBackground(new Color(233,233,233));
    }

    public static void main(String[] args)
    {
        new GTLBox();
    }
}
