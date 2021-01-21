package ProgettoOOP.Lavoro.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.validation.constraints.Pattern.Flag;

public class IndButton implements ActionListener
{
	private boolean f=true;
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		f = false;
		
		
	}
	
	public boolean flag()
	{
		return f;
	}
	
	
}
