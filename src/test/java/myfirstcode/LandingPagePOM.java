package myfirstcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPagePOM {

	WebDriver driver;
	
	public LandingPagePOM(WebDriver driver) {
		this.driver=driver;
	}
	 //	WebElement uname=driver.findElement(By.id("userEmail"));
	 
	 	@FindBy(id="userEmail")
	 	WebElement userEmail;
	 	
	 	
	 public void getLoginDetails() {
		 
	 }
	 	
}
