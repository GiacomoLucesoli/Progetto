package ProgettoOOP.Lavoro.Statistiche;

import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;

import ProgettoOOP.Lavoro.Read.JsonOBJ;
import ProgettoOOP.Lavoro.model.JsonMod;

import java.util.List;

public class TESTMAIN {
	public static void main (String [] args) {

		String url="https://jobs.github.com/positions.json?description=c%2B%2B";
		JsonMod [] arrayOBJ=JsonOBJ.StringUrl(url);
		for (int i=0;i<arrayOBJ.length;i++) {
		System.out.println(arrayOBJ[i].getLocation());}
		/*System.out.println("in quali citt� vuoi cercare lavori?");
		
		Richiesta.SetCitta();
		
		for (int i=0;i<Richiesta.citta.length; i++) {
		System.out.print(Statistiche.StatTipi(arrayOBJ, Richiesta.citta)[i]);
		}
		System.out.println(arrayOBJ[1].created_at+arrayOBJ[2].created_at+arrayOBJ[3].created_at);
		System.out.println("metti ladata recente");
		System.out.println(Statistiche.StatData(arrayOBJ));

		try {
			for (int i=0;i<Richiesta.citta.length; i++) {
			System.out.println(Statistiche.StatLinguaggi(arrayOBJ)[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		**/
		BestCities.SetBestCities(arrayOBJ);
		System.out.println(BestCities.GetBestCity());
		System.out.println(BestCities.GetSecondBestCity());
		
	}
	

}
