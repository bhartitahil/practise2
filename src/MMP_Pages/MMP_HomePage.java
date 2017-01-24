package MMP_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MMP_HomePage {

	WebDriver driver;

	public MMP_HomePage(WebDriver driver) {

		this.driver = driver;
		if(!"Home".equals(driver.getTitle()))
		{
			throw new IllegalStateException("Not on the Home Page");
		}
	}

	public RegisterPatientPage RegisterPatient() {

		 driver.findElement(By.linkText("Patient Login")).click();
		    driver.findElement(By.linkText("Register")).sendKeys(Keys.ENTER);

		return new RegisterPatientPage(driver);
	}
	public PatientLoginPage PatientLogin() {

		 driver.findElement(By.xpath(".//*[@id='navigation']/li[2]/a")).click();
		 Actions action= new Actions(driver);
		   WebElement login= driver.findElement(By.linkText("Login"));
		   action.moveToElement(login);
		  login.sendKeys(Keys.ENTER);		    

		return new PatientLoginPage(driver);
	}
	
	public AdminLoginPage AdminLogin()
	{
		driver.findElement(By.linkText("Office Login")).click();
	    driver.findElement(By.cssSelector("#welcome > div.row > div.col-md-4.col-sm-6 > a.button")).click();
		return new AdminLoginPage(driver);
	}

}
