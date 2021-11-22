package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardAction {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
 
		driver.get("https://www.facebook.com/");
		
  		Actions act=new Actions(driver);
  		driver.findElement(By.name("email")).sendKeys("suryabhansingh1998@gmail.com");
  		act.sendKeys(Keys.ENTER).perform();


Thread.sleep(3000);
driver.close();

}
}