package gui;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.Application;
import model.Usuario;

public class AdminScreen extends Screen {
	
	// Constants --------------------------------------------------------------
	
	private static final String adminLabels[] = {
		"Professores",
		"Alunos"
	};
	
	private static final String adminCommands[] = {
		Application.ADMIN_PROFESSORES,
		Application.ADMIN_ALUNOS
	};
	
	// Instance fields --------------------------------------------------------
	
	private JButton buttons[];
	
	private ProfessoresPanel professoresPanel;
	
	private CadastroProfessor cadastroProfessor;
	
	// Constructors -----------------------------------------------------------
	
	public AdminScreen()
	{
		super(adminLabels, adminCommands);
		
		addPath(Usuario.ADMINISTRADOR);
		
		professoresPanel = new ProfessoresPanel();
		cadastroProfessor = new CadastroProfessor();
	}
	
	// Methods ----------------------------------------------------------------
	
	/**
	 * 
	 */
	public void showProfessores()
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
}
