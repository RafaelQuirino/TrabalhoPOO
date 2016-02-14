package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui.Frame;
import gui.Login;
import model.Usuario;

public class LoginHandler implements ActionListener{
	
	// Instance fields --------------------------------------------------------
	
	private Frame frame;
	
	// Constructors -----------------------------------------------------------
	
	public LoginHandler(Frame frame)
	{
		this.frame = frame;
	}
	
	// Methods ----------------------------------------------------------------

	@Override
	public void actionPerformed(ActionEvent e)
	{
		Login login = frame.getLogin();
		
		if(Usuario.autenticar(login.getUser(), login.getPassword()))
		{
			frame.doLogin();
		}
		else
		{
			JOptionPane.showMessageDialog(
				null,
				"Usuário ou senha inválidos!",
				"Erro",
				JOptionPane.ERROR_MESSAGE
			);
			login.resetAuthentication();
		}
	}
	
}
