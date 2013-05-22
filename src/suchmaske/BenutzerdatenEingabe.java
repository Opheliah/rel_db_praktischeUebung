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
import java.awt.Font;


	


public class BenutzerdatenEingabe extends JFrame {
	
	final BenutzerdatenEingabe currentWindow=this;
	
	private JPanel contentPane;
	private JTextField benutzernamefeld=new JTextField();
	private JPasswordField passwortfeld=new JPasswordField();
	private String benutzername="";
	private char[] passwort={};
	private ErsterEntwurf benutzerdateneingabe=new ErsterEntwurf();
	private JTextField hostnamefeld=new JTextField();
	private JTextField portfeld=new JTextField();
	private JTextField sidfeld=new JTextField();
	private String hostname="";
	private String port="";
	private String sid="";
	private LoginBestaetigung bestaetigeVerbindung;
	
	
	
	public BenutzerdatenEingabe() {
		getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		getContentPane().setLayout(null);
		
		
		//Eingabefelder:
		
		hostnamefeld.setBounds(133, 41, 214, 28);
		hostnamefeld.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField zwischenfeld=new JTextField();
				zwischenfeld=(JTextField) e.getSource();
				hostname=zwischenfeld.getText();
			}
		});
		getContentPane().add(hostnamefeld);
		hostnamefeld.setColumns(10);
		
		
		portfeld.setBounds(133, 81, 214, 28);
		portfeld.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JTextField zwischenfeld=new JTextField();
				zwischenfeld=(JTextField) e.getSource();
				port=zwischenfeld.getText();
			}
		});
		getContentPane().add(portfeld);
		portfeld.setColumns(10);
		
		
		sidfeld.setBounds(133, 121, 214, 28);
		sidfeld.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField zwischenfeld=(JTextField) e.getSource();
				sid=zwischenfeld.getText();
			}
		});
		getContentPane().add(sidfeld);
		sidfeld.setColumns(10);
		
		
		benutzernamefeld.setBounds(133, 161, 214, 28);
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
		
		
		passwortfeld.setBounds(133, 201, 214, 28);
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
		
		//Labels:
		
		
		JLabel lblHostname = new JLabel("Hostname");
		lblHostname.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblHostname.setBounds(25, 44, 126, 22);
		getContentPane().add(lblHostname);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblPort.setBounds(25, 87, 126, 16);
		getContentPane().add(lblPort);
		
		JLabel lblNewLabel_2 = new JLabel("SID");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(25, 123, 141, 22);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Benutzername");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setBounds(25, 161, 114, 28);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Passwort");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(25, 200, 100, 28);
		getContentPane().add(lblNewLabel_1);
		
		
		//Bestaetigen:
		
		JButton butBestaetigen = new JButton("Best\u00E4tigen");
		butBestaetigen.setBounds(240, 275, 117, 29);
		butBestaetigen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				try{
				String passwortString=String.valueOf(passwort);
				//Connection verbindung=new Connection();
				boolean verbunden=false;
				//boolean verbunden=verbindung.login(hostname, port, sid, benutzername, passwort);
				bestaetigeVerbindung=new LoginBestaetigung(verbunden);
				bestaetigeVerbindung.setVisible(true);
				
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		getContentPane().add(butBestaetigen);
		
		JButton butFensterschliessen=new JButton("Fenster schliessen");
		butFensterschliessen.setBounds(25, 275, 141, 29);
		butFensterschliessen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentWindow.setVisible(false);
			}
		});
		getContentPane().add(butFensterschliessen);
		
		
		
	}
}
