package model;

import java.util.ArrayList;

import app.Model;

public class Aula extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9161363761318894525L;

	// Instance fields --------------------------------------------------------
	
	private String data;
	
	private int professorId;
	
	private int turmaId;
	
	private ArrayList<Integer> alunoIds;
	
	// Constructors -----------------------------------------------------------
	
	public Aula()
	{
		alunoIds = new ArrayList<Integer>();
	}

	// Instance methods -------------------------------------------------------

	/**
	 * 
	 */
	public String toString()
	{
		return data;
	}
	
	/**
	 * 
	 */
	public boolean hasAlunoId(Integer id)
	{
		return alunoIds.contains(id);
	}
	
	// Data operations ---------------------------------------------------------
	
	/**
	 * 
	 */
	public Professor getProfessor()
	{
		return (Professor)Model.find(Professor.class, professorId);
	}
	
	/**
	 * 
	 */
	public int getFaltas()
	{
		return getTurma().getAlunos().size() - alunoIds.size();
	}
	
	/**
	 * 
	 */
	public Turma getTurma()
	{
		return (Turma)Model.find(Turma.class, turmaId);
	}
	
	// Setters and Getters ----------------------------------------------------
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public ArrayList<Integer> getAlunoIds() {
		return alunoIds;
	}

	public void addAlunoId(Integer alunoId) {
		alunoIds.add(alunoId);
	}

	public int getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(int turmaId) {
		this.turmaId = turmaId;
	}
	
}
