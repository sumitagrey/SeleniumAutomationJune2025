package myfirstcode;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class submitOrder {
   	@Test(dataProvider="getData")
	//@Test
	public void submitOrderTest(HashMap<String, String> data) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");
        String email=data.get("email");
        String password=data.get("password");
        
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("userPassword")).sendKeys(email);
        driver.findElement(By.id("login")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<String> targetProducts = Arrays.asList("ZARA COAT 3", "Another Product Name", "Yet Another Product");
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        // Loop through the target products and add them to the cart
        targetProducts.forEach(targetProduct -> {
            WebElement product = products.stream()
                    .filter(p -> p.findElement(By.cssSelector("b")).getText().equals(targetProduct))
                   .findFirst().orElse(null);
            if (product != null) {
                product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[class*='ng-animating']"))));
               wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div[class*='ngx-spinner-overlay']"))));
            }
        });
        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

    }

   	@Test(dataProvider="getData")
	public void values(HashMap<String, String> data) {
		String uname=data.get("email");
		System.out.print("Email from hash map-->"+uname);
	}
	
	
	@DataProvider
	public String [][] getData() {
 		
		//HashMap<Object,Object> hm= new HashMap<Object,Object>();
		HashMap<String,String> hm= new HashMap<String,String>();
		hm.put("email", "vigupta.kws@gmail.com");
		hm.put("password","P@ssw0rd@94");
		
 		return new String[][] {{"vigupta.kws@gmail.com","P@ssw0rd@94"}};
	} 
}
