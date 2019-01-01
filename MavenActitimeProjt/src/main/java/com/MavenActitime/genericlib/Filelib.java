package com.MavenActitime.genericlib;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Filelib {
String Excelpath="D:\\Automation\\MavenActitimeProjt\\src\\test\\resources\\testdata.xlsx";
public String getexceldata(String sheetname,int rownum,int colnum) throws Throwable
{
FileInputStream fis=new FileInputStream(Excelpath);
Workbook wb=WorkbookFactory.create(fis);
Sheet sh=wb.getSheet(sheetname);
Row rw=sh.getRow(rownum);
String data=rw.getCell(colnum).getStringCellValue();
wb.close();
return data;
}
public void setexceldata(String sheetname,int rownum,int colnum,String data) throws Throwable
{
FileInputStream fis=new FileInputStream(Excelpath);
Workbook wb=WorkbookFactory.create(fis);
Sheet sh=wb.getSheet(sheetname);
Row rw=sh.getRow(rownum);
Cell cl=rw.createCell(colnum);
cl.setCellValue(data);

FileOutputStream fos=new FileOutputStream(Excelpath);
wb.write(fos);
wb.close();
}
public Properties getpropertyobject() throws Throwable
{
FileInputStream fobj=new FileInputStream("D:\\Automation\\MavenActitimeProjt\\src\\test\\resources\\commondata.properties");
Properties pobj=new Properties();
pobj.load(fobj);
return pobj;

}
}
