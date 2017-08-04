package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WblHomepage {
	
	public static void main (String[]args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhushan\\myjava\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://whiteboxqa.com/");
		driver.navigate().to("http://whiteboxqa.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("loginButton")).click();
		System.out.println("Current URL" + driver.getCurrentUrl());
		System.out.println("Title of the page" + driver.getTitle());
		System.out.println("Pagesource"+ driver.getPageSource());
		driver.findElement(By.name("uname")).sendKeys("shashisingh2006@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("innovapath123");
		driver.findElement(By.id("login")).click();
		Thread.sleep(5000);
		driver.close();
		//driver.quit();
		
	}

}
