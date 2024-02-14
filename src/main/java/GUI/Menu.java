package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {

    public Menu(MainJFrame frame, JMenu menu){


        menu = new JMenu("Menu");
        menu.setFont(frame.getFontToolBar());
        menu.setBackground(frame.getColorToolBar());
        JMenuItem menuItem = new JMenuItem("Both text and icon", new ImageIcon("src\\main\\resources\\dots.png"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);
        menu.setForeground(Color.BLACK);

        this.setBorder(null);
        this.setBackground(frame.getColorToolBar());
        this.add(menu);

    }

}
