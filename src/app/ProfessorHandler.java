package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import gui.CadastroPanel;
import gui.Frame;
import gui.ListagemPanel;
import gui.ProfessorScreen;
import model.Aluno;
import model.Aula;
import model.Avaliacao;
import model.Professor;
import model.Turma;
import model.Usuario;

public class ProfessorHandler implements ActionListener {

	private static boolean doingNovaAvaliacao = false;
	private static boolean doingNovaAula = false;
	
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
			
			case Application.PROFESSOR_AVALIACAO_RELATORIO:
				avaliacaoRelatorio();
				break;
				
			case Application.PROFESSOR_AVALIACAO_GERAR_RELATORIO:
				avaliacaoGerarRelatorio();
				break;
				
			case Application.PROFESSOR_AULAS:
				aulas();
				break;
				
			case Application.PROFESSOR_NOVA_AULA:
				doingNovaAula = true;
				novaAula();
				doingNovaAula = false;
				break;
				
			case Application.PROFESSOR_CRIAR_AULA:
				criarAula();
				break;
				
			case Application.PROFESSOR_AULA_RELATORIO:
				aulaRelatorio();
				break;
				
			case Application.PROFESSOR_AULA_GERAR_RELATORIO:
				aulaGerarRelatorio();
				break;
				
		}
		getScreen().validate();
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
		
		for(Avaliacao a : getProfessor().getAvaliacoes())
		{
			String data[] = {
				a.getNome(),
				a.getTurma().getNome(),
				a.getData(),
				String.format("%.2f", a.media())
			};
			screen.getAvaliacoesPanel().addRow(data);
		}
		screen.setDisplay(screen.getAvaliacoesPanel());
	}
	
	/**
	 * Nova Avaliacao
	 */
	private void novaAvaliacao()
	{
		doingNovaAvaliacao = true;
		ProfessorScreen screen = getScreen();
		
		CadastroPanel cadastro = screen.getCadastroAvaliacaoPanel();
		JComboBox combo = (JComboBox)cadastro.getComponent("Turma");
		((JComboBox)cadastro.getComponent("Turma")).removeAllItems();
		((JTextField)cadastro.getComponent("Data")).setText("");
		
		for(String key : cadastro.getKeys())
		{
			if(!key.equals("Data") && !key.equals("Turma") &&
			   !key.equals("Nome") && !key.equals("Alunos"))
				cadastro.removeRow(key);
		}
		
		for(Turma turma : getProfessorTurmas())
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
		avaliacao.setNome(((JTextField)cadastro.getComponent("Nome")).getText());
		
		for(String label : cadastro.getKeys()){
			if(!label.equals("Data") && !label.equals("Turma") &&
			   !label.equals("Nome") && !label.equals("Alunos"))
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
	
	/**
	 * Avaliacao Relatorio Form
	 */
	private void avaliacaoRelatorio()
	{
		final ProfessorScreen screen = getScreen();
		final CadastroPanel cadastro = screen.getCadastroAvaliacaoRelatorio();
		
		final JComboBox turmaCombo = (JComboBox)cadastro.getComponent("Turma");
		((JComboBox)cadastro.getComponent("Nome")).setVisible(false);
		
		turmaCombo.removeAllItems();
		
		final Professor professor = getProfessor();
		
		turmaCombo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				JComboBox nomeCombo = (JComboBox)cadastro.getComponent("Nome");
				nomeCombo.removeAllItems();
				Turma t = (Turma)turmaCombo.getSelectedItem();
				
				if(t instanceof Turma)
				{
					int turmaId = t.getId();
					for(Avaliacao a : professor.getTurmaAvaliacoes(turmaId))
						nomeCombo.addItem(a);
					
					((JComboBox)cadastro.getComponent("Nome")).setVisible(true);
					screen.validate();
				}
			}
		});
		
		for(Turma t : getProfessorTurmas())
			turmaCombo.addItem(t);
		
		screen.setDisplay(cadastro);
	}
	
	/**
	 * Gerar Relatorio de Avaliacoes
	 */
	public void avaliacaoGerarRelatorio()
	{
		ProfessorScreen screen = getScreen();
		CadastroPanel cadastro = screen.getCadastroAvaliacaoRelatorio();
		ListagemPanel listagem = screen.getRelatorioAvaliacao();
		
		listagem.reset();
		
		int turmaId = ((Turma)
			((JComboBox)cadastro.getComponent("Turma")).getSelectedItem()).getId();
		
		Avaliacao avaliacao = ((Avaliacao)
			((JComboBox)cadastro.getComponent("Nome")).getSelectedItem());
		
		for(Integer id : avaliacao.getAlunoIds())
		{
			Aluno a = (Aluno)Model.find(Aluno.class, id);
			
			listagem.addRow(new String[]{
				a.getNome(),
				String.format("%.2f", avaliacao.getNota(id))
			});
		}
		screen.setDisplay(listagem);
	}
	
	////////////////
	// Frequencia //-----------------------------------------------------------
	////////////////
	
	/**
	 * 
	 */
	private void aulas()
	{
		ProfessorScreen screen = getScreen();
		ListagemPanel listagem = screen.getListagemAulas();
		listagem.reset();
		
		for(Aula a : getProfessor().getAulas())
			listagem.addRow(new String[]{
				a.getData(),
				a.getTurma().toString(),
				String.valueOf(a.getFaltas())
			});
		
		screen.setDisplay(listagem);
	}
	
	/**
	 * 
	 */
	private void novaAula()
	{
		final ProfessorScreen screen = getScreen();
		final CadastroPanel cadastro = screen.getCadastroAula();
		//cadastro.reset();
		final JComboBox<Turma> turmaCombo = (JComboBox)cadastro.getComponent("Turma");
		turmaCombo.removeAllItems();
		
		turmaCombo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(!doingNovaAula){
					removeCadastroItemsExcept(new String[]{"Data", "Turma"}, cadastro);
					Turma t = (Turma)turmaCombo.getSelectedItem();
					for(Aluno a : t.getAlunos())
						cadastro.addRow(a.getNome(), new JCheckBox(), a.getId());
					screen.validate();
				}
			}
		});
		
		for(Turma t : getProfessorTurmas())
			turmaCombo.addItem(t);
		
		removeCadastroItemsExcept(new String[]{"Data", "Turma"}, cadastro);
		Turma t = (Turma)turmaCombo.getSelectedItem();
		for(Aluno a : t.getAlunos())
			cadastro.addRow(a.getNome(), new JCheckBox(), a.getId());
		screen.validate();
		
		screen.setDisplay(cadastro);
	}
	
	/**
	 * 
	 */
	private void criarAula()
	{
		ProfessorScreen screen = getScreen();
		CadastroPanel cadastro = screen.getCadastroAula();
		
		String data = ((JTextField)cadastro.getComponent("Data")).getText();
		Turma turma = (Turma)((JComboBox)cadastro.getComponent("Turma")).getSelectedItem();
		ArrayList<Integer> alunoIds = new ArrayList<Integer>();
		
		for(String key : cadastro.getKeys())
			if(!key.equals("Data") && !key.equals("Turma"))
				if(((JCheckBox)cadastro.getComponent(key)).isSelected())
					alunoIds.add(cadastro.getId(key));
		
		Aula aula = new Aula();
		aula.setData(data);
		aula.setTurmaId(turma.getId());
		aula.setProfessorId(getProfessorId());
		
		for(Integer i : alunoIds)
			aula.addAlunoId(i);
		Model.createModel(aula);
		aulas();
	}
	
	/**
	 * 
	 */
	private void aulaRelatorio()
	{
		final ProfessorScreen screen = getScreen();
		final CadastroPanel cadastro = screen.getCadastroAulaRelatorio();
		
		final JComboBox turmaCombo = (JComboBox)cadastro.getComponent("Turma");
		((JComboBox)cadastro.getComponent("Data")).setVisible(false);
		
		turmaCombo.removeAllItems();
		
		final Professor professor = getProfessor();
		
		turmaCombo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				JComboBox nomeCombo = (JComboBox)cadastro.getComponent("Data");
				nomeCombo.removeAllItems();
				Turma t = (Turma)turmaCombo.getSelectedItem();
				
				if(t instanceof Turma)
				{
					int aulaId = t.getId();
					for(Aula a : professor.getTurmaAulas(aulaId))
						nomeCombo.addItem(a);
					
					((JComboBox)cadastro.getComponent("Data")).setVisible(true);
					screen.validate();
				}
			}
		});
		
		for(Turma t : getProfessorTurmas())
			turmaCombo.addItem(t);
		
		screen.setDisplay(cadastro);
	}
	
	/**
	 * 
	 */
	private void aulaGerarRelatorio()
	{
		ProfessorScreen screen = getScreen();
		CadastroPanel cadastro = screen.getCadastroAulaRelatorio();
		ListagemPanel listagem = screen.getAulaRelatorio();
		
		listagem.reset();
		
		int turmaId = ((Turma)
			((JComboBox)cadastro.getComponent("Turma")).getSelectedItem()).getId();
		
		Aula aula = ((Aula)
			((JComboBox)cadastro.getComponent("Data")).getSelectedItem());
		
		Turma turma = (Turma)Model.find(Turma.class, turmaId);
		ArrayList<Aluno> alunos = turma.getAlunos();
		
		for(Aluno a : alunos)
		{
			String presente = aula.hasAlunoId(a.getId()) ? "Sim" : "Não";
			listagem.addRow(new String[]{
				a.getNome(),
				presente
			});
		}
		
		screen.setDisplay(listagem);
	}
	
	/////////////
	// Helpers //==============================================================
	/////////////
	
	/**
	 * 
	 */
	private ArrayList<Turma> getProfessorTurmas()
	{
		/*Professor professor = getProfessor();
		
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		
		for(Turma t : professor.getTurmas())
			turmas.add(t);
		*/
		return getProfessor().getTurmas();
	}
	
	/**
	 * 
	 */
	private int getProfessorId()
	{
		return Usuario.getUsuarioAtual().getPessoaId();
	}
	
	/**
	 * 
	 */
	private Professor getProfessor()
	{
		return (Professor)Model.find(Professor.class, getProfessorId());
	}
	
	/**
	 * 
	 */
	private void removeCadastroItemsExcept(String exceptList[], CadastroPanel cadastro)
	{
		for(String key : cadastro.getKeys())
		{
			boolean contains = false;
			
			for(String s : exceptList)
				if(s.equals(key))
					contains = true;
			
			if(!contains)
				cadastro.removeRow(key);
		}
	}
}
