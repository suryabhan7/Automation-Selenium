package flightbooking;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class Check {
	@Test
	public static void main(String[] args)throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(1000);
        WebElement elementPopup =driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[3]"));
        elementPopup.click();
       	WebElement element = driver.findElement(By.xpath("//li[@data-cy ='roundTrip']//span"));
		element.click();
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("//li[@data-cy ='oneWayTrip']//span"));
		element1.click();
		Thread.sleep(2000);
		
        driver.findElement(By.xpath("//div[@class=\"fsw_inputBox searchCity inactiveWidget \"]/label")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"hsw_autocomplePopup autoSuggestPlugin \"]/div/input")).sendKeys("Kolkata");
        
        List<WebElement>list=driver.findElements(By.cssSelector("p[class=\"font14 appendBottom5 blackText\"]"));
        for(int i=0;i<list.size();i++)
        {
        	String text=list.get(i).getText();
        	System.out.println("Text is" +text);
        	if(text.contains("Kolkata"))
        	{
        		list.get(i).click();
        		break;
        	}
        }
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//span[text()='To']")).click();
        
        //Thread.sleep(2000);
       // driver.findElement(By.xpath("//input[@placeholder=\"To\"]")).sendKeys("Delhi");
        
        WebElement to = driver.findElement(By.xpath("//input[@placeholder=\"To\"]"));
        to.sendKeys("Delhi");
        //to.sendKeys(Keys.ARROW_DOWN);
        //to.sendKeys(Keys.ENTER);
        to.click();
       
        
     List<WebElement>list1=driver.findElements(By.cssSelector("p[class=\"font14 appendBottom5 blackText\"]"));
        for(int j=0;j<list1.size();j++)
       {
       	String text=list1.get(j).getText();
       	System.out.println("Text is" +text);
       	if(text.contains("Delhi"))
       	{
       		list1.get(j).click();
       		break;
        	}
      // 	Thread.sleep(2000);
       	
       	
      	driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
      	Thread.sleep(2000);
      	
      	driver.findElement(By.xpath("//div[@class=\"DayPicker-Day\"][contains(@aria-label,'Dec 24 2021')]")).click();
        
      	Thread.sleep(2000);
      	
      	
      	//WebElement search = driver.findElement(By.xpath("//p[@data-cy=\"submit\"]/a "));
      	WebElement search = driver.findElement(By.xpath("//a[@class=\"primaryBtn font24 latoBold widgetSearchBtn \"] "));
      	search.click();
     
      //	document.querySelector("#root > div > div.minContainer > div > div > div.fsw > p > a")
      
      	
    	Thread.sleep(2000);
      	
	}
	}
}

