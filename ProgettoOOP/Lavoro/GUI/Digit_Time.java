package ProgettoOOP.Lavoro.GUI;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.management.loading.PrivateClassLoader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//@author Giacomo Lucesoli
//@author Thomas Bonacci 

public class Digit_Time 
{
	
	private String tempo = null;
	JFrame frame;
	JPanel panel;
	JButton continuaButton;
	JTextField tempoField;
	public Digit_Time()
	{
		frame = new JFrame("Digita il tempo:");
		frame.setDefaultCloseOperation(0);
		frame.setSize(600, 140);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		continuaButton = new JButton("CONTINUA");
		tempoField = new JTextField();
		panel.add(tempoField);
		panel.add(continuaButton);
		frame.add(panel);
		frame.setVisible(true);
		continuaButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tempo = tempoField.getText();
				
				frame.setVisible(false);
			}
		});
	}
	public String risultato()
	{
		return tempo;
	}
}
