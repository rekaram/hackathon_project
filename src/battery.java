import java.io.*;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.nio.file.*;
public class Battery {
	public static void main(String[] args)throws Exception 
	  { 
		String compare1="Uid u0a202";
		String compare2="Foreground activities";
		float Battery_percentage=0,Battery_drain=0;
		//import file path to read text file
		File file = new File("C:\\Users\\user\\Desktop\\project\\Battery.txt"); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st,st2,st3,Foreground=""; 
		//reaing the text file line by line
		while ((st = br.readLine()) != null) 
		{
			st2=st;
			//use ":" as a delimiter to split the line into array
			String[] array = st2.split(":");
			if(array.length>1)
			{ 
			        //removing space at the front and back of the string
				array[0]=array[0].trim();
				//String comparision 
				if(array[0].equals(compare1)  )
				{
		         		st3=array[1];
		         		String[] array1 = st3.split("\\(");
		         		Battery_drain=Float.parseFloat(array1[0]); 
		         		//System.out.println(Battery_drain);
				}
				if(array[0].equals(compare2))
				{
                		 	st3=array[1];
		         		String[] array1 = st3.split("\\(r");
		         		Foreground=array1[0].trim();
		         		//System.out.println(Foreground);
				} 
			}
	   
			  
		}
		Battery_percentage=(Battery_drain/1000);
		//System.out.println(Battery_percentage);
		JSONParser parser=new JSONParser();
		JSONObject obj=new JSONObject();
		obj.put("Foreground_time",Foreground);
		obj.put("Battery_drain" ,Battery_drain);
		obj.put("Battery_percentage" ,Battery_percentage);
		//creating json file to push the output
		FileWriter file1=new FileWriter("C:\\Users\\user\\Desktop\\project\\output.json");
		file1.write(obj.toString());
		file1.flush();
		System.out.println(obj);
		
	  } 
	
}
