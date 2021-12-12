import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFiles {
	
	public static void main(String[] args) {
		String fileType = "PDF";
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("plugins.always_open_pdf_externally", true);
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://file-examples.com/");
		
		WebElement click = driver.findElement(By.xpath("//h3[text()='Documents']/following-sibling::a"));
		click.click();
		click.sendKeys(Keys.ENTER);
		
		//driver.findElement(By.xpath("//td[text()='"+fileType+"']/following-sibiling::td[2]/a")).click();	
	
		driver.findElement(By.xpath("//*[@id=\"table-files\"]/tbody/tr[4]/td[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"table-files\"]/tbody/tr[1]/td[5]/a[1]")).click();
	}
}
