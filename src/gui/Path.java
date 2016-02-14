package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Path extends JPanel {

	private static final Color BACKGROUND_COLOR = Color.white;
	
	private static final String PATH_SEPARATOR = ">";
	
	private ArrayList<String> paths;
	
	public Path()
	{
		paths = new ArrayList<String>();
		setBackground(BACKGROUND_COLOR);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		//setPreferredSize(new Dimension(0, HEIGHT));
		setBorder(BorderFactory.createEtchedBorder());
	}
	
	/**
	 * 
	 */
	public void reset()
	{
		paths = new ArrayList<String>();
		removeAll();
	}
	
	/**
	 * 
	 */
	public void addPath(String text)
	{
		paths.add(text);
		
		Font font = new Font("Serif", Font.PLAIN, 16);
		
		JLabel label = new JLabel(text);
		label.setFont(font);
		
		JLabel separator = new JLabel(PATH_SEPARATOR);
		separator.setFont(font);
		
		if(paths.size() > 1)
			add(separator);
		
		add(label);
	}
	
}
