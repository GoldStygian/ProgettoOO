package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class HomeAutore {
    private JPanel MainPanel;
    private JPanel ToolBar;
    private JPanel BarIcon;
    private JLabel Icon;
    private JLabel NameApp;
    private JPanel BarraDiRicerca;
    private JPanel SerchBorder;
    private JTextField SerchBar;
    private JLabel IconaLente;
    private JPanel ButtonPanel;
    private JPanel MenuButton;
    private JLabel IconMenu;
    private JButton NotificheButton;
    private JLabel IconNotfiche;
    private JPanel NotificheBox;
    private JMenu Menu;
    private JMenuBar MenuBar;
    //private MainJFrame frame;
    private Boolean bool = true;

    public HomeAutore(MainJFrame frame, Controller controller, JPanel HomePanel) {
        GuiPresetComponet t = new GuiPresetComponet(frame);


        ButtonPanel.setBackground(frame.getColorToolBar());

        ToolBar.setBackground(frame.getColorToolBar());

        t.SetIcon(Icon, new ImageIcon(t.ResizeIcon(65, 65, frame.getIcon())));

        t.SetIcon(IconaLente, new ImageIcon(t.ResizeIcon(20, 20, new ImageIcon("src\\main\\resources\\magnifying-glass.png"))));

        BarraDiRicerca.setBackground(frame.getColorToolBar());

        MainPanel.setBackground(frame.getColorBack());

        //SerchBar.setText(" ".repeat(120));

        NameApp.setFont(frame.getFontToolBar());

        NameApp.setForeground(Color.BLACK);

        //SerchBar.setBorder(new LineBorder(Color.BLACK,1));
        SerchBar.setBorder(null);

        SerchBar.setPreferredSize(new Dimension(500, 30));

        SerchBar.setBackground(new Color(199, 111, 91));

        SerchBorder.setBorder(new LineBorder(Color.BLACK, 2));

        SerchBar.setFont(frame.getFontToolBar());

        t.SetIcon(IconMenu, new ImageIcon(t.ResizeIcon(20, 20, new ImageIcon("src\\main\\resources\\dots.png"))));

        NotificheBox.setBackground(frame.getColorToolBar());


        MenuBar = new Menu(frame, Menu, HomePanel, MainPanel);
        ButtonPanel.setBackground(frame.getColorToolBar());
        MenuButton.setBackground(frame.getColorToolBar());
        MenuButton.add(MenuBar);

        t.ToolBarButton(NotificheButton);
        t.SetIcon(IconNotfiche,new ImageIcon(t.ResizeIcon(20, 20, new ImageIcon("src\\main\\resources\\bell.png"))));

        NotificheButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                NotificheBox.setBackground(new Color(199, 111, 91));
                NotificheButton.setBackground(new Color(199, 111, 91));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                NotificheBox.setBackground(frame.getColorToolBar());
                NotificheButton.setBackground(frame.getColorToolBar());
            }

        });

        SerchBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (bool) {
                    bool = false;
                    SerchBar.setText("");
                }

            }
        });

        IconaLente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                super.mouseEntered(e);
                frame.SetNewPanel(new SearchPage(frame, MainPanel, controller, SerchBar.getText()).getPanel(), MainPanel);
            }
        });

        NotificheBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                NotificheBox.setBackground(new Color(199, 111, 91));
                NotificheButton.setBackground(new Color(199, 111, 91));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                NotificheBox.setBackground(frame.getColorToolBar());
                NotificheButton.setBackground(frame.getColorToolBar());
            }

        });

        /*
        IconaLente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.SetNewPanel(new SearchPage(frame, MainPanel,controller, SerchBar.getText()).getPanel(), MainPanel);
            }
        });
        */

    }

    public JPanel getPanel() {
        return MainPanel;
    }



}
