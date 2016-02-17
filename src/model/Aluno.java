package model;

import java.util.ArrayList;

import app.Model;

public class Aluno extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -728954966906293875L;

	// Instance fields --------------------------------------------------------
	
	private String matricula;
	
	private int turmaId;
	
	// Data operations --------------------------------------------------------
	
	/**
	 * 
	 */
	public ArrayList<Aula> getAulas()
	{
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		
		for(Aula a : (ArrayList<Aula>)Model.all(Aula.class))
			if(a.getTurmaId() == turmaId)
				aulas.add(a);
		
		return aulas;
	}
	
	/**
	 * 
	 */
	public ArrayList<Aula> getProfessorAulas(int professorId)
	{
		ArrayList<Aula> aulas = new ArrayList<Aula>();
		
		for(Aula a : (ArrayList<Aula>)Model.all(Aula.class))
			if(a.getTurmaId() == turmaId && a.getProfessorId() == professorId)
				aulas.add(a);
		
		return aulas;
	}
	
	/**
	 * 
	 */
	public ArrayList<Professor> getProfessores()
	{
		ArrayList<Professor> professores = new ArrayList<Professor>();
		
		for(Professor p : (ArrayList<Professor>)Model.all(Professor.class))
			if(p.getTurmaids().contains(turmaId))
				professores.add(p);
		
		return professores;
	}
	
	/**
	 * 
	 */
	public ArrayList<Avaliacao> getProfessorAvaliacoes(int professorId)
	{
		ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		
		Professor professor = (Professor) Model.find(Professor.class, professorId);
		
		for(Avaliacao a : professor.getTurmaAvaliacoes(turmaId))
			if(a.getProfessorId() == professorId)
				avaliacoes.add(a);
		
		return avaliacoes;
	}

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
