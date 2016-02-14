package model;

import app.Model;

public class Pessoa extends Model{

	// Instance fields --------------------------------------------------------
	
	private String nome;
	
	private String email;
	
	private String sexo;
	
	private String dataNascimento;
	
	// Methods ----------------------------------------------------------------
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
}
