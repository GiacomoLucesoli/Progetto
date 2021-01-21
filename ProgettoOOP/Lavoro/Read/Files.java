package ProgettoOOP.Lavoro.Read;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Files 
{
	public static void Write(char write)
	{
		try {
			File file = new File("json.json");
			FileWriter fw = new FileWriter(file, true);
			fw.append(write);
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static void Clear()
	{
		try {
			File file = new File("json.json");
			FileWriter fwClear = new FileWriter(file);
			fwClear.write("");
			fwClear.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
