package pageObjClasses;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InsertExcelFileData {

	
	public static void main(String[] args) {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Sheet1");
		
		Row row = null;
		Cell cell;
		
		String[] data =new String[] {"Veljko", "veljko", "Vule1234", "Vule1234", "3" };
		
		for(int i = 0; i < 30; i++) {
			
			row = sheet.createRow(i);
			
			for(int j = 0; j<5 ; j++) {
				
				cell = row.createCell(j);
				
				if (j==0) {
					cell.setCellValue(data[j] + ( 1 + i) );
				}
				else if (j==1) {
					cell.setCellValue(data[j] + (i + 1) + "@email.com");
				}
				else {
					cell.setCellValue(data[j]);
				}
			}
			
		}
		
		FileOutputStream st;
		
		try {
			st = new FileOutputStream("registar1.xlsx");
			try {
				wb.write(st);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				wb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
