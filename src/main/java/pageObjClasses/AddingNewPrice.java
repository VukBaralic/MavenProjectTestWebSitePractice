package pageObjClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddingNewPrice {
	
	private static final String productCardBTN = "ProductCard";
	private static final String editCard = "EditCard";
	private static final String viewCard = "ViewCard";
	private static final String findAllProduct = "PriceEditField1";
	private static final String listOfAllProduct = "PriceEditField2";
	private static final String priceValueString = "PriceEditField3";
	private static final String listOfProductInfo = "ProductIDAndNameProductField";


	public static void goToProductCard(WebDriver driver, Map<String, String> sPaths) {
 
		driver.findElement(By.id(sPaths.get(productCardBTN))).click();
	}

	public static void goToEditCard(WebDriver driver, Map<String, String> sPaths) {

		driver.findElement(By.xpath(sPaths.get(editCard))).click();
	}

	public static void setPrice(WebDriver driver, Map<String, String> sPaths, double x)  {
		
		
		WebElement forma = driver.findElement(By.cssSelector(sPaths.get(findAllProduct))); // (nadjeno polje svih produkta)

		List<WebElement> lista = forma.findElements(By.cssSelector(sPaths.get(listOfAllProduct))); // lista svih produkta

		for (int i = 0; i < lista.size(); i++) {
			WebElement firstProduct = lista.get(i); // pronalazenje pojedinacno produkta po indexima
			
			List<WebElement> listaPolja = firstProduct.findElements(By.tagName(sPaths.get(listOfProductInfo))); // nova lista sa tagom td
			// u okviru jednog produkta
			
			String ProductName = listaPolja.get(4).getText(); // polje na poziciji 5 su polja Name,
			// vraca text tog polja u Stringu
			
			if (ProductName.contains("Racunar")) {
						
			// dobijanje vrednosti cene u Stringu
			String priceValue = firstProduct.findElement(By.cssSelector(sPaths.get(priceValueString))).getAttribute("value");

			double newPrice = Double.parseDouble(priceValue); // menjanje u double

			newPrice = newPrice + x;
			String newStringPrice = String.valueOf(newPrice); // menjanje u String

			firstProduct.findElement(By.cssSelector(sPaths.get(priceValueString))).clear(); // brisanje polja
			firstProduct.findElement(By.cssSelector(sPaths.get(priceValueString))).sendKeys(newStringPrice); // upisivanje
			}																							// nove cene
		}

		forma.submit();

	}

	public static List<Double> getPrice(WebDriver driver, Map<String, String> sPaths) {

		List<Double> niz = new ArrayList<Double>();

		driver.findElement(By.xpath(sPaths.get(viewCard))).click();

		WebElement forma = driver.findElement(By.cssSelector(sPaths.get(findAllProduct)));

		List<WebElement> lista = forma.findElements(By.cssSelector(sPaths.get(listOfAllProduct)));
		
		for (int i = 0; i < lista.size(); i++) {
			
			WebElement firstProduct = lista.get(i);
			
			List<WebElement> listaPolja = firstProduct.findElements(By.tagName(sPaths.get(listOfProductInfo)));
			
			String ProductName = listaPolja.get(5).getText();
			
			if(ProductName.contains("Racunar")) {
				
			String checkPrice = listaPolja.get(6).getText();
			
			double newPrice = Double.parseDouble(checkPrice);
			
			niz.add(newPrice);
			}
		}

		return niz;
	}

}
