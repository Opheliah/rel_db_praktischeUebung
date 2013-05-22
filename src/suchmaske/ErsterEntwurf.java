package suchmaske;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.UIManager;

public class ErsterEntwurf extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPanel = new JPanel();
	private JTextField textfeld=new JTextField();
	private JTextField textfeld1=new JTextField();
	private JTextField textfeld2=new JTextField();
	private JTextField textfeld3=new JTextField();
	private JTextField suchfeld=new JTextField();
	
	JComboBox comboBox = new JComboBox();
	private JComboBox comboBox1=new JComboBox();
	private JComboBox comboBox2=new JComboBox();
	private JComboBox comboBox3=new JComboBox();
	private JComboBox comboBox4=new JComboBox();
	private JComboBox comboBox5=new JComboBox();
	private JComboBox comboBox6=new JComboBox();
	private JComboBox comboBox7=new JComboBox();
	private JComboBox comboBox8=new JComboBox();
	private JComboBox undOderBox1=new JComboBox();
	private JComboBox undOderBox2=new JComboBox();
	private JComboBox undOderBox3=new JComboBox();
	
	private String[] auswahlmoeglichkeiten={"--nicht ausgew\u00E4hlt--", "alles ausw\u00E4hlen", "Person", "Titel", "Produktionsjahr", "Film-/Serienrolle", "Mitarbeiterfunktion", "Filmgesellschaft"};
	private String[] auswahl={"--nicht ausgew\u00E4hlt--", "Person", "Titel", "Produktionsjahr", "Film-/Serienrolle", "Mitarbeiterfunktion", "Filmgesellschaft"};
	private String[] auswahl1 = new String[] {"--nicht ausgew\u00E4hlt--", "Titel", "Produktionsjahr", "Film-/Serienrolle", "Mitarbeiterfunktion", "Filmgesellschaft"};
	private String[] auswahl2 = new String[] {"--nicht ausgew\u00E4hlt--", "Person","Produktionsjahr", "Film-/Serienrolle", "Mitarbeiterfunktion", "Filmgesellschaft"};
	private String[] auswahl3 = new String[] {"--nicht ausgew\u00E4hlt--", "Person", "Titel","Film-/Serienrolle", "Mitarbeiterfunktion", "Filmgesellschaft"};
	private String[] auswahl4 = new String[] {"--nicht ausgew\u00E4hlt--", "Person", "Titel", "Produktionsjahr","Mitarbeiterfunktion", "Filmgesellschaft"};
	private String[] auswahl5 = new String[] {"--nicht ausgew\u00E4hlt--", "Person", "Titel", "Produktionsjahr", "Film-/Serienrolle","Filmgesellschaft"};
	private String[] auswahl6 = new String[] {"--nicht ausgew\u00E4hlt--", "Person", "Titel", "Produktionsjahr", "Film-/Serienrolle", "Mitarbeiterfunktion"};
	private String[] relation1 = new String[] {"--nicht ausgew\u00E4hlt--","ist gleich", "ist ungleich"};
	private String[] relation2 = new String[] {"--nicht ausgew\u00E4hlt--","ist gleich", "ist ungleich", "ist groesser", "ist kleiner", "ist groesser/gleich", "ist kleiner/gleich"};
	private String[] leer = new String[] {};
	private String [] undoder=new String[] {"und", "oder"};
	
	private String[] c1box_param={};
	private String[] c2box_param={};
	private String[] c3box_param={};
	private String[] c4box_param={};
	private String[] c5box_param={};
	private String[] c6box_param={};
	private String[] c7box_param={};
	private String[] c8box_param={};
	
	private String ergebnisauswahl;
	private String c1suchfeld;
	private String c2suchfeld;
	private String c3suchfeld;
	private String c4suchfeld;
	private String c5suchfeld;
	private String c6suchfeld;
	private String c7suchfeld;
	private String c8suchfeld;
	private String sucheingabe;
	private String eigenschaftEingabe1;
	private String eigenschaftEingabe2;
	private String eigenschaftEingabe3;
	private String eigenschaftEingabe;
	private String undoderAuswahl1;
	private String undoderAuswahl2;
	private String undoderAuswahl3;
	
	private String benutzername;
	private String passwort;
	
	private final JButton butSuchestarten = new JButton("Suche starten");
	private final JButton butHilfe = new JButton("?");
	private final JButton butBenutzerdaten = new JButton("einloggen");
	private final JButton butschliessen = new JButton("erweiterte Einstellungen schliessen");
	
	private int cboxauswahlindex;
	
	private LinkedList<LinkedList<String>> suchdaten=new LinkedList<LinkedList<String>>();
	private final JButton btnMerklisteBearbeiten = new JButton("Merklisten bearbeiten");
	private final JButton btnNewButton = new JButton("neue Merkliste");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ErsterEntwurf dialog = new ErsterEntwurf();
			dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dialog.setSize(670, 490);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	
	
	private void setCombParameter(int cboxparamindex){
		if(cboxparamindex == 0){
			c1box_param=leer;
			c2box_param=leer;
			c3box_param=leer;
			c4box_param=leer;
			c5box_param=leer;
			c6box_param=leer;
			c7box_param=leer;
			c8box_param=leer;
		}
		else if(cboxparamindex==1){
			c1box_param=auswahl;
			c3box_param=auswahl;
			c5box_param=auswahl;
			c7box_param=auswahl;
			c2box_param=leer;
			c4box_param=leer;
			c6box_param=leer;
			c8box_param=leer;
		}
		else if(cboxparamindex==2){
			c1box_param=auswahl;
			c3box_param=auswahl;
			c5box_param=auswahl;
			c7box_param=auswahl;
			c2box_param=leer;
			c4box_param=leer;
			c6box_param=leer;
			c8box_param=leer;
		}
		else if(cboxparamindex==3){
			c1box_param=auswahl2;
			c3box_param=auswahl2;
			c5box_param=auswahl2;
			c7box_param=auswahl2;
			c2box_param=leer;
			c4box_param=leer;
			c6box_param=leer;
			c8box_param=leer;
		}
		else if(cboxparamindex==4){
			c1box_param=auswahl3;
			c3box_param=auswahl3;
			c5box_param=auswahl3;
			c7box_param=auswahl3;
			c2box_param=leer;
			c4box_param=leer;
			c6box_param=leer;
			c8box_param=leer;
		}
		else if(cboxparamindex==5){
			c1box_param=auswahl4;
			c3box_param=auswahl4;
			c5box_param=auswahl4;
			c7box_param=auswahl4;
			c2box_param=leer;
			c4box_param=leer;
			c6box_param=leer;
			c8box_param=leer;
		}
		else if(cboxparamindex==6){
			c1box_param=auswahl5;
			c3box_param=auswahl5;
			c5box_param=auswahl5;
			c7box_param=auswahl5;
			c2box_param=leer;
			c4box_param=leer;
			c6box_param=leer;
			c8box_param=leer;
		}
		else if(cboxparamindex==7){
			c1box_param=auswahl6;
			c3box_param=auswahl6;
			c5box_param=auswahl6;
			c7box_param=auswahl6;
			c2box_param=leer;
			c4box_param=leer;
			c6box_param=leer;
			c8box_param=leer;
		}
		comboBox1.setModel(new DefaultComboBoxModel(c1box_param));
		comboBox3.setModel(new DefaultComboBoxModel(c3box_param));
		comboBox5.setModel(new DefaultComboBoxModel(c5box_param));
		comboBox7.setModel(new DefaultComboBoxModel(c7box_param));
		comboBox2.setModel(new DefaultComboBoxModel(c2box_param));
		comboBox4.setModel(new DefaultComboBoxModel(c4box_param));
		comboBox6.setModel(new DefaultComboBoxModel(c6box_param));
		comboBox8.setModel(new DefaultComboBoxModel(c8box_param));
	}
	
	public ErsterEntwurf() {
		setBackground(SystemColor.window);
		setBounds(100, 100, 650, 600);
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//erweiterte Sucheinstellung unsichtbar:
		
		comboBox1.setVisible(false);
		comboBox2.setVisible(false);
		comboBox3.setVisible(false);
		comboBox4.setVisible(false);
		comboBox5.setVisible(false);
		comboBox6.setVisible(false);
		comboBox7.setVisible(false);
		comboBox8.setVisible(false);
		undOderBox1.setVisible(false);
		undOderBox2.setVisible(false);
		undOderBox3.setVisible(false);
		textfeld.setVisible(false);
		textfeld1.setVisible(false);
		textfeld2.setVisible(false);
		textfeld3.setVisible(false);
		butschliessen.setVisible(false);
		
		
		//Auswahlbox des Ergebnis:
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--nicht ausgew\u00E4hlt--", "alles ausw\u00E4hlen", "Person", "Titel", "Produktionsjahr", "Film-/Serienrolle", "Mitarbeiterfunktion", "Filmgesellschaft"}));
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JComboBox zwischenbox=(JComboBox) e.getSource();
				ergebnisauswahl=(zwischenbox.getSelectedItem()).toString();
				
			}
		});
		comboBox.setBounds(18, 58, 211, 27);
		
		
		//Auswahlmoeglichkeiten d. erweiterten Suchenfelder in Abhaengigkeit des Ergebnis bestimmen:
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox suchzwischenbox = (JComboBox)e.getSource();
				cboxauswahlindex = (int)suchzwischenbox.getSelectedIndex();
				setCombParameter(cboxauswahlindex);
			}
			
		});
		contentPanel.add(comboBox);
		
		//Trennungslinie von Hauptsuche und erweiterter Suche:
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 86, 514, 20);
		contentPanel.add(separator);
		
		//Ueberschrift Suchanfrage:
		JLabel lblSuche = new JLabel("Suchanfrage:");
		lblSuche.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblSuche.setBounds(18, 6, 130, 16);
		contentPanel.add(lblSuche);
		
		//Erweiterte Sucheinstellungen Auswahlboxen:
		
		//1.Reihe links
		comboBox1.setBackground(UIManager.getColor("Button.background"));
		comboBox1.setBounds(119, 155, 170, 27);
		comboBox1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				JComboBox erweitert1_zwischenbox = (JComboBox) e.getSource();
				c1suchfeld=(erweitert1_zwischenbox.getSelectedItem()).toString();
				
				if(c1suchfeld.equalsIgnoreCase("--nicht ausgew\u00E4hlt--")){
					
				}
				
				else if(c1suchfeld.equalsIgnoreCase("Person")) {
					c2box_param=relation1;
				}
				else if(c1suchfeld.equalsIgnoreCase("Titel")){
					c2box_param=relation1;
				}
				else if(c1suchfeld.equalsIgnoreCase("Produktionsjahr")) {
					c2box_param=relation2;
				}
				else if(c1suchfeld.equalsIgnoreCase("Film-/Serienrolle")){
					c2box_param=relation1;
				}
				else if(c1suchfeld.equalsIgnoreCase("Mitarbeiterfunktion")){
					c2box_param=relation1;
				}
				else if(c1suchfeld.equalsIgnoreCase("Filmgesellschaft")){
					c2box_param=relation1;
				}
				comboBox2.setModel(new DefaultComboBoxModel(c2box_param));
				
			}
		}
				);
		contentPanel.add(comboBox1);
		
		//1.Reihe mitte
		comboBox2.setBounds(301, 155, 173, 27);
		comboBox2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JComboBox erweitert2zwischenbox = (JComboBox) e.getSource();
				c2suchfeld=(erweitert2zwischenbox.getSelectedItem()).toString();
			}
		});
		contentPanel.add(comboBox2);
	
		
		//2.Reihe links
		comboBox3.setBounds(119, 192, 170, 27);
		
		comboBox3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				JComboBox erweitert3_zwischenbox = (JComboBox) e.getSource();
				c3suchfeld=(erweitert3_zwischenbox.getSelectedItem()).toString();
				
				if(c3suchfeld.equalsIgnoreCase("--nicht ausgew\u00E4hlt--")){
					
				}
				
				else if(c3suchfeld.equalsIgnoreCase("Person")) {
					c4box_param=relation1;
				}
				else if(c3suchfeld.equalsIgnoreCase("Titel")){
					c4box_param=relation1;
				}
				else if(c3suchfeld.equalsIgnoreCase("Produktionsjahr")) {
					c4box_param=relation2;
				}
				else if(c3suchfeld.equalsIgnoreCase("Film-/Serienrolle")){
					c4box_param=relation1;
				}
				else if(c3suchfeld.equalsIgnoreCase("Mitarbeiterfunktion")){
					c4box_param=relation1;
				}
				else if(c3suchfeld.equalsIgnoreCase("Filmgesellschaft")){
					c4box_param=relation1;
				}
				comboBox4.setModel(new DefaultComboBoxModel(c4box_param));
				
			}
		}
				);
		contentPanel.add(comboBox3);
		
		//2. Reihe mitte
		comboBox4.setBounds(301, 194, 173, 27);
		comboBox4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JComboBox erweitert4zwischenbox=(JComboBox) e.getSource();
				c4suchfeld=(erweitert4zwischenbox.getSelectedItem()).toString();
			}
		});
		contentPanel.add(comboBox4);
		
		//3. Reihe links
		comboBox5.setBounds(119, 233, 170, 27);
		comboBox5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				JComboBox erweitert5_zwischenbox = (JComboBox) e.getSource();
				c5suchfeld=(erweitert5_zwischenbox.getSelectedItem()).toString();
				
				if(c5suchfeld.equalsIgnoreCase("--nicht ausgew\u00E4hlt--")){
					
				}
				
				else if(c5suchfeld.equalsIgnoreCase("Person")) {
					c6box_param=relation1;
				}
				else if(c5suchfeld.equalsIgnoreCase("Titel")){
					c6box_param=relation1;
				}
				else if(c5suchfeld.equalsIgnoreCase("Produktionsjahr")) {
					c6box_param=relation2;
				}
				else if(c5suchfeld.equalsIgnoreCase("Film-/Serienrolle")){
					c6box_param=relation1;
				}
				else if(c5suchfeld.equalsIgnoreCase("Mitarbeiterfunktion")){
					c6box_param=relation1;
				}
				else if(c5suchfeld.equalsIgnoreCase("Filmgesellschaft")){
					c6box_param=relation1;
				}
				comboBox6.setModel(new DefaultComboBoxModel(c6box_param));
				
			}
		}
				);
		contentPanel.add(comboBox5);
		
		//3.Reihe mitte
		comboBox6.setBounds(301, 233, 173, 27);
		comboBox6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JComboBox erweitert6zwischenbox=(JComboBox) e.getSource();
				c6suchfeld=(erweitert6zwischenbox.getSelectedItem()).toString();
			}
		});
		contentPanel.add(comboBox6);
		
		//4. Reihe links
		comboBox7.setBounds(119, 272, 170, 27);
		
		comboBox7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				JComboBox erweitert7_zwischenbox = (JComboBox) e.getSource();
				c7suchfeld=(erweitert7_zwischenbox.getSelectedItem()).toString();
				
				if(c7suchfeld.equalsIgnoreCase("--nicht ausgew\u00E4hlt--")){
					
				}
				
				else if(c7suchfeld.equalsIgnoreCase("Person")) {
					c8box_param=relation1;
				}
				else if(c7suchfeld.equalsIgnoreCase("Titel")){
					c8box_param=relation1;
				}
				else if(c7suchfeld.equalsIgnoreCase("Produktionsjahr")) {
					c8box_param=relation2;
				}
				else if(c7suchfeld.equalsIgnoreCase("Film-/Serienrolle")){
					c8box_param=relation1;
				}
				else if(c7suchfeld.equalsIgnoreCase("Mitarbeiterfunktion")){
					c8box_param=relation1;
				}
				else if(c7suchfeld.equalsIgnoreCase("Filmgesellschaft")){
					c8box_param=relation1;
				}
				comboBox8.setModel(new DefaultComboBoxModel(c8box_param));
				
			}
		}
				);
		contentPanel.add(comboBox7);
		
		//4. Reihe mitte
		comboBox8.setBounds(301, 271, 173, 27);
		comboBox8.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JComboBox erweitert8zwischenbox=(JComboBox) e.getSource();
				c8suchfeld=(erweitert8zwischenbox.getSelectedItem()).toString();
			}
		});
		contentPanel.add(comboBox8);
		
		
		//Textfelder 
		//Haupt-Suchfeld
		suchfeld.setBounds(301, 56, 170, 27);
		suchfeld.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JTextField zwischenfeld = (JTextField) e.getSource();
				sucheingabe=zwischenfeld.getText();
				
			}
		});
		contentPanel.add(suchfeld);
		suchfeld.setColumns(10);
		
		//erweiterte_Sucheinstellungsfelder
		//1.Feld 
		textfeld.setBounds(495, 153, 134, 28);
		textfeld.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JTextField zwischenfeld = (JTextField) e.getSource();
				eigenschaftEingabe=zwischenfeld.getText();
			}
		});
		contentPanel.add(textfeld);
		textfeld.setColumns(10);
		
		//2.Feld 
		textfeld1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				 JTextField zwischenfeld=(JTextField) e.getSource();
				 eigenschaftEingabe1=zwischenfeld.getText();
			}
		});
		textfeld1.setBounds(495, 192, 134, 28);
		contentPanel.add(textfeld1);
		textfeld1.setColumns(10);
		
		//3.Feld
		textfeld2.setBounds(495, 231, 134, 28);
		textfeld2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField zwischenfeld=(JTextField) e.getSource();
				eigenschaftEingabe2=zwischenfeld.getText();
			}
		});
		contentPanel.add(textfeld2);
		textfeld2.setColumns(10);
		
		//4.Feld
		textfeld3.setBounds(495, 269, 134, 28);
		textfeld3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				JTextField zwischenfeld = (JTextField) e.getSource();
				eigenschaftEingabe3=zwischenfeld.getText();
			}
		});
		contentPanel.add(textfeld3);
		textfeld3.setColumns(10);
		
		//Ueberschriften
		JLabel lblStichwort = new JLabel("Stichwort:");
		lblStichwort.setBounds(301, 30, 88, 16);
		contentPanel.add(lblStichwort);
		
		JLabel lblErgebnistyp = new JLabel("Ergebnistyp:");
		lblErgebnistyp.setBounds(18, 30, 88, 16);
		contentPanel.add(lblErgebnistyp);
		
		//Buttons
		
		JButton but_erweiterteSuche = new JButton("erweiterte Sucheinstellung");
		but_erweiterteSuche.setBackground(Color.WHITE);
		but_erweiterteSuche.setBounds(18, 97, 187, 36);
		but_erweiterteSuche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBox1.setVisible(true);
				comboBox2.setVisible(true);
				comboBox3.setVisible(true);
				comboBox4.setVisible(true);
				comboBox5.setVisible(true);
				comboBox6.setVisible(true);
				comboBox7.setVisible(true);
				comboBox8.setVisible(true);
				undOderBox1.setVisible(true);
				undOderBox2.setVisible(true);
				undOderBox3.setVisible(true);
				textfeld.setVisible(true);
				textfeld1.setVisible(true);
				textfeld2.setVisible(true);
				textfeld3.setVisible(true);
				butschliessen.setVisible(true);
			
			}
		});
		contentPanel.add(but_erweiterteSuche);
		
		
		
		
		butschliessen.setBackground(Color.WHITE);
		butschliessen.setBounds(217, 97, 255, 36);
		butschliessen.addActionListener(new ActionListener() {
				
		@Override
		public void actionPerformed(ActionEvent e){
			comboBox1.setVisible(false);
			comboBox2.setVisible(false);
			comboBox3.setVisible(false);
			comboBox4.setVisible(false);
			comboBox5.setVisible(false);
			comboBox6.setVisible(false);
			comboBox7.setVisible(false);
			comboBox8.setVisible(false);
			undOderBox1.setVisible(false);
			undOderBox2.setVisible(false);
			undOderBox3.setVisible(false);
			textfeld.setVisible(false);
			textfeld1.setVisible(false);
			textfeld2.setVisible(false);
			textfeld3.setVisible(false);
			butschliessen.setVisible(false);
			eigenschaftEingabe=null;
			eigenschaftEingabe1=null;
			eigenschaftEingabe2=null;
			eigenschaftEingabe3=null;
			setCombParameter(cboxauswahlindex);
			c1suchfeld=null;
			c2suchfeld=null;
			c3suchfeld=null;
			c4suchfeld=null;
			c5suchfeld=null;
			c6suchfeld=null;
			c7suchfeld=null;
			c8suchfeld=null;
			
			
			}
		}); 
		contentPanel.add(butschliessen);
		
		butSuchestarten.setBounds(374, 360, 205, 36);
		butSuchestarten.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				//Methodenaufruf und Parameteruebergabe:
				LinkedList<String> erstezeile=new LinkedList<String>();
				String[] einlesen1={"",c1suchfeld, c2suchfeld, eigenschaftEingabe};
				LinkedList<String> zweitezeile=new LinkedList<String>();
				String[] einlesen2={undoderAuswahl1, c3suchfeld, c4suchfeld, eigenschaftEingabe1};
				LinkedList<String> drittezeile=new LinkedList<String>();
				String[] einlesen3={undoderAuswahl2, c5suchfeld, c6suchfeld, eigenschaftEingabe2};
				LinkedList<String> viertezeile=new LinkedList<String>();
				String[] einlesen4={undoderAuswahl3, c7suchfeld, c8suchfeld, eigenschaftEingabe3};
				
				int i;
				for(i=0; i<4; i++){
						erstezeile.add(i, einlesen1[i]);
						zweitezeile.add(i, einlesen2[i]);
						drittezeile.add(i, einlesen3[i]);
						viertezeile.add(i, einlesen4[i]);
					
					
				}
				suchdaten.add(0, erstezeile);
				suchdaten.add(1, zweitezeile);
				suchdaten.add(2, drittezeile);
				suchdaten.add(3, viertezeile);
				
			}
		});
		
		contentPanel.add(butSuchestarten);
		
		
		
		
		
		butBenutzerdaten.setBounds(18, 466, 88, 36);
		butBenutzerdaten.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				BenutzerdatenEingabe loginWindow = new BenutzerdatenEingabe();
				loginWindow.setVisible(true);
			}
		});
		contentPanel.add(butBenutzerdaten);
		
		butHilfe.setBounds(593, 360, 36, 36);
		contentPanel.add(butHilfe);
		
		
		undOderBox1.setModel(new DefaultComboBoxModel(undoder));
		undOderBox1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox zwischenbox = new JComboBox();
				zwischenbox=(JComboBox) e.getSource();
				undoderAuswahl1=(zwischenbox.getSelectedItem()).toString();
				
				
			}
		});
		undOderBox1.setBounds(18, 194, 89, 27);
		contentPanel.add(undOderBox1);
		
		undOderBox2.setModel(new DefaultComboBoxModel(undoder));
		undOderBox2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox zwischenbox=new JComboBox();
				zwischenbox=(JComboBox) e.getSource();
				undoderAuswahl2=(zwischenbox.getSelectedItem()).toString();
			}
		});
		undOderBox2.setBounds(18, 233, 89, 27);
		contentPanel.add(undOderBox2);
		
		undOderBox3.setModel(new DefaultComboBoxModel(undoder));
		undOderBox3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox zwischenbox=new JComboBox();
				zwischenbox=(JComboBox) e.getSource();
				undoderAuswahl3=(zwischenbox.getSelectedItem()).toString();			}
		});
		undOderBox3.setBounds(18, 272, 88, 27);
		contentPanel.add(undOderBox3);
		btnMerklisteBearbeiten.setBounds(119, 466, 162, 36);
		
		contentPanel.add(btnMerklisteBearbeiten);
		btnNewButton.setBounds(293, 468, 137, 33);
		
		contentPanel.add(btnNewButton);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
