package ProgettoOOP.Lavoro.Statistiche;

import ProgettoOOP.Lavoro.model.JsonMod;

//@author Giacomo Lucesoli 

public class Time {
	private static int [] time= new int[6];
	
	public static int [] getTime() {
		return time;
	}
	
	public static int TimeLength() {
		return getTime().length;
	}



	//metodo per convertire le stringhe che determinano l'orario nei JSON in un array di int
	public static int [] ConvertiOrario (JsonMod OBJ) {
		//l'array di int va dall'unit� di tempo pi� grande (anno in posizione 0) a quella pi� piccola (secondo in posizione 5)
		String year;
		year= OBJ.getCreated_at().substring(24 , 28); 
		time[0] = Integer.parseInt(year);
		String month;
		month= OBJ.getCreated_at().substring(4 , 7); 
		switch(month) {
		case "Jan":time[1]=1;break;
		case "Feb":time[1]=2;break;
		case "Mar":time[1]=3;break;
		case "Apr":time[1]=4;break;
		case "May":time[1]=5;break;
		case "Jun":time[1]=6;break;
		case "Jul":time[1]=7;break;
		case "Aug":time[1]=8;break;
		case "Sep":time[1]=9;break;
		case "Oct":time[1]=10;break;
		case "Nov":time[1]=11;break;
		case "Dec":time[1]=12;break;
		default: System.out.println("c'� un errore nel formato del mese");time[1]=0;
		}
		String day;
		day= OBJ.getCreated_at().substring(8 , 10); 
		time[2] = Integer.parseInt(day);
		//System.out.println("intero giorno: "+time[2]);
		String hour;
		hour= OBJ.getCreated_at().substring(11 , 13); 
		time[3] = Integer.parseInt(hour);
		String min;
		min= OBJ.getCreated_at().substring(14 , 16); 
		time[4] = Integer.parseInt(min);
		String sec;
		sec= OBJ.getCreated_at().substring(17 , 19); 
		time[5] = Integer.parseInt(sec);
		
		
		return time;
	}

}
