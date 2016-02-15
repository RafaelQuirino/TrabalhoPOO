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

public class TurmaPanel extends ListagemPanel {

	private static final String columns[] = {
		"Nome",
		"Alunos"
	};
	
	public TurmaPanel()
	{
		super(columns);
		addButton("Criar Turma", Application.ADMIN_NOVA_TURMA_COMMAND);
	}
}
