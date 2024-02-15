package main.java.GUI;

import main.java.Controller.Controller;
import main.java.Model.Frase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WikiPage {

    private JPanel MainPanel;
    private final MainJFrame frame;
    private final JPanel OldPanel;
    private JScrollPane ScrollPanel;
    private JPanel ContentContentPane;
    private final Controller controller;
    private final int idPagina;
    HashMap<Integer, ArrayList<String>> Frasi;

    public WikiPage(MainJFrame frame, JPanel OldPanel, Controller controller, int idPagina) {

        this.controller = controller;
        this.frame = frame;
        this.OldPanel = OldPanel;
        this.idPagina= idPagina;

    }

    public JPanel getPanel() {
        return MainPanel;
    }

    private void createUIComponents() throws SQLException {
        // TODO: place custom component creation code here

        this.Frasi =  controller.getWikiPage(idPagina);

        ContentContentPane = new JPanel();
        ContentContentPane.setLayout(new BoxLayout(ContentContentPane, BoxLayout.Y_AXIS));
        ScrollPanel = new JScrollPane(ContentContentPane);

        if (Frasi != null) {
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String buttonText = ((JButton) e.getSource()).getText();
                    System.out.println("Hai premuto la frase: " + buttonText);
                }
            };

            for (Map.Entry<Integer, ArrayList<String>> entry : Frasi.entrySet()) {

                JButton button = new JButton(String.valueOf(entry.getKey()));
                JLabel label = new JLabel(entry.getValue().get(2));

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
