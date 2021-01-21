package ProgettoOOP.Lavoro.Read;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ProgettoOOP.Lavoro.GUI.Quantità;
import ProgettoOOP.Lavoro.model.JsonMod;

//@author Giacomo Lucesoli
//@author Thomas Bonacci 

public class JsonOBJ 
{
	
    /*public static void main(String[] args) 
    {
    	String url = "https://jobs.github.com/positions.json?description=c%2B%2B";
    	
    	String jSON=ReadAPI.toJSON(url); //il json è contenuto della stringa jSON
    	
    	
    	
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        String orario = "type";
        String creato = "created_at";
        String compagnia = "company";
        String luogo = "location";
        String descrizione = "description";
        try 
        {
            
        	 JSONArray obj =  (JSONArray) jsonParser.parse(jSON);
        	 //array di array di ogni gruppo (key, value)
        	 JsonMod ArrayOBJ[] = new JsonMod[obj.size()]; // array dove salvare i dati che saranno letti
        	 for(int i=0; i<obj.size(); i++)//gira tutti i lavori 
        	 {
        		 JSONObject str =  (JSONObject) obj.get(i); //crea un jsonobject con tutti i dati del lavoro <i>
            	ArrayOBJ[i]= new JsonMod(); //creazione ed insermento della nuova classe X obj.size()
        		 if(str.containsKey(orario))
        		 {
        			 Object OBJLab = str.get(orario);
        			 String n = (String) OBJLab;
        			 ArrayOBJ[i].setType(n);
        		 }
        		 if(str.containsKey(creato))
        		 {
        			 Object OBJLab = str.get(creato);
        			 String n = (String) OBJLab;
        			 ArrayOBJ[i].setCreated_at(n);
        		 }
        		 if(str.containsKey(compagnia))
        		 {
        			 Object OBJLab = str.get(compagnia);
        			 String n = (String) OBJLab;
        			 ArrayOBJ[i].setCompany(n);
        		 }
        		 if(str.containsKey(luogo))
        		 {
        			 Object OBJLab = str.get(luogo);
        			 String n = (String) OBJLab;
        			 ArrayOBJ[i].setLocation(n);
        		 }
        		 if(str.containsKey(descrizione))
        		 {
        			 Object OBJLab = str.get(descrizione);
        			 String n = (String) OBJLab;
        			 ArrayOBJ[i].setDescription(n);
        		 }
        		 
        		  
        		;  
        		 
        	 }
        	 return ArrayOBJ;
        	 System.out.println(ArrayOBJ[1].getCompany());
        	 System.out.print(obj.size());
		
			


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }    
        
  */

	public static JsonMod[] StringUrl(String url)
    {
    	//String url = "https://jobs.github.com/positions.json?description=c%2B%2B";
    	
    	String jSON=ReadAPI.toJSON(url); //il json è contenuto denlla stringa jSON
    	
    	
    	
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        String orario = "type";
        String creato = "created_at";
        String compagnia = "company";
        String luogo = "location";
        String descrizione = "description";
        JSONArray obj= null;
        try 
        {
            
        	 obj =  (JSONArray) jsonParser.parse(jSON);
        } catch (ParseException e) {
            e.printStackTrace();
        }
      
	 //array di array di ogni gruppo (key, value)
		 JsonMod ArrayOBJ[] = new JsonMod[obj.size()]; // array dove salvare i dati che saranno letti
		 for(int i=0; i<obj.size(); i++)//gira tutti i lavori 
		 {
			 JSONObject str =  (JSONObject) obj.get(i); //crea un jsonobject con tutti i dati del lavoro <i>
			ArrayOBJ[i]= new JsonMod(); //creazione ed insermento della nuova classe X obj.size()
			 if(str.containsKey(orario))
			 {
				 Object OBJLab = str.get(orario);
				 String n = (String) OBJLab;
				 boolean j=false;
			     if (n=="Contract") j=true;
			     ArrayOBJ[i].setType(j);
			 }
			 if(str.containsKey(creato))
			 {
				 Object OBJLab = str.get(creato);
				 String n = (String) OBJLab;
				 ArrayOBJ[i].setCreated_at(n);
			 }
			 if(str.containsKey(compagnia))
			 {
				 Object OBJLab = str.get(compagnia);
				 String n = (String) OBJLab;
				 ArrayOBJ[i].setCompany(n);
			 }
			 if(str.containsKey(luogo))
			 {
				 Object OBJLab = str.get(luogo);
				 String n = (String) OBJLab;
				 ArrayOBJ[i].setLocation(n);
			 }
			 if(str.containsKey(descrizione))
			 {
				 Object OBJLab = str.get(descrizione);
				 String n = (String) OBJLab;
				 ArrayOBJ[i].setDescription(n);
			 }
			 
			  
			  
			 
		 }
		 
		 System.out.println(ArrayOBJ[1].getCreated_at());
		 System.out.print(obj.size());



        
        return ArrayOBJ;
    } 
	
}
