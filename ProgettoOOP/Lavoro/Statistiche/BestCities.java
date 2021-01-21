package ProgettoOOP.Lavoro.Statistiche;

import java.util.Scanner;

import org.json.simple.JSONObject;

import ProgettoOOP.Lavoro.model.JsonMod;
//classe per calcolare e ritornare le 2 citt� con pi� valori
public class BestCities {
	static int max1=0;
	static int max2=0;
	static int index1=0;
	static int index2=0;
	static JSONObject citta1=new JSONObject();
	static JSONObject citta2=new JSONObject();
	
	public BestCities (JsonMod [] arrayOBJ, String [] citta, int[] inputData) {
	/*
		Scanner input = new Scanner(System.in);
		
		//Vector <JSONObject> Recenti=new Vector <JSONObject>();
		int [] inputData = new int [Time.TimeLength()];
		
		//l'utente inserisce la data massima che � considerata recente
		for (int i=0; i<inputData.length; i++) {
			inputData[i]=input.nextInt();
		}
		*/
		
		int [] cont=new int [arrayOBJ.length];
		for (int j=0; j<citta.length && citta[j]!=null; j++) {
			for (int i=0;i<(arrayOBJ.length);i++) {
				int [] orario=Time.ConvertiOrario(arrayOBJ[i]);
				if(arrayOBJ[i].getLocation().equals(citta[j])){
					for (int n=0;n<Time.getTime().length;n++) {
						if (inputData[n]<orario[n]) {
							cont[i]=1;
							if ( i!=(arrayOBJ.length-1)) {
								for (int f=i+1;f<arrayOBJ.length;f++) {
									if (arrayOBJ[i].getLocation().equals(arrayOBJ[f].getLocation())) {
										cont[i]++;
									}
								}
							}
						}
						else {
							if (inputData[n]>orario[n]) break;
						}
					}
					
				}
				
			}
		}
		// && arrayOBJ[i].getLocation().equals(citta[j])
		//int max1=0, max2=0, index1=0, index2=0;
		for (int i=0;i<(arrayOBJ.length);i++) {
			if (cont[i]>max1) {
				max1=cont[i];
				index1=i;
			}
			else {
				if (cont[i]>max2) {
					max2=cont[i];
					index2=i;
				}
			}
		}
		citta1.put("valori",max1);				
		citta1.put("citta", arrayOBJ[index1].getLocation());
		citta2.put("valori",max2);
		citta2.put("citta", arrayOBJ[index2].getLocation());

		
	}
	public JSONObject GetBestCity () {
		return citta1;
	}
	public JSONObject GetSecondBestCity () {
		return citta2;
	}

}
