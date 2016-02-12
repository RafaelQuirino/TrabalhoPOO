package model;

public class Aluno {
	
	private String Name, Matricula, Endereco;
	private float Media;
	
	void setName(String name){
		this.Name = name;
	}
	
	String getName(){
		return this.Name;
	}
	
	void setMatricula(String matricula){
		this.Matricula = matricula;
	}
	
	String getMatricula(){
		return this.Matricula;
	}
	
	void setEndereco(String end){
		this.Endereco = end;
	}
	
	String getEndereco(){
		return this.Endereco;
	}
	
	void setMedia(float media){
		this.Media = media;
	}
	
	float getMedia(){
		return this.Media;
	}
	
}
