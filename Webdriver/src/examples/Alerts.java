package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Alerts {
	
	
	WebDriver driver;
	@BeforeClass
	
	public void beforeClass(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhushan\\myjava\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
	}
    @Test
    public void method1() throws InterruptedException{
    	driver.findElement(By.cssSelector(".btn.btn-default")).click();
    	driver.switchTo().alert().accept();// simple accept alert
    	
    	Thread.sleep(2000);
    	/*driver.switchTo().alert().dismiss();// dismiss alert
    	driver.switchTo().alert().getText(); // if there is text already there
    	driver.switchTo().alert().sendKeys("Hey there.."); // Promopt alert */
    	
    }
}
