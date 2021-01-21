package ProgettoOOP.Lavoro.GUI;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.json.simple.JSONObject;

//@author Giacomo Lucesoli
//@author Thomas Bonacci 

public class GUI_elencoProgrammi 
{
	public int cont = 0;
	public boolean piu = false;
	public boolean meno = false;
	JFrame frame;
	JButton preButton;
	JButton succButton;
	JButton Button;
	public GUI_elencoProgrammi(JSONObject[] OBJProg) 
	{
		frame = new JFrame("Elenco programmi:");
		frame.setDefaultCloseOperation(0);
		frame.setSize(600, 140);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		Button = new JButton("INDIETRO");
		succButton = new JButton("SUCCESSIVO");
		preButton = new JButton("PRECEDENTE");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		JPanel panelButt = new JPanel();

		panelButt.setLayout(new GridLayout(1,3));
		panelButt.add(preButton);
		panelButt.add(Button);
		panelButt.add(succButton);
		JLabel txtLabel = new JLabel("", SwingConstants.CENTER);
		panel.add(txtLabel);
		panel.add(panelButt);
		frame.add(panel);
		
		String programma;
		int value;
		boolean flag = true;
		IndButton button = new IndButton();
		
		while(flag) 
		{
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(piu)
			{
				cont++;
				piu = false;
			}
			if(meno)
			{
				cont--;
				meno = false;
			}
			if(cont<0)
				cont =0;
			if(cont>OBJProg.length-1)
				cont=OBJProg.length-1;
	
			programma = (String) OBJProg[cont].get("Linguaggio");
			value = (int) OBJProg[cont].get("Quantita");
			txtLabel.setText("Il programma: "+  programma + " ha un totale di " + value + " lavori trovati" );
			if(cont>0)
			{
				preButton.setBackground(Color.LIGHT_GRAY);
				preButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
							meno = true;
						
						
					}
				});
			}
			else 
			{
				preButton.addActionListener(null);
				preButton.setBackground(Color.GRAY);
			}
			if(cont<OBJProg.length-1) 
			{
				
				succButton.setBackground(Color.LIGHT_GRAY);
				succButton.addActionListener(new ActionListener() 
				{
					
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						piu= true;
					
						
					}
				});
			}
			else 
			{
				succButton.addActionListener(null);
				succButton.setBackground(Color.GRAY);
			}
			
		
			Button.addActionListener(button);
			flag = button.flag();
			
		}
		frame.setVisible(flag);
	}
}
