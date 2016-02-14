package app;

import gui.Frame;
import gui.Login;
import gui.Screen;

public class Application {

	public static final String SAIR_COMMAND = "sair";
	
	public static final String ADMIN_CADASTRAR_PROFESSOR_COMMAND = "acpc";
	public static final String ADMIN_CADASTRAR_ALUNO_COMAND = "acac";
	
	public Application()
	{
		Frame frame = new Frame();
		
		frame.setLoginHandler(new LoginHandler(frame));
		frame.setAdminHandler(new AdminHandler(frame));
	}
	
}
