package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreaPagina {
    private JButton BackButton;
    private JTextField titoloTextField;
    private JTextField fraseTextField;
    private JButton CreateButton;
    private JPanel MainPanel;
    private JCheckBox checkBox1;
    private JTextField textField1;

    public CreaPagina(MainJFrame frame, JPanel OldPanel, Controller controller){

        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(OldPanel, MainPanel);
                frame.Resize(1400, 700);
            }
        });

        CreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.creaPagina(titoloTextField.getText(), fraseTextField.getText());
            }
        });

    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
