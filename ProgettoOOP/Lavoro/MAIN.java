package ProgettoOOP.Lavoro;

import org.json.simple.JSONObject;
import ProgettoOOP.Lavoro.GUI.GUI_MAIN;
import ProgettoOOP.Lavoro.Read.JsonOBJ;
import ProgettoOOP.Lavoro.Statistiche.Statistiche;
import ProgettoOOP.Lavoro.model.JsonMod;


//@author Thomas Bonacci 

public class MAIN 
{

	public static void main(String[] args) 
	{
		String url="https://jobs.github.com/positions.json?description=c%2B%2B";
		JsonMod [] arrayOBJ=JsonOBJ.StringUrl(url);
		GUI_MAIN guiMain = new GUI_MAIN();		
		guiMain.Scelta_gui(arrayOBJ);
	}

}
