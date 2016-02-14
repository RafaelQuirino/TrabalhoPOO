package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gui.AdminScreen;
import gui.Frame;
import model.Professor;
import model.Usuario;

public class AdminHandler implements ActionListener {

	// Instance fields --------------------------------------------------------
	
	private Frame frame;
	
	// Constructors -----------------------------------------------------------
	
	public AdminHandler(Frame frame)
	{
		this.frame = frame;
	}
	
	// Methods ----------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
			//case Application.ADMIN_CADASTRAR_PROFESSOR_COMMAND:
			//	cadastrarProfessor();
			//	break;
			
			case Application.ADMIN_CADASTRAR_ALUNO_COMMAND:
				cadastrarAluno();
				break;
			
			case Application.ADMIN_PROFESSORES:
				showAdminProfessores();
				break;
			
			case Application.ADMIN_NOVO_PROFESSOR_COMMAND:
				novoProfessor();
				break;
			
			case Application.ADMIN_CRIAR_PROFESSOR_COMMAND:
				criarProfessor();
				break;
		}
	}
	
	/**
	 * 
	 */
	private void showAdminProfessores()
	{
		ArrayList<Professor> professores = Model.getData(Professor.class);
		
		AdminScreen screen = (AdminScreen) frame.getScreen();
		screen.showProfessores();
		screen.getProfessoresPanel().reset();
		for(Professor p : professores)
		{
			String data[] = {
					p.getNome(),
					p.getDisciplina()
			};
			screen.getProfessoresPanel().addRow(data);
		}
	}
	
	/**
	 * 
	 */
	private void novoProfessor()
	{
		AdminScreen screen = (AdminScreen) frame.getScreen();
		
		screen.showCadastroProfessor();
	}
	
	/**
	 * 
	 */
	private void cadastrarAluno()
	{
		
	}
	
	/**
	 * 
	 */
	private void criarProfessor()
	{
		AdminScreen screen = (AdminScreen) frame.getScreen();
		
		Professor professor = new Professor();
		professor.setNome(screen.getCadastroProfessor().getNome());
		professor.setRegistro(screen.getCadastroProfessor().getRegistro());
		professor.setDisciplina(screen.getCadastroProfessor().getDisciplina());
		Usuario usuario = new Usuario();
		usuario.setLogin(screen.getCadastroProfessor().getLogin());
		usuario.setSenha(screen.getCadastroProfessor().getSenha());
		usuario.setPessoa(professor);
		usuario.setTipo(Usuario.PROFESSOR);
		Model.createModel(professor);
		Model.createModel(usuario);
		showAdminProfessores();
	}
	
}
