package model;

import java.util.ArrayList;

import app.Model;

public class Professor extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2769021129402029211L;

	// Instance Fields --------------------------------------------------------
	
	private String registro;
	
	private String disciplina;
	
	private ArrayList<Integer> turmaIds;

	// Constructors -----------------------------------------------------------
	
	public Professor()
	{
		turmaIds = new ArrayList<Integer>();
	}
	
	// Methods ----------------------------------------------------------------
	
	public String toString()
	{
		return getNome();
	}
	
	/**
	 * 
	 */
	public ArrayList<Avaliacao> getTurmaAvaliacoes(int turmaId)
	{
		ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		
		for(Avaliacao a : (ArrayList<Avaliacao>)Model.all(Avaliacao.class))
			if(getId() == a.getProfessorId() && a.getTurmaId() == turmaId)
				avaliacoes.add(a);
		
		return avaliacoes;
		
	}
	
	/**
	 * 
	 */
	public ArrayList<Turma> getTurmas()
	{
		ArrayList<Turma> turmas = new ArrayList<Turma>();
		
		for(Turma t : (ArrayList<Turma>)Model.all(Turma.class))
			if(turmaIds.contains(t.getId()))
				turmas.add(t);
		
		return turmas;
	}
	
	// Setters and Getters ----------------------------------------------------
	
	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getRegistro() {
		return this.registro;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public ArrayList<Integer> getTurmaids(){
		return turmaIds;
	}

	public void addTurmaId(int id) {
		turmaIds.add(id);
	}
}
