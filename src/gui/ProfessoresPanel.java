package gui;

import app.Application;

public class ProfessoresPanel extends ListagemPanel {
	
	private static final String columns[] = {
		"Nome",
		"Disciplina",
		"Turmas"
	};
	
	public ProfessoresPanel()
	{
		super(columns);
		addButton("Novo Professor", Application.ADMIN_NOVO_PROFESSOR_COMMAND);
		addButton("Adicionar Turma", Application.ADMIN_ADICIONAR_TURMA_COMMAND);
	}
}
