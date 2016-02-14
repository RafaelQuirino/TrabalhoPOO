package model;

import app.Model;

public class Turma extends Model {

	private String nome;

	public String toString()
	{
		return nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
