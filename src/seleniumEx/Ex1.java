package seleniumEx;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex1 {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Ex\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.id("search_query_top")).sendKeys("No Products");
		driver.findElement(By.name("submit_search")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if (driver.findElement(By.xpath("//*[@class='alert alert-warning']")).getText().contains("No Products")) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}

		driver.close();
	}
}
