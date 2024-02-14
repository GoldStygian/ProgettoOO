package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class HomeAutore {
    private JPanel MainPanel;
    private JPanel ToolBar;
    private MainJFrame frame;

    public HomeAutore(MainJFrame frame, Controller controller) {
        this.frame = frame;

        MainPanel.setBackground(frame.getColorBack());

    }

    public JPanel getPanel() {
        return MainPanel;
    }

    private void createUIComponents() {

        ToolBar = new JPanel(new GridBagLayout());
        //ToolBar.add(new ToolBarBox(frame));
        ToolBar.setBackground(frame.getColorToolBar());
    }

}
