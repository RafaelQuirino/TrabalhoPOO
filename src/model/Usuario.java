package model;

import app.Model;

public class Usuario extends Model{

	// Constants --------------------------------------------------------------
	
	public static final String PROFESSOR = "Professor";
	
	public static final String ALUNO = "Aluno";
	
	// Static fields ----------------------------------------------------------
	
	private static Usuario usuarioAtual;
	
	// Instance fields --------------------------------------------------------
	
	private String tipo;
	
	private Pessoa pessoa;
	
	// Constructors -----------------------------------------------------------
	
	public Usuario()
	{
		
	}
	
	// Static methods ----------------------------------------------------------------
	
	public static boolean autenticar(String usuario, String senha)
	{
		Usuario u = new Usuario();
		u.setPessoa(new Pessoa("Joao"));
		u.setTipo(Usuario.ALUNO);
		
		usuarioAtual = u;
		return true;
	}
	
	public static Usuario getUsuarioAtual()
	{
		return usuarioAtual;
	}
	
	// Instance methods -------------------------------------------------------
	
	public void setPessoa(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	
	public Pessoa getPessoa(){
		return pessoa;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return tipo;
	}
}
