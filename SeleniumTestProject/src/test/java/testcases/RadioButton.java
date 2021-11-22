package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.singaporeair.com/en_UK/in/home#/book/bookflight");
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		
		WebElement radio2 = driver.findElement(By.id("redeemFlights"));
		WebElement radio1 = driver.findElement(By.id("bookFlights"));
		
		radio2.click();
		System.out.println(radio1.isSelected());
		System.out.println(radio2.isSelected());
		Thread.sleep(3000);
		driver.close();
	}
}
