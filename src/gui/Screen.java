package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen extends JPanel {

	// GUI constants ----------------------------------------------------------
	
	private static final Color HEADER_FOREGROUND_COLOR = Color.white;
	
	private static final Color HEADER_BACKGROUND_COLOR = new Color(127, 157, 255);
	
	// Instance fields --------------------------------------------------------
	
	JLabel headerLabel;
	
	Display display;
	
	Menu menu;
	
	// Constructors -----------------------------------------------------------
	
	public Screen()
	{
		setLayout(new BorderLayout());
		
		headerLabel = new JLabel();
		
		JPanel mainPanel = new JPanel(),
			   header = new JPanel();
		
		Path path = new Path();
		menu = new Menu();
		display = new Display();
		
		path.addPath("Aluno");
		path.addPath("Notas");
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(path, BorderLayout.NORTH);
		mainPanel.add(menu, BorderLayout.WEST);
		mainPanel.add(display, BorderLayout.CENTER);
		
		headerLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		headerLabel.setForeground(HEADER_FOREGROUND_COLOR);
		
		//header.setPreferredSize(new Dimension(0, 50));
		header.setBackground(HEADER_BACKGROUND_COLOR);
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		header.add(headerLabel);
		
		add(header, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
	}
	
	// Methods ----------------------------------------------------------------
	
	/**
	 * 
	 */
	public void setHeaderText(String text)
	{
		headerLabel.setText(text);
	}
	
	/**
	 * 
	 */
	public void addMenu(String text, ActionListener listener)
	{
		menu.addMenu(text, listener);
	}
	
}
