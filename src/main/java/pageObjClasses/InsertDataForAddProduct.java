package pageObjClasses;


import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InsertDataForAddProduct {

	public static void main(String[] args) throws IOException {
		
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("Sheet1");
		
		Row row = null;
		Cell cell;
		
		String[] data =new String[] {"Racunar", "R1", "New Product", "The product is not damaged", "199" };
		
		for(int i = 0; i < 5; i++) {
			
			row = sheet.createRow(i);
			
			for(int j = 0; j<5 ; j++) {
				
				cell = row.createCell(j);
				
				if (j==0) {
					cell.setCellValue(data[j] + ( 1 + i) );
				}
				else if (j==1) {
					cell.setCellValue(data[j] + (1 + i));
				}
				else {
					cell.setCellValue(data[j]);
				}
			}
			
		}
		FileOutputStream st;
		
		st = new FileOutputStream("AddProductData1.xlsx");
		wb.write(st);
		wb.close();

	}

}
