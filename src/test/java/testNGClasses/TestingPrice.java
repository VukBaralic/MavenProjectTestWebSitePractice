package testNGClasses;

import java.io.IOException;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjClasses.FileLocatorsSplit;
import pageObjClasses.LogIn;
import pageObjClasses.AddingNewPrice;

public class TestingPrice {
	
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Wolf\\eclipse-workspace\\ITBootCampMavenProject2\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(LogIn.URL());
		LogIn.fillUpLogIn(driver,FileLocatorsSplit.reader(), "Vukasin1" , "Vukasin123");
		LogIn.logInButon(driver, FileLocatorsSplit.reader());
		
	}
	
	@Test
	public void checkPrice() throws IOException {
		
		double addNewPrice = 100.0;
		
		AddingNewPrice.goToProductCard(driver, FileLocatorsSplit.reader());
		List<Double> cenaPrePovecanja = AddingNewPrice.getPrice(driver, FileLocatorsSplit.reader());
		for (int i = 0; i < cenaPrePovecanja.size(); i++) {     // uvecavamo sve clanove liste za 100
			cenaPrePovecanja.set(i, (cenaPrePovecanja.get(i) + addNewPrice));
		}
		System.out.println(cenaPrePovecanja);
		AddingNewPrice.goToEditCard(driver, FileLocatorsSplit.reader());
		
		AddingNewPrice.setPrice(driver, FileLocatorsSplit.reader(), addNewPrice);
		
		List<Double> cenaPoslePovecanja = AddingNewPrice.getPrice(driver, FileLocatorsSplit.reader());
		System.out.println(cenaPoslePovecanja);
		Assert.assertEquals(cenaPoslePovecanja, cenaPrePovecanja ); 
		}

	
	@AfterClass
	public void close() {
		driver.quit();
	}
}
