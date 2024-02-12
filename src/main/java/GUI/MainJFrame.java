package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class MainJFrame extends JFrame {
    private Font FontToolBar;

    public MainJFrame(String Nome){
        super(Nome);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(400, 200);
        File is = new File("C:\\Users\\filix\\IdeaProjects\\ProgettoOO\\src\\main\\resources\\Flipahaus-V2.ttf");
        try {
            FontToolBar = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(44f);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void SetNewPanel(JPanel NewMainPanel, JPanel OldMainPanel){
        this.remove(OldMainPanel);
        //this.add(NewMainPanel);
        this.setContentPane(NewMainPanel);
        this.revalidate();
        this.repaint();
    }

    public void SetPanel(JPanel NewMainPanel){
        //this.add(NewMainPanel);
        this.setContentPane(NewMainPanel);
    }


    public Font getFont(){
        return FontToolBar;
    }
}
