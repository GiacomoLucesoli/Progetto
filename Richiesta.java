import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Richiesta {
	static String [] Citta = new String [5];
	static String Lavoro;
	public static void RichiediCitta() throws IOException {
		
		Scanner input = new Scanner(System.in);
		BufferedWriter writer;
		writer = new BufferedWriter( new FileWriter("citta.txt"));
		for(int i=0; i<5; i++) {
			String next = input.next();
			Citta[i]=next;
			writer.write(next + "\n");
			}
		writer.close();
		
		
	}
	public static void RichiediLavoro() {
		Scanner input = new Scanner(System.in);
		Lavoro=input.next();
		
	}

}
