package suchmaske;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import java.util.LinkedList;

public class Tabellenfenster extends JFrame {

	private JPanel contentPane;
	private JTable ergebnistabelle;
	private int zeilenanzahl;
	private int spaltenanzahl;
	
	private LinkedList<LinkedList<String>> ergebnisliste;
	

	/**
	 * Launch the application.
	 */
	
	
	private void tabellefuellen(){
		LinkedList<String> zwischenliste=new LinkedList<String>();
		String wert;
		int zeile;
		int spalte;
		for(zeile=1;zeile<zeilenanzahl;zeile++){
			zwischenliste=ergebnisliste.get(zeile-1);
			for(spalte=0; spalte<spaltenanzahl; spalte++){
				wert=zwischenliste.get(spalte);
				ergebnistabelle.setValueAt(wert, zeile, spalte);
			}
		}
		
	}
	/**
	 * Create the frame.
	 */
	public Tabellenfenster(LinkedList<LinkedList<String>> ergebnisse) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//		contentPane.setLayout(null);
				ergebnisliste=ergebnisse;
				zeilenanzahl= ergebnisliste.size()+1;
				LinkedList<String> zwischenliste=new LinkedList<String>();
				zwischenliste=ergebnisliste.getFirst();
				spaltenanzahl=zwischenliste.size();
				ergebnistabelle = new JTable(zeilenanzahl, spaltenanzahl);
				tabellefuellen();
				ergebnistabelle.setForeground(Color.BLACK);
				ergebnistabelle.setGridColor(Color.BLACK);
				ergebnistabelle.setBounds(110, 90, 400, 280);
				contentPane.add(ergebnistabelle);
	}
}
