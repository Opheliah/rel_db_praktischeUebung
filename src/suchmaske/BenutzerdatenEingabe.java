package suchmaske;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;

import control.Connection;

public class BenutzerdatenEingabe extends JFrame {
	
	private JPanel contentPane;
	private JTextField benutzernamefeld=new JTextField();
	private JPasswordField passwortfeld=new JPasswordField();
	private String benutzername;
	private char[] passwort;
	private ErsterEntwurf benutzerdateneingabe=new ErsterEntwurf();
	
	
	public BenutzerdatenEingabe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 224);
		contentPane = new JPanel();
		getContentPane().setLayout(null);
		
		
		benutzernamefeld.setBounds(23, 78, 134, 28);
		benutzernamefeld.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField zwischentext=(JTextField) e.getSource();
				try {
				benutzername=zwischentext.getText();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(benutzernamefeld);
		benutzernamefeld.setColumns(10);
		
		
		passwortfeld.setBounds(193, 78, 134, 28);
		passwortfeld.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JPasswordField zwischenpasswort=new JPasswordField();
				zwischenpasswort = (JPasswordField) e.getSource();
				try {
				passwort=zwischenpasswort.getPassword();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		getContentPane().add(passwortfeld);
		
		JLabel lblNewLabel = new JLabel("Benutzername");
		lblNewLabel.setBounds(30, 38, 114, 28);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Passwort");
		lblNewLabel_1.setBounds(200, 38, 100, 28);
		getContentPane().add(lblNewLabel_1);
		
		JButton butBestaetigen = new JButton("Best\u00E4tigen");
		butBestaetigen.setBounds(183, 149, 117, 29);
		butBestaetigen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String passwortString=String.valueOf(passwort);
				Connection verbindung=new Connection();
				//verbindung.setPass(passwortString);
				//verbindung.setUser(benutzername);
			}
		});
		getContentPane().add(butBestaetigen);
	}
}
