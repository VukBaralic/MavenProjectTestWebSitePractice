package pageObjClasses;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn {

	private static final String username = "USERNAME";
	private static final String password = "PASSWORD";
	private static final String logInBtn = "LogInBtn";
	private static final String logoutBTN = "ProfileBTN";
	private static final String incorectTXT = "IncorectLogInTXT1";
	private static final String incorectTXT2 = "IncorectLogInTXT2";
	
	
	public static String URL() {
		String adresa = "https://sandbox.2checkout.com/sandbox";
		
		return adresa;
	}

	public static void fillUpLogIn(WebDriver driver, Map<String, String> sPaths, String name, String pass) {

		driver.findElement(By.name(sPaths.get(username))).sendKeys(name);

		driver.findElement(By.id(sPaths.get(password))).sendKeys(pass);
	}

	public static void logInButon(WebDriver driver,Map<String, String> sPaths) {

		driver.findElement(By.xpath(sPaths.get(logInBtn))).click();
	}

	public static List<WebElement> checkLogIn(WebDriver driver,Map<String, String> sPaths) {
		
		List<WebElement> LogOutBTN = driver.findElements(By.id(sPaths.get(logoutBTN)));

		return LogOutBTN;		
	}
	
	public static String incorectLogIn(WebDriver driver,Map<String, String> sPaths) {
		
	String txt = driver.findElement(By.className(sPaths.get(incorectTXT))).findElement(By.tagName(sPaths.get(incorectTXT2))).getText();
		
		return txt;
		
	}
}
