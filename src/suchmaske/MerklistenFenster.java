package suchmaske;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;



public class MerklistenFenster extends JFrame{
	private String filmname;
	private String merklistenname;
	
	private JTextField filmnameFeld=new JTextField();
	private JTextField nameMerklisteFeld=new JTextField();
	
	private JButton butHinzufuegen=new JButton();
	private JButton btnAuswaehlen=new JButton();
	
	private JTable merklistenTabelle=new JTable();
	
	private LinkedList<String> merklistenDaten;
	
	private JLabel lblMerkliste=new JLabel();
	private JLabel lblNameDerMerkliste=new JLabel();

	
	
	
	
	public MerklistenFenster() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		filmnameFeld.setVisible(false);
		butHinzufuegen.setVisible(false);
		merklistenTabelle.setVisible(false);
		lblMerkliste.setVisible(false);
		
		
		JLabel lblFilmname = new JLabel("Filmname:");
		lblFilmname.setBounds(28, 79, 86, 16);
		getContentPane().add(lblFilmname);
		
		filmnameFeld = new JTextField();
		filmnameFeld.setBounds(28, 107, 241, 28);
		filmnameFeld.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField zwischenfeld=new JTextField();
				zwischenfeld=(JTextField) e.getSource();
				filmname=zwischenfeld.getText();

			}
		});
		getContentPane().add(filmnameFeld);
		filmnameFeld.setColumns(10);
		
		butHinzufuegen = new JButton("hinzufuegen");
		butHinzufuegen.setBounds(296, 108, 117, 29);
		butHinzufuegen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// Wert hinzufuegen
			}
		});
		getContentPane().add(butHinzufuegen);
		
		merklistenTabelle = new JTable();
		merklistenTabelle.setBounds(28, 169, 385, 160);
		merklistenTabelle.setForeground(Color.BLACK);
		merklistenTabelle.setGridColor(Color.BLACK);
		getContentPane().add(merklistenTabelle);
		
		lblMerkliste = new JLabel("Merkliste:");
		lblMerkliste.setBounds(28, 147, 97, 16);
		getContentPane().add(lblMerkliste);
		
		lblNameDerMerkliste = new JLabel("Name der Merkliste");
		lblNameDerMerkliste.setBounds(28, 11, 144, 16);
		getContentPane().add(lblNameDerMerkliste);
		
		btnAuswaehlen = new JButton("auswaehlen");
		btnAuswaehlen.setBounds(296, 40, 117, 29);
		btnAuswaehlen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				//Tabelle raussuchen
				filmnameFeld.setVisible(true);
				butHinzufuegen.setVisible(true);
				merklistenTabelle.setVisible(true);
				lblMerkliste.setVisible(true);
			}
		});
		getContentPane().add(btnAuswaehlen);
		
		JButton btnspeichern = new JButton("speichern");
		btnspeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnspeichern.setBounds(296, 343, 117, 29);
		getContentPane().add(btnspeichern);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(28, 39, 241, 27);
		getContentPane().add(comboBox);
		
	}

}
