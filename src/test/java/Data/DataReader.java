package Data;
import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

	
	public List<HashMap<String, String>> getJsonData() throws IOException {

	//	String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Data//config.json"));
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Data//config.json"),(StandardCharsets.UTF_8));
		//Convert String to hashmap using 'Jackson Databind' dependency
	//	ObjectMapper mapper = new ObjectMapper();
		//List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});

		return null;
	}
}
