package ProgettoOOP.src;

import org.json.simple.JSONObject;

public class BestCities {
	static int max1=0;
	static int max2=0;
	static int index1=0;
	static int index2=0;
	static JSONObject citta1=new JSONObject();
	static JSONObject citta2=new JSONObject();
	public static void SetBestCities (JsonMod [] arrayOBJ) {
		
		int [] cont=new int [arrayOBJ.length];
		for (int i=0;i<(arrayOBJ.length-1);i++) {
			cont[i]=1;
			for (int n=i+1;n<arrayOBJ.length;n++) {
				if (arrayOBJ[i].location.equals(arrayOBJ[n].location)) {
					cont[i]++;
				}
			}
		}
		//int max1=0, max2=0, index1=0, index2=0;
		for (int i=0;i<(arrayOBJ.length);i++) {
			if (cont[i]>max1) {
				max1=cont[i];
				index1=i;
			}
			else {
				if (cont[i]>=max2) {
					max2=cont[i];
					index2=i;
				}
			}
		}
		citta1.put("con",max1);				
		citta1.put("citta con più lavori", arrayOBJ[index1].location);
		citta2.put("con",max2);
		citta2.put("seconda citta con più lavori", arrayOBJ[index2].location);

		
	}
	public static JSONObject GetBestCity () {
		return citta1;
	}
	public static JSONObject GetSecondBestCity () {
		return citta2;
	}

}
