package com.grokonez.convertexcel2json;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import com.fasterxml.jackson.databind.ObjectMapper;
 
public class ConvertExcel2Json {

  private static final String CONFIG_FILE = "/customers-1.xlsx";

  public static File readFileFromClasspath()
  {
    URL fileUrl = ConvertExcel2Json.class.getResource(CONFIG_FILE);
    return new File(fileUrl.getFile());
  }
  
  public static void main(String[] args) {
    // Step 1: Read Excel File into Java List Objects
    List<Customer> customers = readExcelFile(readFileFromClasspath());
    
      // Step 2: Write Java List Objects to JSON File
      writeObjects2JsonFile(customers, "customers.json");
      
      System.out.println("Done");
  }
  
  /**
   * Read Excel File into Java List Objects
   * 
   * @param filePath
   * @return
   */
  private static List<Customer> readExcelFile(File filePath){
    try {
      FileInputStream excelFile = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(excelFile);
     
        Sheet sheet = workbook.getSheet("Customers");
        Iterator<Row> rows = sheet.iterator();
        
        List<Customer> lstCustomers = new ArrayList<Customer>();
        
        int rowNumber = 0;
        while (rows.hasNext()) {
          Row currentRow = rows.next();
          
          // skip header
          if(rowNumber == 0) {
            rowNumber++;
            continue;
          }
          
          Iterator<Cell> cellsInRow = currentRow.iterator();
 
          Customer cust = new Customer();
          Info info = new Info();
          Tests tests = new Tests();
          List<Tests> testsList = new ArrayList<Tests>();

          int cellIndex = 0;
          int rowIndex = 0;
          while (cellsInRow.hasNext()) {
            Cell currentCell = cellsInRow.next();
            
            /*if(cellIndex==0) { // ID
              cust.setId(String.valueOf(currentCell.getNumericCellValue()));
            } else if(cellIndex==1) { // Name
              cust.setName(currentCell.getStringCellValue());
            } else if(cellIndex==2) { // Address
              cust.setAddress(currentCell.getStringCellValue());
            } else if(cellIndex==3) { // Age
              cust.setAge((int) currentCell.getNumericCellValue());
            } else*/
            if(cellIndex==0) { // Summary
              info.setSummary(currentCell.getStringCellValue());
            } else if(cellIndex==1) { // Wordings
              info.setWordings(currentCell.getStringCellValue());
            } else if(cellIndex==2) { // Lesson
              info.setLesson(currentCell.getStringCellValue());
            } else if(cellIndex==3) { // StartDay
              info.setStartDay(currentCell.getStringCellValue());
              tests.setStartDay(currentCell.getStringCellValue());
            } else if(cellIndex==4) { // EndDay
              info.setEndDay(currentCell.getStringCellValue());
              tests.setEndDay(currentCell.getStringCellValue());
            }
            cellIndex++;
          }
          testsList.add(tests);
          cust.setInfo(info);
          cust.setTests(testsList);
          lstCustomers.add(cust);
        }
        
        // Close WorkBook
        workbook.close();
        
        return lstCustomers;
        } catch (IOException e) {
          throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
  }
  
    /**
     * 
     * Convert Java Objects to JSON File
     * 
     * @param customers
     * @param pathFile
     */
    private static void writeObjects2JsonFile(List<Customer> customers, String pathFile) {
        ObjectMapper mapper = new ObjectMapper();
 
        File file = new File(pathFile);
        try {
            // Serialize Java object info JSON file.
            mapper.writeValue(file, customers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}