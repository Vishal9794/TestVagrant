package jsonproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSONFile {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		
		FileReader reader=new FileReader(".\\jsonfiles\\RCBTeam.json");
		
		Object obj=jsonparser.parse(reader);
		
		JSONObject teamjsonobj=(JSONObject)obj;
			
		JSONArray array=(JSONArray)teamjsonobj.get("player");
		
		int count1=0;
		int count2=0;
		
		for(int i=0;i<array.size();i++) {
			
			JSONObject player=(JSONObject) array.get(i);
			if(!(player.get("country").equals("India"))) {
				count1++;
			}
			
			if((player.get("role").equals("Wicket-keeper"))){
				count2++;
			}
			
		}
		if(count1==4) {
			System.out.println("Team has only 4 foreign players");
		}else {
			System.out.println("Team has more than or less than 4 foreign players");
		}
		if(count2>=1) {
			System.out.println("Team has atleast one wicket-keeper");
		}else {
			System.out.println("Team doesn't have any wicket-keeper");
		}
	}
}
