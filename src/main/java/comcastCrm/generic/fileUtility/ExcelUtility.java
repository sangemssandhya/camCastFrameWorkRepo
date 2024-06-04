package comcastCrm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream("./Externalresource/CRMproject.xlsx");
		 Workbook wb=WorkbookFactory.create(fis);
		 String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		 wb.close();
		 return data;
		 
		
	}
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis =new FileInputStream("./Externalresource/CRMproject.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		int lastRow=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return lastRow;
		
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream("./Externalresource/CRMproject.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos=new FileOutputStream("./Externalresource/CRMproject.xlsx");
		wb.write(fos);
		wb.close();
		
		
	}
	
}