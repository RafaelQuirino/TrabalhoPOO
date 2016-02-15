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

public class AlunosPanel extends ListagemPanel {
	
	private static final String columns[] = {
		"Nome",
		"Matrícula",
		"Turma"
	};
	
	public AlunosPanel()
	{
		super(columns);
		
		addButton("Novo Aluno", Application.ADMIN_NOVO_ALUNO_COMMAND);
	}

}
