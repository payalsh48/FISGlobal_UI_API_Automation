package com.ui.automation;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.SearchResultsPage;

public class AddToCartEbayTest {

	private WebDriver driver;

	@BeforeClass()
	public void setUp() {
		String pathToChromeDriver = System.getProperty("user.dir") + "/src/test/resources/chromedriver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test
	public void testAddToCart() {
		driver.get("https://www.ebay.com");

		HomePage homePage = new HomePage(driver);
		homePage.searchForItem("Laptop");

		SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.selectFirstItem();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		searchResultsPage.addToCart();

		CartPage cartPage = new CartPage(driver);
		int itemCount = cartPage.getCartItemCount();

		Assert.assertEquals(itemCount, 1, "Item count in the cart should be 1");
	}

	 @AfterClass
	public void tearDown() {
		// Close the browser
		if (driver != null) {
			driver.quit();
		}
	}
}
