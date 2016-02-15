package model;

import java.util.ArrayList;

public class Professor extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2769021129402029211L;

	private String registro;
	
	private String disciplina;
	
	private ArrayList<Turma> turmas;

	public Professor()
	{
		turmas = new ArrayList<Turma>();
	}
	
	public String toString()
	{
		return getNome();
	}
	
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

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public void addTurma(Turma turma) {
		turmas.add(turma);
	}
}
