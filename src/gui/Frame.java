package gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame extends JFrame {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
	private static final boolean MAXIMIZED = true;
	
	private Login login;
	
	public Frame()
	{
		login = new Login();
		setContentPane(login);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		if(MAXIMIZED)
			setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
}
