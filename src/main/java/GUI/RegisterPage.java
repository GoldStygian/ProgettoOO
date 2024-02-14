package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.ErrorManager;

public class RegisterPage {

    private JPanel MainPanel;
    private JButton BackButton;
    private JTextField EmailField;
    private JPasswordField passwordField;
    private JComboBox GenereBox;
    private JTextField NomeField;
    private JTextField CognomeField;
    private JButton RegisterButton;
    private JLabel MessageError;

    public RegisterPage(MainJFrame frame, JPanel OldPanel, Controller controller) {
        MessageError.setVisible(false);
        GenereBox.addItem("M");
        GenereBox.addItem("F");

        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(OldPanel, MainPanel);
                frame.Resize(1400, 700);
            }
        });

        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("code" + controller.register(NomeField.getText(), CognomeField.getText(), GenereBox.getSelectedItem(), EmailField.getText(), passwordField.getText()));
            }
        });

    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
