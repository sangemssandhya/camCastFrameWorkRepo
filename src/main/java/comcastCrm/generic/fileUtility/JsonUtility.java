package comcastCrm.generic.fileUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String getDataFromJsonFile(String Key) throws Throwable
	{
		FileReader file=new FileReader("./Externalresource/AppCommonData.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(file);
		JSONObject map=(JSONObject)obj;
		String data=(String) map.get(Key);
		return data;
		
		
	}

}
