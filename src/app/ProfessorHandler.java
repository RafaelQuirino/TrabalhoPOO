package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import gui.CadastroPanel;
import gui.Frame;
import gui.ProfessorScreen;
import model.Aluno;
import model.Avaliacao;
import model.Professor;
import model.Turma;
import model.Usuario;

public class ProfessorHandler implements ActionListener {

	private static boolean doingNovaAvaliacao = false;
	
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
	
	////////////////
	// Avaliacoes //-----------------------------------------------------------
	////////////////
	
	/**
	 * Listagem de avaliacoes
	 */
	private void avaliacoes()
	{
		ProfessorScreen screen = getScreen();
		screen.getAvaliacoesPanel().reset();
		screen.setDisplay(screen.getAvaliacoesPanel());
		
		for(Avaliacao a : (ArrayList<Avaliacao>)Model.all(Avaliacao.class))
		{
			String data[] = {
				a.getTurma().getNome(),
				a.getData(),
				String.format("%.2f", a.media())
			};
			screen.getAvaliacoesPanel().addRow(data);
		}
	}
	
	/**
	 * Nova Avaliacao
	 */
	private void novaAvaliacao()
	{
		doingNovaAvaliacao = true;
		ProfessorScreen screen = getScreen();
		//screen.resetCadastroAvaliacaoPanel();
		CadastroPanel cadastro = screen.getCadastroAvaliacaoPanel();
		JComboBox combo = (JComboBox)cadastro.getComponent("Turma");
		((JComboBox)cadastro.getComponent("Turma")).removeAllItems();
		((JTextField)cadastro.getComponent("Data")).setText("");
		
		int professorId = Usuario.getUsuarioAtual().getPessoa().getId();
		
		Professor p = (Professor) Model.find(Professor.class, professorId);
		ArrayList turmas = p.getTurmas();
		
		for(Object turma : turmas)
			combo.addItem((Turma)turma);
		
		
		screen.setDisplay(cadastro);
		doingNovaAvaliacao = false;
		novaAvaliacaoChangeCombo();
	}
	
	/**
	 * 
	 */
	private void novaAvaliacaoChangeCombo()
	{
		if(!doingNovaAvaliacao)
		{
			ProfessorScreen screen = getScreen();
			JComboBox combo = (JComboBox)screen.getCadastroAvaliacaoPanel().getComponent("Turma");
			Turma turma = (Turma)combo.getSelectedItem();
			CadastroPanel cadastro = screen.getCadastroAvaliacaoPanel();
			screen.resetCadastroAvaliacaoFields();
			
			for(Aluno aluno : turma.getAlunos())
				cadastro.addRow(aluno.getNome(), new JTextField(), aluno.getId());
			
			screen.validate();
		}
	}
	
	/**
	 * Criar Avaliacao
	 */
	private void criarAvaliacao()
	{
		ProfessorScreen screen = getScreen();
		CadastroPanel cadastro = screen.getCadastroAvaliacaoPanel();
		JComboBox combo = (JComboBox)screen.getCadastroAvaliacaoPanel().getComponent("Turma");
		Turma turma = (Turma)combo.getSelectedItem();
		
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setProfessorId(Usuario.getUsuarioAtual().getPessoaId());
		avaliacao.setTurmaId(turma.getId());
		avaliacao.setData(((JTextField)cadastro.getComponent("Data")).getText());
		
		for(String label : cadastro.getKeys()){
			if(!label.equals("Data") && !label.equals("Turma"))
			{
				int alunoId = cadastro.getId(label);
				
				String s = ((JTextField)cadastro.getComponent(label)).getText();
				float nota = Float.parseFloat(s);
				avaliacao.addNota(nota, alunoId);
			}
		}
		Model.createModel(avaliacao);
		avaliacoes();
		
	}
	
	////////////////
	// Frequencia //-----------------------------------------------------------
	////////////////
	
	
}
