package AdvancedJava;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ComparingArrayList {
	static String EXCELPATH="G:\\tabish\\Selenium\\com.itl.practice\\src\\test\\resources\\Free+Paid_group.xlsx";
	public static WebDriver driver;
	//String expertList;
	static int cellNum=0;
	static int counter=0;
	@BeforeClass
	public void beforeTest() {
		System.out.println("Initilizing the Google Chrome Driver");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\tabish\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@BeforeMethod
		public void astroOpen() {
		driver.get("https://www.anytimeastro.com/chat-with-astrologer/?utm_source=ata_freechat");
	}
	
	@Test
	public void arrayListCompare_expertID() throws Throwable {
		Boolean result = checkList("DisplayName");
		 driver.findElements(By.xpath("//div[@class=\"psychic-card overflow-hidden 1  expertOnline h-100 offer-applicable \"]"));
		if(result==true) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test Failed");
		}
	}
	public static boolean checkList(String excelColumn) {
		ArrayList<String> expectedList = new ArrayList<String>();
		ArrayList<String> actualList = new ArrayList<>(Arrays.asList());
		boolean result =false;
		
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
		System.out.println(expectedList);
		wb.close();
		
		
		// on webpage................
    	driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class=\"psychic-card overflow-hidden 1  expertOnline h-100 offer-applicable \"]/descendant::a[@data-toggle=\"tooltip\"]"));
		for(WebElement ele:ls) {
	         String optionName = ele.getAttribute("title");
	         actualList.add(optionName);
			}
		System.out.println(actualList);
		}
		catch(Exception e) {
			e.printStackTrace();
	}
			for(int i=0; i<actualList.size(); i++) {
				if(expectedList.get(i).equals(actualList.get(i))) {
					continue;
				}
				else {
					System.out.println("Mismatch between options ==> "+ "\n"
				+ "Expected==> "+ expectedList.get(i) + "\n" 
				+ "Actual==> " + actualList.get(i));
					counter++;
				}
			}
			if(counter==0) {
				System.out.println("options are matching...");
				result=true;
			}
		else {
			System.out.println("Mismatching between elements..");
			result=false;
		}
		return result;
}
	}

