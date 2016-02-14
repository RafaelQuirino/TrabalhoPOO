package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.AdminScreen;
import gui.Frame;

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
			case Application.ADMIN_CADASTRAR_PROFESSOR_COMMAND:
				cadastrarProfessor();
				break;
			
			case Application.ADMIN_CADASTRAR_ALUNO_COMAND:
				cadastrarAluno();
				break;
		}
	}
	
	private void cadastrarProfessor()
	{
		AdminScreen screen = (AdminScreen) frame.getScreen();
		
		screen.showCadastroProfessor();
	}
	
	private void cadastrarAluno()
	{
		
	}
	
}
