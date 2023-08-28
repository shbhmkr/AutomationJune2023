package genericUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilData {
	
	public String fetchDataFromExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\SHUBHAM\\eclipse-Automation\\Automation\\TestData\\Exceldata.xlsx");
		return WorkbookFactory.create(fis).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
	}

}
