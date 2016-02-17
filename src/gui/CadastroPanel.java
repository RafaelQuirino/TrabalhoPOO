package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CadastroPanel extends JPanel {

	// Instance fields --------------------------------------------------------
	
	private JButton button;
	
	Hashtable<String, JComponent> fields;
	
	Hashtable<String, JLabel> labels;
	
	Hashtable<String, Integer> ids;
	
	Hashtable<String, JPanel> panels;
	
	JPanel westPanel;
	
	JPanel centerPanel;
	
	// Constructors -----------------------------------------------------------
	
	public CadastroPanel(String buttonLabel, String buttonActionCommand)
	{
		fields = new Hashtable<String, JComponent>();
		labels = new Hashtable<String, JLabel>();
		ids = new Hashtable<String, Integer>();
		panels = new Hashtable<String, JPanel>();
		
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		setLayout(new BorderLayout());
		//setPreferredSize(new Dimension(400,0));
		setBackground(Color.blue);
		
		westPanel = new JPanel();
		centerPanel = new JPanel();

		JPanel southPanel = new JPanel();
				
		button = new JButton(buttonLabel);
		button.setActionCommand(buttonActionCommand);
		button.setPreferredSize(new Dimension(0, 50));
		
		westPanel.setOpaque(false);
		centerPanel.setOpaque(false);
		southPanel.setOpaque(false);
		
		westPanel.setLayout(new GridLayout(0,1,10,10));
		centerPanel.setLayout(new GridLayout(0,1,10,10));
		
		//centerPanel.setPreferredSize(new Dimension(300, 300));
		
		southPanel.add(button);
		
		add(westPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		
	}
	
	// Instance methods -------------------------------------------------------
	
	/**
	 * 
	 */
	public void clear()
	{
		for(String key : getKeys())
		{
			JComponent comp = getComponent(key);
			
			if(comp instanceof JTextField)
				((JTextField)comp).setText("");
			else if(comp instanceof JTextField)
				((JPasswordField)comp).setText("");
		}
	}
	
	/**
	 * 
	 */
	/*public void reset()
	{
		fields = new Hashtable<String, JComponent>();
		labels = new Hashtable<String, JLabel>();
		westPanel.removeAll();
		centerPanel.removeAll();
	}*/
	
	/**
	 * 
	 */
	public void addRow(String label, JComponent component)
	{
		addRow(label, component, 0);
	}
	
	/**
	 * 
	 */
	public void addRow(String label, JComponent component, Integer id)
	{
		JLabel jl = new JLabel(label);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 60));
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel.setOpaque(false);
		panel.setLayout(new BorderLayout());
		panel.add(component, BorderLayout.CENTER);
		
		fields.put(label, component);
		labels.put(label, jl);
		ids.put(label, id);
		panels.put(label, panel);
		
		westPanel.add(jl);
		centerPanel.add(panel);
		

		//validate();
		//repaint();
	}
	
	/**
	 * 
	 */
	public void removeRow(String label)
	{
		westPanel.remove(labels.get(label));
		centerPanel.remove(panels.get(label));
		
		fields.remove(label);
		labels.remove(label);
		ids.remove(label);
		
		repaint();
		validate();
	}
	
	/**
	 * 
	 */
	public JComponent getComponent(String label)
	{
		return fields.get(label);
	}
	
	/**
	 * 
	 */
	public int getId(String label)
	{
		return ids.get(label);
	}
	
	/**
	 * 
	 */
	public ArrayList<String> getKeys()
	{
		ArrayList<String> keys = new ArrayList<String>();
		Enumeration e = fields.keys();
		
		while(e.hasMoreElements()){
			keys.add((String) e.nextElement());
		}
		
		return keys;
	}
	
	/**
	 * 
	 */
	public void setHandler(ActionListener handler)
	{
		button.addActionListener(handler);
	}
	
}
