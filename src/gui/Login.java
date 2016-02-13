package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Login extends JPanel {
	
	private static final int WIDTH = 450;
	private static final int HEIGHT = 250;
	
	private static final Color BG_COLOR = Color.WHITE;
	
	private static final Color LOGIN_BG_COLOR = new Color(250,250,250);
	private static final Color LOGIN_BORDER_COLOR = new Color(230,230,230);
	
	private static final String LABEL_TEXT = "Login";
	
	private JPanel innerPanel;
	private JPanel headerPanel;
	
	private MainPanel mainPanel;
	
	public Login()
	{
		innerPanel = new JPanel();
		innerPanel.setOpaque(false);
		innerPanel.setLayout(new BorderLayout());
		
		headerPanel = new JPanel();
		headerPanel.setOpaque(false);
		headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		headerPanel.setPreferredSize(new Dimension(0,80));
		
		JLabel label = new JLabel(LABEL_TEXT);
		label.setFont(new Font("Serif", Font.PLAIN, 44));
		headerPanel.add(label);
		
		mainPanel = new MainPanel();
		
		innerPanel.add(headerPanel, BorderLayout.NORTH);
		innerPanel.add(mainPanel, BorderLayout.CENTER);
		
		add(innerPanel);
		
		setBackground(BG_COLOR);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
		setPreferredSize(new Dimension(100,100));
	}
	
	private class MainPanel extends JPanel
	{
		
		public MainPanel()
		{
			setPreferredSize(new Dimension(Login.WIDTH, Login.HEIGHT));
			setBackground(LOGIN_BG_COLOR);
			setBorder(BorderFactory.createLineBorder(LOGIN_BORDER_COLOR));
			setLayout(new FlowLayout(FlowLayout.CENTER, 0, 35));
			
			JPanel innerPanel = new JPanel(),
				   leftPanel = new JPanel(),
				   rightPanel = new JPanel();
			
			JLabel usuarioLabel = new JLabel("Usuário"),
				   senhaLabel = new JLabel("Senha");
			
			JTextField usuarioField = new JTextField();
			JPasswordField senhaField = new JPasswordField();
			
			JButton button = new JButton("Entrar");
			
			Font font = new Font("Serif", Font.PLAIN, 20);
			
			innerPanel.setPreferredSize(new Dimension(
				Login.WIDTH - 70,
				Login.HEIGHT - 70
			));
			
			innerPanel.setLayout(new BorderLayout());
			innerPanel.setOpaque(false);
			innerPanel.add(leftPanel, BorderLayout.WEST);
			innerPanel.add(rightPanel, BorderLayout.CENTER);
			innerPanel.add(button, BorderLayout.SOUTH);
			
			button.setPreferredSize(new Dimension(0,40));
			
			usuarioLabel.setOpaque(false);
			senhaLabel.setOpaque(false);
			
			usuarioLabel.setFont(font);
			senhaLabel.setFont(font);
			
			leftPanel.setPreferredSize(new Dimension(120,0));
			
			Border border1 = BorderFactory.createEmptyBorder(0,0,30,0);
			leftPanel.setBorder(border1);
			rightPanel.setBorder(border1);
			
			Insets textFieldInsets = new Insets(0,10,0,10);
			usuarioField.setMargin(textFieldInsets);
			senhaField.setMargin(textFieldInsets);
			
			Font textFieldFont = new Font("Serif", Font.PLAIN, 16);
			usuarioField.setFont(textFieldFont);
			senhaField.setFont(textFieldFont);
			
			leftPanel.setLayout(new GridLayout(2, 1, 0, 30));
			rightPanel.setLayout(new GridLayout(2, 1, 0, 30));
			
			leftPanel.setOpaque(false);
			rightPanel.setOpaque(false);
			
			leftPanel.add(usuarioLabel);
			leftPanel.add(senhaLabel);
			
			rightPanel.add(usuarioField);
			rightPanel.add(senhaField);
			
			add(innerPanel);
		}
	}
	
}
