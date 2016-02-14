package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Application;

public class CadastroProfessor extends JPanel {

	private JButton button;
	
	JTextField nomeField = new JTextField(),
			   registroField = new JTextField(),
			   disciplinaField = new JTextField(),
			   loginField = new JTextField(),
			   senhaField = new JTextField();
	
	JTextField textFields[] = {
		nomeField, registroField, disciplinaField,
		loginField, senhaField
	};
	
	String stringLabels[] = {
		"Nome",
		"Registro",
		"Disciplina",
		"Login",
		"Senha"
	};
	
	
	public CadastroProfessor()
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
		
		for(int i = 0; i < labels.length; i++){
			labels[i] = new JLabel(stringLabels[i]);
			//textFields[i] = new JTextField();
			west.add(labels[i]);
			center.add(textFields[i]);
		}
		
		button = new JButton("Criar Professor");
		button.setActionCommand(Application.ADMIN_CRIAR_PROFESSOR_COMMAND);
		
		west.setOpaque(false);
		center.setOpaque(false);
		south.setOpaque(false);
		
		west.setLayout(new GridLayout(stringLabels.length,1,10,10));
		center.setLayout(new GridLayout(stringLabels.length,1,10,10));
		
		south.add(button);
		
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
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
	
	public String getRegistro()
	{
		return registroField.getText();
	}
	
	public String getDisciplina()
	{
		return disciplinaField.getText();
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
