package ProgettoOOP.Lavoro.GUI;

import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUI_tipo 
{
	JFrame frame;
	JButton Button;
	public GUI_tipo(int full, int part)
	{
		frame = new JFrame("Statistiche lavori");
		frame.setDefaultCloseOperation(0);
		frame.setSize(600, 140);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		Button = new JButton("INDIETRO");
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		JPanel panelTXT = new JPanel();
		JPanel panelValue = new JPanel();
		panelTXT.setLayout(new GridLayout(1,2));
		panelValue.setLayout(new GridLayout(1,2));
		panel.add(panelTXT);
		panel.add(panelValue);
		panel.add(Button);
		frame.add(panel);
		JLabel labelF_T = new JLabel("Full-time",SwingConstants.CENTER);
		JLabel labelP_T = new JLabel("Part-time",SwingConstants.CENTER);
		panelTXT.add(labelF_T);
		panelTXT.add(labelP_T);
		
		
		JLabel valueF_T = new JLabel("",SwingConstants.CENTER);
		JLabel valueP_T = new JLabel("",SwingConstants.CENTER);
		panelValue.add(valueF_T);
		panelValue.add(valueP_T);
		valueF_T.setText(""+full);
		valueP_T.setText(""+part);
		boolean flag = true;
		IndButton button = new IndButton();
		while(flag) 
		{
			Button.addActionListener(button);
			flag = button.flag();
			
		}
		frame.setVisible(flag);
	}
	
	
}
