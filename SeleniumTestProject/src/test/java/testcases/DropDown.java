package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown  {
	public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.sugarcrm.com/au/request-demo/?utm_source=google.com&utm_medium=organic");
	Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[1]/div/div/div/div[1]/form/div/div[7]/div/select")));
	dropdown.selectByVisibleText("251 - 500 employees");
	Thread.sleep(2000);
	driver.close();
	}
}
