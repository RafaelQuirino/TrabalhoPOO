package model;

import app.Model;

public class Aluno extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -728954966906293875L;

	// Instance fields --------------------------------------------------------
	
	private String matricula;
	
	private int turmaId;

	// Setters and Getters ----------------------------------------------------
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Turma getTurma() {
		return (Turma) Model.find(Turma.class, turmaId);
	}

	public int getTurmaId(){
		return turmaId;
	}
	
	public void setTurmaId(int id) {
		turmaId = id;
	}
	
	
}
