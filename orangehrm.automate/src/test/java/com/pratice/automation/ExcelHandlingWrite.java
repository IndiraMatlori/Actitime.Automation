package com.pratice.automation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelHandlingWrite {
    File file;
    @Test
    public void WriteData() throws Exception {
        //Acess the file
         file = new File("C:\\TestData.xlsx");
        //find the Extension file
        String extension = file.getName().substring(file.getName().indexOf(".") + 1);
        //crete an instance of fileinputstream
        FileInputStream inputStreamnput = new FileInputStream(file);
        //based on the extension file Create object Wrokbook class
        Workbook workbook;
        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(inputStreamnput);
        } else {
            workbook = new HSSFWorkbook(inputStreamnput);
        }
        //if sheet name selenium alredy exsit then use at it is if not present then crete new sheet
        Sheet sheet;
        if (workbook.getSheet("Selenium1") != null) {
            sheet = workbook.getSheet("Selenium1");
        } else {
            sheet = workbook.createSheet("Selenium1");
        }
        //create new rows using sheet reference
        for (int i = 0; i < 10; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 2; j++) {
                Cell cell = row.createCell(j);
            if(j==0) {
                cell.setCellValue("ReadFile"+i);//i is the row num
            }
            else {
                cell.setCellValue("WriteinFile"+i);//i is the row num
            }
            }
        }
       // write the data in the file
        FileOutputStream outputStream=new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("Date written successfully..!");
    }



}


