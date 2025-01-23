package com.izzey.notepad.edit;

import javax.swing.JFrame;
//import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class IconlessFrame extends JFrame{
    public IconlessFrame(){
        Image icon = new BufferedImage(1,1, BufferedImage.TYPE_INT_ARGB);
        setIconImage(icon);
    }
}
