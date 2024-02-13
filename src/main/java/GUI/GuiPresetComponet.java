package main.java.GUI;

import javax.swing.*;
import java.awt.*;

public class GuiPresetComponet {

    private MainJFrame frame;
    public GuiPresetComponet(MainJFrame frame){
        this.frame = frame;
    }

    public void ToolBarButton(JButton Button){
        Button.setFont(frame.getFontToolBar());

        Button.setBackground(frame.getColorToolBar());

        Button.setBorderPainted(false);

        Button.setForeground(Color.BLACK);

    }

    public Image ResizeIcon(int W, int H, ImageIcon i){
        Image ResizeImage = i.getImage().getScaledInstance(W,H, java.awt.Image.SCALE_SMOOTH);
        return ResizeImage;
    }

    public void SetIcon(JLabel j, ImageIcon i){
        j.setIcon(i);
    }


}
