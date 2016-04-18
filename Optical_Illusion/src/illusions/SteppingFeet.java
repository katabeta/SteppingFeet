package illusions;

/*
 * Default Java class imports
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/*
 * Java GUI / Swing imports
 */
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * Custom class imports
 */
import handlers.ColorHandler;
import handlers.Colorables;
import handlers.ExitButtonHandler;
import handlers.ResetHandler;
import handlers.ToggleBackgroundHandler;
import net.miginfocom.swing.MigLayout;
import panels.DarkPanel;
import panels.FieldPanel;
import panels.FootPanel;
import panels.LightPanel;
import panels.UIBPanel;
import panels.UITFPanel;
import panels.UIField;

/* 
 * @author Irina Lavryonova														*
 * @version 2016-03-20
 */
 
public class SteppingFeet extends JFrame{

	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Define frame size
	 */
	private final static int WIDTH = 940;
	private final static int HEIGHT = 720;

	/**
	 * Refresh rate
	 */
	private Timer timer;
	private final long TIMER_PERIOD = 10L;
	private final long TIMER_DELAY = 0L;

	/**
	 * Labels
	 */
	private JLabel footColorLightL, footColorDarkL, bgColorL, panelColorL;
	/**
	 * Combo boxes
	 */
	private JComboBox<String> footColorLightCB, footColorDarkCB, bgColorCB, panelColorCB;
	/**
	 * Buttons
	 */
	private JButton toggleBackgroundB, resetB, exitB;

	/**
	 * Color choices for the JComboBoxes/drop down menus
	 */
	private final String[] CHOICES = {"Black","Blue","Cyan","Dark gray",
			"Gray","Green","Light gray","Magenta","Orange","Pink","Red","White","Yellow"};

	/**
	 * Button handlers
	 */
	private ToggleBackgroundHandler tbbHandler;
	private ResetHandler rebHandler;
	private ExitButtonHandler ebHandler;

	/**
	 * ComboBox Handlers
	 */
	private ColorHandler footLightCBHandler;
	private ColorHandler footDarkCBHandler;
	private ColorHandler bgCBHandler;
	private ColorHandler panelCBHandler;

	/**
	 * Movement booleans
	 */
	boolean hasLightTouchedRightSide;
	boolean hasDarkTouchedRightSide;

	/**
	 * Movement integers
	 */
	private int darkMvntInt;
	private int lightMvntInt;

	/**
	 * Panels
	 * Parent class - JPanel
	 */
	private UITFPanel uitfPanel;
	private UIBPanel uibPanel;
	private UIField uifieldPanel;
	public static FieldPanel fieldPanel;
	public static ArrayList<DarkPanel> darkPanels;
	public static ArrayList<LightPanel> lightPanels;
	public static FootPanel footPanelLight, footPanelDark;

	
	/**
	 * Layouts
	 */
	public final static MigLayout FRAME_LAYOUT = new MigLayout();
	public final static MigLayout UITF_LAYOUT = new MigLayout();
	public final static MigLayout UIB_LAYOUT = new MigLayout();
	public final static MigLayout FIELD_LAYOUT = new MigLayout();
	public final static MigLayout BG_LIGHT_LAYOUT = new MigLayout(
			"w 11!, h 520!", // Layout Constraints
			"[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0"
			+ "[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0"
			+ "[]0[]0[]0[]0[]0[]0[]0[]", // Column constraints
			""); // Row constraints
	public final static MigLayout BG_DARK_LAYOUT = new MigLayout(
			"w 17!, h 520!", // Layout Constraints
			"[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0"
			+ "[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0[]0"
			+ "[]0[]0[]0[]0[]0[]0[]0[]", // Column constraints
			"");
	public final static MigLayout FOOT_LAYOUT = new MigLayout("w 30!, h 30!");	

