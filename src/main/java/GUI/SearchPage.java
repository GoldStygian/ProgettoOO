package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchPage {
    private JPanel MainPanel;
    private final MainJFrame frame;
    private final JPanel OldPanel;
    private JScrollPane ScrollPanel;
    private JPanel ContentContentPane;
    private final Controller controller;
    private final String ricerca;
    private ArrayList<ArrayList<String>> DataPages;
    private ActionListener listener;

    public SearchPage(MainJFrame frame, JPanel OldPanel, Controller controller, String ricerca) {

        this.controller = controller;
        this.ricerca = ricerca;
        this.frame = frame;
        this.OldPanel = OldPanel;

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
            this.listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    int buttonHidden = Integer.parseInt(((JButton) e.getSource()).getActionCommand());
                    System.out.println("Hai premuto il link con id: " + e.getActionCommand());
                    frame.SetNewPanel(new WikiPage(frame, MainPanel, controller, buttonHidden).getPanel(), MainPanel);
                }
            };

            for (ArrayList<String> innerList : DataPages) {

                JButton button = new JButton(innerList.get(0));
                button.setActionCommand(innerList.get(3));
                JLabel label = new JLabel(innerList.get(1) + innerList.get(2));
                button.addActionListener(listener);

                ContentContentPane.add(button);
                ContentContentPane.add(label);

            }
        } else {
            JLabel label = new JLabel("Nessuna pagina trovata");

            ContentContentPane.add(label);
        }
    }

}
