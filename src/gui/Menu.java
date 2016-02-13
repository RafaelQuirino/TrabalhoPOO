package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{

	// GUI constants ----------------------------------------------------------
	
	private static final int WIDTH = 250;
	
	private static final int PADDING = 20;
	
	private static final int BUTTON_HEIGHT = 50;
	
	private static final Color BACKGROUND_COLOR = new Color(245,245,245);
	
	// Constructors ----------------------------------------------------------
	
	public Menu()
	{
		setBackground(BACKGROUND_COLOR);
		setPreferredSize(new Dimension(WIDTH, 0));
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, PADDING));
	}
	
	// Methods ----------------------------------------------------------
	
	public void addMenu(String text, ActionListener actionListener)
	{
		JButton button = new JButton(text);
		button.setPreferredSize(new Dimension(WIDTH-(PADDING*2), BUTTON_HEIGHT));
		button.addActionListener(actionListener);
		add(button);
	}
	
}
