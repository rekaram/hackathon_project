package Hackathon_Battery;
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
	// string variables to be compared for extracting values
	String compare1="Uid u0a202";
	String compare2="Foreground activities";
	
	// float variables used to store battery percentage and drain values
	float Battery_percentage=0,Battery_drain=0;
	
	//import file path to read text file
	File file = new File("C:\\Users\\user\\Desktop\\project\\Battery.txt"); 
	BufferedReader br = new BufferedReader(new FileReader(file)); 
	
	// string variable used to store foreground string
	String st,st2,st3;
	String Foreground=""; 
	
	//reaing the text file line by line until the end of the file
	while ((st = br.readLine()) != null) 
	{
		st2=st;
		
		//use ":" as a delimiter to split the line into array
		String[] array = st2.split(":");
		
		// if array has any data
		if(array.length>1)
		{ 
			
                //removing space at the front and back of the string
		array[0]=array[0].trim();
				 
		 // if it equals Uid u0a202 
		if(array[0].equals(compare1)  )
		{
		st3=array[1];
					
	         // to extract the data we are splitting as before the bracket in array1[0] and after the bracket in array[1]
		 String[] array1 = st3.split("\\(");
			
	         // then converting array1[0] into float which is the required battery drain
		 Battery_drain=Float.parseFloat(array1[0]); 
		         		
		 }
			
		 // if it equals Foreground activities 
		 if(array[0].equals(compare2))
	         {
                 st3=array[1];
			 
	         // to extract the data we are splitting as before the bracket in array1[0] and after the bracket in array[1]
		 String[] array1 = st3.split("\\(r");
			 
		 // then storing array1[0] into string variable which is the required foreground
		 Foreground=array1[0].trim();	
		 } 
	         }	  
	}
	
	// finding percentage of battery drained
	Battery_percentage=(Battery_drain/1000);
	
	// creating json object 
	JSONObject obj=new JSONObject();
	
	// adding the required data into the json object
	obj.put("Foreground_time",Foreground);
	obj.put("Battery_drain" ,Battery_drain);
	obj.put("Battery_percentage" ,Battery_percentage);
	
	//writing the json object into json file
	FileWriter file1=new FileWriter("C:\\Users\\user\\Desktop\\project\\output.json");
	file1.write(obj.toString());
	file1.flush();
	
	//displaying data stored in the json object
	System.out.println(obj);
	 } 
 }
