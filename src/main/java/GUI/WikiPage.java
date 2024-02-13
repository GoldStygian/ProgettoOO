package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;

public class WikiPage {

    private JPanel MainPanel;

    public WikiPage(MainJFrame frame, JPanel OldPanel, Controller controller, String titolo){

        controller.getWikiPage(titolo);

    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
