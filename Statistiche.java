package ProgettoOOP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import org.json.simple.JSONObject;
import java.util.List;


public class Statistiche {
	//le stat sulla tipologia
	public static JSONObject[] StatTipi (JsonMod [] arrayOBJ, String [] citta) {
		JSONObject [] StatType = new JSONObject [citta.length];
		for (int j=0; j<citta.length; j++) {
			double Part=0,Full=0;
			int i,Lavori=0;
			StatType[j]=new JSONObject();
			for (i=0; i < arrayOBJ.length; i++) {
				if(arrayOBJ[i].location.equals(citta[j])){					
					Lavori++;
					if (arrayOBJ[i].type) Part++; 
					else Full++;				
				}
				
			}
			//li ho messi esterni perchè non mi funzionava il programma e volevo essere certo che non fosse per una cosa tipo sbaglio di tipo
			//double FullP =(Full/Lavori)*100; 
			//double PartP =(Part/Lavori)*100;
			//System.out.println("Nella città di "+ citta[j] +" ci sono "+ Lavori + " lavori, di cui il "+ PartP +"% sono Part-Time mentre il " + FullP + "% sono Full-Time.\n");
			StatType[j].put("Città",citta[j]);
			StatType[j].put("Numero di Lavori",Lavori);
			StatType[j].put("Part-Time",Part);
			StatType[j].put("Full-Time",Full);
		}
		return StatType;
	}
	
	public static JSONObject StatData (JsonMod [] arrayOBJ) {
		Scanner input = new Scanner(System.in);
		//Time inputData= new Time();
		int [] inputData = new int [Time.TimeLength()];
		int recenti=0;
		for (int i=0; i<inputData.length; i++) {
			inputData[i]=input.nextInt();
		}
		JSONObject StatDate = new JSONObject ();
		for (int i=0; i<arrayOBJ.length; i++) {
			int [] orario=Time.ConvertiOrario(arrayOBJ[i]);
			
			boolean a=true;
			for (int n=0;n<Time.time.length;n++) {
				//System.out.println(orario[n]);
				if (inputData[n]<orario[n]) {
					recenti++;
					break;
				}
				else {
					if (inputData[n]>orario[n]) break;
				}
					
				
			}
			
		}
		//System.out.println("Su un totale di " +arrayOBJ.length+" lavori " + recenti + " sono precedenti alla data richiesta");
		StatDate.put("Recenti",recenti);
		return StatDate;
	}
	//JsonMod [] arrayOBJ
	//public static Vector <String> SetLinguaggi () throws IOException {
	public static String[] SetLinguaggi () throws IOException {
		
		int cont = 0;
		BufferedReader in = new BufferedReader(new FileReader("linguaggi.txt"));
		while(in.readLine()!=null) cont++;
		in.close();
		//Vector <String> linguaggi=new Vector <String>();
		String [] linguaggi=new String [cont];
		Scanner file = new Scanner ( new BufferedReader (new FileReader ("linguaggi.txt")));
		for (int i=0; file.hasNext(); i++) {
			//String riga=file.nextLine();
			linguaggi[i]=file.nextLine();
		}
		file.close();
			
		

		return linguaggi;
	}
	
	public static JSONObject[] StatLinguaggi (JsonMod [] arrayOBJ) throws IOException {
		String[] linguaggi;
		
		linguaggi = Statistiche.SetLinguaggi();
		JSONObject [] StatLanguages = new JSONObject [linguaggi.length];
		int [] num= new int [linguaggi.length];
		//inizializzo a zero il contatore di ciascun linguaggio
		for (int n=0; n<linguaggi.length;n++) {
			StatLanguages[n]=new JSONObject();
			num[n]=0;
			}
			// se il inguaggio è presente nella descrizione aumento il valore del suo contatore
		for (int i=0;i<arrayOBJ.length; i++) {
			for (int n=0; n<linguaggi.length;n++) {	
				if (arrayOBJ[i].description.contains(linguaggi[n]))	{
						num[n]++;
				}
			}
		}
		for (int n=0; n<linguaggi.length;n++) {
				//System.out.println("Ci sono " + num[n] + " offerte di lavoro in cui è richiesta una conoscenza sul linguaggio: " +linguaggi[n]);
			StatLanguages[n].put("Linguaggio", linguaggi[n]);
			StatLanguages[n].put("Quantità",num[n]);
		}
		return StatLanguages;
		
		
		
		
	}
	
}

/**
 * public static void StatLinguaggi (JsonMod [] arrayOBJ) {
 *
		Vector <String> linguaggi=Statistiche.SetLinguaggi();
		int [] num= new int [linguaggi.size()];
		//inizializzo a zero il contatore di ciascun linguaggio
		for (int n=0; n<linguaggi.size();n++) {
			num[n]=0;
		}
		// se il inguaggio è presente nella descrizione aumento il valore del suo contatore
		for (int i=0;i<arrayOBJ.length; i++) {
			for (int n=0; n<linguaggi.size();n++) {	
				if (arrayOBJ[i].description.contains(linguaggi.get(n)))	{
					num[n]++;
				}
			}
		}
		for (int n=0; n<linguaggi.size();n++) {
			System.out.println("Ci sono " + num[n] + " offerte di lavoro in cui è richiesta una conoscenza sul linguaggio: " +linguaggi.get(n));
		}
		
		
		
	}*/





















