package gui;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import app.Application;
import model.Turma;

public class ProfessorScreen extends Screen {

	// Constants --------------------------------------------------------------
	
	private static final String labels[] = {
		"Avaliações"
	};
	
	private static String AVALIACOES_COLUMNS[] = {
		"Turma",
		"Data",
		"Média"
	};
	
	private static final String commands[] = {
		Application.PROFESSOR_AVALIACOES
	};
	
	// Instance fields --------------------------------------------------------
	
	private ListagemPanel avaliacoesPanel;
	
	private CadastroPanel cadastroAvaliacaoPanel;
	
	// Constructors -----------------------------------------------------------
	
	public ProfessorScreen()
	{
		super(labels, commands);
		
		// avaliacoesPanel setup
		
		avaliacoesPanel = new ListagemPanel(AVALIACOES_COLUMNS);
		avaliacoesPanel.addButton("Nova Avaliação", Application.PROFESSOR_NOVA_AVALIACAO);
		
		// cadastroAvaliacaoPanel setup

		cadastroAvaliacaoPanel = new CadastroPanel(
			"Criar Avaliação", Application.PROFESSOR_CRIAR_AVALIACAO
		);
		
		cadastroAvaliacaoPanel.addRow("Turma", new JComboBox<Turma>(), 0);
		cadastroAvaliacaoPanel.addRow("Data", new JTextField(), 0);
	}
	
	// Instance Methods -------------------------------------------------------
	
	public void setHandler(ActionListener handler)
	{
		super.setHandler(handler);
		avaliacoesPanel.setHandler(handler);
		cadastroAvaliacaoPanel.setHandler(handler);
		JComboBox combo = (JComboBox)cadastroAvaliacaoPanel.getComponent("Turma");
		combo.addActionListener(handler);
		combo.setActionCommand(Application.PROFESSOR_NOVA_AVALIACAO_CHANGE_COMBO);
	}
	
	/**
	 * 
	 */
	public void resetCadastroAvaliacaoFields()
	{
		for(String key : cadastroAvaliacaoPanel.getKeys())
			if(!key.equals("Turma") && !key.equals("Data"))
				cadastroAvaliacaoPanel.removeRow(key);
	}
	
	// Setters and Getters ----------------------------------------------------

	public ListagemPanel getAvaliacoesPanel() {
		return avaliacoesPanel;
	}
	
	public CadastroPanel getCadastroAvaliacaoPanel(){
		return cadastroAvaliacaoPanel;
	}
}
