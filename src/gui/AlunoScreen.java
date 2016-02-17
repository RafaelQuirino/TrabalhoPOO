package gui;

import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import app.Application;
import model.Aula;
import model.Professor;

public class AlunoScreen extends Screen {

	// Constants --------------------------------------------------------------
	
	private static final String labels[] = {
		"Avaliações",
		"Aulas"
	};
	
	private static final String commands[] = {
		Application.ALUNO_AVALIACOES,
		Application.ALUNO_AULAS
	};
	
	private static final String AVALIACOES_COLUMNS[] = {
		"Data",
		"Professor",
		"Nome",
		"Nota"
	};
	
	private static final String AULAS_COLUMNS[] = {
		"Data",
		"Professor",
		"Presente"
	};
	
	// Instance fields --------------------------------------------------------
	
	private ListagemPanel listagemAvaliacoes;
	
	private CadastroPanel avaliacoesCadastroRelatorio;
	
	private ListagemPanel avaliacoesRelatorio;
	
	private ListagemPanel listagemAulas;
	
	private CadastroPanel aulasCadastroRelatorio;
	
	private ListagemPanel aulasRelatorio;
	
	// Constructors -----------------------------------------------------------
	
	public AlunoScreen()
	{
		super(labels, commands);
		
		// listagemAvaliacoes setup
		
		listagemAvaliacoes = new ListagemPanel(AVALIACOES_COLUMNS);
		listagemAvaliacoes.addButton(
			"Relatório", Application.ALUNO_AVALIACOES_RELATORIO
		);
		
		// avaliacoesCadastroRelatorio setup
		
		avaliacoesCadastroRelatorio = new CadastroPanel(
			"Gerar Relatório", Application.ALUNO_AVALIACOES_GERAR_RELATORIO
		);
		avaliacoesCadastroRelatorio.addRow("Professor", new JComboBox<Professor>());
		
		// avaliacoesRelatorio setup
		
		avaliacoesRelatorio = new ListagemPanel(AVALIACOES_COLUMNS);
		
		// listagemAulas setup
		
		listagemAulas = new ListagemPanel(AULAS_COLUMNS);
		listagemAulas.addButton("Relatório", Application.ALUNO_AULAS_RELATORIO);
		
		// aulasCadastroRelatorio setup
		
		aulasCadastroRelatorio = new CadastroPanel(
			"Gerar Relatório", Application.ALUNO_AULAS_GERAR_RELATORIO
		);
		aulasCadastroRelatorio.addRow("Professor", new JComboBox<Aula>());
		
		// aulasRelatorio setup
		
		aulasRelatorio = new ListagemPanel(AULAS_COLUMNS);
	}
	
	// Instance Methods -------------------------------------------------------
	
	public void setHandler(ActionListener handler)
	{
		super.setHandler(handler);
		
		listagemAvaliacoes.setHandler(handler);
		avaliacoesCadastroRelatorio.setHandler(handler);
		listagemAulas.setHandler(handler);
		aulasCadastroRelatorio.setHandler(handler);
	}
	
	// Setters and Getters ----------------------------------------------------

	public ListagemPanel getListagemAvaliacoes(){
		return listagemAvaliacoes;
	}
	
	public CadastroPanel getAvaliacoesCadastroRelatorio(){
		return avaliacoesCadastroRelatorio;
	}
	
	public ListagemPanel getAvaliacoesRelatorio(){
		return avaliacoesRelatorio;
	}
	
	public ListagemPanel getListagemAulas(){
		return listagemAulas;
	}
	
	public CadastroPanel getAulasCadastroRelatorio(){
		return aulasCadastroRelatorio;
	}
	
	public ListagemPanel getAulasRelatorio(){
		return aulasRelatorio;
	}
}
