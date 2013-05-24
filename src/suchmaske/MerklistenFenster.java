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
import control.Wishlists;


public class MerklistenFenster extends JFrame{
	private Wishlists wListe=new Wishlists();
	
	private String filmname;
	private String merklistenname;
	
	private JTextField listname=new JTextField();
	private JTextField eintragName=new JTextField();
	
	private JButton butHinzufuegen = new JButton("hinzufuegen");
	private JButton btnGo = new JButton("Go!");
	
	private JTable merklistenTabelle=new JTable();
	
	private LinkedList<String> merklistenDaten;
	
	private JLabel lblMerkliste=new JLabel();
	private JLabel lblNameDerMerkliste=new JLabel();

	private String[] auswahlOben={"--nicht ausgew\u00E4hlt--", "neue Liste erstellen", "Liste anzeigen", "Liste loeschen"};
	private String[] auswahlUnten={"--nicht ausgew\u00E4hlt--","Eintrag hinzufuegen", "Eintrag loeschen"};
	
	private JComboBox hauptAuswahl = new JComboBox(auswahlOben);
	private JComboBox eintragAuswahl=new JComboBox();
	private final JButton btnschliessen = new JButton("Fenster schliessen");
	
	
	
	public MerklistenFenster() {
		final MerklistenFenster currentWindow=this;
		
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		listname.setVisible(true);
		butHinzufuegen.setVisible(false);
		merklistenTabelle.setVisible(false);
		lblMerkliste.setVisible(false);
		
		
		JLabel lblFilmname = new JLabel("Eintr\u00E4ge bearbeiten:");
		lblFilmname.setBounds(28, 139, 156, 16);
		getContentPane().add(lblFilmname);
		
		listname.setBounds(281, 37, 195, 28);
		getContentPane().add(listname);
		listname.setColumns(10);
		
		
		merklistenTabelle = new JTable();
		merklistenTabelle.setBounds(28, 199, 448, 242);
		merklistenTabelle.setForeground(Color.BLACK);
		merklistenTabelle.setGridColor(Color.BLACK);
		getContentPane().add(merklistenTabelle);
		
		lblNameDerMerkliste = new JLabel("Name der Merkliste");
		lblNameDerMerkliste.setBounds(28, 11, 144, 16);
		getContentPane().add(lblNameDerMerkliste);
		
		
		btnGo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(hauptAuswahl.getSelectedItem().toString().equalsIgnoreCase("neue Liste erstellen")){
					Wishlists.createList(listname.getText());
				}
				else if(hauptAuswahl.getSelectedItem().toString().equalsIgnoreCase("Liste anzeigen")){
					Wishlists.showList(listname.getText());
				}
				else if(hauptAuswahl.getSelectedItem().toString().equalsIgnoreCase("Liste loeschen")){
					Wishlists.removeList(listname.getText());
				}
				else {
					//Fehler ausgeben.
				}
				eintragAuswahl=new JComboBox(auswahlUnten);
			}
		});
		btnGo.setBounds(28, 78, 117, 29);
		getContentPane().add(btnGo);
		
		
		hauptAuswahl.setBounds(28, 39, 241, 27);
		getContentPane().add(hauptAuswahl);
		
		
		eintragAuswahl.setBounds(28, 160, 170, 27);
		getContentPane().add(eintragAuswahl);
		
		butHinzufuegen = new JButton("hinzufuegen");
		butHinzufuegen.setBounds(359, 158, 117, 29);
		butHinzufuegen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(eintragAuswahl.getSelectedItem().toString().equalsIgnoreCase("Eintrag hinzufuegen")){
					Wishlists.addToList(eintragAuswahl.getSelectedItem().toString(), eintragName.getText());
				}
				else if(eintragAuswahl.getSelectedItem().toString().equalsIgnoreCase("Eintrag loeschen")) {
					Wishlists.removeFromList(eintragAuswahl.getSelectedItem().toString(), eintragName.getText());
				}
				else {
					
				}
			}
		});
		getContentPane().add(butHinzufuegen);
		
		eintragName.setBounds(213, 157, 134, 28);
		getContentPane().add(eintragName);
		eintragName.setColumns(10);
		
		btnschliessen.setBounds(320, 443, 156, 29);
		btnschliessen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				currentWindow.setVisible(false);
			}
		});
		getContentPane().add(btnschliessen);
		
	}

}
