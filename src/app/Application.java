package app;

import gui.Frame;
import gui.Login;
import gui.Screen;

public class Application {

	public static final String SAIR_COMMAND = "sair";
	
	public static final String ADMIN_CADASTRAR_PROFESSOR_COMMAND = "admin1";
	public static final String ADMIN_CADASTRAR_ALUNO_COMMAND = "admin2";
	public static final String ADMIN_NOVO_PROFESSOR_COMMAND = "admin334";
	public static final String ADMIN_CRIAR_PROFESSOR_COMMAND = "admin3";
	public static final String ADMIN_PROFESSORES = "admin4";
	public static final String ADMIN_ALUNOS = "admin5";
	
	public Application()
	{
		Frame frame = new Frame();
		
		frame.setLoginHandler(new LoginHandler(frame));
		frame.setAdminHandler(new AdminHandler(frame));
	}
	
}
