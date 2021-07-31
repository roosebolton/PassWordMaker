package gui;

import javax.swing.*;
import java.awt.*;

/**
 * A gui class that presents an interface to the user for generating a password
 **/
public class Gui extends JFrame {

    //attributes for layout

    //main Pane
    private Container pane;

    //Main Panel
    private JPanel mainPanel = new JPanel(new GridLayout(3,1,2,2));
    //Three main parts of Main Panel in order
    private JPanel north = new JPanel(new GridLayout(2,0,0,0));
    private JPanel middle = new JPanel(new GridLayout(3,1,0,0));
    private JPanel south = new JPanel(new GridLayout(1,3,0,0));

    ///////////////////////////////////////North///////////////////////////////////////////////

    //Three main parts of north Panel
    private JPanel northNorth = new JPanel();
    private JPanel northSouth = new JPanel();

    //JLabel that goes in northNorth Panel
    private JLabel titleLabel = new JLabel("Password Generator");

    //Button for generating password
    private JButton generate = new JButton("Generate Password");

    /////////////////////////////////////End of North//////////////////////////////////////////

    ////////////////////////////////////////Middle/////////////////////////////////////////////

    private JPanel middleNorth = new JPanel(new GridLayout(1,3,0,0));
    private JPanel middleMiddle = new JPanel(new GridLayout(1,3,0,0));
    private JPanel middleSouth = new JPanel(new GridLayout(1,3,0,0));

    //middleNorthMiddle contains number of charachters label
    private JPanel middleNorthWest = new JPanel();
    private JPanel middleNorthMiddle = new JPanel();
    private JPanel middleNorthEast = new JPanel();

    //numberOfCharactersLabel goes in middleNorthMiddle
    private JLabel numberOfCharactersLabel = new JLabel("Number of Characters");

    //middlemiddle contains spinner
    private JPanel middleMiddleWest = new JPanel();
    private JPanel middleMiddleMiddle = new JPanel();
    private JPanel middleMiddleEast = new JPanel();

    //Spinnermodel to add to spinner
    private SpinnerModel spinnerModel =
            new SpinnerNumberModel(8, //initial value
                    8, //min
                    1000, //max
                    1);                //step

    //Spinner to add to middleMiddleMiddle
    private JSpinner spinner = new JSpinner(spinnerModel);

    //middleSouth contains JLabel with generated password
    private JPanel middleSouthWest = new JPanel();
    private JPanel middleSouthMiddle = new JPanel(new GridLayout(2,1,0,0));
    private JPanel middleSouthEast = new JPanel();

    private JPanel middleMiddleSouthMiddleNorth = new JPanel();
    private JPanel middleMiddleSouthMiddleSouth = new JPanel();

    //Label for generated password title in middleMiddleSouthMiddleNorth
    private JLabel passwordTitle = new JLabel("Generated Password");

    //Label that will be used to display generated password in middleMiddleSouthMiddleSouth
    private JLabel password = new JLabel("");

    //////////////////////////////////////End of Middle////////////////////////////////////////


    /////////////////////////////////////////South/////////////////////////////////////////////

    //four main parts of south Panel
    private JPanel southWest = new JPanel();
    private JPanel southMiddle = new JPanel(new GridLayout(1,1,0,0));
    private JPanel southEast = new JPanel();

    //southMiddle contains checkboxes
    private JPanel southMiddleNorth = new JPanel();

    //Checkboxes will be placed in southMiddle
    private ButtonGroup optionGroup = new ButtonGroup();
    private JCheckBox noSpecCharacters = new JCheckBox("No Special Characters");
    private JCheckBox noNumber = new JCheckBox("No Numbers");
    private JCheckBox noAmbigious = new JCheckBox("No Ambigious Characters");


    //////////////////////////////////////End of South////////////////////////////////////////


    //////////////////////////////////End of attributes///////////////////////////////////////


    /////////////////////////////////////Methods//////////////////////////////////////////////
    /**
     *Constructor
     **/
    public Gui(){
        super();
        initialize();
    }

    /**
     *Initializes gui for proper presentation upon start
     **/
    private void initialize(){
        setTitle("Password Generator");
        this.setSize(600,400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dim.width-600)/2,(dim.height-400)/2);
        pane = getContentPane();
        pane.setLayout(new GridLayout(1,1,2,2));
        pane.add(mainPanel);

        mainPanel.add(north);
        mainPanel.add(middle);
        mainPanel.add(south);

        //northside
        north.add(northNorth);
        north.add(northSouth);

        //northNorth
        northNorth.add(titleLabel);

        //northSouth
        northSouth.add(generate);

        //middleside
        middle.add(middleNorth);
        middle.add(middleMiddle);
        middle.add(middleSouth);

        //middleNorth
        middleNorth.add(middleNorthWest);
        middleNorth.add(middleNorthMiddle);
        middleNorth.add(middleNorthEast);

        middleNorthMiddle.add(numberOfCharactersLabel);

        //middleMiddle
        middleMiddle.add(middleMiddleWest);
        middleMiddle.add(middleMiddleMiddle);
        middleMiddle.add(middleMiddleEast);

        middleMiddle.add(middleMiddleWest);
        middleMiddle.add(middleMiddleMiddle);
        middleMiddle.add(middleMiddleEast);

        middleMiddleMiddle.add(spinner);

        //middleSouth
        middleSouth.add(middleSouthEast);
        middleSouth.add(middleSouthMiddle);
        middleSouth.add(middleSouthWest);

        middleSouthMiddle.add(middleMiddleSouthMiddleNorth);
        middleSouthMiddle.add(middleMiddleSouthMiddleSouth);

        middleMiddleSouthMiddleNorth.add(passwordTitle);
        middleMiddleSouthMiddleSouth.add(password);

        //Southside
        south.add(southWest);
        south.add(southMiddle);
        south.add(southEast);

        //southMiddle contains checkboxes
        optionGroup.add(noSpecCharacters);
        optionGroup.add(noNumber);
        optionGroup.add(noAmbigious);

        southMiddle.add(southMiddleNorth);

        southMiddleNorth.add(noSpecCharacters);
        southMiddleNorth.add(noNumber);
        southMiddleNorth.add(noAmbigious);

    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
          public void run(){
            Gui frame = new Gui();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
          }
        });
    }
}
