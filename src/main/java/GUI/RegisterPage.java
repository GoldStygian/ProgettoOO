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
    private JPanel ToolBar;
    private JPanel IconBox;
    private JLabel Icon;
    private JLabel NameApp;
    private JPanel GoBack;
    private JPanel InternalBox;
    private JLabel IconBack;
    private JLabel Logo;
    private JPanel Divisore;
    private JPanel Box;

    public RegisterPage(MainJFrame frame, JPanel OldPanel, Controller controller) {

        GenereBox.addItem("M");
        GenereBox.addItem("F");
        GenereBox.setFont(frame.getFontToolBar());
        GuiPresetComponet t = new GuiPresetComponet(frame);

        t.ToolBarButton(BackButton);
        t.SetIcon(Icon, new ImageIcon(t.ResizeIcon(65, 65, frame.getIcon())));
        t.SetIcon(IconBack, new ImageIcon(t.ResizeIcon(20, 20, new ImageIcon("src\\main\\resources\\back.png"))));
        t.SetIcon(Logo, new ImageIcon(t.ResizeIcon(120, 120, frame.getIcon())));
        t.GenericButton(RegisterButton);
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.SetNewPanel(OldPanel, MainPanel);
                //frame.Resize(1400, 700);
            }
        });

        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Message = controller.register(NomeField.getText(), CognomeField.getText(), GenereBox.getSelectedItem(), EmailField.getText(), passwordField.getText());
                if (!Message.equals("<html></html>")) {
                    MessageError.setText(Message);
                } else {
                    frame.SetNewPanel(OldPanel, MainPanel);
                }

            }
        });


    }

    public JPanel getPanel() {
        return MainPanel;
    }

}
