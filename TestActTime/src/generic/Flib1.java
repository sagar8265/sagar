
package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {
	//generic reusable method to read the excel data
			public String readExcelData(String excelPath, String sheetName, int rowCount, int cellCount) throws EncryptedDocumentException, IOException
			{
				FileInputStream fis = new FileInputStream(excelPath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheetName);
				Row row = sh.getRow(rowCount);	
				Cell cell = row.getCell(cellCount);
				String value = cell.getStringCellValue();
				return value; 		 	        		
			}

			//generic reusable method to read the property data
			public String readPropertyData(String propPath,String key) throws IOException
			{
				FileInputStream fis = new FileInputStream(propPath);
				Properties prop = new Properties();
				prop.load(fis);
				String value = prop.getProperty(key);
				return value;
			}

			//generic reusable method to write the data in the excel file
			public void writeExcelData(String excelPath, String sheetName, int rowCount, int cellCount,String data) throws EncryptedDocumentException, IOException
			{
				FileInputStream fis = new FileInputStream(excelPath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheetName);
				Row row = sh.getRow(rowCount);	

				Cell cell = row.createCell(cellCount);
				cell.setCellValue(data);

				FileOutputStream fos = new FileOutputStream(excelPath);
				wb.write(fos);
				wb.close();


			}

			//generic reusable method to get the row count
			public int getRowCount(String excelPath, String sheetName) throws EncryptedDocumentException, IOException
			{
				FileInputStream fis = new FileInputStream(excelPath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheetName);
				int rc = sh.getLastRowNum();
				return rc;
			}	
		

}

public class Flib1 {

}
