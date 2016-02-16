package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Display extends JPanel implements ComponentListener {

	private static final Color BACKGROUND_COLOR = new Color(255,255,255);
	
	private JComponent contentPane;
	
	public Display()
	{
		setBackground(BACKGROUND_COLOR);
		addComponentListener(this);
	}
	
	public void setContentPane(JComponent component)
	{
		removeAll();
		contentPane = component;
		add(contentPane);
		validate();
		repaint();
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		if(!(contentPane == null))
		{
			//int width = (int)getSize().getWidth() - 100;
			//int height = (int)getSize().getHeight() - 100;
			//contentPane.setPreferredSize(new Dimension(width, height));
			//validate();
			//repaint();
		}
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
