package com.izzey.notepad.fileactions;
import com.izzey.notepad.Notepad;

import javax.swing.*;
import java.awt.*;
import java.awt.print.*;
import java.awt.event.ActionEvent;
public class PrintFile extends FileAction{

    public PrintFile(Notepad note, String name) {
        super(note, name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return NO_SUCH_PAGE; // Only one page to print
                }

                // Translate the graphics to match the page format
                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                // Print content
                note.getArea().printAll(graphics);
                return PAGE_EXISTS;
            }
        });

        // Display the print dialog to the user
        if (printerJob.printDialog()) {
            try {
                printerJob.print();
                JOptionPane.showMessageDialog(null, "Printing complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, "Failed to print: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Printing was canceled!", "Canceled", JOptionPane.WARNING_MESSAGE);
        }
    }

}
