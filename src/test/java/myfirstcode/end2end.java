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

public class end2end {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("vigupta.kws@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("P@ssw0rd@94");
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

//}
	/*	//WebDriverManager.chromeDriver().setUp();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("sumitag@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Password1");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		//List<WebElement> itemList=driver.findElements(By.xpath("//div[@class='container']/div[2]"));
				System.out.println("After list");
	/*	WebElement pl=	product.stream().filter(s-> s
				.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("ZARA COAT 3"))
				.findFirst().orElse(null);
			pl.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
			WebElement prod = products.stream()
				    .filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3"))
				    .findFirst()
				    .orElseThrow(() -> new RuntimeException("Product not found"));
				prod.findElement(By.cssSelector("button:last-of-type")).click();	
		
		
		/*	for(int i=0;i<itemList.size();i++) {
			String itemName=itemList.get(i).getText();
			System.out.println(itemName);
			if(itemName.equalsIgnoreCase("ZARA COAT 3")) {
				System.out.println("inside ZARA COAT 3");
				driver.findElements(By.xpath("//div[@class='card-body']/button")).get(i).click();
			}
		}*/
		
//	}

}
