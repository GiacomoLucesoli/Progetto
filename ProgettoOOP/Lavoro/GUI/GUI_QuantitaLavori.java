package ProgettoOOP.Lavoro.GUI;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.json.simple.JSONObject;

public class GUI_QuantitaLavori 
{
	
	JFrame frame;
	JPanel panel;
	JButton indButton;

	public GUI_QuantitaLavori(JSONObject[] jMod, int[] data)
	{
		frame = new JFrame("Quantità di lavori trovati:");
		frame.setDefaultCloseOperation(0);
		frame.setSize(800, 340);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(new GridLayout(7,1));
		indButton = new JButton("INDIETRO");
	

		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,2));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,2));
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(1,2));
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(1,2));
		
		JLabel citta1 = new JLabel("",SwingConstants.CENTER);
		JLabel citta2 = new JLabel("",SwingConstants.CENTER);
		JLabel citta3 = new JLabel("",SwingConstants.CENTER);
		JLabel citta4 = new JLabel("",SwingConstants.CENTER);
		JLabel citta5 = new JLabel("",SwingConstants.CENTER);
		
		JLabel quant1 = new JLabel("",SwingConstants.CENTER);
		JLabel quant2 = new JLabel("",SwingConstants.CENTER);
		JLabel quant3 = new JLabel("",SwingConstants.CENTER);
		JLabel quant4 = new JLabel("",SwingConstants.CENTER);
		JLabel quant5 = new JLabel("",SwingConstants.CENTER);
		
		JLabel txtJLabel = new JLabel("",SwingConstants.CENTER);
		LineBorder Black = new LineBorder(Color.black); 
		citta1.setBorder(Black); 
		citta2.setBorder(Black);
		citta3.setBorder(Black); 
		citta4.setBorder(Black); 
		citta5.setBorder(Black);
		quant1.setBorder(Black); 
		quant2.setBorder(Black); 
		quant3.setBorder(Black);
		quant4.setBorder(Black); 
		quant5.setBorder(Black);
	
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);

		panel1.add(citta1);panel1.add(quant1);
		panel2.add(citta2);panel2.add(quant2);
		panel3.add(citta3);panel3.add(quant3);
		panel4.add(citta4);panel4.add(quant4);
		panel5.add(citta5);panel5.add(quant5);
		panel.add(txtJLabel);
		panel.add(indButton);
		
		
		
		String dataString = data[0]+"/"+data[1]+"/"+data[2]+"\n"
				+ 			"alle ore: " + data[3]+ ":"+ data[4]+ ":"+data[5]+"\n";
		
		txtJLabel.setText("quantita di lavori trovati per ogni città dopo il " + dataString);
		
		citta1.setText((String)jMod[0].get("Citta"));
		citta2.setText((String)jMod[1].get("Citta"));
		citta3.setText((String)jMod[2].get("Citta"));
		citta4.setText((String)jMod[3].get("Citta"));
		citta5.setText((String)jMod[4].get("Citta"));
		

		quant1.setText(""+(int)jMod[0].get("Recenti"));
		quant2.setText(""+(int)jMod[1].get("Recenti"));
		quant3.setText(""+(int)jMod[2].get("Recenti"));
		quant4.setText(""+(int)jMod[3].get("Recenti"));
		quant5.setText(""+(int)jMod[4].get("Recenti"));
		
		panel.add(indButton);
		frame.add(panel);
		frame.setVisible(true);
		
		boolean flag = true;
		IndButton button = new IndButton();
		while(flag) 
		{
			indButton.addActionListener(button);
			flag = button.flag();
			
		}
		frame.setVisible(flag);
		// aggiungere il pulsante per tornare indietro
	}
}
