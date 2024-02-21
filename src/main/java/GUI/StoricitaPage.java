package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class StoricitaPage {

    private JPanel MainPanel;
    private JScrollPane ScrollPanel;
    private JPanel Storicita;
    private JPanel ContentScrollPane;
    private JPanel ToolBar;
    private JPanel IconBox;
    private JLabel Icon;
    private JLabel NameApp;
    private JPanel GoBack;
    private JPanel InternalBox;
    private JLabel IconBack;
    private JButton Backbutton;
    private final Controller controller;
    MainJFrame frame;

    public StoricitaPage(MainJFrame frame, JPanel OldPanel, Controller controller){

        this.frame = frame;
        this.controller = controller;
        GuiPresetComponet t = new GuiPresetComponet(frame);
        NameApp.setFont(frame.getFontToolBar());
        t.SetIcon(Icon, new ImageIcon(t.ResizeIcon(65, 65, frame.getIcon())));

        t.SetIcon(IconBack, new ImageIcon(t.ResizeIcon(20, 20, new ImageIcon("src\\main\\resources\\back.png"))));

        t.ToolBarButton(Backbutton);

        NameApp.setForeground(Color.BLACK);

        ScrollPanel.setBorder(null);


        Backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(OldPanel, MainPanel);
                frame.Resize(1400, 700);
            }
        });

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


        InternalBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                InternalBox.setBackground(new Color(199, 111, 91));
                Backbutton.setBackground(new Color(199, 111, 91));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                InternalBox.setBackground(frame.getColorToolBar());
                Backbutton.setBackground(frame.getColorToolBar());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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

        ContentScrollPane = new JPanel();

        ArrayList<ArrayList<String>> pages = controller.getMyPage();

        if(pages!=null){
            for (ArrayList<String> page : pages){

                JButton pageButton = new JButton(page.get(1));
                pageButton.setActionCommand(page.get(0));
                pageButton.setBorder(null);
                pageButton.setFont(frame.getFontToolBarLower());
                pageButton.setBackground(frame.getColorBack());
                pageButton.setForeground(new Color(0, 0, 0));
                pageButton.addMouseMotionListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        pageButton.setBackground(new Color(199, 111, 91));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        pageButton.setBackground(frame.getColorToolBar());
                    }

                });

                //add listner

                ContentScrollPane.add(pageButton);

            }
        }

    }
}
