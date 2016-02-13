package model;

import app.Model;

public class Pessoa extends Model{

	// Instance fields --------------------------------------------------------
	
	private String nome;
	
	// Constructors -----------------------------------------------------------
	
	public Pessoa(String nome)
	{
		this.nome = nome;
	}
	
	// Methods ----------------------------------------------------------------
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
}
