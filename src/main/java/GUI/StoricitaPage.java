package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StoricitaPage {

    private JPanel MainPanel;
    private JScrollPane ScrollPanel;
    private JPanel Storicita;
    private JPanel ContentScrollPane;
    private final Controller controller;

    public StoricitaPage(JFrame frame, JPanel OldPanel, Controller controller){

        this.controller = controller;

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

                //add listner

                ContentScrollPane.add(pageButton);

            }
        }

    }
}
