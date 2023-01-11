package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Xlutils
{

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static Workbook wb;
    public static Sheet ws;
    public static Row row;
    public static Cell cell;
    public static CellStyle style;
    public static int getRowCount(String xfile,String xlsheet) throws IOException
    {

        fi = new FileInputStream(xfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        int row = ws.getLastRowNum();
        wb.close();
        return row;
    }
    public static short getColumncount(String xfile,String xlsheet,int rownum) throws IOException
    {
        fi = new FileInputStream(xfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        short colcount = row.getLastCellNum();
        wb.close();
        return colcount;
    }
    public static String getCellStringData(String xfile,String xlsheet,int rownum,int column) throws IOException
    {
        fi = new FileInputStream(xfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);

        String data;
        try
        {
            cell = row.getCell(column);
            data = cell.getStringCellValue();
        }catch (Exception e)
        {
            data = "";
        }
        wb.close();
        return data;
    }
    public static double getNumericCelldata(String xfile,String xlsheet,int rownum,int column)throws IOException
    {
        fi = new FileInputStream(xfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        double data;
        try {
            cell = row.getCell(column);
            data = cell.getNumericCellValue();
        }catch (Exception e)
        {
            data = 0.0;
        }
        wb.close();
        return data;
    }
    public static boolean getBooleanCellData(String xfile,String xlsheet,int rownum,int column)throws IOException {
        fi = new FileInputStream(xfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);

        boolean data;
        try {
            cell = row.getCell(column);
            data = cell.getBooleanCellValue();
        } catch (Exception e) {
            data = false;
        }
        wb.close();
        return data;
    }

    public static void setCellData(String xfile,String xlsheet,int rownum,int column,String data)throws IOException
    {
        fi = new FileInputStream(xfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);

        cell = row.createCell(column);
        cell.setCellValue(data);

        fo = new FileOutputStream(xfile);
        wb.write(fo);
        wb.close();
    }

    public static void fillGreenColor(String xfile,String xlsheet,int rownum,int column) throws IOException
    {
        fi = new FileInputStream(xfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);
        cell = row.getCell(column);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        fo = new FileOutputStream(xfile);
        wb.write(fo);
        wb.close();

    }

    public static void fillRedColor(String xfile,String xlsheet,int rownum,int column)throws IOException
    {
        fi = new FileInputStream(xfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(rownum);

        cell = row.getCell(column);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        fo = new FileOutputStream(xfile);
        wb.write(fo);
        wb.close();


    }
}



