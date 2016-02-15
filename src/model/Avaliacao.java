package model;

import java.util.ArrayList;

import app.Model;

public class Avaliacao extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3194407473000991187L;

	private Turma turma;
	
	private Professor professor;
	
	private ArrayList<Aluno> alunos;

	public Avaliacao()
	{
		alunos = new ArrayList<Aluno>();
	}
	
	public Turma getTurma() {
		return turma;
	}
	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
}
