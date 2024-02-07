package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	
	static FileInputStream fileInputStream;
	static FileOutputStream fileOutputStream;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static CellStyle style;
	
	public static String readExcelData(String sheetName,int rowNumber,int cellNumber) throws IOException {
		fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\Excel\\TestDATA.xlsx");
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		cell = row.getCell(cellNumber);
		workbook.close();
		fileInputStream.close();
		return cell.toString();
	}
	public static void writeData(String sheetName,int rowNumber,int cellNumber,float data) throws IOException {
		fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\Excel\\TestDATA.xlsx");
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		if(sheet.getRow(rowNumber)==null) {
			row = sheet.createRow(rowNumber);
		}else {
			row = sheet.getRow(rowNumber);
		}
		
		//row = sheet.getRow(rowNumber);
		if(row.getCell(cellNumber)==null) {
			cell = row.createCell(cellNumber);
		}else {
			cell = row.getCell(cellNumber);
		}
		
		//cell = row.getCell(cellNumber);
		cell.setCellValue(data);
		fileOutputStream = new FileOutputStream(System.getProperty("user.dir")+"\\Excel\\TestDATA.xlsx");
		workbook.write(fileOutputStream);
		fileOutputStream.close();
	}
	public static int getRowNumber(String sheetName) throws IOException {
		fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\Excel\\TestDATA.xlsx");
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		int rowNumber = sheet.getPhysicalNumberOfRows();
		return rowNumber;
	}
	public static int getCellNumber(String sheetName) throws IOException {
		fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\Excel\\TestDATA.xlsx");
		workbook = new XSSFWorkbook(fileInputStream);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(1);
		int cellNumber = row.getLastCellNum();
		return cellNumber;
	}
	

}
