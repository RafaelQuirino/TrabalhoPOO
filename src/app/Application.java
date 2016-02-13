package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Frame;
import gui.Login;
import gui.Screen;

public class Application {

	public Application()
	{
		Frame frame = new Frame();
		
		frame.addLoginHandler(new LoginHandler(frame));
	}
	
}
