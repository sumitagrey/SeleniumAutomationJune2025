package Data;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class HashMapData {
	 @DataProvider(name = "testDataWithHashMap")
     public static Object[][] provideTestData() {
		 HashMap<String, String> data1 = new HashMap<>();
         data1.put("email", "vigupta.kws@gmail.com");
         data1.put("password", "P@ssw0rd@94");

         HashMap<String, String> data2 = new HashMap<>();
         data2.put("email", "sumitag@gmail.com");
         data2.put("password", "Password1");

         return new Object[][] {
             { "Test Case A", data1 },
             { "Test Case B", data2 }
         };
}
}