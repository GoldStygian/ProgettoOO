package main.java.GUI;

import javax.swing.*;

public class Main {

    private static MainJFrame frame;


    public static void main(String[] args){
       frame = new MainJFrame("Home");

       JPanel HomePanel = new Home();

       HomePanel.setVisible(true);
       frame.setContentPane(HomePanel);

       HomePanel.setVisible(false);
       JPanel loginpage = new LoginPage();

       loginpage.setVisible(true);
       frame.setContentPane(loginpage);




    }



}
