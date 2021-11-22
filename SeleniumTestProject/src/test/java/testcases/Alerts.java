package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("1008");
		driver.findElement(By.name("submit")).click();


		Alert alert = driver.switchTo().alert();


		String msg = alert.getText();
		System.out.println(msg);
		Thread.sleep(1000);


		alert.accept();
		Thread.sleep(500);
		

		Alert alertNew = driver.switchTo().alert();
		

		System.out.println(alertNew.getText());
		Thread.sleep(500);
		

		alertNew.accept();
		Thread.sleep(500);

	}

}
