package main.java.GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JMenuBar {

    public Menu(MainJFrame frame, JMenu menu){


        menu = new JMenu("Menu");
        menu.setFont(frame.getFontToolBar());
        menu.setBackground(frame.getColorToolBar());
        JMenuItem menuItem = new JMenuItem("Both text and icon");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);
        menu.setForeground(Color.BLACK);
        //menu.setBorder( new LineBorder(Color.RED));
        //menu.setBorderPainted(false);
        menuItem.setOpaque(true);
        menuItem.setBackground(frame.getColorToolBar());
        menuItem.setFont(frame.getFontToolBar());
        menuItem.setForeground(Color.BLACK);

        this.setBorder(null);
        this.setBackground(frame.getColorToolBar());
        this.add(menu);



    }

}
