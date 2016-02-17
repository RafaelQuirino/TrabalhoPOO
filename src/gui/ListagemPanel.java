package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListagemPanel extends JPanel {
	
	// Constants --------------------------------------------------------------
	
	private static final int WIDTH = 400;
	
	private static final int HEIGHT = 400;
	
	// Instance fields --------------------------------------------------------
	
	private JTable table;
	
	private ArrayList<JButton> buttons;
	
	private JPanel buttonsPanel;
	
	// Constructors -----------------------------------------------------------
	
	public ListagemPanel(String columns[])
	{
		buttons = new ArrayList<JButton>();
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		tablePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		table = new JTable(new String[0][0], columns);
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		dtm.setColumnIdentifiers(columns);
		table.setModel(dtm);
		
		tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		setLayout(new BorderLayout());
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1,0, 10, 10));
		buttonsPanel.setOpaque(false);
		setOpaque(false);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.setPreferredSize(new Dimension(0, 50));
		p.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		p.add(buttonsPanel, BorderLayout.CENTER);
		p.setOpaque(false);
		
		add(p, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);
	}
	
	// Methods ----------------------------------------------------------------
	
	public void addButton(String label, String actionCommand)
	{
		JButton button = new JButton(label);
		button.setActionCommand(actionCommand);
		buttons.add(button);
		buttonsPanel.add(button);
	}
	
	public void addRow(String row[])
	{
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(row);
	}
	
	public void reset()
	{
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
	
	public void setHandler(ActionListener handler)
	{
		for(JButton b : buttons)
			b.addActionListener(handler);
	}

}
