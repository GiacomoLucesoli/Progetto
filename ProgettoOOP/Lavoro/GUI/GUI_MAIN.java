package ProgettoOOP.Lavoro.GUI;

import java.io.IOException;
import org.json.simple.JSONObject;
import ProgettoOOP.Lavoro.Statistiche.BestCities;
import ProgettoOOP.Lavoro.Statistiche.Statistiche;
import ProgettoOOP.Lavoro.model.JsonMod;

//@author Giacomo Lucesoli
//@author Thomas Bonacci 

public class GUI_MAIN 
{
	private String[] citta = new String[5];

	public GUI_MAIN() 
	{
		/*
		//comando per jmod
		String url = "https://jobs.github.com/positions.json?description=c%2B%2B";
		JsonOBJ.StringUrl(url);
		*/
		//comando per gui_5città
		GUI_5città le_5città = new GUI_5città();
		System.out.println("");
		citta=le_5città.getCittà();
		System.out.println(citta[0]);
		System.out.println(citta[1]);
		System.out.println(citta[2]);
		System.out.println(citta[3]);
		System.out.println(citta[4]);
	}
	

	public void Scelta_gui(JsonMod[] JMod)
	{
		Statistiche statistiche = new  Statistiche(JMod);
		while(true)
		{
		//comando per gui_scelta
			GUI_scelta scelta = new GUI_scelta();
			Integer sceltaInteger = null;
			while(sceltaInteger == null)
				sceltaInteger = scelta.risultato();
				
		
			if(sceltaInteger==1)
			{
				//int quan = 1;
			
				Quantità quantita = new Quantità();
				
				quantita.Lavori(statistiche.NumLavori(citta));
			}
			if(sceltaInteger==2)
			{
				statistiche.StatTipi(citta);
				int part = Statistiche.Part;
				int full = Statistiche.Full;
				GUI_tipo tipo = new GUI_tipo(full, part);
			}
			if(sceltaInteger==3)
			{
				Digit_Time2 time = new Digit_Time2("Digita la data e verranno visualizzati i lavori con data successiva:");
				int[] data = time.getValue();
				JSONObject[] jMod=Statistiche.StatData(citta, data);
				GUI_QuantitaLavori quantita = new GUI_QuantitaLavori(jMod, data);
				
			}
			if(sceltaInteger==4)
			{
				//String[] Prog = {"c++", "c", "java"};
				//int[] valueProg = {2,4,7};
				
				try {
					GUI_elencoProgrammi programmi = new GUI_elencoProgrammi(statistiche.StatLinguaggi(citta));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//comando per digitare il tempo 1/2
			if(sceltaInteger==5)
			{
				Digit_Time2 time = new Digit_Time2("Digita la data e verranno visualizzati i lavori 2 luoghi con quantità di lavori maggiore con data successiva:");
				int[] data = time.getValue();
				Quantità quantita = new Quantità();
				BestCities bestcities = new BestCities(JMod, citta, data);
				
				//String[] citt = {"Roma", "Milano"};
				//int[] value = {4,6};
				String citta1 = (String) bestcities.GetBestCity().get("citta");
				String citta2 = (String) bestcities.GetSecondBestCity().get("citta");
				int value1 = (int) bestcities.GetBestCity().get("valori");
				int value2 = (int) bestcities.GetSecondBestCity().get("valori");
				
				quantita.Lavori(citta1, citta2, value1, value2, data);
	
			}
			
			//comando per visualizzare la quantità di lavori trovati
			
		}
    }
}
