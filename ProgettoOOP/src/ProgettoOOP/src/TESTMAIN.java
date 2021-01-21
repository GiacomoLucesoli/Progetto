package ProgettoOOP.src;

import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import java.util.List;

public class TESTMAIN {
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		String url="https://jobs.github.com/positions.json?description=c%2B%2B";
		JsonMod [] arrayOBJ=JsonOBJ.StringUrl(url);
		for (int i=0;i<arrayOBJ.length;i++) {
		System.out.println(arrayOBJ[i].getLocation()+arrayOBJ[i].getCreated_at());
		}
		
		System.out.println("in quali città vuoi cercare lavori?");
		
		Richiesta.SetCitta();
		/*
		for (int i=0;i<Richiesta.citta.length; i++) {
		System.out.print(Statistiche.StatTipi(Richiesta.GetCitta())[i]);
		}
		System.out.println(arrayOBJ[1].getCreated_at()+arrayOBJ[2].getCreated_at()+arrayOBJ[3].getCreated_at());
		System.out.println("metti ladata recente");
		
		String [] citta = Richiesta.GetCitta();
		JSONObject[] marco = Statistiche.StatTipi(citta);
		
		try {
			for (int i=0;i<Richiesta.citta.length; i++) {
			System.out.println(Statistiche.StatLinguaggi(Richiesta.citta)[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BestCities.SetBestCities(arrayOBJ,Richiesta.citta);
		System.out.print(BestCities.GetBestCity());
		System.out.print(BestCities.GetSecondBestCity());
		*/
		String [] tumadre=Richiesta.citta;
		Statistiche marco=new Statistiche(arrayOBJ);
		JSONObject [] StatDate=marco.StatData(tumadre);
		for (int o=0;o<tumadre.length; o++) {
		System.out.println(StatDate[o]);}
	}
	

}
