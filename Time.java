package ProgettoOOP.src;

public class Time {
	static int [] time= new int[6];
	
	
	
	public static int TimeLength() {
		return time.length;
	}



	public static int [] ConvertiOrario (JsonMod OBJ) {
		
		String month;
		month= OBJ.created_at.substring(4 , 7); 
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
		default: System.out.println("c'è un errore nel formato del mese");time[1]=0;
		}
		String day;
		day= OBJ.created_at.substring(8 , 10); 
		time[2] = Integer.parseInt(day);
		//System.out.println("intero giorno: "+time[2]);
		String hour;
		hour= OBJ.created_at.substring(11 , 13); 
		time[3] = Integer.parseInt(hour);
		String min;
		min= OBJ.created_at.substring(14 , 16); 
		time[4] = Integer.parseInt(min);
		String sec;
		sec= OBJ.created_at.substring(17 , 19); 
		time[5] = Integer.parseInt(sec);
		String year;
		year= OBJ.created_at.substring(24 , 28); 
		time[0] = Integer.parseInt(year);
		
		return time;
	}

}