	public SteppingFeet(){
		//Initialize timer
		timer = new Timer();


		//Get the content pane (CP)
		Container pane = getContentPane();
		
		//Set the layout parameters
		pane.setLayout(FRAME_LAYOUT);
		pane.setBackground(Color.WHITE);

		//Set the window's title
		setTitle("Optical Illusion - Stepping Feet");

		/**
		 * Movement integers
		 * Used in animation
		 */
		lightMvntInt = 0;
		darkMvntInt = 17;


		/**
		 * Panels
		 * Create panels (JPanel/__Panel)
		 * Create an ArrayList of Light and Dark Panels	
		 */
		uitfPanel = new UITFPanel();
		uibPanel = new UIBPanel();
		uifieldPanel = new UIField(); //JLayersPane
		fieldPanel = new FieldPanel();
		footPanelLight = new FootPanel();
		footPanelDark = new FootPanel();
		darkPanels = new ArrayList<DarkPanel>();
		lightPanels = new ArrayList<LightPanel>();
		for(int i = 0; i < 25; i++){
			darkPanels.add(new DarkPanel());
			lightPanels.add(new LightPanel());
		}
		
		/**
		 * Labels
		 * Create labels (JLabel)
		 */
		footColorLightL = new JLabel("Foot Color Light: ");
		footColorDarkL = new JLabel("Foot Color Dark: ");
		bgColorL = new JLabel("Background Color: ");
		panelColorL = new JLabel("Panel Color: ");
		
		/**
		 * Text Fields
		 * 1. Create a dropdown menu (JComboBox)
		 * 2. Create an object that will listen to change on object from step 1 
		 * 	(ActionListener/ColorHandler)
		 * 3. Add object created in step 3 to the object created in step 1 
		 */
			//FootLight
		footColorLightCB = new JComboBox<String>(CHOICES);
		footLightCBHandler = new ColorHandler(footColorLightCB, Colorables.LIGHT_FOOT);
		footColorLightCB.addActionListener(footLightCBHandler);
			//FootDark
		footColorDarkCB = new JComboBox<String>(CHOICES);
		footDarkCBHandler = new ColorHandler(footColorDarkCB, Colorables.DARK_FOOT);
		footColorDarkCB.addActionListener(footDarkCBHandler);
			//Background
		bgColorCB = new JComboBox<String>(CHOICES);
		bgCBHandler = new ColorHandler(bgColorCB, Colorables.BG);
		bgColorCB.addActionListener(bgCBHandler);
			//Panel
		panelColorCB = new JComboBox<String>(CHOICES);
		panelCBHandler = new ColorHandler(panelColorCB, Colorables.PANEL);
		panelColorCB.addActionListener(panelCBHandler);


		/**
		 * Buttons
		 * 1. Create a button (JButton)
		 * 2. Create an object that will listen to change on object from step 1 
		 * 	ActionListener/__Handler)
		 * 3. Add object created in step 3 to the object created in step 1 
		 */
			//Toggle
		toggleBackgroundB = new JButton("Gray out all lines");
		tbbHandler = new ToggleBackgroundHandler(bgColorCB, panelColorCB, CHOICES);
		toggleBackgroundB.addActionListener(tbbHandler);
			//Reset
		resetB = new JButton("Reset all lines");
		rebHandler = new ResetHandler(bgColorCB, panelColorCB, CHOICES);
		resetB.addActionListener(rebHandler);
			//Exit
		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);		


		/**
		 * Add things to the pane in the order that you want to add them to appear
		 * (left to right, top to bottom)
		 */
			//Pane
		pane.add(uitfPanel, "cell 0 1, center");
		pane.add(uibPanel, "cell 0 2, center");
		pane.add(uifieldPanel/*JLayeredPane*/, "cell 0 3, center");
			//UITFPanel - JPanel = parent
		uitfPanel.add(footColorLightL);
		uitfPanel.add(footColorLightCB);
		uitfPanel.add(footColorDarkL);
		uitfPanel.add(footColorDarkCB);
		uitfPanel.add(bgColorL);
		uitfPanel.add(bgColorCB);
		uitfPanel.add(panelColorL);
		uitfPanel.add(panelColorCB);
			//UIBPanel - JPanel = parent
		uibPanel.add(toggleBackgroundB);
		uibPanel.add(resetB);
		uibPanel.add(exitB);
			//FieldPanels - JPanel = parent
		for(int i = 0; i < 25; i++){
			fieldPanel.add(darkPanels.get(i));
			fieldPanel.add(lightPanels.get(i));
		}
		
		//UIFieldPanel - Add layered content - JLayeredPane = Parent
		uifieldPanel.add(fieldPanel, new Integer(JLayeredPane.DEFAULT_LAYER + 1));
		uifieldPanel.add(footPanelLight, new Integer(JLayeredPane.DEFAULT_LAYER + 2));
		uifieldPanel.add(footPanelDark, new Integer(JLayeredPane.DEFAULT_LAYER + 2));

