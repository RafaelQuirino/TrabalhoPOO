package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.Application;

public class AlunosPanel extends JPanel {
	
	private JTable table;
	
	private JButton novoAlunoButton;
	
	private static final String columns[] = {
		"Nome",
		"Matrícula",
		"Turma"
	};
	
	public AlunosPanel()
	{
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		tablePanel.setPreferredSize(new Dimension(400, 400));
		
		table = new JTable(new String[0][0], columns);
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		dtm.setColumnIdentifiers(columns);
		table.setModel(dtm);
		
		tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		setLayout(new BorderLayout());
		
		novoAlunoButton = new JButton("Novo Aluno");
		novoAlunoButton.setActionCommand(Application.ADMIN_NOVO_ALUNO_COMMAND);
		
		add(novoAlunoButton, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);
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
		novoAlunoButton.addActionListener(handler);
	}

}
