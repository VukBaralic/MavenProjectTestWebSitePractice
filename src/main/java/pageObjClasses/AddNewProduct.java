package pageObjClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewProduct {

	private static final String productCardBTN = "ProductCard";
	private static final String addNewBTN = "AddNewProductBtn";
	private static final String productName = "ProductInfoName";
	private static final String productID = "ProductInfoID";
	private static final String productDesc = "ProductInfoShortDescription";
	private static final String productLongDesc = "ProductInfoLongDescription";
	private static final String productPrice = "ProductInfoPrice";
	private static final String productSubmitBTN = "SaveChagesBtn";
	private static final String findAllProduct = "PriceEditField1";
	private static final String listOfAllProduct = "PriceEditField2";
	private static final String listOfProductInfo = "ProductIDAndNameProductField";

	public static void goToProductCard(WebDriver driver, Map<String, String> sPaths) {

		driver.findElement(By.id(sPaths.get(productCardBTN))).click();
	}

	public static void addNew(WebDriver driver, Map<String, String> sPaths) {

		driver.findElement(By.cssSelector(sPaths.get(addNewBTN))).click();

	}

	public static void fillUpForm(WebDriver driver, Map<String, String> sPaths, String name, String id, String des,
			String longdes, String price) {

		driver.findElement(By.name(sPaths.get(productName))).sendKeys(name);

		driver.findElement(By.name(sPaths.get(productID))).sendKeys(id);

		driver.findElement(By.name(sPaths.get(productDesc))).sendKeys(des);

		driver.findElement(By.name(sPaths.get(productLongDesc))).sendKeys(longdes);

		driver.findElement(By.name(sPaths.get(productPrice))).sendKeys(price);

	}

	public static void submitNewProduct(WebDriver driver, Map<String, String> sPaths) {

		driver.findElement(By.name(sPaths.get(productSubmitBTN))).click();

	}

	public static String getProductId(WebDriver driver, int j, Map<String, String> sPaths) {

		driver.findElement(By.id(sPaths.get(productCardBTN))).click();

		WebElement forma = driver.findElement(By.cssSelector(sPaths.get(findAllProduct))); // celo polje sa svim produktima
																							
		List<WebElement> lista = forma.findElements(By.cssSelector(sPaths.get(listOfAllProduct))); // lista od elemenata
																									// sa tr tagom, to su produkti
		
		WebElement firstProduct = lista.get(j); // element na poziciji 0, je prvi produkt

		List<WebElement> listaPolja = firstProduct.findElements(By.tagName(sPaths.get(listOfProductInfo))); // nova lista sa tagom td
																										// u okviru jednog produkta
																										
		String ProductID = listaPolja.get(4).getText(); // polje na poziciji 4-5 su polja produktID i Name,
															// vraca text tog polja u Stringu

		return ProductID;
	}
	
	public static WebElement we(WebDriver driver) {
		WebElement x = driver.findElement(By.cssSelector("span.form_valid.large"));
		return x;
		
	}
	
	public static String getProductData(int i, int j) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Wolf\\eclipse-workspace\\ITBootCampMavenProject2\\resources\\AddProductData1.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		return sheet.getRow(i).getCell(j).getStringCellValue();
		
	
}
}