		//Set sizes of layered content (JLayeredPane has a null layout)
		uifieldPanel.setPreferredSize(new Dimension(910, 570)); //JLayeredPane
		fieldPanel.setSize(new Dimension(fieldPanel.getPreferredSize().width, 
				fieldPanel.getPreferredSize().height));
		footPanelLight.setSize(new Dimension(footPanelLight.getPreferredSize().width,
				footPanelLight.getPreferredSize().height));
		footPanelDark.setSize(new Dimension(footPanelDark.getPreferredSize().width, 
				footPanelDark.getPreferredSize().height));


		//Schedule timer
		timer.schedule(new AnimateTask(), TIMER_DELAY, TIMER_PERIOD);

		//Starting properties
		footColorLightCB.setSelectedItem(CHOICES[11]);
		footColorDarkCB.setSelectedItem(CHOICES[0]);
		bgColorCB.setSelectedItem(CHOICES[11]);
		panelColorCB.setSelectedItem(CHOICES[0]);


		//Set size of frame
		setSize(WIDTH, HEIGHT);
		//Set the default operation when the user presses the "X" to be close
		setDefaultCloseOperation(EXIT_ON_CLOSE);


		/**
		 * Set look and feel
		 * Catch 1) Make sure taht this sytem is able to find this LookAndFeel
		 * Catch 2) Make sure that this system can instantiate this LookAndFeel
		 * Catch 3) Make sure that this system has granted permission to set this
		 * 	LookAndFeel
		 * Catch 4) Make sure that this system has this LookAndFeel
		 */
		try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch(ClassNotFoundException e){}
		catch(InstantiationException e){}
		catch(IllegalAccessException e){}
		catch(UnsupportedLookAndFeelException e){}
	}//JFrame Constructor

	/**
	 * Task for the timer
	 * Calls the animate method a everything refresh unit
	 * and manually sets where the layered content is 
	 */
	private class AnimateTask extends TimerTask{
		@Override
		public void run(){
			animate();
			//Manually set where layered content is
			fieldPanel.setBounds(new Rectangle(Math.abs(uifieldPanel.getPreferredSize().width 
					- fieldPanel.getPreferredSize().width)/2, 
					Math.abs(uifieldPanel.getPreferredSize().height 
							- fieldPanel.getPreferredSize().height)/2, 
					fieldPanel.getPreferredSize().width, fieldPanel.getPreferredSize().height));
			footPanelLight.setBounds(new Rectangle(fieldPanel.getX() 
					+ lightMvntInt,  Math.abs(uifieldPanel.getPreferredSize().height 
							- fieldPanel.getPreferredSize().height)/2 
					+ 250, footPanelLight.getPreferredSize().width, 
					footPanelLight.getPreferredSize().height));
			footPanelDark.setBounds(new Rectangle(fieldPanel.getX() 
					+ darkMvntInt,  Math.abs(uifieldPanel.getPreferredSize().height 
							- fieldPanel.getPreferredSize().height)/2 
					+ 375, footPanelDark.getPreferredSize().width, 
					footPanelDark.getPreferredSize().height));;
		}//override
	}//class

	/**
	 * Determine which direction the feet should be moving to stay on the field 
	 * and adds the appropriate value to the variable
	 */
	private void animate(){	
		/**
		 * Toggle the boolean which controls which direction the light foot moves 
		 * horizontally based on whether it has touched the side of the field
		 */
		if ((footPanelLight.getX() + footPanelLight.getPreferredSize().width) 
				== (fieldPanel.getX() + fieldPanel.getPreferredSize().width)){
			hasLightTouchedRightSide = true;
		} else if (footPanelLight.getX() == fieldPanel.getX()){
			hasLightTouchedRightSide = false;
		}//else if
		/**
		 * Toggle the boolean which controls which direction the dark foot moves 
		 * horizontally based on whether it has touched the side of the field
		 */
		if ((footPanelDark.getX() + footPanelDark.getPreferredSize().width) 
				== (fieldPanel.getX() + fieldPanel.getPreferredSize().width)){
			hasDarkTouchedRightSide = true;
		} else  if (footPanelDark.getX() == fieldPanel.getX()){
			hasDarkTouchedRightSide = false;
		}//else if

		/**
		 * Check if the light foot has touched the side
		 * yes - reverse direction
		 * no - continue
		 */
		if(hasLightTouchedRightSide){
			lightMvntInt--;
		} else{
			lightMvntInt++;
		}//else
		/**
		 * Check if the dark foot has touched the side
		 * yes - reverse direction
		 * no - continue
		 */
		if(hasDarkTouchedRightSide) {
			darkMvntInt--;
		} else{
			darkMvntInt++;
		}//else
	}//function
} //end of program
