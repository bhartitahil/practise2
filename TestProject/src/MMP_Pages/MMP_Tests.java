package MMP_Pages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import MMP_Pages.PatientLoginPage;
import MMP_Pages.RegisterPatientPage;

import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MMP_Tests {

	WebDriver driver;

	MMP_HomePage hPage;
	PatientLoginPage lPage;
	RegisterPatientPage rPage;
	AdminLoginPage aPage;
	DoctorLoginPage dPAge;

	
	@Parameters({ "url", "browserType" })
	@BeforeClass
	public void setUp(String url, String browserType) {
		if (browserType.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Bharti\\Desktop\\selenium Sudheer\\geckodriver-v0.11.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserType.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(url);

	}

	@Parameters({ "PateintUserName", "PatientPasswrod" })
	@Test
	public void VerifyPatientLogin(String PateintUserName, String PatientPasswrod) 
	{
		hPage = new MMP_HomePage(driver);
		lPage = hPage.PatientLogin();

		boolean result=lPage.PatientLogin(PateintUserName, PatientPasswrod);
		
		AssertJUnit.assertTrue(result);

	}
	
	@Parameters({ "AdminUserName", "AdminPasswrod" })
	@Test
	public void VerifyAdminLogin(String AdminUserName, String AdminPasswrod) 
	{
		hPage = new MMP_HomePage(driver);
		aPage = hPage.AdminLogin();
		
		boolean result=aPage.AdminLogin(AdminUserName, AdminPasswrod);
		
		AssertJUnit.assertTrue(result);
	}

	/*
	 * @Test public void VerifyRegisterPatient() {
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Test public void VerifyDoctorLogin() {
	 * 
	 * }
	 */
	@AfterClass
	public void closeBrowser() {
		driver.quit();

	}
}
