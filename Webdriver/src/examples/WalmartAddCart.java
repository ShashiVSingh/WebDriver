package examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WalmartAddCart {
	WebDriver driver;

	@BeforeClass
	public void BeforePage() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bhushan\\myjava\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.walmart.com/");
	}

	@Test
	public void SearchFirstItem() {

		driver.findElement(By.cssSelector("input#global-search-input")).sendKeys("laptop");
		driver.findElement(By.cssSelector(".header-GlobalSearch-submit.btn")).click();

		List<WebElement> results = driver
				.findElements(By.cssSelector("a[class^='product-title-link line-clamp line-clamp-3']"));

		for (WebElement element : results) {
			String resultTitle = element.getAttribute("aria-label");
			System.out.println(resultTitle);
			if (resultTitle.contains("Dell Inspiron 11 3162 11.6")) {
				element.click();
				break;
			}

		}

		// driver.findElement(By.cssSelector("button[class='.prod-ProductCTA--primary.btn.btn-primary.btn-block']
		// *;nth-child(2")).click();
		driver.findElement(By.cssSelector("button[class='.prod-ProductCTA--primary.btn.btn-primary.btn-block']"))
				.click();
		List<WebElement> ele = driver.findElements(By.cssSelector("button[class='btn btn-inverse btn-block']"));

		String parentWindow = driver.getWindowHandle();

		driver.findElement(By.cssSelector(".Cart-PACModal-ItemInfoContainer"));

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);
			for (WebElement elem : ele) {
				if (elem.getText().equalsIgnoreCase("Continue Shopping")) {
					elem.click();
					break;

				}
				driver.switchTo().window(parentWindow);
			}
		}
	}

	@Test
	public void SearchSecondItem() {

		driver.findElement(By.cssSelector("input#global-search-input")).sendKeys("tablets");
		driver.findElement(By.cssSelector(".header-GlobalSearch-submit.btn")).click();
		List<WebElement> results1 = driver
				.findElements(By.cssSelector("a[class^='product-title-link line-clamp line-clamp-3']"));

		for (WebElement element : results1) {
			String resultTitle1 = element.getAttribute("aria-label");
			System.out.println(resultTitle1);
			if (resultTitle1.contains("RCA Voyager 7 16GB Tablet Android 6.0 (Marshmallow)")) {
				element.click();
				break;
			}

		}

		driver.findElement(
				By.cssSelector("button[class='.prod-ProductCTA--primary.btn.btn-primary.btn-block'] "))
				.click();
		List<WebElement> ele1 = driver.findElements(By.cssSelector("button[class='btn btn-inverse btn-block']"));
		for (WebElement elems : ele1) {
			if (elems.getText().equalsIgnoreCase("View Cart")) {
				elems.click();
				break;

			}
		}
	}

	@Test
	public void CartTestPage() {
		WebDriverWait Wait = new WebDriverWait(driver, 15);
		WebElement el = Wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("h1[class^='cart-list-title display-inline-block access-title']")));

		System.out.println(el.getText());
		Assert.assertEquals("2 items.", el.getText());
	}

	@AfterClass
	public void closePage() {
		driver.close();
	}

}
