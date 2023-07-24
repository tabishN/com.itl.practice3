package AdvancedJava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ComparinArray_usingRetainAll extends WebDriverUtility{
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
		checkList("DisplayName");
		
}
}

