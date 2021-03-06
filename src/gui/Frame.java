package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import app.AdminHandler;
import app.AlunoHandler;
import app.LoginHandler;
import app.ProfessorHandler;
import model.Usuario;

public class Frame extends JFrame {

	// GUI constants ----------------------------------------------------------
	
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 600;
	
	private static final boolean MAXIMIZED = true;
	
	// Instance fields --------------------------------------------------------
	
	private Login login;
	
	private Screen screen;
	
	private AdminHandler adminHandler;
	
	private ProfessorHandler professorHandler;
	
	private AlunoHandler alunoHandler;
	
	// Constructors -----------------------------------------------------------
	
	public Frame()
	{
		login = new Login();
		
		setContentPane(login);
		login.resetAuthentication();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		if(MAXIMIZED)
			setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
	// Methods ----------------------------------------------------------------
	
	/**
	 * 
	 */
	public void doLogin()
	{
		Usuario usuario = Usuario.getUsuarioAtual();
		
		switch(usuario.getTipo())
		{
			case Usuario.ADMINISTRADOR:
				screen = new AdminScreen();
				screen.setHandler(adminHandler);
				adminHandler.listagemProfessores();
				break;
			
			case Usuario.PROFESSOR:
				screen = new ProfessorScreen();
				screen.setHandler(professorHandler);
				professorHandler.avaliacoes();
				break;
				
			case Usuario.ALUNO:
				screen = new AlunoScreen();
				screen.setHandler(alunoHandler);
				alunoHandler.avaliacoes();
				break;
		}
		
		screen.setHeaderText(usuario.getTipo() + ": " + usuario.getPessoa().getNome());
		
		screen.setSairHandler(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(login);
				login.resetAuthentication();
				validate();
			}
		});
		
		setContentPane(screen);
		validate();
	}
	
	// Setters and Getters ----------------------------------------------------
	
	public Login getLogin(){
		return login;
	}
	
	public Screen getScreen(){
		return screen;
	}
	
	public void setLoginHandler(LoginHandler handler){
		login.addHandler(handler);
	}
	
	public void setAdminHandler(AdminHandler adminHandler){
		this.adminHandler = adminHandler;
	}
	
	public void setProfessorHandler(ProfessorHandler handler){
		this.professorHandler = handler;
	}
	
	public void setAlunoHandler(AlunoHandler handler){
		this.alunoHandler = handler;
	}
}
