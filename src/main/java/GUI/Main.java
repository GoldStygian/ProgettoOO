package main.java.GUI;

import javax.swing.*;

public class Main {

    private static MainJFrame frame;


    public static void main(String[] args){
       frame = new MainJFrame("Home");

       JPanel loginpage = new LoginPage();


       frame.setContentPane(loginpage);






    }



}
