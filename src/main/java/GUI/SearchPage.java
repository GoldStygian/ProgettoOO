package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchPage {
    private JPanel MainPanel;
    private JScrollPane ScrollPanel;
    private JPanel ContentContentPane;

    private Controller controller;
    private String ricerca;

    public SearchPage(MainJFrame frame, JPanel OldPanel, Controller controller, String ricerca) {

        this.controller=controller;
        this.ricerca=ricerca;

    }

    public JPanel getPanel() {
        return MainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        ArrayList<ArrayList<String>> DataPages = controller.searchPages(ricerca);

        ContentContentPane = new JPanel();
        ContentContentPane.setLayout(new BoxLayout(ContentContentPane, BoxLayout.Y_AXIS));
        ScrollPanel = new JScrollPane(ContentContentPane);

        for (ArrayList<String> innerList : DataPages) {

            JLabel label = new JLabel(innerList.get(0));
            JLabel button = new JLabel(innerList.get(1)+innerList.get(2));

            ContentContentPane.add(label);
            ContentContentPane.add(button);

        }
    }
}
