package MMP_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {

	static WebDriver driver;

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public boolean AdminLogin(String AdminUserName, String AdminPassword) {
		 
		
		    driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys(AdminUserName);
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys(AdminPassword);
		    driver.findElement(By.name("admin")).click();
		    
		    return true;

	}
}
