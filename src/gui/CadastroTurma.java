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

public class CadastroTurma extends JPanel {

	private JButton button;
	
	JTextField nomeField = new JTextField();
	
	JTextField textFields[] = {
		nomeField
	};
	
	String stringLabels[] = {
		"Nome"
	};
	
	
	public CadastroTurma()
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
		
		button = new JButton("Criar Turma");
		button.setActionCommand(Application.ADMIN_CRIAR_TURMA_COMMAND);
		
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

}
