package Exceldata;

import java.io.File;

import base.Base;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel_class extends Base{

	 public static String folderpath ="C:\\Users\\shivani\\workspace\\ExcelData\\";

	 public static Workbook wb;
	 public static Sheet sh;
	 public static WritableWorkbook wwb;
	 public static WritableSheet wsh;
	 public static void excelconnection(String filename, String sheetname) {

	  File f=new File(folderpath+filename);
	  try {
	   wb=Workbook.getWorkbook(f);
	   sh=wb.getSheet(sheetname);
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  }
	 public static int rcount() {
	  int r=sh.getRows();
	  //System.out.println("rows"+i);
	  return r;

	 }
	 public static int ccount() {
	  int c = sh.getColumns();
	//  System.out.println("columns"+i);
	  return c;
	 }

	public static String readData(int col,int row)
	{
	 String c = sh.getCell(col, row).getContents();
	 return c;
	}
}
