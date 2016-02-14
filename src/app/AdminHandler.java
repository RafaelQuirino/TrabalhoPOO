package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.AdminScreen;
import gui.CadastroAluno;
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
			//case Application.ADMIN_CADASTRAR_PROFESSOR_COMMAND:
			//	cadastrarProfessor();
			//	break;
			
			case Application.ADMIN_CADASTRAR_ALUNO_COMMAND:
				cadastrarAluno();
				break;
			
			case Application.ADMIN_PROFESSORES:
				showAdminProfessores();
				break;
			
			case Application.ADMIN_NOVO_PROFESSOR_COMMAND:
				novoProfessor();
				break;
			
			case Application.ADMIN_CRIAR_PROFESSOR_COMMAND:
				criarProfessor();
				break;
				
			case Application.ADMIN_TURMAS:
				showAdminTurmas();
				break;
				
			case Application.ADMIN_NOVA_TURMA_COMMAND:
				novaTurma();
				break;
				
			case Application.ADMIN_CRIAR_TURMA_COMMAND:
				criarTurma();
				break;
				
			case Application.ADMIN_ALUNOS:
				showAlunos();
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
	private void showAlunos()
	{
		ArrayList<Aluno> alunos = Model.getData(Aluno.class);
		
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
	 * 
	 */
	private void novoAluno()
	{
		AdminScreen screen = getScreen();
		CadastroAluno cadastroAluno = screen.getCadastroAluno();
		cadastroAluno.resetTurma();
		
		for(Turma t : (ArrayList<Turma>)Model.getData(Turma.class))
			cadastroAluno.addTurma(t);
		
		getScreen().setDisplay(getScreen().getCadastroAluno());
	}
	
	/**
	 * 
	 */
	private void criarAluno()
	{
		AdminScreen screen = getScreen();
		CadastroAluno cadastroAluno = screen.getCadastroAluno();
		
		Aluno aluno = new Aluno();
		aluno.setMatricula(cadastroAluno.getMatricula());
		aluno.setNome(cadastroAluno.getNome());
		aluno.setTurma(cadastroAluno.getSelectedTurma());
		
		Usuario usuario = new Usuario();
		usuario.setLogin(cadastroAluno.getLogin());
		usuario.setSenha(cadastroAluno.getSenha());
		usuario.setPessoa(aluno);
		usuario.setTipo(Usuario.ALUNO);
		Model.createModel(aluno);
		Model.createModel(usuario);
		showAlunos();
	}
	
	/**
	 * 
	 */
	private void showAdminProfessores()
	{
		ArrayList<Professor> professores = Model.getData(Professor.class);
		
		AdminScreen screen = (AdminScreen) frame.getScreen();
		//screen.showProfessores();
		screen.setDisplay(screen.getProfessoresPanel());
		screen.getProfessoresPanel().reset();
		for(Professor p : professores)
		{
			String data[] = {
					p.getNome(),
					p.getDisciplina()
			};
			screen.getProfessoresPanel().addRow(data);
		}
	}
	
	/**
	 * 
	 */
	private void showAdminTurmas()
	{
		ArrayList<Turma> turmas = Model.getData(Turma.class);
		getScreen().setDisplay(getScreen().getTurmaPanel());
		getScreen().getTurmaPanel().reset();
		for(Turma t : turmas)
		{
			String data[] = {
				t.getNome(),
				"Nao implementado!"
			};
			getScreen().getTurmaPanel().addRow(data);
		}
	}
	
	/**
	 * 
	 */
	private void novaTurma()
	{
		getScreen().setDisplay(getScreen().getCadastroTurma());
	}
	
	/**
	 * 
	 */
	private void criarTurma()
	{
		
		Turma turma = new Turma();
		turma.setNome(getScreen().getCadastroTurma().getNome());
		Model.createModel(turma);
		showAdminTurmas();
	}
	
	/**
	 * 
	 */
	private void novoProfessor()
	{
		AdminScreen screen = (AdminScreen) frame.getScreen();
		
		screen.showCadastroProfessor();
	}
	
	/**
	 * 
	 */
	private void cadastrarAluno()
	{
		
	}
	
	/**
	 * 
	 */
	private void criarProfessor()
	{
		AdminScreen screen = (AdminScreen) frame.getScreen();
		
		Professor professor = new Professor();
		professor.setNome(screen.getCadastroProfessor().getNome());
		professor.setRegistro(screen.getCadastroProfessor().getRegistro());
		professor.setDisciplina(screen.getCadastroProfessor().getDisciplina());
		Usuario usuario = new Usuario();
		usuario.setLogin(screen.getCadastroProfessor().getLogin());
		usuario.setSenha(screen.getCadastroProfessor().getSenha());
		usuario.setPessoa(professor);
		usuario.setTipo(Usuario.PROFESSOR);
		Model.createModel(professor);
		Model.createModel(usuario);
		showAdminProfessores();
	}
	
	private AdminScreen getScreen()
	{
		return (AdminScreen) frame.getScreen();
	}
	
}
