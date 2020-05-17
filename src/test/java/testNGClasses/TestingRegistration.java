package testNGClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjClasses.FileLocatorsSplit;
import pageObjClasses.LogIn;
import pageObjClasses.Registration;

public class TestingRegistration {
	
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Wolf\\eclipse-workspace\\ITBootCampMavenProject2\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void checkRegistrationUser() {
		driver.get(Registration.URL);
		
		Registration.goToRegistrationPage(driver);
		Registration.fillUpRegistration(driver);
		Registration.regButton(driver);
		
		Assert.assertNotEquals(LogIn.checkLogIn(driver, FileLocatorsSplit.reader()), 0);
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}

}
