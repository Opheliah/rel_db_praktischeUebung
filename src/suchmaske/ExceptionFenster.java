package suchmaske;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ExceptionFenster extends JFrame {
	
	final ExceptionFenster currentWindow=this;
	private String exceptiontext1="In diesem Feld darf nur eine Zahl eingegeben werden.";
	
	public ExceptionFenster(){
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(exceptiontext1);
		lblNewLabel.setBounds(31, 36, 339, 16);
		getContentPane().add(lblNewLabel);
		
		JButton btnFensterSchliessen = new JButton("OK");
		btnFensterSchliessen.setBounds(143, 78, 109, 29);
		btnFensterSchliessen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				currentWindow.setVisible(false);
			}
		});
		getContentPane().add(btnFensterSchliessen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 150);
	}

}
