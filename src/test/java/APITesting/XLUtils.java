package APITesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FilterOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int row =ws.getLastRowNum();
		wb.close();
		fi.close();
		return row;
				
	}
	
	public static int getCellCount(String xlfile, String xlsheet,int rownum) throws IOException{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellCount  = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
				
	}

	
	

}
