package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Application;
import model.Turma;

public class CadastroAluno extends JPanel {

	private JButton button;
	
	JTextField nomeField = new JTextField(),
			   matriculaField = new JTextField(),
			   loginField = new JTextField(),
			   senhaField = new JTextField();
	
	JTextField textFields[] = {
		nomeField, matriculaField,
		loginField, senhaField
	};
	
	String stringLabels[] = {
		"Nome",
		"Matrícula",
		"Login",
		"Senha"
	};
	
	private JComboBox<Turma> turmaList;
	
	
	public CadastroAluno()
	{
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300,300));
		setBackground(Color.blue);
		
		JPanel west = new JPanel(),
			   center = new JPanel(),
			   south = new JPanel();
		
		JLabel labels[] = new JLabel[stringLabels.length];

		turmaList = new JComboBox<Turma>(new Turma[0]);
		
		west.add(new JLabel("Turma"));
		center.add(turmaList);
		
		for(int i = 0; i < labels.length; i++){
			labels[i] = new JLabel(stringLabels[i]);
			//textFields[i] = new JTextField();
			west.add(labels[i]);
			center.add(textFields[i]);
		}
		
		button = new JButton("Novo Aluno");
		button.setActionCommand(Application.ADMIN_CRIAR_ALUNO_COMMAND);
		
		west.setOpaque(false);
		center.setOpaque(false);
		south.setOpaque(false);
		
		west.setLayout(new GridLayout(stringLabels.length+1,1,10,10));
		center.setLayout(new GridLayout(stringLabels.length+1,1,10,10));
		
		south.add(button);
		
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
	}
	
	public Turma getSelectedTurma()
	{
		return (Turma) turmaList.getSelectedItem();
	}
	
	public void resetTurma()
	{
		turmaList.removeAllItems();
	}
	
	public void addTurma(Turma t)
	{
		turmaList.addItem(t);
	}
	
	public void setHandler(ActionListener handler)
	{
		button.addActionListener(handler);
	}
	
	// Setters and Getters ----------------------------------------------------
	
	public String getNome()
	{
		return nomeField.getText();
	}
	
	public String getMatricula()
	{
		return matriculaField.getText();
	}
	
	public String getLogin()
	{
		return loginField.getText();
	}
	
	public String getSenha()
	{
		return senhaField.getText();
	}
	
}
