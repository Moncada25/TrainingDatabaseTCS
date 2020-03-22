package com.tcs.training10.ejerciciobd.view;

import com.tcs.training10.ejerciciobd.controller.Controller;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Principal extends Controller {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            UIManager.put("ScrollPane.border", BORDER);
            UIManager.put("Table.focusCellHighlightBorder", BORDER);
            UIManager.put("TableHeader.foreground", ROJO);
            UIManager.put("TableHeader.font", TEXT);
            UIManager.put("Table.font", TEXT);
            UIManager.put("Table.foreground", AZUL);
        } catch (ClassNotFoundException | IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException e) {
            e.printStackTrace();
        }

        JFrame home = new JFrame();

        JLabel welcome = new JLabel("<html>" + getStyle() + "<h1>Welcome to Personal</h1></html>");
        JPanel title = new JPanel(new FlowLayout());
        title.add(welcome);

        home.add(title, BorderLayout.NORTH);
        home.add(getPanel(home), BorderLayout.SOUTH);

        home.setSize(400, 180);
        home.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        home.setLocationRelativeTo(null);
        home.setResizable(true);
        home.setMinimumSize(new Dimension(400, 180));
        home.setTitle("Database Example");
        home.setVisible(true);
    }
}