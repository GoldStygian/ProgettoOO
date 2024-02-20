package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.util.ArrayList;

public class FrameRichieste extends JFrame {

    private JPanel ToolBar;
    private JPanel BarIcon;
    private JLabel Icon;
    private JLabel NameApp;
    private JPanel BarraDiRicerca;
    private JPanel ButtonPanel;
    private JPanel RefreshBox;
    private JLabel IconRefresh;
    private JButton RefreshButton;
    private JPanel MainJPanel;
    private JScrollPane MainScrollPane;
    private JPanel Modifiche;

    private ArrayList<PanelRichieste> ModificheOnPanel = new ArrayList<>();

    public FrameRichieste(String Nome, MainJFrame frame, Controller controller){
        super(Nome);
        JFrame f = this;
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.pack();
        this.setVisible(false);
        this.add(MainJPanel);
        this.setSize(800, 950);
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

        Modifiche.setBackground(frame.getColorBack());
        MainScrollPane.setBackground(frame.getColorBack());
        MainJPanel.setBackground(frame.getColorBack());

        LoadModifiche(frame, controller);

        RefreshBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                RefreshBox.setBackground(new Color(199, 111, 91));
                RefreshButton.setBackground(new Color(199, 111, 91));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                RefreshBox.setBackground(frame.getColorToolBar());
                RefreshButton.setBackground(frame.getColorToolBar());
            }

        });

        RefreshButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                RefreshBox.setBackground(new Color(199, 111, 91));
                RefreshButton.setBackground(new Color(199, 111, 91));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                RefreshBox.setBackground(frame.getColorToolBar());
                RefreshButton.setBackground(frame.getColorToolBar());
            }

        });

    }

    public void LoadModifiche(MainJFrame frame, Controller controller){

        controller.loadModifiche();
        ArrayList<ArrayList> s = controller.GetModifiche();
        System.out.print(s);
        System.out.printf("%d", s.get(0).size());
        int NumNot = s.get(0).size();
        for (int i = 0 ; i < NumNot; i++) {

            GridBagConstraints gbc;
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = i;
            PanelRichieste toadd = new PanelRichieste(frame,controller,(int) s.get(0).get(i), (Timestamp) s.get(10).get(i), (Timestamp) s.get(1).get(i), (String) s.get(2).get(i), (Boolean) s.get(3).get(i), (Boolean) s.get(4).get(i), (Boolean) s.get(5).get(i), (Boolean) s.get(6).get(i), (int) s.get(7).get(i), (int) s.get(8).get(i),(String) s.get(9).get(i),(String) s.get(11).get(i),(String) s.get(12).get(i),(String) s.get(13).get(i));
            ModificheOnPanel.add(toadd);
            Modifiche.add(toadd,gbc);

        }

    }

}
