package de.xbrowniecodez.jbytemod.ui;

import javax.swing.*;
import java.awt.*;

public class MemoryBar extends JPanel {
    private JProgressBar progressBar;

    public MemoryBar() {
        setLayout(new BorderLayout());
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        updateMemoryUsage();

        Timer timer = new Timer(1000, e -> updateMemoryUsage());
        timer.start();

        add(progressBar, BorderLayout.CENTER);
    }

    private void updateMemoryUsage() {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long usedMemory = totalMemory - freeMemory;
        int percentUsed = (int) ((double) usedMemory / totalMemory * 100);

        progressBar.setValue(percentUsed);
        progressBar.setString("Memory Usage: " + percentUsed + "%");
    }
}
