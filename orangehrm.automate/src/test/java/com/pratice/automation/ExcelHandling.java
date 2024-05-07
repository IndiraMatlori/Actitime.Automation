package com.pratice.automation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelHandling {
    public static void main(String[]arg) throws Exception{
        //to access the file
        FileInputStream inputStream=new FileInputStream("C:\\TestData.xlsx");
       //to access the work
        Workbook workbook=new XSSFWorkbook(inputStream);
        //to access the 0th index sheet
          Sheet sheet =workbook.getSheetAt(0);
          // to get total no of rows
       int totalRows= sheet.getPhysicalNumberOfRows();
       System.out.println("total no of rows" + totalRows);
       //to get total no of columns
        Row row;
                row= sheet.getRow(0);
        int totalnoofcolumn=row.getPhysicalNumberOfCells();
        System.out.println("total no of columns" +totalnoofcolumn);

        //Object[][] data= new Object[totalRows-1][totalnoofcolumn];

        for(int i=0; i<totalRows; i++) {
            //get the access to each row based og the value of i
            row = sheet.getRow(i);

            for (int j = 0; j < totalnoofcolumn; j++) {
                //get the access to column based of value of j
                Cell cell = row.getCell(j);
              /*  Object var=null;
                if(cell.getCellType()!=null){
                    switch (cell.getCellType()){
                        case STRING :
                            var =cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            var=cell.getNumericCellValue();
                            break;
                        case BLANK:
                            break;
                        case BOOLEAN:
                            var=cell.getBooleanCellValue();
                            break;*/
                String var = cell.getStringCellValue();
                System.out.println(var+" "+ var);
            }
            //  data[i-1][j]=var;
            System.out.println();
        }
        workbook.close();
        inputStream.close();
    }

}
