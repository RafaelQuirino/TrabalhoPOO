package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.AlunoScreen;
import gui.Frame;
import model.Aluno;
import model.Usuario;

public class AlunoHandler implements ActionListener {
	
	// Instance fields --------------------------------------------------------
	
	private Frame frame;
	
	// Constructors -----------------------------------------------------------
	
	public AlunoHandler(Frame frame)
	{
		this.frame = frame;
	}
	
	// Methods ----------------------------------------------------------------
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch(e.getActionCommand())
		{
			case Application.PROFESSOR_AVALIACOES:
				//avaliacoes();
				break;
		}
		getScreen().validate();
	}
	
	
	/////////////
	// Helpers //==============================================================
	/////////////
	
	/**
	 * 
	 */
	private AlunoScreen getScreen()
	{
		return (AlunoScreen) frame.getScreen();
	}
	
	/**
	 * 
	 */
	private int getAlunoId()
	{
		return Usuario.getUsuarioAtual().getPessoaId();
	}
	
	/**
	 * 
	 */
	private Aluno getAluno()
	{
		return (Aluno)Model.find(Aluno.class, getAlunoId());
	}
	
}
