package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.Application;

public class AvaliacoesPanel extends ListagemPanel {
	
	private static String columns[] = {
		"Turma",
		"Data",
		"Média"
	};
	
	public AvaliacoesPanel()
	{
		super(columns);
		
		addButton("Nova Avaliação", Application.PROFESSOR_NOVA_AVALIACAO);
	}
}
