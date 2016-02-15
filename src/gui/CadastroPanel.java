package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CadastroPanel extends JPanel {

	// Instance fields --------------------------------------------------------
	
	private JButton button;
	
	Hashtable<String, JComponent> rows;
	
	JPanel westPanel;
	
	JPanel centerPanel;
	
	// Constructors -----------------------------------------------------------
	
	public CadastroPanel(String buttonLabel, String buttonActionCommand)
	{
		rows = new Hashtable<String, JComponent>();
		
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300,300));
		setBackground(Color.blue);
		
		westPanel = new JPanel();
		centerPanel = new JPanel();

		JPanel southPanel = new JPanel();
				
		button = new JButton(buttonLabel);
		button.setActionCommand(buttonActionCommand);
		
		westPanel.setOpaque(false);
		centerPanel.setOpaque(false);
		southPanel.setOpaque(false);
		
		westPanel.setLayout(new GridLayout(0,1,10,10));
		centerPanel.setLayout(new GridLayout(0,1,10,10));
		
		southPanel.add(button);
		
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
	}
	
	// Instance methods -------------------------------------------------------
	
	/**
	 * 
	 */
	public void addRow(String label, JComponent component)
	{
		rows.put(label, component);
		westPanel.add(new JLabel(label));
		centerPanel.add(component);
	}
	
	/**
	 * 
	 */
	public JComponent getRow(String label)
	{
		return rows.get(label);
	}
	
	/**
	 * 
	 */
	public void setHandler(ActionListener handler)
	{
		button.addActionListener(handler);
	}
	
}
