package model;

public class Aluno extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -728954966906293875L;

	private String matricula;
	
	private Turma turma;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
}
