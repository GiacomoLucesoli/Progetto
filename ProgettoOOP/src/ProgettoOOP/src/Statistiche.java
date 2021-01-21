package ProgettoOOP.src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import org.json.simple.JSONObject;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Statistiche {
	private static JsonMod [] arrayOBJ=null;


	public Statistiche(JsonMod [] lavori) {
		arrayOBJ=lavori;
	}
	
	public JsonMod[] GetArrayOBJ () {
		return arrayOBJ;
	}
	public int NumLavori (String [] citta) {
		int quantita=0;
		for (int j=0; j<citta.length && citta[j]!=null; j++) {
			for (int i=0; i < arrayOBJ.length; i++) {
				if (arrayOBJ[i].getLocation().equals(citta[j])) {
					quantita++;
				}
			}
		}
		return quantita;
	}
	//Metodo per le statistiche sulla tipologia
	public JSONObject[] StatTipi (String [] citta) {
		//le parti di programma segnate come note sono per far si che il metodo ritorni il JSON dei lavori per le caratteristiche di filtraggio
		JSONObject [] StatType = new JSONObject [citta.length];
		//JSONObject [] Lavori = new JSONObject [arrayOBJ.length];
		//in ciascuna delle città inserite in input 
		for (int j=0; j<citta.length && citta[j]!=null; j++) {
			
			double Part=0,Full=0;			
			StatType[j]=new JSONObject();
			//per ogni lavoro trovato
			for (int i=0; i < arrayOBJ.length; i++) {
				//Lavori[i] = new JSONObject();
				//nel caso in cui la città del lavoro trovato coincida con la città richiesta
				if(arrayOBJ[i].getLocation().equals(citta[j])){	
					//controlla il tipo di lavoro
					if (arrayOBJ[i].getType()) {Part++;
					//Lavori[i].put("Part Time",arrayOBJ[i]);
					}
					else {
						Full++;	
						//Lavori[i].put("Full Time",arrayOBJ[i]);
					}
					
				}
				
			}
			StatType[j].put("Citta",citta[j]);
			StatType[j].put("Part-Time",Part);
			StatType[j].put("Full-Time",Full);
		}
		return StatType;
		//return Lavori;
	}
	//Metodo per le statistiche sulle date
	public static JSONObject[] StatData (String [] citta, int [] inputData) {		
		/*Scanner input = new Scanner(System.in);
		
		//Vector <JSONObject> Recenti=new Vector <JSONObject>();
		int [] inputData = new int [Time.TimeLength()];
		
		//l'utente inserisce la data massima che è considerata recente
		for (int i=0; i<inputData.length; i++) {
			inputData[i]=input.nextInt();
		}
		
		*/
		JSONObject [] StatDate = new JSONObject [citta.length];
		//in ciascun lavoro
		for (int j=0; j<citta.length && citta[j]!=null; j++) {
			StatDate[j]=new JSONObject();
			StatDate[j].put("Citta",citta[j]);
			int recenti=0;
			for (int i=0; i<arrayOBJ.length; i++) {				
				int [] orario=Time.ConvertiOrario(arrayOBJ[i]);
				if(arrayOBJ[i].getLocation().equals(citta[j])){	
					
					
					//verifica se la data del lavoro è recente 
					for (int n=0;n<inputData.length;n++) {
						//System.out.println(orario[n]);
						if (inputData[n]<orario[n]) {
							recenti++;
							//JSONObject a = new JSONObject();
							//a.put("Lavoro Recente", arrayOBJ[n]);
							//Recenti.add(a);
							
							break;
						}
						else {
							if (inputData[n]>orario[n]) break;
						}
							
						
					}
					
				}				
			}
			StatDate[j].put("Recenti",recenti);
		}
		//System.out.println("Su un totale di " +arrayOBJ.length+" lavori " + recenti + " sono precedenti alla data richiesta");
		
		
		return StatDate;
		//return Recenti;
	}
	
	//metodo per mettere a string i linguaggi scritti sul file di testo "linguaggi.txt"
	public Vector<String> SetLinguaggi () throws IOException {
		
		//int cont = 0;
		BufferedReader in = new BufferedReader(new FileReader("linguaggi.txt"));
		//while(in.readLine()!=null) cont++;
		in.close();
		Vector <String> linguaggi=new Vector <String>();
		//String [] linguaggi=new String [cont];
		Scanner file = new Scanner ( new BufferedReader (new FileReader ("linguaggi.txt")));
		for (int i=0; file.hasNext(); i++) {
			//String riga=file.nextLine();
			//linguaggi[i]=file.nextLine();
			linguaggi.add(i, file.nextLine());
		}
		file.close();
			
		

		return linguaggi;
	}
	//Metodo per le statistiche sui linguaggi richiesti
	public JSONObject[] StatLinguaggi (String [] citta) throws IOException {
		
		Vector <String> linguaggi= SetLinguaggi();;
		//Vector <JSONObject> Lavori=new Vector <JSONObject>();
		JSONObject [] StatLanguages = new JSONObject [linguaggi.size()];
		int [] num= new int [linguaggi.size()];
		//inizializzo a zero il contatore di ciascun linguaggio
		for (int n=0; n<linguaggi.size();n++) {
			StatLanguages[n]=new JSONObject();
			num[n]=0;
			}
		for (int j=0; j<citta.length && citta[j]!=null; j++) {	
			// se il inguaggio è presente nella descrizione aumento il valore del suo contatore
			for (int i=0;i<arrayOBJ.length; i++) {
				if(arrayOBJ[i].getLocation().equals(citta[j])){	
					for (int n=0; n<linguaggi.size();n++) {	
						if (arrayOBJ[i].getDescription().contains(linguaggi.get(n)))	{
								num[n]++;
								JSONObject a = new JSONObject();
								a.put("Lavoro Recente", arrayOBJ[n]);
								//Lavori.add(a);
								
						}
					}
				}
				
			}
		}
		for (int n=0; n<linguaggi.size();n++) {
				//System.out.println("Ci sono " + num[n] + " offerte di lavoro in cui è richiesta una conoscenza sul linguaggio: " +linguaggi[n]);
			StatLanguages[n].put("Linguaggio", linguaggi.get(n));
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



















