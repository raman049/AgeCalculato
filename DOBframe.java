package calendar;

import java.awt.Container;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class DOBframe extends JFrame {
	
	public DOBframe(){
	setResizable(false);
	setVisible(true);
	setSize(280, 300);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	Container container = getContentPane();
	DOBpanel jpanel = new DOBpanel();
	container.add(jpanel);
	getContentPane().add(jpanel);
	

	}
	
}
