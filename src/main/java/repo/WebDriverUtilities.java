package repo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilities {

	
	
	public boolean cleverTapClick(WebDriver driver) {
		try {
			WebElement a = driver.findElement(By.xpath("//button[text()='No thanks']"));
			//a.click();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			if(a!=null) {
				a.click();
			}
			}
			catch(Exception e) {
				System.out.println("exception are as follows " + e.getMessage());
				driver.findElement(By.xpath("//button[@id=\"wzrk-cancel\"]")).click();
				
			}
		return true;
		
	}
	public void waitMTD(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void waitForElement(WebDriver driver, WebElement ele) {
		WebDriverWait waitforEle = new WebDriverWait(driver, 15);
		waitforEle.until(ExpectedConditions.visibilityOf(ele));
	}
	public static int getRndNumber() {
	    Random random=new Random();
	    int randomNumber=0;
	    boolean loop=true;
	    while(loop) {
	        randomNumber=random.nextInt();
	        if(Integer.toString(randomNumber).length()==9 && !Integer.toString(randomNumber).startsWith("-")) {
	            loop=false;
	        }
	        }
	    return randomNumber;
	}
}
