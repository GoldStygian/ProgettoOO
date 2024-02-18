package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class NotificheFrame extends JFrame {

    private JPanel MainJPanel;
    private JPanel Notifiche;
    private JScrollPane MainScrollPane;
    private JPanel ToolBar;
    private JPanel BarIcon;
    private JLabel Icon;
    private JLabel NameApp;
    private JPanel BarraDiRicerca;
    private JPanel ButtonPanel;
    private JPanel RefreshBox;
    private JLabel IconRefresh;
    private JButton RefreshButton;


    public NotificheFrame(String Nome, MainJFrame frame, Controller controller) {

        super(Nome);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.pack();
        this.setVisible(false);
        this.add(MainJPanel);
        this.setSize(600, 800);
        this.setIconImage(frame.getIconImage());
        this.setResizable(false);
        //this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

        GuiPresetComponet t = new GuiPresetComponet(frame);
        ButtonPanel.setBackground(frame.getColorToolBar());

        ToolBar.setBackground(frame.getColorToolBar());

        t.SetIcon(Icon, new ImageIcon(t.ResizeIcon(65, 65, frame.getIcon())));

        t.SetIcon(IconRefresh, new ImageIcon(t.ResizeIcon(30, 30, new ImageIcon("src/main/resources/refresh.png"))));

        BarraDiRicerca.setBackground(frame.getColorToolBar());

        NameApp.setFont(frame.getFontToolBar());

        NameApp.setForeground(Color.BLACK);

        RefreshBox.setBackground(frame.getColorToolBar());
        t.ToolBarButton(RefreshButton);

        MainScrollPane.setBorder(null);

        Notifiche.setBackground(frame.getColorBack());
        MainScrollPane.setBackground(frame.getColorBack());
        MainJPanel.setBackground(frame.getColorBack());

        try {
            controller.LoadNotifiche();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        ArrayList<ArrayList> s = controller.GetNotifiche();
        System.out.print(s);
        System.out.printf("%d", s.get(0).size());
        for (int i = 0 ; i < s.get(0).size(); i++) {

            GridBagConstraints gbc;
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = i;
            Notifiche.add(new NotifichePanel(frame,controller, (int) s.get(0).get(i), (Timestamp) s.get(1).get(i), (String) s.get(2).get(i), (Boolean) s.get(3).get(i), (Boolean) s.get(4).get(i), (Boolean) s.get(5).get(i), (Boolean) s.get(6).get(i), (int) s.get(7).get(i), (String) s.get(9).get(i)),gbc);

        }
        /*
        int i = 0;
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        Notifiche.add(new NotifichePanel(frame, (int) s.get(0).get(i), (Timestamp) s.get(1).get(i), (String) s.get(2).get(i), (Boolean) s.get(3).get(i), (Boolean) s.get(4).get(i), (Boolean) s.get(5).get(i), (Boolean) s.get(6).get(i), (int) s.get(7).get(i), (String) s.get(9).get(i)),gbc);


        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        Notifiche.add(new NotifichePanel(frame, (int) s.get(0).get(i), (Timestamp) s.get(1).get(i), (String) s.get(2).get(i), (Boolean) s.get(3).get(i), (Boolean) s.get(4).get(i), (Boolean) s.get(5).get(i), (Boolean) s.get(6).get(i), (int) s.get(7).get(i), (String) s.get(9).get(i)),gbc);


        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        Notifiche.add(new NotifichePanel(frame, (int) s.get(0).get(i), (Timestamp) s.get(1).get(i), (String) s.get(2).get(i), (Boolean) s.get(3).get(i), (Boolean) s.get(4).get(i), (Boolean) s.get(5).get(i), (Boolean) s.get(6).get(i), (int) s.get(7).get(i), (String) s.get(9).get(i)),gbc);


        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        Notifiche.add(new NotifichePanel(frame, (int) s.get(0).get(i), (Timestamp) s.get(1).get(i), (String) s.get(2).get(i), (Boolean) s.get(3).get(i), (Boolean) s.get(4).get(i), (Boolean) s.get(5).get(i), (Boolean) s.get(6).get(i), (int) s.get(7).get(i), (String) s.get(9).get(i)),gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        Notifiche.add(new NotifichePanel(frame, (int) s.get(0).get(i), (Timestamp) s.get(1).get(i), (String) s.get(2).get(i), (Boolean) s.get(3).get(i), (Boolean) s.get(4).get(i), (Boolean) s.get(5).get(i), (Boolean) s.get(6).get(i), (int) s.get(7).get(i), (String) s.get(9).get(i)),gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        Notifiche.add(new NotifichePanel(frame, (int) s.get(0).get(i), (Timestamp) s.get(1).get(i), (String) s.get(2).get(i), (Boolean) s.get(3).get(i), (Boolean) s.get(4).get(i), (Boolean) s.get(5).get(i), (Boolean) s.get(6).get(i), (int) s.get(7).get(i), (String) s.get(9).get(i)),gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        Notifiche.add(new NotifichePanel(frame, (int) s.get(0).get(i), (Timestamp) s.get(1).get(i), (String) s.get(2).get(i), (Boolean) s.get(3).get(i), (Boolean) s.get(4).get(i), (Boolean) s.get(5).get(i), (Boolean) s.get(6).get(i), (int) s.get(7).get(i), (String) s.get(9).get(i)),gbc);

         */

    }


}
