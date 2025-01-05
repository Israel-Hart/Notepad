package com.izzey.notepad.edit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.Color;
public class FindBox extends JFrame {
    private JButton findNextBtn, cancelBtn ;
    private JPanel panel, dirPanel; // dirPanel=Direction Panel
    private JCheckBox matchCheckBox, wrapCheckBox;
    private JRadioButton upRadio, downRadio;
    private JTextField findField;
    private JLabel findLabel, upLabel, downLabel, matchLabel, wrapLabel;
    public FindBox() {
        findNextBtn = new JButton("Find Next");
        cancelBtn = new JButton("Cancel");
        matchCheckBox = new JCheckBox();
        wrapCheckBox = new JCheckBox();
        findField = new JTextField();
        findLabel = new JLabel("Find what:");
        upLabel = new JLabel("Up");
        downLabel = new JLabel("Down");
        upRadio = new JRadioButton();
        downRadio = new JRadioButton();
        matchLabel = new JLabel("Match case");
        wrapLabel = new JLabel("Wrap around");
        panel = new JPanel();
        dirPanel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(350,150));
        panel.setBorder(BorderFactory.createEmptyBorder());

        findLabel.setBounds(10,10,100,10);
        findField.setBounds(70,10,175,20);
        findField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        findNextBtn.setBounds(252,10,90,20);
        findNextBtn.setBackground(new Color(230,230,230));
        findNextBtn.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        findNextBtn.setFocusable(false);
        cancelBtn.setBounds(252,37,90,20);
        cancelBtn.setBackground(new Color(230,230,230));
        cancelBtn.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        cancelBtn.setFocusable(false);

        matchCheckBox.setBounds(10,80,20,20);
        matchLabel.setBounds(30,80,150,20);

        wrapCheckBox.setBounds(10,105,20,20);
        wrapLabel.setBounds(30,105,150,20);

        upRadio.setBounds(140,45,20,20);
        downRadio.setBounds(140,70,20,20);

        upLabel.setBounds(170,45,150,20);
        downLabel.setBounds(170,70,150,20);

        panel.add(findLabel);
        panel.add(findField);
        panel.add(findNextBtn);
        panel.add(cancelBtn);
        panel.add(matchCheckBox);
        panel.add(matchLabel);
        panel.add(wrapCheckBox);
        panel.add(wrapLabel);
        panel.add(upRadio);
        panel.add(downRadio);
        panel.add(upLabel);
        panel.add(downLabel);
        add(panel);
        setName("Find");
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FindBox();
    }
}
