package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import gui.AdminScreen;
import gui.CadastroPanel;
import gui.Frame;
import model.Aluno;
import model.Professor;
import model.Turma;
import model.Usuario;

public class AdminHandler implements ActionListener {

	// Instance fields --------------------------------------------------------
	
	private Frame frame;
	
	// Constructors -----------------------------------------------------------
	
	public AdminHandler(Frame frame)
	{
		this.frame = frame;
	}
	
	// Methods ----------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
			// Professor commands
				
			case Application.ADMIN_PROFESSORES:
				listagemProfessores();
				break;
			
			case Application.ADMIN_NOVO_PROFESSOR_COMMAND:
				novoProfessor();
				break;
			
			case Application.ADMIN_CRIAR_PROFESSOR_COMMAND:
				criarProfessor();
				break;
				
			case Application.ADMIN_ADICIONAR_TURMA_COMMAND:
				adicionarTurma();
				break;
				
			case Application.ADMIN_DO_ADICIONAR_TURMA_COMMAND:
				doAdicionarTurma();
				break;
				
			// Turma commands
				
			case Application.ADMIN_TURMAS:
				listagemTurmas();
				break;
				
			case Application.ADMIN_NOVA_TURMA_COMMAND:
				novaTurma();
				break;
				
			case Application.ADMIN_CRIAR_TURMA_COMMAND:
				criarTurma();
				break;
				
			// Aluno commands
				
			case Application.ADMIN_ALUNOS:
				listagemAlunos();
				break;
				
			case Application.ADMIN_NOVO_ALUNO_COMMAND:
				novoAluno();
				break;
				
