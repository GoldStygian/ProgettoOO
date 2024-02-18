package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CreaPagina {
    private JButton BackButton;
    private JTextField titoloTextField;
    private JTextField fraseTextField;
    private JButton CreateButton;
    private JPanel MainPanel;
    private JCheckBox linkCheckBox;
    private JTextField PaginaLinkRef;
    private JLabel LabelPaginaLinkRef;

    public CreaPagina(MainJFrame frame, JPanel OldPanel, Controller controller){

        PaginaLinkRef.setVisible(false);
        LabelPaginaLinkRef.setVisible(false);

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
                controller.creaPagina(titoloTextField.getText(), fraseTextField.getText(), linkCheckBox.isSelected(), PaginaLinkRef.getText());
            }
        });

        linkCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    PaginaLinkRef.setVisible(true);
                    LabelPaginaLinkRef.setVisible(true);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    PaginaLinkRef.setVisible(false);
                    LabelPaginaLinkRef.setVisible(false);
                }
            }
        });

    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
