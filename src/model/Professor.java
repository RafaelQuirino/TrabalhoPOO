package model;

public class Professor extends Pessoa {

	private String registro;
	
	private String disciplina;

	void setRegistro(String registro) {
		this.registro = registro;
	}

	String getRegistro() {
		return this.registro;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
