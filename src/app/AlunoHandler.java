package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import gui.AlunoScreen;
import gui.CadastroPanel;
import gui.Frame;
import gui.ListagemPanel;
import model.Aluno;
import model.Avaliacao;
import model.Professor;
import model.Usuario;

public class AlunoHandler implements ActionListener {
	
	// Instance fields --------------------------------------------------------
	
	private Frame frame;
	
	// Constructors -----------------------------------------------------------
	
	public AlunoHandler(Frame frame)
	{
		this.frame = frame;
	}
	
	// Methods ----------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
			case Application.ALUNO_AVALIACOES:
				avaliacoes();
				break;
				
			case Application.ALUNO_AVALIACOES_RELATORIO:
				avaliacoesRelatorio();
				break;
				
			case Application.ALUNO_AVALIACOES_GERAR_RELATORIO:
				avaliacoesGerarRelatorio();
				break;
		}
		getScreen().validate();
	}
	
	////////////////
	// Avaliacoes //===========================================================
	////////////////
	
	/**
	 * 
	 */
	private void avaliacoes()
	{
		AlunoScreen screen = getScreen();
		ListagemPanel listagem = screen.getListagemAvaliacoes();
		listagem.reset();
		
		ArrayList<Avaliacao> avaliacoes = getAluno().getTurma().getAvaliacoes();
		
		for(Avaliacao a : avaliacoes)
		{
			listagem.addRow(new String[]{
				a.getData(),
				a.getProfessor().getNome(),
				a.getNome(),
				String.format("%.2f", a.getNota(getAluno().getId()))
			});
		}
		
		screen.setDisplay(listagem);
	}
	
	/**
	 * 
	 */
	private void avaliacoesRelatorio()
	{
		AlunoScreen screen = getScreen();
		CadastroPanel cadastro = screen.getAvaliacoesCadastroRelatorio();
		cadastro.clear();
		
		JComboBox<Professor> combo = (JComboBox) cadastro.getComponent("Professor");
		
		for(Professor p : getAluno().getProfessores())
			combo.addItem(p);
		
		screen.setDisplay(cadastro);
	}
	
	/**
	 * 
	 */
	private void avaliacoesGerarRelatorio()
	{
		AlunoScreen screen = getScreen();
		CadastroPanel cadastro = screen.getAvaliacoesCadastroRelatorio();
		ListagemPanel listagem = screen.getAvaliacoesRelatorio();
		JComboBox combo = (JComboBox)cadastro.getComponent("Professor");
		Professor professor = (Professor) combo.getSelectedItem();
		
		listagem.reset();
		
		for(Avaliacao a : professor.getTurmaAvaliacoes(getAluno().getTurmaId()))
			listagem.addRow(new String[]{
				a.getData(),
				professor.getNome(),
				a.getNome(),
				String.format("%.2f", a.getNota(getAluno().getId()))
			});
		
		screen.setDisplay(listagem);
	}
	
	/////////////
	// Helpers //==============================================================
	/////////////
	
	/**
	 * 
	 */
	private AlunoScreen getScreen()
	{
		return (AlunoScreen) frame.getScreen();
	}
	
	/**
	 * 
	 */
	private int getAlunoId()
	{
		return Usuario.getUsuarioAtual().getPessoaId();
	}
	
	/**
	 * 
	 */
	private Aluno getAluno()
	{
		return (Aluno)Model.find(Aluno.class, getAlunoId());
	}
	
}
