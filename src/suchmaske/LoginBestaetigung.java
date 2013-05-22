package suchmaske;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginBestaetigung extends JFrame {
	
	final LoginBestaetigung currentWindow=this;
	
	public LoginBestaetigung(boolean loggedIn) {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		
		
		JButton butOkay = new JButton("OK");
		butOkay.setBounds(138, 130, 91, 29);
		butOkay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentWindow.setVisible(false);
			}
		});
		getContentPane().add(butOkay);
		
		if(loggedIn==true){
			JLabel verbindungaufgebaut=new JLabel("Die Verbindung zur Datenbank wurde hergestellt.");
			verbindungaufgebaut.setBounds(45, 45, 350, 30);
			getContentPane().add(verbindungaufgebaut);
			JLabel verbindungaufgebaut2=new JLabel("Viel Spass bei den Suchanfragen.");
			verbindungaufgebaut2.setBounds(45, 60, 350, 30);
			getContentPane().add(verbindungaufgebaut2);
		}
		else {
			JLabel verbindungFehler=new JLabel("Bei der Verbindung zur Datenbank ist ein Fehler aufgetreten.");
			verbindungFehler.setBounds(45, 45, 400, 30);
			getContentPane().add(verbindungFehler);
			JLabel verbindungFehler2=new JLabel("Bitte ueberpruefe deine eingegebenen Daten und versuche es");
			verbindungFehler2.setBounds(45, 60, 400, 30);
			getContentPane().add(verbindungFehler2);
			JLabel verbindungFehler3=new JLabel("es noch einmal.");
			verbindungFehler3.setBounds(45, 75, 400, 30);
			getContentPane().add(verbindungFehler3);
		}
		
		
	}
}
