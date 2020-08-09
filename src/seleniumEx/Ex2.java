package seleniumEx;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex2 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Ex\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		ArrayList<String> productName = new ArrayList<String>();

		driver.get("http://automationpractice.com/index.php");

		driver.findElement(By.xpath("(//*[@class='button ajax_add_to_cart_button btn btn-default'])[2]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("(//*[@id='layer_cart_product_title'])")).getText());
		productName.add(0, driver.findElement(By.xpath("(//*[@id='layer_cart_product_title'])")).getText());
		driver.findElement(By.xpath("//*[@class='continue btn btn-default button exclusive-medium']")).click();

		driver.findElement(By.xpath("(//*[@class='button ajax_add_to_cart_button btn btn-default'])[4]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("(//*[@id='layer_cart_product_title'])")).getText());
		productName.add(1, driver.findElement(By.xpath("(//*[@id='layer_cart_product_title'])")).getText());
		driver.findElement(By.xpath("//*[@class='continue btn btn-default button exclusive-medium']")).click();

		driver.findElement(By.xpath("(//*[@class='button ajax_add_to_cart_button btn btn-default'])[6]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("(//*[@id='layer_cart_product_title'])")).getText());
		productName.add(2, driver.findElement(By.xpath("(//*[@id='layer_cart_product_title'])")).getText());
		driver.findElement(By.xpath("//*[@class='continue btn btn-default button exclusive-medium']")).click();

		driver.findElement(By.xpath("//*[@class='shopping_cart']/a")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//*[@class='cart_description']//*[@class='product-name']")));
		boolean veryify = false;
		for (int i = 0; i < productName.size(); i++) {
			veryify = productName.get(i).contains(driver
					.findElement(
							By.xpath("(//*[@class='cart_description']//*[@class='product-name'])[" + (i + 1) + "]"))
					.getText());
		}

		if (veryify) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test fail");
		}

		driver.close();
	}
}
