package main.java.GUI;

public class Main {

    private static MainJFrame frame;

    public static void main(String[] args){

       frame = new MainJFrame("Home");
       frame.SetPanel(new Home(frame).getPanel());

        //deallocare i panel

    }

}
