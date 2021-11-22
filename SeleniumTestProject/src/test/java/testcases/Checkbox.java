package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://html.form.guide/checkbox/html-form-with-checkbox/");
		driver.findElement(By.xpath("/html/body/div/div[2]/article/p[3]/input")).click();
		System.out.println(driver.findElement(By.xpath("")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("")).getText());
		Thread.sleep(1000);
		driver.close();
	}
}
