import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MainGUI extends JFrame{
  private int winWidth  = 525;
  private int winHeight = winWidth - (winWidth / 3);
  private SpringLayout springLayout, inputPanelLayout, optionsPanelLayout, resultsLayout;
  private JTextField inputTextField2, inputTextField1, inputTextField3;
  private JPanel inputsPanel, resultsPanel, optionsPanel, radioPanel;
  private JLabel inputLabel1, inputLabel2, inputLabel3;
  private JLabel outputLabel1, outputLabel2, outputLabel3;
  private JLabel resultLabel1, resultLabel2, resultLabel3;
  private JButton submitBtn;
  private ButtonGroup bgroup;
  private JRadioButton LLH_to_ECEF_RadioButton;
  private JRadioButton ECEF_to_LLH_RadioButton;

  
	public MainGUI() {
		
		setUpFrame();
		initUI();
	}

	private void initUI() {
		//initialize layouts
		springLayout = new SpringLayout();
		inputPanelLayout = new SpringLayout();
		optionsPanelLayout = new SpringLayout();
		resultsLayout = new SpringLayout();
		
		getContentPane().setLayout(springLayout);
		
		//initialize panels
		inputsPanel = new JPanel();
		resultsPanel = new JPanel();
		optionsPanel = new JPanel();
		radioPanel = new JPanel();
		
		
		
		//initialize button groups
		bgroup = new ButtonGroup();
		
		//initialize radio buttons
		LLH_to_ECEF_RadioButton = new JRadioButton("Convert to ECEF", true);
		ECEF_to_LLH_RadioButton = new JRadioButton("Convert to LLH");
		
		//add radio buttons to group
		bgroup.add(LLH_to_ECEF_RadioButton);
		bgroup.add(ECEF_to_LLH_RadioButton);
		
		//initialize labels
	    inputLabel3 = new JLabel("Height");
		inputLabel1 = new JLabel("Latitude");
		inputLabel2 = new JLabel("Longitude");
		
		outputLabel1 = new JLabel("X Coordinate ");
		outputLabel2 = new JLabel("Y Coordinate ");
		outputLabel3 = new JLabel("Z Coordinate ");
		
		resultLabel1 = new JLabel("0");
		resultLabel2 = new JLabel("0");
		resultLabel3 = new JLabel("0");		
		
		//initialize text fields
	    inputTextField2 = new JTextField();
	    inputTextField1 = new JTextField();
	    inputTextField3 = new JTextField();
	    
		//initialize buttons
	    submitBtn = new JButton("Submit");
		submitBtn.setBackground(Color.CYAN);
		submitBtn.setForeground(Color.BLACK);
		
	    //call private setups
		setUpPanels();
		setUpLayout();
		
	}
	
	private void setUpPanels() {
		
		getContentPane().add(optionsPanel);
		getContentPane().add(inputsPanel);
		getContentPane().add(resultsPanel);
		
		inputsPanel.add(inputLabel1);
		inputsPanel.add(inputLabel2);
		inputsPanel.add(inputLabel3);
		
		resultsPanel.add(outputLabel1);
		resultsPanel.add(outputLabel2);
		resultsPanel.add(outputLabel3);
		
		resultsPanel.add(resultLabel1);
		resultsPanel.add(resultLabel2);
		resultsPanel.add(resultLabel3);
		
		optionsPanel.add(radioPanel);
		
		inputsPanel.add(submitBtn);
		inputsPanel.add(inputTextField2);
		inputTextField2.setColumns(10);
		
		inputTextField1.setColumns(10);
		inputsPanel.add(inputTextField1);
		
		inputTextField3.setColumns(10);
		inputsPanel.add(inputTextField3);
		
		
        //... Arrange buttons vertically in a panel
        radioPanel.setLayout(new GridLayout(3, 1));
        radioPanel.add(ECEF_to_LLH_RadioButton);
        radioPanel.add(LLH_to_ECEF_RadioButton);
        
        //... Add a titled border to the button panel.
        radioPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Change Calculations"));
		
		
	}
	
	private void setUpLayout() {
		springLayout.putConstraint(SpringLayout.SOUTH, resultsPanel, 186, SpringLayout.NORTH, getContentPane());
		
		
		//optionsPanel constraints code
		optionsPanel.setLayout(optionsPanelLayout);
		optionsPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, Color.BLACK));
		optionsPanelLayout.putConstraint(SpringLayout.NORTH, radioPanel, 0, SpringLayout.NORTH, optionsPanel);
		optionsPanelLayout.putConstraint(SpringLayout.WEST, radioPanel, 0, SpringLayout.WEST, optionsPanel);
		optionsPanelLayout.putConstraint(SpringLayout.EAST, radioPanel, 169, SpringLayout.WEST, optionsPanel);		
		
		//resultsPanel constraints code
		resultsPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, Color.BLACK));
		springLayout.putConstraint(SpringLayout.NORTH, resultsPanel, 49, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, resultsPanel, 17, SpringLayout.EAST, inputsPanel);
		springLayout.putConstraint(SpringLayout.EAST, resultsPanel, 303, SpringLayout.EAST, inputsPanel);
		
		
		//inputsPanel constraints code
		inputsPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, Color.BLACK));
		springLayout.putConstraint(SpringLayout.NORTH, inputsPanel, 49, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, inputsPanel, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, inputsPanel, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, inputsPanel, 146, SpringLayout.WEST, getContentPane());

		//resultsPanel constraints code
		resultsPanel.setLayout(resultsLayout);
		springLayout.putConstraint(SpringLayout.WEST, optionsPanel, 17, SpringLayout.EAST, inputsPanel);
		springLayout.putConstraint(SpringLayout.NORTH, optionsPanel, 24, SpringLayout.SOUTH, resultsPanel);
		
		resultsLayout.putConstraint(SpringLayout.NORTH, outputLabel1, 12, SpringLayout.NORTH, resultsPanel);
		resultsLayout.putConstraint(SpringLayout.WEST, outputLabel1, 12, SpringLayout.WEST, resultsPanel);
		resultsLayout.putConstraint(SpringLayout.EAST, outputLabel1, 80, SpringLayout.WEST, resultsPanel);
		
		resultsLayout.putConstraint(SpringLayout.NORTH, outputLabel2, 26, SpringLayout.SOUTH, outputLabel1);
		resultsLayout.putConstraint(SpringLayout.WEST, outputLabel2, 0, SpringLayout.WEST, outputLabel1);
		resultsLayout.putConstraint(SpringLayout.WEST, outputLabel3, 0, SpringLayout.WEST, outputLabel1);
		resultsLayout.putConstraint(SpringLayout.SOUTH, outputLabel3, -22, SpringLayout.SOUTH, resultsPanel);
	
		resultsLayout.putConstraint(SpringLayout.NORTH, resultLabel1, 0, SpringLayout.NORTH, outputLabel1);
		resultsLayout.putConstraint(SpringLayout.WEST, resultLabel1, 32, SpringLayout.EAST, outputLabel1);
		resultsLayout.putConstraint(SpringLayout.NORTH, resultLabel2, 0, SpringLayout.NORTH, outputLabel2);
		resultsLayout.putConstraint(SpringLayout.WEST, resultLabel2, 0, SpringLayout.WEST, resultLabel1);
		resultsLayout.putConstraint(SpringLayout.NORTH, resultLabel3, 0, SpringLayout.NORTH, outputLabel3);
		resultsLayout.putConstraint(SpringLayout.WEST, resultLabel3, 0, SpringLayout.WEST, resultLabel1);
		
		springLayout.putConstraint(SpringLayout.SOUTH, optionsPanel, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, optionsPanel, -175, SpringLayout.EAST, getContentPane());
		
		
		//inputsPanel inner panel
		inputsPanel.setLayout(inputPanelLayout);
		inputPanelLayout.putConstraint(SpringLayout.WEST, inputLabel1, 0, SpringLayout.WEST, inputLabel2);
		inputPanelLayout.putConstraint(SpringLayout.WEST, inputLabel3, 0, SpringLayout.WEST, inputLabel1);
		inputPanelLayout.putConstraint(SpringLayout.WEST, submitBtn, 2, SpringLayout.WEST, inputLabel1);
		inputPanelLayout.putConstraint(SpringLayout.SOUTH, submitBtn, -6, SpringLayout.SOUTH, inputsPanel);
		inputPanelLayout.putConstraint(SpringLayout.EAST, submitBtn, 0, SpringLayout.EAST, inputTextField2);
		inputPanelLayout.putConstraint(SpringLayout.NORTH, inputTextField2, 6, SpringLayout.SOUTH, inputLabel2);
		inputPanelLayout.putConstraint(SpringLayout.NORTH, inputTextField1, 30, SpringLayout.NORTH, inputsPanel);
		inputPanelLayout.putConstraint(SpringLayout.SOUTH, inputLabel1, -6, SpringLayout.NORTH, inputTextField1);
		inputPanelLayout.putConstraint(SpringLayout.WEST, inputTextField1, 10, SpringLayout.WEST, inputsPanel);
		inputPanelLayout.putConstraint(SpringLayout.WEST, inputTextField2, 0, SpringLayout.WEST, inputTextField1);
		inputPanelLayout.putConstraint(SpringLayout.NORTH, inputLabel2, 37, SpringLayout.SOUTH, inputTextField1);
		inputPanelLayout.putConstraint(SpringLayout.WEST, inputLabel2, 0, SpringLayout.WEST, inputTextField1);
		inputPanelLayout.putConstraint(SpringLayout.WEST, inputTextField3, 0, SpringLayout.WEST, inputLabel1);
		inputPanelLayout.putConstraint(SpringLayout.SOUTH, inputTextField3, -28, SpringLayout.NORTH, submitBtn);
		inputPanelLayout.putConstraint(SpringLayout.SOUTH, inputLabel3, -6, SpringLayout.NORTH, inputTextField3);
	
		
	}
	
	private void setUpFrame() {
		this.setTitle("Convert LLH to ECEF or Vice Versa");
		this.setSize(winWidth, winHeight);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width/2) - (this.getWidth()/2);
		int yPos = (dim.height/2) - (this.getHeight()/2);
		
		this.setLocation(xPos, yPos);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
    }
}
