package gui;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Application;
import model.Aula;
import model.Avaliacao;
import model.Turma;

public class ProfessorScreen extends Screen {

	// Constants --------------------------------------------------------------
	
	private static final String labels[] = {
		"Avaliações",
		"Aulas"
	};
	
	private static final String commands[] = {
		Application.PROFESSOR_AVALIACOES,
		Application.PROFESSOR_AULAS
	};
	
	private static final String AVALIACOES_COLUMNS[] = {
		"Nome",
		"Turma",
		"Data",
		"Média",
	};
	
	private static final String RELATORIO_AVALIACAO_COLUMNS[] = {
		"Nome",
		"Nota"
	};
	
	private static final String AULAS_COLUMNS[] = {
		"Data",
		"Turma",
		"Faltas"
	};
	
	private static final String AULA_RELATORIO_COLUMNS[] = {
		"Nome",
		"Presente"
	};
	
	// Instance fields --------------------------------------------------------
	
	private ListagemPanel avaliacoesPanel;
	
	private CadastroPanel cadastroAvaliacaoPanel;
	
	private CadastroPanel cadastroAvaliacaoRelatorio;
	
	private ListagemPanel relatorioAvaliacao;
	
	private ListagemPanel listagemAulas;
	
	private CadastroPanel cadastroAula;
	
	private CadastroPanel cadastroAulaRelatorio;
	
	private ListagemPanel aulaRelatorio;
	
	// Constructors -----------------------------------------------------------
	
	public ProfessorScreen()
	{
		super(labels, commands);
		
		// avaliacoesPanel setup
		
		avaliacoesPanel = new ListagemPanel(AVALIACOES_COLUMNS);
		avaliacoesPanel.addButton("Nova Avaliação", Application.PROFESSOR_NOVA_AVALIACAO);
		avaliacoesPanel.addButton("Relatório", Application.PROFESSOR_AVALIACAO_RELATORIO);
		
		// cadastroAvaliacaoPanel setup

		cadastroAvaliacaoPanel = new CadastroPanel(
			"Criar Avaliação", Application.PROFESSOR_CRIAR_AVALIACAO
		);
		
		JPanel tmp = new JPanel();
		tmp.setOpaque(false);
		
		cadastroAvaliacaoPanel.addRow("Turma", new JComboBox<Turma>(), 0);
		cadastroAvaliacaoPanel.addRow("Nome", new JTextField());
		cadastroAvaliacaoPanel.addRow("Data", new JTextField(), 0);
		cadastroAvaliacaoPanel.addRow("Alunos", tmp);
		
		// cadastroAvaliacaoRelatorio setup
		
		cadastroAvaliacaoRelatorio = new CadastroPanel(
			"Gerar Relatório", Application.PROFESSOR_AVALIACAO_GERAR_RELATORIO
		);
		
		cadastroAvaliacaoRelatorio.addRow("Turma", new JComboBox<Turma>());
		cadastroAvaliacaoRelatorio.addRow("Nome", new JComboBox<Avaliacao>());
		
		// avaliacaoRelatorio setup
		
		relatorioAvaliacao = new ListagemPanel(RELATORIO_AVALIACAO_COLUMNS);
		
		// listagemAulas setup
		
		listagemAulas = new ListagemPanel(AULAS_COLUMNS);
		listagemAulas.addButton("Nova Aula", Application.PROFESSOR_NOVA_AULA);
		listagemAulas.addButton("Relatório", Application.PROFESSOR_AULA_RELATORIO);
		
		// cadastroAula setup
		
		cadastroAula = new CadastroPanel(
			"Criar Aula", Application.PROFESSOR_CRIAR_AULA
		);
		
		cadastroAula.addRow("Data", new JTextField());
		cadastroAula.addRow("Turma", new JComboBox<Turma>());
		
		cadastroAulaRelatorio = new CadastroPanel(
			"Gerar Relatório", Application.PROFESSOR_AULA_GERAR_RELATORIO
		);
		
		cadastroAulaRelatorio.addRow("Turma", new JComboBox<Turma>());
		cadastroAulaRelatorio.addRow("Data", new JComboBox<Aula>());
		
		// aulaRelatorio setup
		
		aulaRelatorio = new ListagemPanel(AULA_RELATORIO_COLUMNS);
	}
	
	// Instance Methods -------------------------------------------------------
	
	public void setHandler(ActionListener handler)
	{
		super.setHandler(handler);
		
		avaliacoesPanel.setHandler(handler);
		cadastroAvaliacaoPanel.setHandler(handler);
		cadastroAvaliacaoRelatorio.setHandler(handler);
		listagemAulas.setHandler(handler);
		cadastroAula.setHandler(handler);
		cadastroAulaRelatorio.setHandler(handler);
		
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
			if(!key.equals("Turma") && !key.equals("Data") && 
			   !key.equals("Nome") && !key.equals("Alunos"))
				cadastroAvaliacaoPanel.removeRow(key);
	}
	
	// Setters and Getters ----------------------------------------------------

	public ListagemPanel getAvaliacoesPanel() {
		return avaliacoesPanel;
	}
	
	public CadastroPanel getCadastroAvaliacaoPanel(){
		return cadastroAvaliacaoPanel;
	}
	
	public CadastroPanel getCadastroAvaliacaoRelatorio(){
		return cadastroAvaliacaoRelatorio;
	}
	
	public ListagemPanel getRelatorioAvaliacao(){
		return relatorioAvaliacao;
	}
	
	public ListagemPanel getListagemAulas(){
		return listagemAulas;
	}
	
	public CadastroPanel getCadastroAula(){
		return cadastroAula;
	}
	
	public CadastroPanel getCadastroAulaRelatorio(){
		return cadastroAulaRelatorio;
	}
	
	public ListagemPanel getAulaRelatorio(){
		return aulaRelatorio;
	}
}
