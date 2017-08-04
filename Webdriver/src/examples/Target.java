package examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Target {

	WebDriver driver;

	@BeforeTest
	public void beforeTest() {

		// System.setProperty("webdriver.gecko.driver",
		// "C:\\Users\\Bhushan\\myjava\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bhushan\\myjava\\chromedriver.exe");
		driver = new ChromeDriver();

		// driver = new FirefoxDriver();

		driver.get("http://www.target.com/p/aveeno-baby-soothing-relief-moisture-cream-8-oz/-/A-11427116");

	}

	@Test

	public void addtoCart() {

		// product page

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement element = driver.findElement(By.id("sbc-quantity-picker"));

		Select select = new Select(element);

		select.selectByValue("2");

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		element = driver.findElement(By.cssSelector(".sbc-add-to-cart.btn.btn-primary.btn-lg.btn-block.sbc-selected"));

		element.click();

		System.out.println("ADD TO CART BUTTON : " + element.isDisplayed());

		String parentWindow = driver.getWindowHandle();

		driver.findElement(By.cssSelector(".itemRtText"));

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);
		}

		// modal

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		element = driver.findElement(By.cssSelector(".cart-ATC.btn.btn-primary.btn-block.btn-lg"));

		System.out.println("MODAL : " + element.isDisplayed());

		element.click();
		driver.close();

		// order summary page

		driver.switchTo().window(parentWindow);

		String cartItems = driver.findElement(By.linkText("2 items")).getText();

		Assert.assertEquals("2 items", cartItems);

		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		element = driver.findElement(By.xpath(".//*[@id='checkout-link']"));

		element.click();

		System.out.println("CHECKOUT BUTTON : " + element.isDisplayed());

		// sign in

		element = driver.findElement(By.cssSelector("#signin-btn"));

		System.out.println("SIGN IN PAGE BUTTON " + element.isDisplayed());

	}

}
