package MMP_MainPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAPatientAccount {
	 static WebDriver driver;

	 public static void main(String[] args) {
	 //open the firefox browser
//	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bharti\\Downloads\\geckodriver-v0.11.1-win64\\geckodriver.exe");
//	 driver = new FirefoxDriver();
//	 System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
		//	driver = new InternetExplorerDriver();
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver = new ChromeDriver();
			
	     //open the url
	  driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
	  //click on "Patient Login" link on the home page and then click on the "Register" link
	  //driver.findElement(By.linkText("Patient Login")).click();
	  WebElement register= driver.findElement(By.linkText("Register"));
	  System.out.println(register.getText());
	  register.click();
	  //wait for the registration page to open
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  //fill the Registration page with the personal details
	  driver.findElement(By.id("firstname")).sendKeys("Mark");
	  driver.findElement(By.id("lastname")).sendKeys("Jr");
	  driver.findElement(By.id("datepicker")).sendKeys("01-01-1990");
	  driver.findElement(By.id("license")).sendKeys("12345678");
	  driver.findElement(By.id("ssn")).sendKeys("987-65-4321");
	  driver.findElement(By.id("state")).sendKeys("Texas");
	  driver.findElement(By.id("city")).sendKeys("Frisco");
	  driver.findElement(By.id("address")).sendKeys("123 Anywhere Street");
	  driver.findElement(By.id("zipcode")).sendKeys("75035");
	  driver.findElement(By.id("age")).sendKeys("26");
	  driver.findElement(By.id("height")).sendKeys("160.60");
	  driver.findElement(By.id("weight")).sendKeys("150");
	  driver.findElement(By.id("pharmacy")).sendKeys("CVS");
	  driver.findElement(By.id("pharma_adress")).sendKeys("123 anywhere street");
	  
	  //select one question from security question drop down
	  Select select = new Select (driver.findElement(By.id("security")));
	  select.selectByVisibleText("what is your pet name");
	  
	  //fill the rest of the registration form
	  driver.findElement(By.id("answer")).sendKeys("mypet");  
	  driver.findElement(By.id("username")).sendKeys("Mark Jr");
	  driver.findElement(By.id("password")).sendKeys("Markjr123");
	  driver.findElement(By.id("confirmpassword")).sendKeys("Markjr123");
	  driver.findElement(By.xpath(".//*[@name='register']")).click();
	  
	  
	  //check that javaScript is throwing error when no email is provided
	  String ExpectedjsErrorMsgForEmail = driver.findElement(By.id("eerr")).getText();
	  System.out.println(ExpectedjsErrorMsgForEmail);
	  if(ExpectedjsErrorMsgForEmail.equals("please enter valid E-mail")){
	   System.out.println("testcase pass");
	  }
	  else
	  {
	   System.out.println("testcase fail");
	  }
	 
	 }
	 

	}