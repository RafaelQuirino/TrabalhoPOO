package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public abstract class Screen extends JPanel {

	// GUI constants ----------------------------------------------------------
	
	private static final Color HEADER_FOREGROUND_COLOR = Color.white;
	
	private static final Color HEADER_BACKGROUND_COLOR = new Color(127, 157, 255);
	
	// Instance fields --------------------------------------------------------
	
	private JLabel headerLabel;
	
	private Display display;
	
	private Menu menu;
	
	private Path path;
	
	private JButton sairButton;
	
	// Constructors -----------------------------------------------------------
	
	public Screen(String labels[], String commands[])
	{
		headerLabel = new JLabel();
		path = new Path();
		menu = new Menu();
		display = new Display();
		sairButton = new JButton("Sair");
		
		for(int i = 0; i < labels.length; i++)
		{
			JButton button = new JButton(labels[i]);
			button.setActionCommand(commands[i]);
			menu.addMenu(button);
		}
		
		menu.addMenu(sairButton);
		
		init();
	}
	
	// Methods ----------------------------------------------------------------
	
	/**
	 * 
	 */
	private void init()
	{
		JPanel mainPanel = new JPanel(),
			   header = new JPanel();
		
		setLayout(new BorderLayout());
		
		display.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		//display.setOpaque(false);
		//display.setBackground(Color.white);
		
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(path, BorderLayout.NORTH);
		mainPanel.add(menu, BorderLayout.WEST);
		mainPanel.add(new JScrollPane(display), BorderLayout.CENTER);
		
		headerLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		headerLabel.setForeground(HEADER_FOREGROUND_COLOR);
		
		//header.setPreferredSize(new Dimension(0, 50));
		header.setBackground(HEADER_BACKGROUND_COLOR);
		header.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		header.add(headerLabel);
		
		add(header, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
	}
	
	/**
	 * 
	 */
	public void addPath(String text)
	{
		path.addPath(text);
	}
	
	public void setPath(String paths[])
	{
		path.setPath(paths);
		validate();
		repaint();
	}
	
	/**
	 * 
	 */
	public void setDisplay(JComponent panel)
	{
		//display.removeAll();
		display.setContentPane(panel);
	}
	
	// Setters and Getters ----------------------------------------------------
	
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
	public void setSairHandler(ActionListener handler)
	{
		sairButton.addActionListener(handler);
	}
	
	/**
	 * 
	 */
	public void setHandler(ActionListener handler)
	{
		for(JButton button : menu.getButtons())
			button.addActionListener(handler);
	}
	
}
