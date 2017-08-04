package examples;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageWindowHandles {

WebDriver driver;
	
	@BeforeClass
	public void beforeClass(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhushan\\myjava\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.navigate().to("http://whiteboxqa.com/");
	System.out.println("Title::"+driver.getTitle());
	
	}
	
	@Test
	public void windowHandles(){
		
		driver.findElement(By.id("headerfblogin")).click();
		String parentWindow = driver.getWindowHandle(); // parent window is whitebox QA
		Set<String> windowNames = driver.getWindowHandles();// use set because of multiple windows n whatever window is available 
		                                                     //in getWindowHandles will store on <String>
		
		for(String name : windowNames){                 // using For Each name... which place it is present we have to give for Loop
			System.out.println("name of the windows:"+name);
			if(!name.equals(parentWindow)){
				driver.switchTo().window(name);
				break;
			}
		}
		driver.findElement(By.id("email")).sendKeys("shashi@whitebox.learning.com");
		driver.findElement(By.id("pass")).sendKeys("shashi");
		driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
		String actual = driver.findElement(By.className("fsl fwb fcb")).getText();
		assertEquals(actual,"Incorrect Email");
		
	}
	
	@AfterClass
	public void afterClass(){
		driver.close();
	}
	


}
