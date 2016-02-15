package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import app.Application;
import model.Professor;
import model.Turma;

public class AdicionarTurmaPanel extends JPanel {

	private JButton adicionarTurmaButton;
	
	private JComboBox<Professor> professoresCombo;
	
	private JComboBox<Turma> turmasCombo;
	
	public AdicionarTurmaPanel()
	{
		setLayout(new GridLayout(3,1,10,10));
		setOpaque(false);
		setPreferredSize(new Dimension(400,200));
		
		professoresCombo = new JComboBox<Professor>();
		turmasCombo = new JComboBox<Turma>();
		
		adicionarTurmaButton = new JButton("Adicionar Turma");
		adicionarTurmaButton.setActionCommand(Application.ADMIN_DO_ADICIONAR_TURMA_COMMAND);
		
		add(professoresCombo);
		add(turmasCombo);
		add(adicionarTurmaButton);
	}
	
	public void reset()
	{
		professoresCombo.removeAllItems();
		turmasCombo.removeAllItems();
	}
	
	public void addProfessor(Professor professor)
	{
		professoresCombo.addItem(professor);
	}
	
	public void addTurma(Turma turma)
	{
		turmasCombo.addItem(turma);
	}
	
	public void setHandler(ActionListener handler)
	{
		adicionarTurmaButton.addActionListener(handler);
	}

	public JButton getAdicionarTurmaButton() {
		return adicionarTurmaButton;
	}

	public JComboBox getProfessoresCombo() {
		return professoresCombo;
	}

	public JComboBox getTurmasCombo() {
		return turmasCombo;
	}
	
}
