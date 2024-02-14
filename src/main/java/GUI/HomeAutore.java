package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    private JMenuBar MenuBox;
    private JMenu Menu;

    private MainJFrame frame;
    private Boolean bool = true;

    public HomeAutore(MainJFrame frame, Controller controller, JPanel oldPanel) {
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

        MenuBox = new Menu(frame,Menu ,oldPanel,MainPanel);
        t.SetIcon(IconMenu,new ImageIcon(t.ResizeIcon(20, 20, new ImageIcon("src\\main\\resources\\dots.png"))));

        MenuButton.add(MenuBox);
        MenuButton.setBackground(frame.getColorToolBar());

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
