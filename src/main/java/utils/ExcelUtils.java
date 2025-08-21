package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;

public class ExcelUtils {

    public static Object[][] getTestData(String fileName, String sheetName) {
        try {
            // Load Excel from resources
            InputStream inputStream = ExcelUtils.class.getClassLoader()
                    .getResourceAsStream("testdata/" + fileName);

            if (inputStream == null) {
                throw new RuntimeException("Excel file not found: " + fileName);
            }

            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

            System.out.println("Reading sheet: " + sheetName + 
                               " | Rows: " + rowCount + 
                               " | Cols: " + colCount);

            Object[][] data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = (cell == null) ? "" : cell.toString();
                }
            }

            workbook.close();
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read Excel data: " + e.getMessage());
        }
    }
}
