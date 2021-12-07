
package flightbooking;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TripTest {
	static WebDriver driver;
	static WebDriverWait wait;
	
	@BeforeMethod
	public static void setup() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		System.out.println("Browser launched succesfully...");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20);
		driver.get("https://www.makemytrip.com/");
	}
	@Test
	public static void verifyflightdetail() throws InterruptedException {
		String expectedURL = "https://www.makemytrip.com/";
		
		 Thread.sleep(1000);
	        WebElement elementPopup =driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]"));
	        elementPopup.click();
	       	WebElement roundtrip = driver.findElement(By.xpath("//li[@data-cy ='roundTrip']//span"));
	       	roundtrip.click();
			Thread.sleep(2000);
			WebElement oneway = driver.findElement(By.xpath("//li[@data-cy ='oneWayTrip']//span"));
			oneway.click();
			Thread.sleep(2000);
			
//	}
//			//
//	
//			@Test
//			public static void verifyfromselect() throws InterruptedException {
//				String expectedURL = "https://www.makemytrip.com/";
			
			driver.findElement(By.xpath("//div[@class=\"fsw_inputBox searchCity inactiveWidget \"]/label")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//div[@class=\"hsw_autocomplePopup autoSuggestPlugin \"]/div/input")).sendKeys("Pune");
	        
	        List<WebElement>list=driver.findElements(By.cssSelector("p[class=\"font14 appendBottom5 blackText\"]"));
	        for(int i=0;i<list.size();i++)
	        {
	        	String text=list.get(i).getText();
	        	System.out.println("Text is" +text);
	        	if(text.contains("Pune"))
	        	{
	        		list.get(i).click();
	        		break;
	        	}
	        }
	        Thread.sleep(3000);
			
			//
	        
	        driver.findElement(By.xpath("//span[text()='To']")).click();
	        
	        //Thread.sleep(2000);
	       // driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).sendKeys("Delhi");
	        
	        WebElement to = driver.findElement(By.xpath("//input[@placeholder=\"To\"]"));
	        
	        Thread.sleep(3000);
	        to.sendKeys("Jaipur");
	        
	        Thread.sleep(3000);
	        //to.sendKeys(Keys.ARROW_DOWN);
	        //to.sendKeys(Keys.ENTER);
	        to.click();
	       
	        
	     List<WebElement>list1=driver.findElements(By.cssSelector("p[class=\"font14 appendBottom5 blackText\"]"));
	        for(int j=0;j<list1.size();j++)
	       {
	       	String text=list1.get(j).getText();
	       	System.out.println("Text is" +text);
	       	if(text.contains("Jaipur"))
	       	{
	       		list1.get(j).click();
	       		break;
	        	}
	       }
	       	Thread.sleep(2000);
	        
	        //
	       	
	    	driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
	      	Thread.sleep(2000);
	      	
	      	driver.findElement(By.xpath("//div[@class=\"DayPicker-Day\"][contains(@aria-label,'Dec 24 2021')]")).click();
	        
	      	Thread.sleep(2000);
	       	
	       	
	       	//
	      	
	      	WebElement search = driver.findElement(By.xpath("//a[@class=\"primaryBtn font24 latoBold widgetSearchBtn \"] "));
	      	search.click();
	     
	     
	      
	      	
	    	Thread.sleep(2000);
	    	//driver.close();
	      	
		}
		

	      	

	@AfterMethod
	public static void closeBrower() {
		driver.close();
		System.out.println("Browser closed succesfully...");
	}
	
	@AfterSuite
	public void cleanUp()
	{
		  System.out.println("we are closing completely...");
	}
	}

