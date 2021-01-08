package ProgettoOOP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Statistiche {
	//le stat sulla tipologia
	public static void StatTipi (JsonMod [] arrayOBJ, String [] citta) {
		for (int j=0; j<citta.length; j++) {
			double Part=0,Full=0;
			int i,Lavori=0;
			//Part=0,Full=0
			for (i=0; i < arrayOBJ.length; i++) {
				if(arrayOBJ[i].location.equals(citta[j])){					
					Lavori++;
					if (arrayOBJ[i].type) Part++; 
					else Full++;				
				}
				
			}
			//li ho messi esterni perchè non mi funzionava il programma e volevo essere certo che non fosse per una cosa tipo sbaglio di tipo
			double FullP =(Full/Lavori)*100; 
			double PartP =(Part/Lavori)*100;
			System.out.println("Nella città di "+ citta[j] +" ci sono "+ Lavori + " lavori, di cui il "+ PartP +"% sono Part-Time mentre il " + FullP + "% sono Full-Time.\n");
		}
	}
	
	public static void StatData (JsonMod [] arrayOBJ) {
		Scanner input = new Scanner(System.in);
		//Time inputData= new Time();
		int [] inputData = new int [Time.TimeLength()];
		int recenti=0;
		for (int i=0; i<inputData.length; i++) {
			inputData[i]=input.nextInt();
		}
		
		for (int i=0; i<arrayOBJ.length; i++) {
			int [] orario=Time.ConvertiOrario(arrayOBJ[i]);
			
			boolean a=true;
			for (int n=0;n<Time.time.length;n++) {
				System.out.println(orario[n]);
				if (inputData[n]<orario[n]) {
					recenti++;
					break;
				}
				else {
					if (inputData[n]>orario[n]) break;
				}
					
				
			}
			
		}
		System.out.println("Su un totale di " +arrayOBJ.length+" lavori " + recenti + " sono precedenti alla data richiesta");
	}
	//JsonMod [] arrayOBJ
	
	public static Vector<String> SetLinguaggi () {
		Vector <String> linguaggi=new Vector <String>();
		try {
			Scanner file = new Scanner ( new BufferedReader (new FileReader ("linguaggi.txt")));
			for (int i=0; file.hasNext(); i++) {
				linguaggi.set(i, file.nextLine());
			}
			file.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return linguaggi;
	}
	
	public static void StatLinguaggi (JsonMod [] arrayOBJ) {
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
		
		
		
	}
}























