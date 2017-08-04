package examples;



//Class 2016-06-23 recording

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	WebDriver driver;
	
/*	@Test(enabled=false)
	public void DragAndDropActions() throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhushan\\myjava\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://code.makery.ch/library/dart-drag-and-drop/");
	Actions action = new Actions(driver);
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.switchTo().frame(1);
	List<WebElement>  elements = driver.findElements(By.cssSelector(".document"));
	System.out.println("Size after drag and drop :" + elements.size());
	
	
	
	WebElement element = driver.findElement(By.cssSelector(".document:nth-of-type(1)"));
	WebElement to = driver.findElement(By.cssSelector(".trash"));
	//action.dragAndDrop(element, to).perform(); other option to do Drag & drop
	action.clickAndHold(element).moveToElement(to).release(to).build().perform();
	elements = driver.findElements(By.cssSelector(".document"));
	
	Thread.sleep(2000);
	System.out.println("Size after drag and drop :" + element.getSize());
	
	}*/
	
/*	@Test   // Navigate n other option
	public void navigate() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhushan\\myjava\\chromedriver.exe");
		driver = new ChromeDriver();
		 driver.get("http://whiteboxqa.com/");
		 driver.findElement(By.id("loginButton")).click();
		 Thread.sleep(2000);
		 driver.navigate().back(); 
		 Thread.sleep(2000);
		 driver.navigate().forward();
		 Thread.sleep(2000);
		 driver.navigate().refresh();
		 driver.navigate().to("https://talentscreen.io/#/website-pages/home");
		 
	}*/
	
	/*@Test
	 public void webElementMethods(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhushan\\myjava\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
		
		WebElement element = driver.findElement(By.id("globle-search-input"));
		Assert.assertEquals("Search",element.getAttribute("placeholder"));
		Assert.assertEquals("query",element.getAttribute("name"));
		
		System.out.println ("radius:"+ element.getCssValue("border-radius"));
		
		System.out.println("font-size:"+ element.getCssValue("font-size"));
		
		Assert.assertTrue(element.isDisplayed());
		System.out.println("enabled:" + element.isEnabled());
		
		//check Boxes, radio button,dropdowns
		//element.isSelected();
		
		Dimension dim = element.getSize();
		System.out.println("height:" + dim.height);
        System.out.println("width:" + dim.width);
        
        
        driver.get("http://whiteboxqa.com/");	
        List<WebElement> elms = driver.findElements(By.cssSelector(".fa.fa-twitter"));
        Point point = elms.get(0).getLocation();
        System.out.println("X:"+ point.x);
        System.out.println("Y:"+ point.y);
	
        point  = elms.get(1).getLocation();
        System.out.println("X:"+ point.x);
        System.out.println("Y:"+ point.y);
		
	}*/
	
	@Test
	public void handleCookies(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhushan\\myjava\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie : cookies){
			System.out.println(cookie.getName());
		}
		Cookie cookie = new Cookie ("Newone","somevalue");
		
		System.out.println("***********************");
		
		driver.manage().addCookie(cookie);
		for(Cookie cooki : cookies){
			System.out.println(cooki.getName());
		}
	}
	
	

}
