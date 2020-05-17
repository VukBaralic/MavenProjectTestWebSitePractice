package pageObjClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileLocatorsSplit {

	public static Map<String, String> reader() {
		
		Map<String, String> paths = new HashMap<>();
		File locators = new File("C:\\Users\\Wolf\\eclipse-workspace\\ProjekatOjacavanje\\src\\pageObjClasses\\realPaths");
		Scanner sc;
		
		try {
		sc = new Scanner(locators);
		
		while (sc.hasNextLine()) {
			String data = sc.nextLine();
			
			String values[] = data.split("`");
			
			paths.put(values[0], values[1]);
		}
		sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("greska");
			e.printStackTrace();
		}
		return paths;
	}
	
}
