package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindAllLinks {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://www.yatra.com/");
		List<WebElement> wb = driver.findElements(By.tagName("a"));
		System.out.println(wb.size());
		
		for(int i=0;i<wb.size();i++) {
			WebElement w=wb.get(i);
			System.out.println(w.getText());
			System.out.println(w.getAttribute("href"));
		}
	}
}