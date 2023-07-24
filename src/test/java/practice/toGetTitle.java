package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class toGetTitle {
	WebDriver driver;
	@Test
	public void title() {
	System.out.println("Initilizing the Google Chrome Driver");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\tabish\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.astrosage.com/");
	System.out.println(driver.getTitle());
	
	

}
}