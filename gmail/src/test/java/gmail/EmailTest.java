package gmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;





public class EmailTest {
	static WebDriver driver;
	static WebDriverWait wait;
	
		@AfterMethod
		public static void closeBrowser() {
			driver.close();
			System.out.println("Browser closed succesfully....");
			
		}
		
		@BeforeMethod
		public static void setup() {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Browser launched succesfully...");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver,20);
			driver.get("https://mail.google.com/");
			
		}
		
		@Test
		public static void emailsignup() throws InterruptedException{
			
			WebElement email = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
			email.sendKeys("seleniuma203@gmail.com");
			email.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			
			WebElement pass = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
			pass.sendKeys("automation123");
			pass.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			
		//}

//		@Test(priority=2)
//		public static void compose() throws InterruptedException{
			WebElement compose = driver.findElement(By.xpath("//div[contains(text(),'Compose')]"));
			compose.click();
			Thread.sleep(3000);
			
			WebElement recipent = driver.findElement(By.xpath("//*[@id=\":pm\"]"));
			recipent.sendKeys("vanubandla25@gmail.com");
			recipent.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			
			WebElement textmsg = driver.findElement(By.xpath("//div[@id=':oy']"));
			textmsg.sendKeys("hey! I did it...");
			
			WebElement send = driver.findElement(By.xpath("//div[@id=':qe']"));
			send.click(); 
			Thread.sleep(4000);
		
		}
}
