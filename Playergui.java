import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class Playergui {
	
	
	private JLabel songName = new JLabel();
	public static JButton play,previous,stop,next,volume,play1;
	
	
	private AudioFormat audioFormat;
    private AudioInputStream audioInputStream;
    private SourceDataLine sourceDataLine;
    private String path = "";
    private File soundFile = new File("./");
    private File dir = new File(System.getProperty("user.dir"));
    private boolean stopPlayback = false;
	         static JFrame mainWindow = new JFrame("BOOMBOOM AUDIO PLAYER");
	         
	         public static JPanel viewpanel=new JPanel();
	        
	         public static JPanel buttonpanel=new JPanel();
	         
	         private JDialog aboutBox;
	         
	         
	         
	         
	         
	         		
	
	         
    public Playergui(){
    	
    	int windowWidth = 640; 
   		int windowHeight =480; 
		mainWindow.setBounds(50, 50, windowWidth, windowHeight);
		Toolkit theKit = mainWindow.getToolkit();  // Get the window toolkit
		Dimension wndSize = theKit.getScreenSize();// Get screen size
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Setting color of window

		Color myColor=new Color(0,0,51);
		mainWindow.getContentPane().setBackground(Color.black);
		myColor=mainWindow.getBackground();	
		System.out.print(myColor.toString());

	
//get window container

		Container content=mainWindow.getContentPane();



//setting layout 


		FlowLayout flow = new FlowLayout();
		content.setLayout(flow);
		 
			
//creating menubar
 		JMenuBar menuBar = new JMenuBar();
 		
// setting the menubar on the windows
		mainWindow.setJMenuBar(menuBar);
		
//Creating a menu
		JMenu fileMenu = new JMenu("File");
		JMenu PlayMenu = new JMenu("Play");
		JMenu HelpMenu = new JMenu("Help");
		JMenu VolumeMenu = new JMenu("Volume");
		
//adding menu to menu bar
		menuBar.add(fileMenu);
		menuBar.add(PlayMenu);
		menuBar.add(HelpMenu);
		

//Creating file menu items

		JMenuItem openMenu = new JMenuItem("Open");
		JMenuItem closeMenu = new JMenuItem("Close");
		
//adding file menu items
		fileMenu.add(openMenu);
		fileMenu.add(closeMenu);
//Creating play menu items
		JMenuItem playMenu = new JMenuItem("Play");
		JMenuItem stopMenu = new JMenuItem("Stop");
		JMenuItem nextMenu = new JMenuItem("Next");
		JMenuItem previousMenu = new JMenuItem("Previou");
		JMenuItem shuffleMenu = new JMenuItem("Shuffle");
		JMenuItem repeatMenu = new JMenuItem("Repeat");
		
//adding play menu items
		PlayMenu.add(playMenu);
		PlayMenu.add(stopMenu);
		PlayMenu.add(nextMenu);
		PlayMenu.add(previousMenu);
		PlayMenu.add(shuffleMenu);
		
		
//creating help menu items		
		JMenuItem aboutMenu = new JMenuItem("About");
		JMenuItem indexMenu = new JMenuItem("Index");
		
		
		
//adding help menu items	    
		HelpMenu.add(indexMenu);
		HelpMenu.add(aboutMenu);
		
//add volume menu in play menu
		PlayMenu.add(VolumeMenu);
		
//creating volume menu items
       JMenuItem upmenu= new JMenuItem("UP");
       JMenuItem downmenu= new JMenuItem("DOWN");
       
       
//adding volume menu items

		VolumeMenu.add(upmenu);
		VolumeMenu.add(downmenu);
		
//adding shortcuts to menu 

fileMenu.setMnemonic('F');
HelpMenu.setMnemonic('H');
PlayMenu.setMnemonic('P');

//adding shortcuts to menu items

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
//adding icons in menu items
//add listener




 


	

	
		
		
		
//creating buttons 


ImageIcon con1=new ImageIcon("play.png");
ImageIcon con2=new ImageIcon("previous.png");
ImageIcon con3=new ImageIcon("stop.png");
ImageIcon con4=new ImageIcon("next.png");
ImageIcon con5=new ImageIcon("volume.png");
//

play =new JButton(con1);
///
//Use the default text position of CENTER, TRAILING (RIGHT).
        play.setMnemonic(KeyEvent.VK_P);					// Alt-P clicks the button
        play.setActionCommand("enable");
       
///
previous=new JButton(con2);
stop=new JButton(con3);
//Use the default text position of CENTER, TRAILING (RIGHT).
        stop.setMnemonic(KeyEvent.VK_S);					// Alt-S clicks the button
        stop.setActionCommand("enable");
        			

next=new JButton(con4);
volume=new JButton(con5);
play1=new JButton("choose file");

// sizing the buttons

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
////////




mainWindow.setLayout(new BorderLayout());
mainWindow.getContentPane().add(buttonpanel,BorderLayout.SOUTH);
buttonpanel.setPreferredSize(new Dimension(100,50));
buttonpanel.setBounds(0, 0, windowWidth, windowHeight);
/////////

viewpanel.add(songName,"South");


mainWindow.getContentPane().add(viewpanel,BorderLayout.NORTH);
viewpanel.setPreferredSize(new Dimension(500,600));
viewpanel.setBounds(480, 350, windowWidth, windowHeight);

//backgroung colour of buttonpanel & viewpanel


viewpanel.setBackground(Color.BLUE);
buttonpanel.setBackground(Color.black);

// creating slider
JSlider slider=new JSlider(25,25);
slider=new JSlider();
slider.setPaintTicks(true);
slider.setMajorTickSpacing(20);
slider.setMinorTickSpacing(5);
slider.setPreferredSize(new Dimension(80,30));
slider.setBackground(Color.black);



// adding slider

buttonpanel.add(slider);
//




mainWindow.setVisible(true);



//add  action listener in open menu item


		
////OPEN BUTTON ON THE TOOLBAR
		 openMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Open file chooser dialog to choose audio file
                JFileChooser fc = new JFileChooser(dir);
                fc.setFileFilter(new javax.swing.filechooser.FileFilter() {
                    public boolean accept(File f) {
                        if (f.isDirectory()) {
                            return true;
                        }
                        String name = f.getName();
                        if (name.endsWith(".wav") || name.endsWith(".aiff") || name.endsWith(".aif")) {
                            return true;
                        }
                        return false;
                    }
                    public String getDescription() {
                        return ".wav, .aif";
                    }
                });
                
                if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    soundFile = fc.getSelectedFile();
                    dir = soundFile.getParentFile();
                }
                songName.setText(soundFile.getPath());
            }                                       //end actionPerformed
        }                                           //end ActionListener
        );                                          //end addActionListener()
		
		
		closeMenu.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
            {
            	
 					System.exit(0);
 				}
 		
        });
        
        
        
        
        // on the Play and Stop buttons.
        play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	   stop.setEnabled(true);
          			play.setEnabled(false);
                
                playAudio(); 
   				                       //Play the file
            }                                       //end actionPerformed
        }                                           //end ActionListener
        );                                          //end addActionListener()
        
        stop.setEnabled(false);
        
        stop.addActionListener(
                new ActionListener(){
            public void actionPerformed(
                    ActionEvent e){
    
                                   //Terminate playback before EOF
                stopPlayback = true;
            }                                       //end actionPerformed
        }                                           //end ActionListener
        );  
}                                        //end addActionListener()
        
        
        
 //////////////////////////////////////////////////// 
 
 /** 
     *  This method plays back audio data from an
     *  audio file whose name is specified in the
     *  String path.
     */
    private void playAudio() {
        try{
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            audioFormat = audioInputStream.getFormat();
            System.out.println(audioFormat);
            DataLine.Info dataLineInfo =new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine =(SourceDataLine)AudioSystem.getLine(dataLineInfo);
            
            //Create a thread to play back the data and
            // start it running.  It will run until the
            // end of file, or the Stop button is
            // clicked, whichever occurs first.
            // Because of the data buffers involved,
            // there will normally be a delay between
            // the click on the Stop button and the
            // actual termination of playback.
            new PlayThread().start();
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }                                   //end catch
    }                                       //end playAudio      
////////////////////
class PlayThread extends Thread{
        byte tempBuffer[] = new byte[10000];
        
        public void run(){
            try{
                sourceDataLine.open(audioFormat);
                sourceDataLine.start();
                
                int cnt;
                //Keep looping until the input read method
                // returns -1 for empty stream or the
                // user clicks the Stop button causing
                // stopPlayback to switch from false to
                // true.
                while((cnt = audioInputStream.read(
                        tempBuffer,0,tempBuffer.length)) != -1
                        && stopPlayback == false){
                    if(cnt > 0){
                        //Write data to the internal buffer of
                        // the data line where it will be
                        // delivered to the speaker.
                        sourceDataLine.write(
                                tempBuffer, 0, cnt);
                    }                                               //end if
                }                                                   //end while
                //Block and wait for internal buffer of the
                //data line to empty.
                sourceDataLine.drain();
                sourceDataLine.close();
                
                //Prepare to playback another file
                stop.setEnabled(false);
                play.setEnabled(true);
                stopPlayback = false;
              
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }                                       //end catch
        }                                           //end run
    }                                               //end inner class PlayThread
    
 

}







