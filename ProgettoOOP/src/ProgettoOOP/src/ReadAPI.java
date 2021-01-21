package ProgettoOOP.src;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

public class ReadAPI 
{
	/*public static void main(String[] args) throws Exception
	{
		String url = "https://jobs.github.com/positions.json?description=c%2B%2B";


		        HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
		        InputStreamReader a = new InputStreamReader(openConnection.getInputStream());
		        
		        
		        BufferedReader in = new BufferedReader(a);

		        String inputLine;
		        inputLine = in.readLine();
		        Files.Clear();
		        for(int i = 0; i <inputLine.length(); i++) 
		        {
		        	char carattere = inputLine.charAt(i);
		        	System.out.print(carattere);
		        	Files.Write(carattere);
		        	
		        	
		        }

		        in.close();
	}*/
	public static String toJSON(String url)
	{
		String inputLine = null;
		try {
			
		

		        HttpURLConnection openConnection = (HttpURLConnection) new URL(url).openConnection();
		        InputStreamReader a = new InputStreamReader(openConnection.getInputStream());
		        
		        
		        BufferedReader in = new BufferedReader(a);

		        
		        inputLine = in.readLine();
		        /*Files.Clear();
		        for(int i = 0; i <inputLine.length(); i++) 
		        {
		        	char carattere = inputLine.charAt(i);
		        	System.out.print(carattere);
		        	Files.Write(carattere);
		        	
		        	
		        }
*/
		        in.close();
		        
		        
	 } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     } /*catch (ParseException e) {
         e.printStackTrace();
     }*/
		return inputLine;			
	}
}