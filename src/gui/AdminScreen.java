package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import app.Application;
import model.Professor;
import model.Turma;
import model.Usuario;

public class AdminScreen extends Screen {
	
	// Constants --------------------------------------------------------------
	
	private static final String adminLabels[] = {
		"Professores",
		"Turmas",
		"Alunos"
	};
	
	private static final String adminCommands[] = {
		Application.ADMIN_PROFESSORES,
		Application.ADMIN_TURMAS,
		Application.ADMIN_ALUNOS
	};
	
	private static final String PROFESSORES_COLUMNS[] = {
		"Registro",
		"Nome",
		"Disciplina",
		"Turmas"
	};
	
	private static final String TURMAS_COLUMNS[] = {
		"Nome",
		"Alunos"
	};
	
	private static final String ALUNOS_COLUMNS[] = {
		"Nome",
		"Matricula",
		"Turma"
	};
	
	// Instance fields --------------------------------------------------------
	
	private JButton buttons[];
	
	private ListagemPanel professoresPanel;
	private CadastroPanel cadastroProfessor;
	private CadastroPanel adicionarTurmaPanel;
	
	private ListagemPanel turmaPanel;
	private CadastroPanel cadastroTurma;
	
	private ListagemPanel alunosPanel;
	private CadastroPanel cadastroAluno;
	
	// Constructors -----------------------------------------------------------
	
	public AdminScreen()
	{
		super(adminLabels, adminCommands);
		
		addPath(Usuario.ADMINISTRADOR);
		
		// professoresPanel setup
		
		professoresPanel = new ListagemPanel(PROFESSORES_COLUMNS);
		
		professoresPanel.addButton(
			"Novo Professor", Application.ADMIN_NOVO_PROFESSOR_COMMAND
		);
		professoresPanel.addButton(
			"Adicionar Turma", Application.ADMIN_ADICIONAR_TURMA_COMMAND
		);
		
		// cadastroProfessor setup
		
		cadastroProfessor = new CadastroPanel(
			"Criar Professor", Application.ADMIN_CRIAR_PROFESSOR_COMMAND
		);
		cadastroProfessor.addRow("Nome", new JTextField());
		cadastroProfessor.addRow("Registro", new JTextField());
		cadastroProfessor.addRow("Disciplina", new JTextField());
		cadastroProfessor.addRow("Login", new JTextField());
		cadastroProfessor.addRow("Senha", new JPasswordField());
		
		// adicionarTurmaPanel setup
		
		adicionarTurmaPanel = new CadastroPanel(
			"Adicionar Turma", Application.ADMIN_DO_ADICIONAR_TURMA_COMMAND
		);
		adicionarTurmaPanel.addRow("Professor", new JComboBox<Professor>());
		adicionarTurmaPanel.addRow("Turma", new JComboBox<Turma>());
		
		// turmaPanel setup
		
		turmaPanel = new ListagemPanel(TURMAS_COLUMNS);
		
		turmaPanel.addButton(
			"Nova Turma", Application.ADMIN_NOVA_TURMA_COMMAND
		);
		
		// cadastroTurma setup
		
		cadastroTurma = new CadastroPanel(
			"Criar Turma", Application.ADMIN_CRIAR_TURMA_COMMAND
		);
		cadastroTurma.addRow("Nome", new JTextField());
		
		// alunosPanel setup
		
		alunosPanel = new ListagemPanel(ALUNOS_COLUMNS);
		
		alunosPanel.addButton(
			"Novo Aluno", Application.ADMIN_NOVO_ALUNO_COMMAND
		);
		
		// cadastroAluno setup
		
		cadastroAluno = new CadastroPanel(
			"Criar Aluno", Application.ADMIN_CRIAR_ALUNO_COMMAND
		);
		cadastroAluno.addRow("Turma", new JComboBox<Turma>());
		cadastroAluno.addRow("Nome", new JTextField());
		cadastroAluno.addRow("Matrícula", new JTextField());
		cadastroAluno.addRow("Login", new JTextField());
		cadastroAluno.addRow("Senha", new JPasswordField());
	}
	
	// Methods ----------------------------------------------------------------
	
	/**
	 * 
	 */
	public void showProfessores1()
	{
		setDisplay(professoresPanel);
	}
	
	
	/**
	 * 
	 */
	public void showCadastroProfessor()
	{
		cadastroProfessor.clear();
		setDisplay(cadastroProfessor);
	}
	
	/**
	 * 
	 */
	public void setHandler(ActionListener handler)
	{
		super.setHandler(handler);
		cadastroProfessor.setHandler(handler);
		professoresPanel.setHandler(handler);
		turmaPanel.setHandler(handler);
		cadastroTurma.setHandler(handler);
		alunosPanel.setHandler(handler);
		cadastroAluno.setHandler(handler);
		adicionarTurmaPanel.setHandler(handler);
	}
	
	// Setters and Getters ----------------------------------------------------
	
	public CadastroPanel getCadastroProfessor()
	{
		return cadastroProfessor;
	}
	
	public ListagemPanel getProfessoresPanel()
	{
		return professoresPanel;
	}
	
	public ListagemPanel getTurmaPanel()
	{
		return turmaPanel;
	}
	
	public CadastroPanel getCadastroTurma()
	{
		return cadastroTurma;
	}
	
	public ListagemPanel getAlunosPanel()
	{
		return alunosPanel;
	}
	
	public CadastroPanel getCadastroAluno()
	{
		return cadastroAluno;
	}
	
	public CadastroPanel getAdicionarTurmaPanel()
	{
		return adicionarTurmaPanel;
	}
}
