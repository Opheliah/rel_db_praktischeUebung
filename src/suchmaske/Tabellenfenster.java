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
	int zeilenanzahl;
	int spaltenanzahl;
	int wert;
	int zeile;
	int spalte;
	private LinkedList<LinkedList<String>> ergebnisliste;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabellenfenster frame = new Tabellenfenster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void tabellefuellen(){
		LinkedList<String> zwischenliste=new LinkedList();
		zeilenanzahl= ergebnisliste.size();
		zwischenliste=ergebnisliste.getFirst();
		spaltenanzahl=zwischenliste.size();
		
		ergebnistabelle.setValueAt(wert, zeile, spalte);
	}
	/**
	 * Create the frame.
	 */
	public Tabellenfenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//		contentPane.setLayout(null);
				
				ergebnistabelle = new JTable(zeilenanzahl, spaltenanzahl);
				tabellefuellen();
				ergebnistabelle.setForeground(Color.BLACK);
				ergebnistabelle.setGridColor(Color.BLACK);
				ergebnistabelle.setBounds(110, 90, 400, 280);
				contentPane.add(ergebnistabelle);
	}
}
