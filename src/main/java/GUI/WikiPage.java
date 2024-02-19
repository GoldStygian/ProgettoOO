package main.java.GUI;

import main.java.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WikiPage {

    private JPanel MainPanel;
    private final MainJFrame frame;
    private final JPanel OldPanel;
    private JScrollPane ScrollPanel;
    private JPanel ContentContentPane;
    private JPanel InsertPanel;
    private JButton InsertButton;
    private JTextField PositionField;
    private JTextField TextField;
    private JCheckBox LinkBox;
    private JTextField PageLinkRefFiled;
    private JButton ProponiButton;
    private JLabel LabelPaginaRef;
    private JLabel MessageError;
    private JLabel LoginNedded;
    private JPanel ModPanel;
    private JTextField TestoModField;
    private JButton ModificaButton;
    private JLabel MessageErrorMod;
    private JTextField PaginaLinkRefModField;
    private JLabel ModSelectedLabel;
    private JCheckBox LinkModBox;
    private JLabel LabelPaginaRefMod;
    private JButton BackButton;
    private final Controller controller;
    private final int idPagina;
    HashMap<Integer, ArrayList<String>> Frasi;

    //locali
    int last_key = -1;

    public WikiPage(MainJFrame frame, JPanel OldPanel, Controller controller, int idPagina) {

        this.controller = controller;
        this.frame = frame;
        this.OldPanel = OldPanel;
        this.idPagina = idPagina;

        this.InsertPanel.setVisible(false); //dx panel
        this.PageLinkRefFiled.setVisible(false);
        this.LabelPaginaRef.setVisible(false);
        this.MessageError.setVisible(false);
        this.LoginNedded.setVisible(false);

        this.ModPanel.setVisible(false); //sx panel
        this.PaginaLinkRefModField.setVisible(false);
        this.LabelPaginaRefMod.setVisible(false);

        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(OldPanel, MainPanel);
            }
        });

        InsertButton.addActionListener(new ActionListener() {
            boolean clicked = false;
            @Override
            public void actionPerformed(ActionEvent e) {

                if(controller.isUserLogged()){
                    if (clicked == false){
                        InsertPanel.setVisible(true);
                        clicked=true;
                    }else{
                        InsertPanel.setVisible(false);
                        clicked=false;
                    }
                }else{
                    LoginNedded.setText("Devi effettuare l'accesso per poter inserire");
                    LoginNedded.setVisible(true);
                }
            }
        });

        LinkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    PageLinkRefFiled.setVisible(true);
                    LabelPaginaRef.setVisible(true);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    PageLinkRefFiled.setVisible(false);
                    LabelPaginaRef.setVisible(false);
                }
            }
        });

        ProponiButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MessageError.setText(controller.ProponiInserimento(idPagina, PositionField.getText(), TextField.getText(), LinkBox.isSelected(), PageLinkRefFiled.getText()));
                if (MessageError.getText().equals("<html>Richiesta avvenuta con successo<br></html>")) MessageError.setForeground(Color.green);
                else MessageError.setForeground(Color.red);
                MessageError.setVisible(true);
            }
        });

        LinkModBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    PaginaLinkRefModField.setVisible(true);
                    LabelPaginaRefMod.setVisible(true);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    PaginaLinkRefModField.setVisible(false);
                    LabelPaginaRefMod.setVisible(false);
                }
            }
        });

        ModificaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MessageErrorMod.setText(controller.ProponiModifica(idPagina, last_key,TestoModField.getText(), LinkModBox.isSelected(), PaginaLinkRefModField.getText()));
                if (MessageErrorMod.getText().equals("<html>Richiesta avvenuta con successo<br></html>")) MessageErrorMod.setForeground(Color.green);
                else MessageErrorMod.setForeground(Color.red);
                MessageErrorMod.setVisible(true);
            }
        });

    }

    public JPanel getPanel() {
        return MainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        this.Frasi = controller.getWikiPage(idPagina);

        ContentContentPane = new JPanel();
        ContentContentPane.setLayout(new BoxLayout(ContentContentPane, BoxLayout.Y_AXIS));
        ScrollPanel = new JScrollPane(ContentContentPane);

        if (Frasi != null) {
            ActionListener listener = new ActionListener() {
                boolean clicked = false;
                //int last_key;
                @Override
                public void actionPerformed(ActionEvent e) {

                    //String buttonText = ((JButton) e.getSource()).getText();
                    if(controller.isUserLogged()){
                        if (clicked == false || last_key!=Integer.parseInt(e.getActionCommand())){
                            ModSelectedLabel.setText("Frase selezionata: "+e.getActionCommand());
                            ModPanel.setVisible(true);
                            clicked=true;
                            last_key=Integer.parseInt(e.getActionCommand());
                        }else{
                            ModPanel.setVisible(false);
                            clicked=false;
                        }
                    }else{
                        LoginNedded.setText("Devi effettuare l'accesso per poter modificare");
                        LoginNedded.setVisible(true);
                    }
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