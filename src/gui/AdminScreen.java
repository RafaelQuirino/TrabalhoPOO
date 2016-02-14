package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.Application;
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
	
	// Instance fields --------------------------------------------------------
	
	private JButton buttons[];
	
	private ProfessoresPanel professoresPanel;
	private CadastroProfessor cadastroProfessor;
	
	private TurmaPanel turmaPanel;
	private CadastroTurma cadastroTurma;
	
	private AlunosPanel alunosPanel;
	private CadastroAluno cadastroAluno;
	
	// Constructors -----------------------------------------------------------
	
	public AdminScreen()
	{
		super(adminLabels, adminCommands);
		
		addPath(Usuario.ADMINISTRADOR);
		
		professoresPanel = new ProfessoresPanel();
		cadastroProfessor = new CadastroProfessor();
		
		turmaPanel = new TurmaPanel();
		cadastroTurma = new CadastroTurma();
		
		alunosPanel = new AlunosPanel();
		cadastroAluno = new CadastroAluno();
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
	}
	
	// Setters and Getters ----------------------------------------------------
	
	public CadastroProfessor getCadastroProfessor()
	{
		return cadastroProfessor;
	}
	
	public ProfessoresPanel getProfessoresPanel()
	{
		return professoresPanel;
	}
	
	public TurmaPanel getTurmaPanel()
	{
		return turmaPanel;
	}
	
	public CadastroTurma getCadastroTurma()
	{
		return cadastroTurma;
	}
	
	public AlunosPanel getAlunosPanel()
	{
		return alunosPanel;
	}
	
	public CadastroAluno getCadastroAluno()
	{
		return cadastroAluno;
	}
}
