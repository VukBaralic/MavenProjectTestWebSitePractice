package testNGClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjClasses.AddNewProduct;
import pageObjClasses.FileLocatorsSplit;
import pageObjClasses.LogIn;

public class TestingAddNewProduct {
	
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
	public void checkNewProduct() throws IOException, InterruptedException {
		
		
		for (int i = 0; i<5 ; i++) {
			AddNewProduct.goToProductCard(driver, FileLocatorsSplit.reader());
			AddNewProduct.addNew(driver, FileLocatorsSplit.reader());
		
		AddNewProduct.fillUpForm( driver , FileLocatorsSplit.reader(), 
				AddNewProduct.getProductData(i, 0), // name
				AddNewProduct.getProductData(i, 1), // id
				AddNewProduct.getProductData(i, 2), // description
				AddNewProduct.getProductData(i, 3), // longDesc
				AddNewProduct.getProductData(i, 4)); // price
		
		AddNewProduct.submitNewProduct(driver, FileLocatorsSplit.reader());
		
		Thread.sleep(2000);
				
		Assert.assertTrue(AddNewProduct.we(driver).isDisplayed());
	
		}
		
		
	}
	@AfterClass
	public void offBrowser() {
		driver.close();
	}

}
