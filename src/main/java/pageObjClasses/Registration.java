package pageObjClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {

	public static String URL = "https://sandbox.2checkout.com/sandbox";

	public static void goToRegistrationPage(WebDriver driver) {

		driver.findElement(By.cssSelector("a[tabindex='5']")).click();

	}

	public static void fillUpRegistration(WebDriver driver) {

		driver.findElement(By.id("username")).sendKeys("Markoo");

		driver.findElement(By.id("email")).sendKeys("marko@email.com");

		driver.findElement(By.id("password")).sendKeys("Vukasin123");

		driver.findElement(By.id("confirm")).sendKeys("Vukasin123");

		WebElement padajucaLista = driver.findElement(By.id("aboutyou")); // pronalazenje padajuce liste i klik na nju
		padajucaLista.click();

		// pronalazenje liste Webelemenata sa tagom option
		List<WebElement> options = padajucaLista.findElements(By.tagName("option"));

		options.get(3).click(); // klik na 3. opciju "I don't have website"

	}

	public static void regButton(WebDriver driver) {
		driver.findElement(By.xpath("//input[@name='submit-button']")).click();
	}

}
