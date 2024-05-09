package com.pratice.automation;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

    public class testNg {

        @DataProvider(name = "browsers")
        public static Object[][] browsers() {
            return new Object[][]{
                    {"Chrome"},
                    {"Firefox"},
                    //{"Safari"},
            };
        }

        @DataProvider(name = "resolutions")
        public static Object[][] resolutions() throws IOException {
            List<String> resolutions = new ArrayList<>();
            Workbook workbook = new XSSFWorkbook(new FileInputStream("https://www.getcalley.com/page-sitemap.xml"));
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    String resolution = cell.getStringCellValue();
                    resolutions.add(resolution);
                }
            }
            workbook.close();

            Object[][] result = new Object[resolutions.size()][];
            for (int i = 0; i < resolutions.size(); i++) {
                result[i] = new Object[]{resolutions.get(i)};
            }

            return result;
        }

        @DataProvider(name = "urls")
        public static Object[][] urls() throws IOException {
            List<String> urls = new ArrayList<>();
            Workbook workbook = new XSSFWorkbook(new FileInputStream("sitemap.xlsx"));
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    String url = cell.getStringCellValue();
                    urls.add(url);
                }
            }
            workbook.close();

            Object[][] result = new Object[urls.size()][];
            for (int i = 0; i < urls.size(); i++) {
                result[i] = new Object[]{urls.get(i)};
            }

            return result;
        }

        @Test(dataProvider = "browsers")
        public void takeScreenshots(String browserName) throws IOException {
            // Define resolutions
            List<String> resolutions = new ArrayList<>();
            Workbook workbook = new XSSFWorkbook(new FileInputStream("https://www.getcalley.com/page-sitemap.xml"));
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    String resolution = cell.getStringCellValue();
                    resolutions.add(resolution);
                }
            }
            workbook.close();
        }
    }



