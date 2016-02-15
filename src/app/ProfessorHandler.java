package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import gui.CadastroPanel;
import gui.Frame;
import gui.ProfessorScreen;
import model.Professor;
import model.Turma;
import model.Usuario;

public class ProfessorHandler implements ActionListener {

	// Instance fields --------------------------------------------------------
	
	private Frame frame;
	
	// Constructors -----------------------------------------------------------
	
	public ProfessorHandler(Frame frame)
	{
		this.frame = frame;
	}
	
	// Methods ----------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
			case Application.PROFESSOR_AVALIACOES:
				avaliacoes();
				break;
			
			case Application.PROFESSOR_NOVA_AVALIACAO:
				novaAvaliacao();
				break;
				
			case Application.PROFESSOR_NOVA_AVALIACAO_CHANGE_COMBO:
				novaAvaliacaoChangeCombo();
				break;
			
			case Application.PROFESSOR_CRIAR_AVALIACAO:
				criarAvaliacao();
				break;
				
		}
	}
	
	// Private methods --------------------------------------------------------
	
	private ProfessorScreen getScreen()
	{
		return (ProfessorScreen) frame.getScreen();
	}
	
	/**
	 * Avaliacoes
	 */
	private void avaliacoes()
	{
		ProfessorScreen screen = getScreen();
		screen.setDisplay(screen.getAvaliacoesPanel());
	}
	
	/**
	 * Nova Avaliacao
	 */
	private void novaAvaliacao()
	{
		ProfessorScreen screen = getScreen();
		CadastroPanel cadastro = screen.getCadastroAvaliacaoPanel();
		JComboBox combo = (JComboBox)cadastro.getRow("Turma");
		
		int professorId = Usuario.getUsuarioAtual().getPessoa().getId();
		
		Professor p = (Professor) Model.getData(Professor.class, professorId);
		ArrayList turmas = p.getTurmas();
		
		for(Object turma : turmas)
			combo.addItem((Turma)turma);
		
		screen.setDisplay(cadastro);
	}
	
	/**
	 * 
	 */
	private void novaAvaliacaoChangeCombo()
	{
		
	}
	
	/**
	 * Criar Avaliacao
	 */
	private void criarAvaliacao()
	{
		ProfessorScreen screen = getScreen();
		
		JComboBox combo = (JComboBox)screen.getCadastroAvaliacaoPanel().getRow("Turma");
		Turma turma = (Turma)combo.getSelectedItem();
		
	}
	
	
}
