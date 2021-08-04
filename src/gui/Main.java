package gui;

import pwlogic.*;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        Controller controller = new Controller();
        Gui gui = new Gui(controller);
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Gui frame = new Gui(controller);
                frame.setVisible(true);
            }
        });


    }

}
