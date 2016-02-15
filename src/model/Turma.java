package model;

import java.util.ArrayList;

import app.Model;

public class Turma extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1250282954489643319L;
	
	// Instance fields --------------------------------------------------------
	
	private String nome;
	
	private ArrayList<Professor> professores;
	
	// Constructors -----------------------------------------------------------
	
	public Turma()
	{
		professores = new ArrayList<Professor>();
	}
	
	// Instance methods -------------------------------------------------------

	public String toString()
	{
		return nome;
	}
	
	// Setters and Getters ----------------------------------------------------
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public void addProfessor(Professor professor) {
		professores.add(professor);
	}
	
}
