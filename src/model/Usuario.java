package model;

import java.util.ArrayList;

import app.Model;

public class Usuario extends Model{

	// Constants --------------------------------------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2770940305382218676L;

	public static final String PROFESSOR = "Professor";
	
	public static final String ALUNO = "Aluno";
	
	public static final String ADMINISTRADOR = "Administrador";
	
	// Static fields ----------------------------------------------------------
	
	private static Usuario usuarioAtual;
	
	// Instance fields --------------------------------------------------------
	
	private String login;
	
	private String senha;
	
	private String tipo;
	
	private int pessoaId;
	
	// Constructors -----------------------------------------------------------
	
	public Usuario()
	{
		
	}
	
	// Static methods ----------------------------------------------------------------
	
	public static boolean autenticar(String usuario, String senha)
	{
		ArrayList<Usuario> usuarios = Model.all(Usuario.class);
		
		for(int i = 0; i < usuarios.size(); i++)
		{
			Usuario u = (Usuario) usuarios.get(i);
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
	
	public void setPessoaId(int id){
		pessoaId = id;
	}
	
	public int getPessoaId(){
		return pessoaId;
	}
	
	public Pessoa getPessoa(){
		return (Pessoa)Model.find(Pessoa.class, pessoaId);
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
