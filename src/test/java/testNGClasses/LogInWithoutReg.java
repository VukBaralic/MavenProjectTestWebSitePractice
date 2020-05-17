package testNGClasses;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjClasses.FileLocatorsSplit;
import pageObjClasses.LogIn;

public class LogInWithoutReg {

	WebDriver driver;
	

	@BeforeClass
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Wolf\\eclipse-workspace\\ITBootCampMavenProject2\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@Test
	public void testLogIn() {
		driver.get(LogIn.URL());
		LogIn.fillUpLogIn(driver,FileLocatorsSplit.reader(), "Vukasin1" , "Vukasin123");
		LogIn.logInButon(driver, FileLocatorsSplit.reader());

		Assert.assertNotEquals(LogIn.checkLogIn(driver, FileLocatorsSplit.reader()).size(), 0);
	}
	
	@Test
	public void testLogInWithoutRegistration() {
		
		driver.get(LogIn.URL());
		LogIn.fillUpLogIn(driver,FileLocatorsSplit.reader(), "Vukasin1" , "Vukasin123");
		LogIn.logInButon(driver, FileLocatorsSplit.reader());
		
		Assert.assertEquals(LogIn.incorectLogIn(driver, FileLocatorsSplit.reader()), "Incorrect username or password.");
		
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}

}
