package main.java.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class MainJFrame extends JFrame {
    private Font FontToolBar;

    private Color ColorToolBar = new Color(128,71,57);

    private ImageIcon Icon = new ImageIcon("C:\\Users\\filix\\IdeaProjects\\ProgettoOO\\src\\main\\resources\\logo2.png");

    public MainJFrame(String Nome, int W, int H){
        super(Nome);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(W, H);
        this.setIconImage(Icon.getImage());
        this.setResizable(false);

        File is = new File("C:\\Users\\filix\\IdeaProjects\\ProgettoOO\\src\\main\\resources\\London History.ttf");
        try {
            FontToolBar = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(35f);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void SetNewPanel(JPanel NewMainPanel, JPanel OldMainPanel){
        this.remove(OldMainPanel);
        this.setContentPane(NewMainPanel);
        this.revalidate();
        this.repaint();
    }

    public void SetPanel(JPanel NewMainPanel){
        this.setContentPane(NewMainPanel);
    }


    public Color getColorToolBar() {
        return ColorToolBar;
    }

    public Font getFontToolBar(){
        return FontToolBar;
    }

    public ImageIcon getIcon(){
        return Icon;
    }

    public void Resize(int W, int H){
        this.setSize(W, H);
    }
}
