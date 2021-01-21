package ProgettoOOP.Lavoro.Statistiche;
import java.util.Scanner;

public class Richiesta {
	static String [] citta = new String [5];
	public static void SetCitta() {
		
		Scanner input = new Scanner(System.in);

		for(int i=0; i<5; i++) {
			String next = input.next();
			citta[i]=next;
		}
		input.close();
	}
	public static void GetCitta () {
		for(int i=0; i<citta.length; i++) {
			System.out.println(citta[i]+ " ");
		}
	}


}
