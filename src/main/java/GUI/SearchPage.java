package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SearchPage {
    private JPanel MainPanel;
    private final MainJFrame frame;
    private final JPanel OldPanel;
    private JScrollPane ScrollPanel;
    private JPanel ContentContentPane;
    private JPanel ToolBar;
    private JPanel IconBox;
    private JLabel Icon;
    private JLabel NameApp;
    private JPanel GoBack;
    private JPanel InternalBox;
    private JLabel IconBack;
    private JButton Backbutton;
    private final Controller controller;
    private final String ricerca;
    private ArrayList<ArrayList<String>> DataPages;
    private ActionListener listener;

    public SearchPage(MainJFrame frame, JPanel OldPanel, Controller controller, String ricerca) {

        this.controller = controller;
        this.ricerca = ricerca;
        this.frame = frame;
        this.OldPanel = OldPanel;

        GuiPresetComponet t = new GuiPresetComponet(frame);

        t.ToolBarButton(Backbutton);

        ToolBar.setBackground(frame.getColorToolBar());

        MainPanel.setBackground(frame.getColorBack());


        t.SetIcon(Icon, new ImageIcon(t.ResizeIcon(65, 65, frame.getIcon())));

        t.SetIcon(IconBack, new ImageIcon(t.ResizeIcon(20, 20, new ImageIcon("src\\main\\resources\\back.png"))));

        NameApp.setFont(frame.getFontToolBar());

        NameApp.setForeground(Color.BLACK);

        Backbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Backbutton.setBackground(new Color(199, 111, 91));
                InternalBox.setBackground(new Color(199, 111, 91));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Backbutton.setBackground(frame.getColorToolBar());
                InternalBox.setBackground(frame.getColorToolBar());

            }
        });

        Backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(OldPanel, MainPanel);
                frame.Resize(1400, 700);
            }
        });



    }

    public JPanel getPanel() {
        return MainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        this.DataPages = controller.searchPages(ricerca);

        ContentContentPane = new JPanel();
        ContentContentPane.setLayout(new BoxLayout(ContentContentPane, BoxLayout.Y_AXIS));
        ScrollPanel = new JScrollPane(ContentContentPane);

        if (DataPages != null) {
            /*
            this.listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int buttonHidden = Integer.parseInt(((JButton) e.getSource()).getActionCommand());
                    //System.out.println("Hai premuto il link con id: " + e.getActionCommand());
                    frame.SetNewPanel(new WikiPage(frame, MainPanel, controller, buttonHidden).getPanel(), MainPanel);
                }
            };


               */
            for (ArrayList<String> innerList : DataPages) {
                /*
                //Titolo[0] ID_pagina[3] NomeAutore[1] ultima modifica[2]
                JButton button = new JButton(innerList.get(0));
                button.setActionCommand(innerList.get(3));
                JLabel label = new JLabel(innerList.get(1) + innerList.get(2));
                button.addActionListener(listener);

                ContentContentPane.add(button);
                ContentContentPane.add(label);
                */
                ContentContentPane.add(new SearchPanelPage(frame,controller,MainPanel,innerList.get(0),innerList.get(3),innerList.get(1),innerList.get(2)));
            }
        } else {
            JLabel label = new JLabel("Nessuna pagina trovata");

            ContentContentPane.add(label);
        }
    }

}
