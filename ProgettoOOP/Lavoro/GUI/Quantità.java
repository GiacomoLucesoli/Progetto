package ProgettoOOP.Lavoro.GUI;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.validation.constraints.Pattern.Flag;
import org.apache.tomcat.util.bcel.Const;
import org.json.simple.JSONObject;
import org.springframework.web.client.HttpClientErrorException.Gone;

//@author Giacomo Lucesoli
//@author Thomas Bonacci 

public class Quantità 
{
	
	JFrame frame;
	JPanel panel;
	JButton indButton;
	JLabel txtLabel;
	
	public Quantità()
	{
		frame = new JFrame("Quantità di lavori trovati:");
		frame.setDefaultCloseOperation(0);
		frame.setSize(600, 140);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		indButton = new JButton("INDIETRO");
		txtLabel = new JLabel("",SwingConstants.CENTER);
		panel.add(txtLabel);
		panel.add(indButton);
		frame.add(panel);
	}
	public void Lavori(int n)
	{
		txtLabel.setText("la quantità di lavori trovati sono: " + n);
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
	
	
	public void Lavori(String citta1, String citta2, int value1, int value2, int[] data)
	{
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,1));
		panel.add(panel2);
		panel.add(indButton);
		frame.add(panel);
		JLabel txtLabel2 = new JLabel("",SwingConstants.CENTER);;
		JLabel txtLabel3 = new JLabel("",SwingConstants.CENTER);;
		panel2.add(txtLabel);
		panel2.add(txtLabel2);
		panel2.add(txtLabel3);
		String dataString = data[0] +"/"+data[1]+"/"+data[2]
							+ "alle ore: " + data[3]+ ":"+ data[4]+ ":"+data[5];
		if(value1!=0)
		{
			txtLabel.setText("la città con più lavori è " + citta1+ " con " +value1+ " lavori");
		}
		else 
		{
			txtLabel.setText("non sono presenti città con lavori disponibili");
		}
		if(value2!=0)
		{
			txtLabel2.setText("la seconda città con più lavori è " + citta2+ " con " + value2+ " lavori");
		}
		else 
		{
			txtLabel2.setText("non sono presenti città con lavori disponibili");
		}
			
		txtLabel3.setText("successivi alla data " +dataString);
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
