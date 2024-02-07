
package utilities;
 
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.util.List;
 
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelUtilities {

	public void createRows(List<String> a, List<String> b, List<String> c, List<String> d, List<String> e,List<String> f, List<String> g) throws IOException {

		int max = Math.max(a.size(), Math.max(b.size(), Math.max(c.size(), Math.max(d.size(), Math.max(e.size(), f.size())))));

		String path = System.getProperty("user.dir")+"\\testData\\Abhishek_SampleExcel.xlsx";

		FileOutputStream flData = new FileOutputStream(path);

		XSSFWorkbook dataBook = new XSSFWorkbook();

		XSSFSheet sheet1 = dataBook.createSheet("sheet1");

		for(int i=0;i<max;i++) {

			sheet1.createRow(i);

		}

		dataBook.write(flData);

		dataBook.close();

		flData.close();

	}	

	public void collectHeadersInfo(List<String> cT, List<String> slT, List<String> srT, List<String> mcT, List<String> cFT,List<String> pT, List<String> kET) throws IOException {

		String path = System.getProperty("user.dir")+"\\testData\\Abhishek_SampleExcel.xlsx";

		FileInputStream flData = new FileInputStream(path);

		XSSFWorkbook dataBook = new XSSFWorkbook(flData);

		XSSFSheet sheet1 = dataBook.getSheet("sheet1");

//		XSSFRow row1 = sheet1.createRow(0);

//		XSSFCell cell1 = row1.createCell(0);

		//XSSFRow row2 = sheet1.createRow(1);

		for(int i=0;i<cT.size();i++) {

			XSSFRow row2 = sheet1.getRow(i);

			XSSFCell cell = row2.createCell(0);

			if (i==0) {

				cell.setCellValue("Company");

			}else {

				cell.setCellValue(cT.get(i));

			}

		}

		for(int i=0;i<slT.size();i++) {

			XSSFRow row2 = sheet1.getRow(i);

			XSSFCell cell = row2.createCell(1);

			if (i==0) {

				cell.setCellValue("Service Line");

			}else {

				cell.setCellValue(slT.get(i));

			}

		}

		for(int i=0;i<srT.size();i++) {

			XSSFRow row2 = sheet1.getRow(i);

			XSSFCell cell = row2.createCell(2);

			if (i==0) {

				cell.setCellValue("Sale Resources");

			}else {

				cell.setCellValue(srT.get(i));

			}

		}

		for(int i=0;i<mcT.size();i++) {

			XSSFRow row2 = sheet1.getRow(i);

			XSSFCell cell = row2.createCell(3);

			if (i==0) {

				cell.setCellValue("Market and Countries");

			}else {

				cell.setCellValue(mcT.get(i));

			}

		}

		for(int i=0;i<cFT.size();i++) {

			XSSFRow row2 = sheet1.getRow(i);

			XSSFCell cell = row2.createCell(4);

			if (i==0) {

				cell.setCellValue("Corporate Functions");

			}else {

				cell.setCellValue(cFT.get(i));

			}

		}

		for(int i=0;i<pT.size();i++) {

			XSSFRow row2 = sheet1.getRow(i);

			XSSFCell cell = row2.createCell(5);

			if (i==0) {

				cell.setCellValue("People");

			}else {

				cell.setCellValue(pT.get(i));

			}

		}

		for(int i=0;i<kET.size();i++) 
		{

			XSSFRow row2 = sheet1.getRow(i);

			XSSFCell cell = row2.createCell(6);

			if (i==0) 
			{

				cell.setCellValue("Key Ethics and Compliance");

			}
			
			else
			
			{

				cell.setCellValue(kET.get(i));

			}

		}

		FileOutputStream flData1 = new FileOutputStream(path);

		dataBook.write(flData1);

		dataBook.close();

		flData.close();

		flData1.close();

		}


}

