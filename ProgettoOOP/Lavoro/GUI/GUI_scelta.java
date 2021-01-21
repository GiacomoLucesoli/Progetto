package ProgettoOOP.Lavoro.GUI;


import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//@author Giacomo Lucesoli
//@author Thomas Bonacci 

public class GUI_scelta 
{
	private Integer scelta = null;
	JFrame frame;
	JPanel panel;
	JButton quantityButton;
	JButton percButton;
	JButton dataDiCreazioneButton;
	JButton programmiButton;
	JButton filtraggio2cittàButton;
	public GUI_scelta()
	{
		frame = new JFrame("GUI_scelta");
		frame.setSize(600, 340);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,1));
		quantityButton = new JButton("QUANTITA'");
		percButton = new JButton("PERCENTUALI");
		dataDiCreazioneButton = new JButton("DATA DI CREAZIONE");
		programmiButton = new JButton("PROGRAMMI");
		filtraggio2cittàButton = new JButton("FILTRAGGIO SU 2 CITTA'");
		
		Font font = new Font("Arial Black",Font.BOLD,30); 
		quantityButton.setFont(font);
		percButton.setFont(font);
		dataDiCreazioneButton.setFont(font);
		programmiButton.setFont(font);
		filtraggio2cittàButton.setFont(font);
		
		
		panel.add(quantityButton);
		panel.add(percButton);
		panel.add(dataDiCreazioneButton);
		panel.add(programmiButton);
		panel.add(filtraggio2cittàButton);
		frame.add(panel);
		frame.setVisible(true);
		
		
		quantityButton.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				scelta = 1;
				frame.setVisible(false);
				
			}
		});
		percButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				scelta = 2;
				frame.setVisible(false);
		
			}
		});
		dataDiCreazioneButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				scelta = 3;
				frame.setVisible(false);
				
			}
		});
		programmiButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				scelta = 4;
				frame.setVisible(false);
				
			}
		});
		filtraggio2cittàButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				scelta = 5;
				frame.setVisible(false);
			}
		});
		
	}
	public Integer risultato()
	{
		return scelta;
	}
	

}
