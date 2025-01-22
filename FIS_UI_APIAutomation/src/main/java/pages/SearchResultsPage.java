package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
	private WebDriver driver;

	private By firstItem = By.xpath("//ul[@class='srp-results srp-list clearfix']/li[1]/div/div[1]");
	private By addToCartButton = By.xpath("//span[contains(text(),'Add to cart')]");

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectFirstItem() {
		driver.findElement(firstItem).click();
	}

	public void addToCart() {
		driver.findElement(addToCartButton).click();
	}
}
