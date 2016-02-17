package gui;

import java.awt.event.ActionListener;

import app.Application;

public class AlunoScreen extends Screen {

	// Constants --------------------------------------------------------------
	
	private static final String labels[] = {
		"Avaliações",
		"Aulas"
	};
	
	private static final String commands[] = {
		Application.PROFESSOR_AVALIACOES,
		Application.PROFESSOR_AULAS
	};
	
	// Instance fields --------------------------------------------------------
	
	
	// Constructors -----------------------------------------------------------
	
	public AlunoScreen()
	{
		super(labels, commands);
		

	}
	
	// Instance Methods -------------------------------------------------------
	
	public void setHandler(ActionListener handler)
	{
		super.setHandler(handler);
		
		
	}
	
	// Setters and Getters ----------------------------------------------------

	
}
