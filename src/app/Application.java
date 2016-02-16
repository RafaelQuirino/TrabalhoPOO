package app;

import gui.Frame;
import gui.Login;
import gui.Screen;

public class Application {

	public static final String SAIR_COMMAND = "sair";
	
	public static final String ADMIN_PROFESSORES = "Professores";
	public static final String ADMIN_NOVO_PROFESSOR_COMMAND = "Novo Professor";	
	public static final String ADMIN_CRIAR_PROFESSOR_COMMAND = "Criar Professor";
	
	public static final String ADMIN_TURMAS = "Turmas";
	public static final String ADMIN_NOVA_TURMA_COMMAND = "Nova Turma";
	public static final String ADMIN_CRIAR_TURMA_COMMAND = "Criar Turma";
	public static final String ADMIN_ADICIONAR_TURMA_COMMAND = "Adicionar Turma";
	public static final String ADMIN_DO_ADICIONAR_TURMA_COMMAND = "Do Adicionar Turma";
	
	public static final String ADMIN_ALUNOS = "Alunos";
	public static final String ADMIN_NOVO_ALUNO_COMMAND = "Novo Aluno";
	public static final String ADMIN_CRIAR_ALUNO_COMMAND = "Criar Aluno";
	
	public static final String PROFESSOR_AVALIACOES = "professor avaliacoes";
	public static final String PROFESSOR_NOVA_AVALIACAO = "nova avaliacao";
	public static final String PROFESSOR_NOVA_AVALIACAO_CHANGE_COMBO = "pcacc";
	public static final String PROFESSOR_CRIAR_AVALIACAO = "Criar Avaliação";
	public static final String PROFESSOR_AVALIACAO_RELATORIO = "Relatorio Avaliacao";
	public static final String PROFESSOR_AVALIACAO_GERAR_RELATORIO = "Gerar Relatorio Avaliacao";
	
	public Application()
	{
		Frame frame = new Frame();
		
		frame.setLoginHandler(new LoginHandler(frame));
		frame.setAdminHandler(new AdminHandler(frame));
		frame.setProfessorHandler(new ProfessorHandler(frame));
	}
	
}
