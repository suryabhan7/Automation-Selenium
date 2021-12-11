import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlightBooking {
	static WebDriver driver;
	static WebDriverWait wait;
	
		@AfterMethod
		public static void closeBrowser() {
			driver.close();
			System.out.println("Browser closed succesfully....");
			
		}
		
		@BeforeMethod
		public static void setup() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Browser launched succesfully...");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			wait = new WebDriverWait(driver,20);
			driver.get("https://www.cleartrip.com/");
			
		}
		
		@Test(priority=1)
		public static void flightTab() throws InterruptedException {
			WebElement roundtrip = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[2]/label[2]/div[1]/span"));
			roundtrip.click();
			Thread.sleep(1000);		
		
			WebElement from = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[3]/div[1]/div[1]/div/div/div/input"));
			from.sendKeys("Mumbai");
			Thread.sleep(1000);
			
			WebElement mumbai = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[3]/div[1]/div[1]/div/div/div[2]/ul/li/p"));
			mumbai.click();
			Thread.sleep(4000);
			
			
			WebElement to = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[3]/div[1]/div[5]/div/div/div[1]/input"));
			to.sendKeys("Delhi");
			Thread.sleep(2000);
			
			WebElement delhi = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[3]/div[1]/div[5]/div/div/div[2]/ul/li/p"));
			delhi.click();
			Thread.sleep(2000);
		}
			
			@Test(priority=3)
			public static void Passenger() throws InterruptedException {
			WebElement adults = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[4]/div/div[1]/select"));
			adults.click();
			
			WebElement num = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[4]/div/div[1]/select/option[2]"));
				num.click();
				Thread.sleep(4000);		
		}
			@Test(priority=2)
			public static void date()throws InterruptedException {
			WebElement date= driver.findElement(By.xpath("//div[@class=\"flex flex-middle p-relative homeCalender\"]/button"));
			date.click();
			
			}
		
		
		
}