package TestPages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellDataSheet {

	public static void main(String[] args) throws IOException {
		
		//Excel File --->WorkBook---->sheet--->Rows---->Cells
		
		String path = "C:\\Users\\ASUS\\Downloads\\TestData.xlsx";
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
//		String data = sheet.getRow(0).getCell(0).getStringCellValue();
//		System.out.println(data);
		 
		int tRows = sheet.getLastRowNum();   
		
		int tCells = sheet.getRow(0).getLastCellNum();
		
		System.out.println("no of rows:"+tRows);  //2  rows are counting from 0
		System.out.println("no of cells:"+tCells); //5 cells are counting from 1(In Excel)
		
		for(int r=0;r<=tRows;r++)  //rows
		{ 
			XSSFRow rows = sheet.getRow(r);
			
			for(int c=0;c<tCells;c++) //cells
			{
				XSSFCell cells = rows.getCell(c);
				System.out.print(cells.toString()+"\t"); 
			}
			System.out.println();
		} 
		workbook.close();
	file.close();
		
		}
		
		
	}