			case Application.ADMIN_CRIAR_ALUNO_COMMAND:
				criarAluno();
				break;
		}
	}
	
	/**
	 * 
	 */
	private AdminScreen getScreen()
	{
		return (AdminScreen) frame.getScreen();
	}
	
	/////////////////
	// Professores //==========================================================
	/////////////////
	
	/**
	 * Listagem professores
	 */
	public void listagemProfessores()
	{
		getScreen().setPath(new String[]{"Admin", "Professores"});
		
		ArrayList<Professor> professores = Model.all(Professor.class);
		
		AdminScreen screen = (AdminScreen) frame.getScreen();
		//screen.showProfessores();
		screen.setDisplay(screen.getProfessoresPanel());
		screen.getProfessoresPanel().reset();
		for(Professor p : professores)
		{
			ArrayList<Turma> turmas = p.getTurmas();
			
			String turmasString = "";
			
			for(int i = 0; i < turmas.size(); i++){
				turmasString += turmas.get(i);
				if(i < turmas.size() - 1)
					turmasString += ", ";
			}
			
			String data[] = {
					p.getRegistro(),
					p.getNome(),
					p.getDisciplina(),
					turmasString
			};
			screen.getProfessoresPanel().addRow(data);
		}
	}
	
	/**
	 * Novo professor
	 */
	private void novoProfessor()
	{
		getScreen().setPath(new String[]{"Admin", "Professores", "Cadastro"});
		getScreen().showCadastroProfessor();
	}
	
	/**
	 * Criar professor
	 */
	private void criarProfessor()
	{
		AdminScreen screen = (AdminScreen) frame.getScreen();
		Professor professor = new Professor();
		CadastroPanel cadastro = screen.getCadastroProfessor();
		
		professor.setNome(((JTextField)cadastro.getComponent("Nome")).getText());
		professor.setRegistro(((JTextField)cadastro.getComponent("Registro")).getText());
		professor.setDisciplina(((JTextField)cadastro.getComponent("Disciplina")).getText());
		
		int professorId = Model.createModel(professor);
		
		Usuario usuario = new Usuario();
		
		usuario.setLogin(((JTextField)cadastro.getComponent("Login")).getText());
		usuario.setSenha(((JTextField)cadastro.getComponent("Senha")).getText());
		usuario.setPessoaId(professorId);
		usuario.setTipo(Usuario.PROFESSOR);
		
		Model.createModel(usuario);
		listagemProfessores();
	}
	
	/**
	 * Adicionar turma
	 */
	private void adicionarTurma()
	{
		getScreen().setPath(new String[]{"Admin", "Professores", "Adicionar Professor à Turma"});
		
		AdminScreen screen = getScreen();
		CadastroPanel cadastro = screen.getAdicionarTurmaPanel();
		
		screen.setDisplay(cadastro);
		//cadastro.reset();
		
		JComboBox<Professor> professoresCombo = (JComboBox)cadastro.getComponent("Professor");
		JComboBox<Turma> turmasCombo = (JComboBox)cadastro.getComponent("Turma");
		
		professoresCombo.removeAllItems();
		turmasCombo.removeAllItems();
		
		for(Professor p : (ArrayList<Professor>) Model.all(Professor.class))
			professoresCombo.addItem(p);
		
		for(Turma t : (ArrayList<Turma>) Model.all(Turma.class))
			turmasCombo.addItem(t);
	}
	
	/**
	 * Do adicionar turma
	 */
	private void doAdicionarTurma()
	{
		AdminScreen screen = getScreen();
		CadastroPanel cadastro = screen.getAdicionarTurmaPanel();
		Professor professor = (Professor)
			((JComboBox)cadastro.getComponent("Professor")).getSelectedItem();
		
		Turma turma = (Turma)
			((JComboBox)cadastro.getComponent("Turma")).getSelectedItem();
		
		professor.addTurmaId(turma.getId());
		turma.addProfessorId(professor.getId());
		
		Model.updateModel(professor);
		Model.updateModel(turma);
		listagemProfessores();
	}
	
	////////////
	// Turmas //===============================================================
	////////////
	
	/**
	 * Listagem turmas
	 */
	private void listagemTurmas()
	{
		getScreen().setPath(new String[]{"Admin", "Turmas"});
		ArrayList<Turma> turmas = Model.all(Turma.class);
		getScreen().setDisplay(getScreen().getTurmaPanel());
		getScreen().getTurmaPanel().reset();
		for(Turma t : turmas)
		{
			String data[] = {
				t.getNome(),
				String.valueOf(t.getAlunos().size())
			};
			getScreen().getTurmaPanel().addRow(data);
		}
	}
	
	/**
	 * Nova turma
	 */
	private void novaTurma()
	{
		getScreen().setPath(new String[]{"Admin", "Turmas", "Cadastro"});
		getScreen().setDisplay(getScreen().getCadastroTurma());
	}
	
	/**
	 * Criar turma
	 */
	private void criarTurma()
	{
		Turma turma = new Turma();
		turma.setNome(((JTextField)getScreen().getCadastroTurma().getComponent("Nome")).getText());
		Model.createModel(turma);
		listagemTurmas();
	}
	
	////////////
	// Alunos //===============================================================
	////////////
	
	/**
	 * Listagem alunos
	 */
	private void listagemAlunos()
	{
		getScreen().setPath(new String[]{"Admin", "Alunos"});
		ArrayList<Aluno> alunos = Model.all(Aluno.class);
		
		AdminScreen screen = getScreen();
		screen.setDisplay(screen.getAlunosPanel());
		screen.getAlunosPanel().reset();
		
		for(Aluno a : alunos)
		{
			String data[] = {
					a.getNome(),
					a.getMatricula(),
					a.getTurma().getNome()
			};
			screen.getAlunosPanel().addRow(data);
		}
	}
	
	/**
	 * Novo aluno
	 */
	private void novoAluno()
	{
		getScreen().setPath(new String[]{"Admin", "Alunos", "Cadastro"});
		AdminScreen screen = getScreen();
		CadastroPanel cadastro = screen.getCadastroAluno();
		cadastro.clear();
		JComboBox<Turma> turmaCombo = (JComboBox)cadastro.getComponent("Turma");
		turmaCombo.removeAllItems();
		
		for(Turma t : (ArrayList<Turma>)Model.all(Turma.class))
			turmaCombo.addItem(t);
		
		getScreen().setDisplay(getScreen().getCadastroAluno());
	}
	
	/**
	 * Criar aluno
	 */
	private void criarAluno()
	{
		AdminScreen screen = getScreen();
		CadastroPanel cadastro = screen.getCadastroAluno();
		
		String nome = ((JTextField)cadastro.getComponent("Nome")).getText();
		String matricula = ((JTextField)cadastro.getComponent("Matrícula")).getText();
		String login = ((JTextField)cadastro.getComponent("Login")).getText();
		String senha = ((JTextField)cadastro.getComponent("Senha")).getText();
		
		int turmaId = ((Turma)((JComboBox)
			cadastro.getComponent("Turma")).getSelectedItem()).getId();
		
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setTurmaId(turmaId);
		Model.createModel(aluno);
		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setPessoaId(aluno.getId());
		usuario.setTipo(Usuario.ALUNO);
		
		Model.createModel(usuario);
		listagemAlunos();
	}
	
}
