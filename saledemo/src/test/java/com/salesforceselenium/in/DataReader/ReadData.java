package com.salesforceselenium.in.DataReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadData {

    String filename ="/Users/prathameshpatil/Desktop/Test folder/JavaSelenium/saledemo/templates/Book1.xlsx";
    String sheetname ="Data";

    public void excelRead(){
        try (FileInputStream fis = new FileInputStream(filename);
             Workbook workbook = WorkbookFactory.create(fis)) {

            // Assuming you're reading data from the first sheet (index 0)
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through rows
            for (Row row : sheet) {
                // Iterate through cells in each row
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case BLANK:
                            System.out.print("[BLANK]\t");
                            break;
                        default:
                            System.out.print("[UNKNOWN]\t");
                    }
                }
                System.out.println(); // Move to the next line after each row
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<List<String>> readExcelData(String filePath, String sheetName) {
        List<List<String>> data = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet(sheetName); 

            // Iterate over rows
            for (Row row : sheet) {
                List<String> rowData = new ArrayList<>();
                // Iterate over cells
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            rowData.add(Double.toString(cell.getNumericCellValue()));
                            break;
                        case BOOLEAN:
                            rowData.add(Boolean.toString(cell.getBooleanCellValue()));
                            break;
                        default:
                            rowData.add("");
                    }
                }
                data.add(rowData);
            }

            workbook.close(); // Close workbook
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static void processData(List<List<String>> data) {
        // Example: Print out the data
        for (List<String> rowData : data) {
            for (String cellData : rowData) {
                System.out.print(cellData + "\t");
            }
            System.out.println();
        }

        
    }


}
