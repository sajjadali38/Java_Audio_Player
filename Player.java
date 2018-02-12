import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class Player extends JFrame{
				JFrame mainWindow = new JFrame("BOOMBOOM AUDIO PLAYER");
	         
	          	JPanel viewpanel=new JPanel();
	        
	    private JPanel buttonpanel=new JPanel();
	    private      	FlowLayout flow = new FlowLayout();
	     private     	JMenuBar menuBar = new JMenuBar();
	     private     	JMenu fileMenu = new JMenu("File");
				JMenu PlayMenu = new JMenu("Play");
				JMenu HelpMenu = new JMenu("Help");
				JMenu VolumeMenu = new JMenu("Volume");
				JMenuItem openMenu = new JMenuItem("Open");
				JMenuItem closeMenu = new JMenuItem("Close");
				JMenuItem playMenu = new JMenuItem("Play");
				JMenuItem stopMenu = new JMenuItem("Stop");
				JMenuItem nextMenu = new JMenuItem("Next");
				JMenuItem previousMenu = new JMenuItem("Previou");
				JMenuItem shuffleMenu = new JMenuItem("Shuffle");
				JMenuItem repeatMenu = new JMenuItem("Repeat");
				JMenuItem aboutMenu = new JMenuItem("About");
				JMenuItem indexMenu = new JMenuItem("Index");
				JMenuItem upmenu= new JMenuItem("UP");
       			JMenuItem downmenu= new JMenuItem("DOWN");
				
				
				
				
				JButton play,previous,stop,next,volume;
				ImageIcon con1=new ImageIcon("play.png");
				ImageIcon con2=new ImageIcon("previous.png");
				ImageIcon con3=new ImageIcon("stop.png");
				ImageIcon con4=new ImageIcon("next.png");
				ImageIcon con5=new ImageIcon("volume.png");
				
				
				play =new JButton(con1);
				previous=new JButton(con2);
				stop=new JButton(con3);
				next=new JButton(con4);
				volume=new JButton(con5);
				
				JSlider slider=new JSlider(25,25);
				slider=new JSlider();
				
				
				
				public void init() {
					
					
						int windowWidth = 640; 
   		int windowHeight =480; 
		mainWindow.setBounds(50, 50, windowWidth, windowHeight);
		Toolkit theKit = mainWindow.getToolkit();  // Get the window toolkit
		Dimension wndSize = theKit.getScreenSize();// Get screen size
		mainWindow.setResizable(true);
		mainWindow.setDefaultLookAndFeelDecorated(false);
		
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Setting color of window

		Color myColor=new Color(0,0,51);
		mainWindow.getContentPane().setBackground(Color.black);
		myColor=mainWindow.getBackground();	
		System.out.print(myColor.toString());
		


//get window container

		Container content=mainWindow.getContentPane();



//setting layout 

content.setLayout(flow);

// setting the menubar on the windows
		mainWindow.setJMenuBar(menuBar);
		
		
		//adding menu to menu bar
		menuBar.add(fileMenu);
		menuBar.add(PlayMenu);
		menuBar.add(HelpMenu);
		
		//adding file menu items
		fileMenu.add(openMenu);
		fileMenu.add(closeMenu);
		
		//adding play menu items
		PlayMenu.add(playMenu);
		PlayMenu.add(stopMenu);
		PlayMenu.add(nextMenu);
		PlayMenu.add(previousMenu);
		PlayMenu.add(shuffleMenu);
		
		
		//adding help menu items	    
		HelpMenu.add(indexMenu);
		HelpMenu.add(aboutMenu);
		
//add volume menu in play menu
		PlayMenu.add(VolumeMenu);
		
		//adding volume menu items

		VolumeMenu.add(upmenu);
		VolumeMenu.add(downmenu);
		
		
		play.setPreferredSize(new Dimension(50,35));
stop.setPreferredSize(new Dimension(50,35));
previous.setPreferredSize(new Dimension(50,35));
next.setPreferredSize(new Dimension(50,35));


//
buttonpanel.add(play);
buttonpanel.add(stop);
buttonpanel.add(previous);
buttonpanel.add(next);
buttonpanel.add(volume);
mainWindow.setLayout(new BorderLayout());
mainWindow.getContentPane().add(buttonpanel,BorderLayout.SOUTH);
buttonpanel.setPreferredSize(new Dimension(100,50));
buttonpanel.setBounds(0, 0, windowWidth, windowHeight);


mainWindow.getContentPane().add(viewpanel,BorderLayout.NORTH);
viewpanel.setPreferredSize(new Dimension(500,600));
viewpanel.setBounds(480, 350, windowWidth, windowHeight);

//backgroung colour of buttonpanel& view panel

buttonpanel.setBackground(Color.black);
viewpanel.setBackground(Color.BLUE);

slider.setPaintTicks(true);
slider.setMajorTickSpacing(20);
slider.setMinorTickSpacing(5);
slider.setPreferredSize(new Dimension(80,30));
slider.setBackground(Color.black);

// adding slider

buttonpanel.add(slider);
//
// Set keyboard accelerators
		openMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		closeMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		playMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		stopMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		previousMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,ActionEvent.CTRL_MASK));
		nextMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,ActionEvent.CTRL_MASK));
		upmenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UP,ActionEvent.CTRL_MASK));
		downmenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,ActionEvent.CTRL_MASK));
		aboutMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		indexMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));

 
//

	
	
		
		mainWindow.setVisible(true);
		
		
		stop.setEnabled(false);
        play.setEnabled(true);
        
        playBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                stop.setEnabled(true);
                play.setEnabled(false);
                playAudio();                        //Play the file
            }                                       //end actionPerformed
        }                                           //end ActionListener
        );                                          //end addActionListener()
				}
				
				  public Player() {
        init();
    }
    
    
       public static void main(String[] args) {
        new Player();
    }
					
					
					
	          	
	
}


