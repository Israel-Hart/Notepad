package com.izzey.notepad.file;
import com.izzey.notepad.Notepad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

public class PageSetup extends FileAction{
    private PageFormat pageFormat;
    private PrinterJob printerJob;
    public PageSetup(Notepad note, String title) {
        super(note,title);
        this.pageFormat = PrinterJob.getPrinterJob().defaultPage(); // Default PageFormat
    }
    public void showPageSetupDialog() {
        printerJob = PrinterJob.getPrinterJob();
        // Display the page setup dialog
        pageFormat = printerJob.pageDialog(this.pageFormat);
        // Save the updated page format (if the user made changes)
        if (pageFormat != null) {
            JOptionPane.showMessageDialog(null, "Page setup updated!", "Success", JOptionPane.INFORMATION_MESSAGE);

        }
    }
    public PageFormat getPageFormat() {
        return pageFormat;
    }
    public PrinterJob getPrinterJob() {
        return printerJob;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        showPageSetupDialog();
    }
}
