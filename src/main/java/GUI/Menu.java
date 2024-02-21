package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JMenuBar {

    private FrameRichieste ModificeUtente;
    private boolean bool = true;

    public Menu(MainJFrame frame, JMenu menu, JPanel HomePanel, JPanel Oldpanel, Controller controller){

        GuiPresetComponet t = new GuiPresetComponet(frame);

        ModificeUtente = new FrameRichieste("Modifiche",frame,controller);

        menu.setFont(frame.getFontToolBar());
        menu.setBackground(frame.getColorToolBar());

        JMenuItem menuItem = new MenuItem(frame,"Impostazioni", new ImageIcon(t.ResizeIcon(60, 60, new ImageIcon("src\\main\\resources\\gear.png"))));
        menu.add(menuItem);


        menuItem = new MenuItem(frame,"Crea Pagina", new ImageIcon(t.ResizeIcon(60, 60, new ImageIcon("src\\main\\resources\\writing.png"))));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //QUI IL TASTO CREA
                frame.SetNewPanel(new CreaPagina(frame, Oldpanel, controller).getPanel(), HomePanel);
                frame.Resize(600, 850);
            }

        });

        menu.add(menuItem);

        menuItem = new MenuItem(frame,"Le mie Richieste", new ImageIcon(t.ResizeIcon(65, 65, new ImageIcon("src\\main\\resources\\request2.png"))));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Mie richieste
                if(bool){
                    ModificeUtente.setVisible(true);
                    bool = false;
                }

            }

        });

        menuItem = new MenuItem(frame,"Storicita", new ImageIcon(t.ResizeIcon(65, 65, new ImageIcon("src\\main\\resources\\request2.png"))));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //qui codice

            }

        });

        ModificeUtente.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                bool = true;

            }
        });

        menu.add(menuItem);

        menuItem = new MenuItem(frame,"Esci", new ImageIcon(t.ResizeIcon(63, 63, new ImageIcon("src\\main\\resources\\logout.png"))));
        menu.add(menuItem);
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(HomePanel, Oldpanel);
                controller.logOut();
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
