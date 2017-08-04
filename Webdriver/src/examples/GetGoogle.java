package examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class GetGoogle {

	public static void main(String[] args)  throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhushan\\myjava\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wellsfargo.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.id("userid")).sendKeys("shashi");
		driver.findElement(By.id("password")).sendKeys("123hdjm");
		driver.findElement(By.id("btnSignon")).click();
		driver.close();
		

	}

}
