package examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class AmazonHomePage {
	
	WebDriver driver;
	
	@Test 
	public void signInTest(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhushan\\myjava\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		System.out.println("home page Title:"+ driver.getTitle());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement element = driver.findElement(By.cssSelector("#nav-link-accountList>span:nth-of-type(2)")); // listen to 2017/06/22 class 23 mints video
		element.click();
		System.out.println("sign in page title :" + driver.getTitle());
		
	}
	
	public void tryPrimeTest(){
		
		driver.get("https://www.amazon.com/");
		System.out.println("home page Title:"+ driver.getTitle());
		WebElement element = driver.findElement(By.cssSelector("#nav-link-prime .nav-line-2"));
		
		Actions action = new Actions(driver); //abject will take driver input
		action.moveToElement(element).perform(); // moveToElement will take the mouse control to a particular element//perform perform action
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".prime-button-try>a")));
		element.click();
		System.out.println("home page Title:"+ driver.getTitle());
		//driver.findElement(By.cssSelector(".prime-button-try>a")).click();
	}
	
	public void searchBoxTest() throws InterruptedException{
		driver.get("https://www.amazon.com/");
		WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
		element.click();
		element.sendKeys("w");
		element.sendKeys("a");
		
		Thread.sleep(1000);
		element.sendKeys("t");
		
		//List<WebElement>elements = driver.findElements(By.cssSelector("#suggestions div"));
		
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(5,TimeUnit.SECONDS);
		wait.withTimeout(30,TimeUnit.SECONDS);
		
		//List<WebElement>elements =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#suggestions div")));
		//System.out.println("list size:" + elements.size());
		
		WebElement elm = wait.until(function);
			System.out.println("element selected:"+ elm.getText());
	}
		

	
	Function<WebDriver,WebElement> function = new Function<WebDriver,WebElement>(){  //  this function is an Interface...whereWebDrive is Input & WebElement is output
		
		public WebElement apply(WebDriver arg0){   // apply -- is a method
		List<WebElement>elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#suggestions div")));
		
		System.out.println("list size:"+ elements.size());
		WebElement elm1 = null;
		for(WebElement elm: elements){
			elm1 = elm;
			System.out.println(elm.getText());
		}
		return elm1;
		}
	};

}
