package ProgettoOOP.Lavoro.Statistiche;

import ProgettoOOP.Lavoro.model.JsonMod;

//@author Giacomo Lucesoli 
//@author Thomas Bonacci

public class Confronto {
	public static void confronta (JsonMod [] arrayOBJ,String [] citta) {
		for (int i=0;i<arrayOBJ.length; i++) {
			boolean corrispondenza=false;
			for (int n=0;n<citta.length;n++) {
				if (citta[n]==arrayOBJ[i].getLocation()) {
					corrispondenza=true;
				}
			}
			if (corrispondenza==false) {
				arrayOBJ=removeTheElement(arrayOBJ,i);
				i--;
			}
		}	
	}
	
	public static JsonMod[] removeTheElement(JsonMod[] arrayOBJ, int index) 
	{ 
	
		if (arrayOBJ == null || index < 0 || index >= arrayOBJ.length) { 
			return arrayOBJ; 
		} 
	
		JsonMod[] anotherArray = new JsonMod[arrayOBJ.length - 1]; 	
		for (int i = 0, k = 0; i < arrayOBJ.length; i++) { 
			if (i == index) { 
				continue; 
			} 
			anotherArray[k++] = arrayOBJ[i]; 
		} 
		return anotherArray; 
	} 

}
