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
	
	private ArrayList<Integer> professorIds;
	
	// Constructors -----------------------------------------------------------
	
	public Turma()
	{
		professorIds = new ArrayList<Integer>();
	}
	
	// Instance methods -------------------------------------------------------

	/**
	 * 
	 */
	public String toString()
	{
		return nome;
	}
	
	/**
	 * 
	 */
	public ArrayList<Aluno> getAlunos()
	{
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		ArrayList all = all(Aluno.class);
		
		for(Aluno a : (ArrayList<Aluno>)all)
			if(a.getTurmaId() == getId())
				alunos.add(a);
		
		return alunos;
	}
	
	/**
	 * 
	 */
	public ArrayList<Professor> getProfessores()
	{
		return (ArrayList<Professor>) Model.findAll(Professor.class, professorIds);
	}
	
	// Setters and Getters ----------------------------------------------------
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Integer> getProfessorIds() {
		return professorIds;
	}

	public void addProfessorId(int id) {
		professorIds.add(id);
	}
	
}
