package com.izzey.notepad.file;
import com.izzey.notepad.Notepad;

import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
public class PrintFile extends FileAction{
    private PageFormat pageFormat;
    public PrintFile(Notepad note, String name) {
        super(note, name);
        this.pageFormat = pageFormat;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob printerJob = note.getPageSetup().getPrinterJob();
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
