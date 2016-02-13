package model;

import java.util.ArrayList;

import app.Model;

public class Usuario extends Model{

	// Constants --------------------------------------------------------------
	
	public static final String PROFESSOR = "Professor";
	
	public static final String ALUNO = "Aluno";
	
	public static final String ADMINISTRADOR = "Administrador";
	
	// Static fields ----------------------------------------------------------
	
	private static Usuario usuarioAtual;
	
	// Instance fields --------------------------------------------------------
	
	private String login;
	
	private String senha;
	
	private String tipo;
	
	private Pessoa pessoa;
	
	// Constructors -----------------------------------------------------------
	
	public Usuario()
	{
		
	}
	
	// Static methods ----------------------------------------------------------------
	
	public static boolean autenticar(String usuario, String senha)
	{
		ArrayList<Usuario> usuarios = Model.getData("usuario");
		
		for(Usuario u : usuarios)
		{
			if(u.getSenha().equals(senha))
			{
				usuarioAtual = u;
				return true;
			}
		}
		return false;
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
	
	public void setLogin(String login){
		this.login = login;
	}
	
	public String getLogin(){
		return login;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}
	
	public String getSenha(){
		return senha;
	}
}
