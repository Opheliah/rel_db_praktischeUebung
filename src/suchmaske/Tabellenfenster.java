package suchmaske;

import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tabellenfenster extends JFrame {
	
	private JPanel contentPane;
	private JTable ergebnistabelle;
	private int zeilenanzahl;
	private int spaltenanzahl;
	private int clickedrow;
	private int clickedcolumn;
	
	private LinkedList<LinkedList<String>> ergebnisliste;
	 
	
	public Tabellenfenster(LinkedList<LinkedList<String>> ergebnisse) {
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnDetailansicht = new JButton("Detailansicht");
		btnDetailansicht.setBounds(327, 6, 117, 29);
		getContentPane().add(btnDetailansicht);
		
		ergebnisliste=ergebnisse;
		zeilenanzahl= ergebnisliste.size();
		LinkedList<String> zwischenliste=new LinkedList<String>();
		zwischenliste=ergebnisliste.getFirst();
		spaltenanzahl=zwischenliste.size();
		
		
		ergebnistabelle = new JTable(zeilenanzahl, spaltenanzahl);
		ergebnistabelle.setBounds(6, 49, 438, 323);
		ergebnistabelle.setForeground(Color.BLACK);
		ergebnistabelle.setGridColor(Color.BLACK);
		tabellefuellen();
		ergebnistabelle.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e){
				clickedcolumn=e.getX();
				clickedrow=e.getY();
				
			}
			@Override
			public void mouseEntered(MouseEvent e){
				
			}
			@Override public void mouseExited(MouseEvent e){
				
			}
			@Override 
			public void mouseReleased(MouseEvent e){
				
			}
			@Override 
			public void mousePressed(MouseEvent e){
				
			}
		});
		getContentPane().add(ergebnistabelle);
	}
	
	@Override
	
	
	private void tabellefuellen(){
		LinkedList<String> zwischenliste=new LinkedList<String>();
		String wert;
		int zeile;
		int spalte;
		for(zeile=0;zeile<zeilenanzahl;zeile++){
			zwischenliste=ergebnisliste.get(zeile);
			for(spalte=0; spalte<spaltenanzahl; spalte++){
				wert=zwischenliste.get(spalte);
				ergebnistabelle.setValueAt(wert, zeile, spalte);
			}
		}
		
	}
}
