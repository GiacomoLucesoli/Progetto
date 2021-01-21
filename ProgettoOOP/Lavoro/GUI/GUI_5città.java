package ProgettoOOP.Lavoro.GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.management.loading.PrivateClassLoader;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders.ButtonBorder;
import ch.qos.logback.core.pattern.color.BlackCompositeConverter;

//@author Giacomo Lucesoli
//@author Thomas Bonacci 

public class GUI_5città
{
	
	
	
	
	JLabel label;
	JFrame frame;
	JButton buttonCont;
	private String[] città = new String[5];

	

	public GUI_5città()
	{
	
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //chiude con la x della finestra
		frame = new JFrame("GUI_5città");
		
		//JButton buttonOK = new JButton("OK");
		buttonCont = new JButton("CONTINUA");
		frame.setSize(600,340);
		
		frame.setLocationRelativeTo(null);// questo metodo ti permette di mettere la finesta al centro dello schermo
		//buttonOK.setBounds(45,60,100,25);
		//buttonCont.setBounds(145,60,200,25);
		
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		//buttonCont.setPreferredSize(new Dimension(200,25));
		GridLayout g = new GridLayout(6,1);
		GridLayout g1 = new GridLayout(1,2);
		
		

		panel.setLayout(g);
		panel1.setLayout(g1);
		panel2.setLayout(g1);
		panel3.setLayout(g1);
		panel4.setLayout(g1);
		panel5.setLayout(g1);
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(buttonCont);
		
		
		
		frame.add(panel);
		
	
		
		
		JLabel label1 = new JLabel("Città 1:", SwingConstants.CENTER);
		JLabel label2 = new JLabel("Città 2:", SwingConstants.CENTER);
		JLabel label3 = new JLabel("Città 3:", SwingConstants.CENTER);
		JLabel label4 = new JLabel("Città 4:", SwingConstants.CENTER);
		JLabel label5 = new JLabel("Città 5:", SwingConstants.CENTER);
		
		JTextField txt1 = new JTextField();
		JTextField txt2 = new JTextField();
		JTextField txt3 = new JTextField();
		JTextField txt4 = new JTextField();
		JTextField txt5 = new JTextField();
		
	
		
		
		panel1.add(label1);panel1.add(txt1);
		panel2.add(label2);panel2.add(txt2);
		panel3.add(label3);panel3.add(txt3);
		panel4.add(label4);panel4.add(txt4);
		panel5.add(label5);panel5.add(txt5);
		
		
		  //set del font a tutti i label 
		Font fontLabel = new Font("Arial Black",Font.BOLD,30); 
		label1.setFont(fontLabel); 
		label2.setFont(fontLabel);
		label3.setFont(fontLabel); 
		label4.setFont(fontLabel);
		label5.setFont(fontLabel); 
		Font fontButton = new Font("Arial Rounded MT Bold", Font.BOLD,28); 
		buttonCont.setFont(fontButton);
		Font fontTxt = new Font("David",Font.BOLD,30); 
		txt1.setFont(fontTxt); 
		txt2.setFont(fontTxt);
		txt3.setFont(fontTxt); 
		txt4.setFont(fontTxt); 
		txt5.setFont(fontTxt);
	  
	  
		// set del bordo per ogni elemento dell griglia 
		LineBorder Black = new LineBorder(Color.black); 
		label1.setBorder(Black); 
		label2.setBorder(Black);
		label3.setBorder(Black); 
		label4.setBorder(Black); 
		label5.setBorder(Black);
		txt1.setBorder(Black); 
		txt2.setBorder(Black); 
		txt3.setBorder(Black);
		txt4.setBorder(Black); 
		txt5.setBorder(Black);
		frame.setVisible(true);
		boolean flag = true;
		IndButton button = new IndButton();
		while(flag) 
		{
			buttonCont.addActionListener(button);
			flag = button.flag();
			
		}
		if(!flag) 
		{
		
			
			città[0] = txt1.getText();
			città[1] = txt2.getText();
			città[2] = txt3.getText();
			città[3] = txt4.getText();
			città[4] = txt5.getText();
			
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
				frame.setVisible(false);
		
		}
	}
	public String[] getCittà() {
		return città;
	}
	



	
	
		
		
		
		
}

	



















/*<MACRO TEMA>: JOBS GITHUB - Lavoro C++
<API REFERENCE>: https://jobs.github.com/api
<OBIETTIVO>: 
Un programmatore di C++ vorrebbe trovare un nuovo lavoro ed ha in mente diverse città in cui spostarsi. 
Ha bisogno di un'applicazione che gli permetta di trovare gli annunci di lavoro contenenti la parola C++, con sede nelle città desiderate. 
Inoltre, l'applicazione dovrà fargli visualizzare delle statistiche generate dai risultati ottenuti.
<STATS E FILTRI>: Scegliere fino ad un massimo di 5 città. Poi, in base alla città, generare statistiche sui lavori trovati, 
riguardanti la tipologia (quantità e percentuale di full_time e part_time), la data di creazione (quindi se è recente oppure no), 
gli altri linguaggi richiesti insieme al C++ (cercare nella descrizione). Possibilità di filtraggio in base alle 2 città con il più alto numero di lavori recenti trovati.

Esempi di Stats e Filtri sono disponibile al seguente indirizzo: https://learn.univpm.it/mod/page/view.php?id=156064

Dettagli circa l'utilizzo delle API sono disponibili in learn: https://learn.univpm.it/mod/page/view.php?id=156065

Ricordiamo che la scadenza per la presentazione del progetto per l'appello di Gennaio 2021 e' Venerdi' 22.*/





//|statistiche| |inserire città|

//setup(String[5]);
// schermata statistiche;
