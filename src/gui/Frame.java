package gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import app.LoginHandler;
import model.Usuario;

public class Frame extends JFrame {

	// GUI constants ----------------------------------------------------------
	
	private static final int WIDTH = 700;
	private static final int HEIGHT = 600;
	
	private static final boolean MAXIMIZED = true;
	
	// Instance fields --------------------------------------------------------
	
	Login login;
	Screen screen;
	
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
	
	public void addLoginHandler(LoginHandler handler)
	{
		login.addHandler(handler);
	}
	
	public Login getLogin()
	{
		return login;
	}
	
	public void doLogin()
	{
		Usuario usuario = Usuario.getUsuarioAtual();
		
		screen = new Screen();
		
		screen.addMenu("Disciplinas", null);
		screen.addMenu("Avaliações", null);
		screen.addMenu("Frequência", null);
		
		String text = usuario.getTipo() + ": " + usuario.getPessoa().getNome();
		
		screen.setHeaderText(text);
		
		setContentPane(screen);
		validate();
	}
	
}
