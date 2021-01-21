package ProgettoOOP.Lavoro.GUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.management.loading.PrivateClassLoader;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.w3c.dom.CDATASection;

//@author Giacomo Lucesoli
//@author Thomas Bonacci 

public class Digit_Time2 
{
	
	private int [] value = {0,0,0,0,0,0};
	JFrame frame;
	JPanel panel;
	JButton continuaButton;

	public Digit_Time2(String txt)
	{
		frame = new JFrame(txt);
		frame.setDefaultCloseOperation(0);
		frame.setSize(600, 140);
		frame.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		continuaButton = new JButton("CONTINUA");
		
		//panel per i menu a tendina
		JPanel panel1 = new JPanel();
		panel.add(panel1);
		panel1.setLayout(new GridLayout(2,6));
		JLabel labelAnno = new JLabel("ANNO", SwingConstants.CENTER);
		JLabel labelMese = new JLabel("MESE", SwingConstants.CENTER);
		JLabel labelGiorno = new JLabel("GIORNO", SwingConstants.CENTER);
		JLabel labelOra = new JLabel("ORA", SwingConstants.CENTER);
		JLabel labelMinuto = new JLabel("MINUTO", SwingConstants.CENTER);
		JLabel labelSecondo = new JLabel("SECONDO", SwingConstants.CENTER);
		panel1.add(labelAnno);
		panel1.add(labelMese);
		panel1.add(labelGiorno);
		panel1.add(labelOra);
		panel1.add(labelMinuto);
		panel1.add(labelSecondo);
		
		// font bottone continua
		Font fontButton = new Font("Arial Rounded MT Bold", Font.BOLD,28); 
		continuaButton.setFont(fontButton);
		// font label
		Font fontLabel = new Font("Arial Rounded MT Bold", Font.PLAIN,15);
		
		labelAnno.setFont(fontLabel);
		labelMese.setFont(fontLabel);
		labelGiorno.setFont(fontLabel);
		labelOra.setFont(fontLabel);
		labelMinuto.setFont(fontLabel);
		labelSecondo.setFont(fontLabel);
		
		DefaultListCellRenderer CenterRenderer = new DefaultListCellRenderer();
		CenterRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		
		// menu a tendina per anni
		Integer[] anno = new Integer[2021-1970+1];
		for(int i = 1970,e=0; i<=2021;i++) 
		{
			anno[e]= i;
			e++;
		}
		final JComboBox<Integer> cbAnni = new JComboBox<Integer>(anno);
		cbAnni.setVisible(true);
		cbAnni.setFont(fontLabel);
		cbAnni.setRenderer(CenterRenderer);
		panel1.add(cbAnni);
		
		// menu a tendina per mesi
		Integer[] mese = new Integer[12];
		for(int i=0; i<12;i++)
			mese[i]=i+1;
		final JComboBox<Integer> cbMesi = new JComboBox<Integer>(mese);
		cbMesi.setVisible(true);
		cbMesi.setFont(fontLabel);
		cbMesi.setRenderer(CenterRenderer);
		panel1.add(cbMesi);
		
		
		// menu a tendina per giorni
		Integer[] giorno = new Integer[31];
		for(int i=0; i<31;i++)
			giorno[i]=i+1;
		final JComboBox<Integer> cbGiorni = new JComboBox<Integer>(giorno);
		cbGiorni.setVisible(true);
		cbGiorni.setFont(fontLabel);
		cbGiorni.setRenderer(CenterRenderer);
		panel1.add(cbGiorni);
		
		
		// menu a tendina per ore
		Integer[] ora = new Integer[23];
		for(int i=0; i<23;i++)
			ora[i]=i+1;
		final JComboBox<Integer> cbOre = new JComboBox<Integer>(ora);
		cbOre.setVisible(true);
		cbOre.setFont(fontLabel);
		cbOre.setRenderer(CenterRenderer);
		panel1.add(cbOre);
		
		// menu a tendina per minuti e secondi
		Integer[] minuto_secondo = new Integer[59];
		for(int i=0; i<59;i++)
			minuto_secondo[i]=i+1;
		final JComboBox<Integer> cbMinuti = new JComboBox<Integer>(minuto_secondo);
		cbMinuti.setVisible(true);
		cbMinuti.setFont(fontLabel);
		cbMinuti.setRenderer(CenterRenderer);
		panel1.add(cbMinuti);
		final JComboBox<Integer> cbSecondi = new JComboBox<Integer>(minuto_secondo);
		cbSecondi.setVisible(true);
		cbSecondi.setFont(fontLabel);
		cbSecondi.setRenderer(CenterRenderer);
		panel1.add(cbSecondi);
		
		
		
		panel.add(continuaButton);
		frame.add(panel);
		frame.setVisible(true);
		boolean flag = true;
		IndButton button = new IndButton();
		while(flag) 
		{
			continuaButton.addActionListener(button);
			flag = button.flag();
			
		}
		if(!flag) 
		{
				// TODO Auto-generated method stub
				//return combobox
				value[0] = ((Integer) cbAnni.getSelectedItem());
				//System.out.println(valueAnno);
				value[1] = ((Integer) cbMesi.getSelectedItem());
				//System.out.println(valueMese);
				value[2] = ((Integer) cbGiorni.getSelectedItem());
				//System.out.println(valueGiorno);
				value[3] = ((Integer) cbOre.getSelectedItem());
				//System.out.println(valueOra);
				value[4] = ((Integer) cbMinuti.getSelectedItem());
				//System.out.println(valueMinuto);
				value[5] = ((Integer) cbSecondi.getSelectedItem());
				//System.out.println(valueSecondo);
				
				
				
		}
		frame.setVisible(flag);
		
	}

	public int[] getValue() {
		return value;
	}

	
	
}
