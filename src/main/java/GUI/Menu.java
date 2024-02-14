package main.java.GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JMenuBar {

    public Menu(MainJFrame frame, JMenu menu){

        GuiPresetComponet t = new GuiPresetComponet(frame);

        menu = new JMenu("Menu");
        menu.setFont(frame.getFontToolBar());
        menu.setBackground(frame.getColorToolBar());

        JMenuItem menuItem = new MenuItem(frame,"Impostazioni", new ImageIcon(t.ResizeIcon(20, 20, new ImageIcon("src\\main\\resources\\gear.png"))));
        menu.add(menuItem);
        menuItem = new MenuItem(frame,"ciao2", null);
        menu.add(menuItem);
        menu.setOpaque(true);
        menu.setForeground(Color.BLACK);

        this.setBorder(null);
        this.setBackground(frame.getColorToolBar());
        this.add(menu);



    }

}
