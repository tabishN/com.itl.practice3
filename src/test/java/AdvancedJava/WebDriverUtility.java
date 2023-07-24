package AdvancedJava;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtility {
	 String EXCELPATH="G:\\tabish\\Selenium\\com.itl.practice\\src\\test\\resources\\Free+Paid_group.xlsx";
	public WebDriver driver;
	 int cellNum=0;
	 int counter=0;
	 int cnt=0;
	
	public void checkList(String excelColumn) {
		ArrayList<String> expectedList = new ArrayList<String>();
		ArrayList<String> actualList = new ArrayList<>(Arrays.asList());
		
		try {
		File f= new File(EXCELPATH);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i=0; i< totalCells; i++) {
			String currentCellData = sheet.getRow(0).getCell(i).getStringCellValue();
			if(currentCellData.equals(excelColumn)) {
				cellNum=i;
				break;
			}
		}
		int totalRows = sheet.getPhysicalNumberOfRows();
		for(int j=1; j<totalRows; j++) {
			XSSFCell cell = sheet.getRow(j).getCell(cellNum);
			if(cell==null || cell.getCellType()==CellType.BLANK) {
				break;
			}
			String cellData = sheet.getRow(j).getCell(cellNum).getStringCellValue();
			expectedList.add(cellData);
			
		}
		System.out.println("Expected list(excel_list) :" + expectedList);
		System.out.println("Excel list size :" + expectedList.size());
		wb.close();
		
		
		// on webpage................
    	driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class=\"psychic-card overflow-hidden   expertOnline h-100 offer-applicable \"]/descendant::a[@data-toggle=\"tooltip\"]"));
		for(WebElement ele:ls) {
	         String optionName = ele.getAttribute("title");
	         actualList.add(optionName);
			}
		System.out.println("actual list :" + actualList);
		System.out.println("actual list on web size :" + actualList.size());
		}
		catch(Exception e) {
			e.printStackTrace();
	}
		expectedList.retainAll(actualList);
		System.out.println("Common expert in the list are :" + expectedList);
		for(int i=0; i<expectedList.size(); i++) {
			cnt++;
		}
		System.out.println("Total common expert size : " + cnt);
		// to remove common expert from the Expected list
		/*
		expectedList.removeAll(actualList);
		System.out.println("Expected list after remove:" + expectedList);
		System.out.println("Excel list size :" + expectedList.size());
		for(int i=0; i<expectedList.size(); i++) {
			cnt++;
		}
		System.out.println("Common expert in the list are : " + cnt);
		*/
}
	

}
