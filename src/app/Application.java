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
	
	public static final String ADMIN_TURMAS = "admin6";
	public static final String ADMIN_NOVA_TURMA_COMMAND = "admin3341234";
	public static final String ADMIN_CRIAR_TURMA_COMMAND = "admin33412344";
	
	public static final String ADMIN_ALUNOS = "admin5";
	public static final String ADMIN_NOVO_ALUNO_COMMAND = "novo aluno";
	public static final String ADMIN_CRIAR_ALUNO_COMMAND = "criar aluno";
	
	public Application()
	{
		Frame frame = new Frame();
		
		frame.setLoginHandler(new LoginHandler(frame));
		frame.setAdminHandler(new AdminHandler(frame));
	}
	
}
