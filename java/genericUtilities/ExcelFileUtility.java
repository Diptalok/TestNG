package genericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String readData(String sname, int row, int cell) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		return WorkbookFactory.create(fis).getSheet(sname).getRow(row).getCell(cell).getStringCellValue();
		
	}

}
