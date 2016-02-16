package model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import app.Model;

public class Avaliacao extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3194407473000991187L;

	// Instance fields --------------------------------------------------------
	
	private int turmaId;
	
	private int professorId;
	
	private String data;
	
	private String nome;
	
	private Hashtable<Integer,Float> notas;

	// Constructors -----------------------------------------------------------
	
	public Avaliacao()
	{
		notas = new Hashtable<Integer, Float>();
	}
	
	// Instance methods -------------------------------------------------------
	
	public ArrayList<Integer> getAlunoIds()
	{
		ArrayList<Integer> ids = new ArrayList<Integer>();
		Enumeration e = notas.keys();
		
		while(e.hasMoreElements())
			ids.add((Integer)e.nextElement());
		
		return ids;
	}
	
	public float media()
	{
		ArrayList<String> keys = new ArrayList<String>();
		
		float soma = 0;
		int count = 0;
		
		Enumeration e = notas.keys();
		
		while(e.hasMoreElements()){
			soma += notas.get(e.nextElement());
			count += 1;
		}
		
		return soma/count;
	}
	
	public String toString()
	{
		return getNome();
	}
	
	// Setters and Getters ----------------------------------------------------
	
	public void addNota(float nota, int alunoId) {
		notas.put(alunoId, nota);
	}

	public float getNota(int alunoId) {
		return notas.get(alunoId);
	}
	
	public Turma getTurma() {
		return (Turma)Model.find(Turma.class, turmaId);
	}
	
	public int getTurmaId(){
		return turmaId;
	}
	
	public void setTurmaId(int id) {
		turmaId = id;
	}

	public Professor getProfessor() {
		return (Professor) Model.find(Professor.class, professorId);
	}
	
	public int getProfessorId(){
		return professorId;
	}

	public void setProfessorId(int id) {
		professorId = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
