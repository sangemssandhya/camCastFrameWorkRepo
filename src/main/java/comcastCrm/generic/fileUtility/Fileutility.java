package comcastCrm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Fileutility {
	public String getDataFromPropertiesFile(String key) throws Throwable
	{
		FileInputStream fis= new FileInputStream("./Externalresource/commonDATA.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String data=pObj.getProperty(key);
		
		return data;
	}

}
