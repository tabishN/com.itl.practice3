package com.itl.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import repo.WebDriverUtilities;

public class ExpDetails_online_busy_StatusTest extends BaseClass{
	public String expertname = "Tabish Tewwwqwe";
	String id;
	String se;
	String online;
	String busy;
	int countOnline;
	int countBusy;
	ArrayList<String> onlineInArray = new ArrayList<String>() ;
	ArrayList<String> busyInArray = new ArrayList<String>() ;
	ArrayList<String> exPids = new ArrayList<String>() ;
	ArrayList<String> expNames = new ArrayList<String>() ;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	ArrayList<String> idWithName = new ArrayList(exPids.size() + expNames.size()) ;
		@Test(priority = 1)
		public void online_busy_status() {
		
			driver.findElement(By.xpath("//a[@id=\"chatPg\"]")).click();
			System.out.println("Chat with Expert list selected");
			//wb.cleverTapClick(driver);
			System.out.println("Expert details are :");
			
			// to get expert details...............
			List<WebElement> ne = driver.findElements(By.xpath("//a[text()='"+expertname+"']/ancestor::div"));
			Iterator<WebElement> i = ne.iterator();
			while(i.hasNext())
			{
				id = i.next().getAttribute("data-psychic-id");	
			}
			System.out.println("Expert id is "+id);
			List<WebElement> newww = driver.findElements(By.xpath("//a[text()='"+expertname+"']/following-sibling::span"));
			for(WebElement s : newww) {
				String selectedExpertDetails = s.getText();
				System.out.println(selectedExpertDetails);
			}
			// To fetch online astrologers............
			List<WebElement> onlineExp = driver.findElements(By.xpath("//div[@title=\"Online\"]/parent::li/following-sibling::li/child::a"));
			for(WebElement onlineEx : onlineExp) 
			{
				 online = onlineEx.getText();
				 onlineInArray.add(online);
				 countOnline++;
			}
			System.out.println("Number of online astrologers are : "+ countOnline);
			System.out.println("online astrologers are : "+onlineInArray);
			// To fetch busy astrologers...........
			List<WebElement> busyExp = driver.findElements(By.xpath("//div[@title=\"Busy\"]/parent::li/following-sibling::li/child::a"));
			for(WebElement busyEx : busyExp) {
				 busy = busyEx.getText();
				 busyInArray.add(busy);
				 countBusy++;
			}
			System.out.println("busy astrologers are : "+busyInArray);
			System.out.println("Number of Busy astrologers are : "+ countBusy);
			int total = countOnline + countBusy;
			System.out.println("Total astrologers are : "+total);
		
		
			}
		@Test(priority = 2)
		public  void expertIDWithNames() {
			Reporter.log("second method execution started",true);
			//driver.findElement(By.xpath("//a[@id=\"chatPg\"]")).click();
			//System.out.println("Chat with Expert list selected");
			Reporter.log("Expert list fetching started....");
			
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				//List<WebElement> e = driver.findElements(By.xpath("//a[text()='"+expertname+"']/ancestor::ul[@class=\"list-unstyled d-flex mb-0\"]"));
				//WebElement v0 = e.get(0);
				List<WebElement> l = driver.findElements(By.xpath("//div[@id=\"expert-list\"]/div"));
				List<WebElement> expName = driver.findElements(By.xpath("//li[@class=\"w-100 overflow-hidden\"]/a"));
				
				for(WebElement x : l) {
					String id = x.getAttribute("data-psychic-id");
					exPids.add(id);
				}
				System.out.println("Total number of exp id's are :" + exPids.size());
				for(WebElement y : expName) {
					String names = y.getText();
					expNames.add(names);
				}
				System.out.println("Total number of exp names are :" + expNames.size());
				
				for (int i = 0; i < exPids.size(); i++){
			    idWithName.add(exPids.get(i));
			    idWithName.add(expNames.get(i));
				}
			//System.out.println(idWithName);
				for (int i = 0; i < idWithName.size(); i += 2) {
		            System.out.print(idWithName.get(i));
		            if (i + 1 < idWithName.size()) {
		                System.out.print(" : " + idWithName.get(i + 1));
		            }
		            System.out.println();
		        }
				/*
				 * Iterator<WebElement> i = l.iterator();
				 * 
				 * while(i.hasNext()) { String id = i.next().getAttribute("data-psychic-id");
				 * System.out.println(id);
				 * 
				 * }
				 */
			
			
			
				
			
			
		}
}

