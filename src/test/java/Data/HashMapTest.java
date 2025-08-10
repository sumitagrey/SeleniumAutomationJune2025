package Data;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class HashMapTest {
	/*It is using HashMapData*/
	
	@Test(dataProvider = "testDataWithHashMap", dataProviderClass = HashMapData.class)
    public void testMethod(String testCaseName, HashMap<String, String> userData) {
        System.out.println("Running Test Case: " + testCaseName);
        String email = userData.get("email");
        String password = userData.get("password");
        System.out.println("email: " + email);
        System.out.println("Password: " + password);

        // You can now use 'username' and 'password' in your test logic
        // For example, passing them to another method:
        processUserData(email, password);
    }

    public void processUserData(String user, String pass) {
        System.out.println("Processing user data for: " + user);
}}
