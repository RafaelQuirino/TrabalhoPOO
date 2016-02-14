package gui;

import javax.swing.JButton;

import app.Application;
import model.Usuario;

public class AdminScreen extends Screen {
	
	// Constants --------------------------------------------------------------
	
	private static final String adminLabels[] = {
		"Cadastrar Professor",
		"Cadastrar Aluno"
	};
	
	private static final String adminCommands[] = {
		Application.ADMIN_CADASTRAR_PROFESSOR_COMMAND,
		Application.ADMIN_CADASTRAR_ALUNO_COMAND
	};
	
	// Instance fields --------------------------------------------------------
	
	private JButton buttons[];
	
	private CadastroProfessor cadastroProfessor;
	
	// Constructors -----------------------------------------------------------
	
	public AdminScreen()
	{
		super(adminLabels, adminCommands);
		
		addPath(Usuario.ADMINISTRADOR);
		
		cadastroProfessor = new CadastroProfessor();
	}
	
	// Methods ----------------------------------------------------------------
	
	public void showCadastroProfessor()
	{
		setDisplay(cadastroProfessor);
	}
	
}
