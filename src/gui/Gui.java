package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pwlogic.Controller;

/**
 * A gui class that presents an interface to the user for generating a password
 * @author roosebolton
 **/
public class Gui extends JFrame{

    //Non layout attributes
    Controller controller;

    //attributes for layout

    //main Pane
    private Container pane;

    //Main Panel
    private JPanel mainPanel = new JPanel(new GridLayout(3,1,2,2));

    //Three main parts of Main Panel in order
    private JPanel north = new JPanel(new GridLayout(2,0,0,0));
    private JPanel middle = new JPanel(new GridLayout(2,1,0,0));
    private JPanel south = new JPanel(new GridLayout(1,3,0,0));

    ///////////////////////////////////////North///////////////////////////////////////////////
    //Three main parts of north Panel
    private JPanel northNorth = new JPanel();
    private JPanel northSouth = new JPanel();

    //JLabel that goes in northNorth Panel
    private JLabel titleLabel = new JLabel("Password Generator");

    //JButton for generating password that goes in northSouth Panel
    private JButton generate = new JButton("Generate Password");
    /////////////////////////////////////End of North//////////////////////////////////////////

    ////////////////////////////////////////Middle/////////////////////////////////////////////
    private JPanel middleNorth = new JPanel(new GridLayout(1,3,0,0));
    private JPanel middleSouth = new JPanel(new GridLayout(2,1,0,0));

    //NumberOfCharactersLabel goes in middleNorthMiddle
    private JLabel numberOfCharactersLabel = new JLabel("Number of Characters");

    //MiddleNorthMiddle contains other components
    private JPanel middleNorthWest = new JPanel();
    private JPanel middleNorthMiddle = new JPanel();
    private JPanel middleNorthEast = new JPanel();

    //Spinnermodel to add to spinner
    private SpinnerModel spinnerModel = new SpinnerNumberModel(8,8, Integer.MAX_VALUE, 1);
    //JSpinner to add to middleNorthMiddle
    private JSpinner spinner = new JSpinner(spinnerModel);

    private JPanel middleSouthNorth = new JPanel(new GridLayout(1,1,2,2));
    //JLabel for generated password title in middleSouthNorth
    private JLabel passwordTitle = new JLabel("Generated Password");

    private JPanel middleSouthSouth = new JPanel();
    //JTextPane that will be used to display generated password in middleSouthSouth
    private JTextPane password = new JTextPane();
    //////////////////////////////////////End of Middle////////////////////////////////////////

    /////////////////////////////////////////South/////////////////////////////////////////////
    //four main parts of south Panel
    private JPanel southWest = new JPanel();
    private JPanel southMiddle = new JPanel(new GridLayout(1,1,0,0));
    private JPanel southEast = new JPanel();

    //southMiddle contains checkboxes
    private JPanel southMiddleMain = new JPanel();

    //Checkboxes will be placed in southMiddle
    private JCheckBox noSpecCharacters = new JCheckBox("No Special Characters");
    private JCheckBox noNumber = new JCheckBox("No Numbers");
    private JCheckBox noAmbigious = new JCheckBox("No Ambigious Characters");
    //////////////////////////////////////End of South////////////////////////////////////////
    //////////////////////////////////End of attributes///////////////////////////////////////


    /////////////////////////////////////Methods//////////////////////////////////////////////
    /**
     *Constructor
     **/
    public Gui(Controller controller){
        super();
        initialize();
        this.controller = controller;
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
        titleLabel.setFont(new Font("Helvetica", Font.BOLD,30));
        northNorth.add(titleLabel);

        //northSouth

        //add Listener to generate JButton
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                  int pwLngth = (int) spinner.getValue();
                  boolean noSpec = noSpecCharacters.isSelected();
                  boolean noNum = noNumber.isSelected();
                  boolean noAmb = noAmbigious.isSelected();
                  password.setText("");
                  String result = controller.getPassword(pwLngth,noSpec,noNum,noAmb);
                  password.setText(result);
            }
        });

        //add button
        northSouth.add(generate);

        //middleside
        middle.add(middleNorth);
        middle.add(middleSouth);

        //middleNorth
        middleNorth.add(middleNorthWest);
        middleNorth.add(middleNorthMiddle);
        middleNorth.add(middleNorthEast);

        middleNorthMiddle.add(numberOfCharactersLabel);
        middleNorthMiddle.add(spinner);

        //middleSouth
        middleSouth.add(middleSouthNorth);
        middleSouth.add(middleSouthSouth);

        middleSouthNorth.add(passwordTitle);
        passwordTitle.setHorizontalAlignment(JLabel.CENTER);

        password.setEditable(false);
        middleSouthSouth.add(password);
        middleSouthSouth.setBackground(Color.WHITE);

        //Southside
        south.add(southWest);
        south.add(southMiddle);
        south.add(southEast);

        southMiddle.add(southMiddleMain);

        southMiddleMain.add(noSpecCharacters);
        southMiddleMain.add(noNumber);
        southMiddleMain.add(noAmbigious);

    }



}
