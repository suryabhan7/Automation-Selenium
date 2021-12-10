import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFlipkart {
	
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
		driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public static void Search() throws InterruptedException {
		String expectedURL = "https://www.flipkart.com/";
		
		 Thread.sleep(1000);
		 
		 	WebElement loginPopup =driver.findElement(By.xpath("/html/body/div[2]/div/div/button"));
	        loginPopup.click();
	        Thread.sleep(2000);
	        
	        WebElement search = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input"));
	        search.sendKeys("mobiles");
	        search.sendKeys(Keys.ENTER);
	        
	        Thread.sleep(1000);
	        
	        WebElement ram = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[5]/div[2]/div/div[2]/div/label/div[1]"));
	        ram.click();
	        Thread.sleep(3000);
	        
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,850)", "");
            
            Thread.sleep(1000);
	        
	        
//            WebElement Element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[6]/div[2]/div[1]/div[1]/input"));
//
//            // Scrolling down the page till the element is found	
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].scrollIntoView();", Element);
	        
//	      	  List<WebElement> brands = driver.findElements(By.xpath("//*[@id='container']/div/div[3]/div/div[1]/div/div[1]/div/section[6]/div[1]/div"));
//	        	System.out.println(brands.size());
//	        for(int i=0;i<brands.size();i++){
//	         System.out.println(brands.get(i).getText());//fetching all the brands
//	         if(brands.get(i).getText().equals("Samsung"))//matching for samsung only
//	         {
//	          brands.get(i).click();//clicking pon samsung
//	         }
////	         brands = driver.findElements(By.xpath("//div[@id='list-tagcloud']/div[2]/a"));//for cache
//	        }
            
            WebElement brand = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[1]/div/div[1]/div/section[6]/div[2]/div[1]/div[1]/input"));
            brand.sendKeys("google");
            
            List<WebElement> brands =driver.findElements(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[6]/div[2]/div[1]/div[2]/div/label/input"));
            System.out.println(brands.size());
            for(int i=0;i<brands.size();i++){
            	System.out.println(brands.get(i).getText());
            	  if(brands.get(i).getText().equals("google"))
            	  {
        	          brands.get(i).click();//clicking pon samsung
        	         }
            	   brands = driver.findElements(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[6]/div[2]/div[1]/div[2]/div/label/input"));//for cache
            }
            	
            }
	}
	

	
	