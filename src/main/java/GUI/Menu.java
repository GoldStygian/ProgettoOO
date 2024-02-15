package main.java.GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JMenuBar {


    public Menu(MainJFrame frame, JMenu menu, JPanel HomePanel, JPanel Oldpanel){

        GuiPresetComponet t = new GuiPresetComponet(frame);


        menu.setFont(frame.getFontToolBar());
        menu.setBackground(frame.getColorToolBar());

        JMenuItem menuItem = new MenuItem(frame,"Impostazioni", new ImageIcon(t.ResizeIcon(60, 60, new ImageIcon("src\\main\\resources\\gear.png"))));
        menu.add(menuItem);

        menuItem = new MenuItem(frame,"Esci", new ImageIcon(t.ResizeIcon(63, 63, new ImageIcon("src\\main\\resources\\logout.png"))));

        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(HomePanel, Oldpanel);
            }

        });

        menu.add(menuItem);



        menu.setOpaque(true);
        menu.setForeground(Color.BLACK);

        this.setBorder(null);
        this.setBackground(frame.getColorToolBar());
        this.add(menu);


    }


}