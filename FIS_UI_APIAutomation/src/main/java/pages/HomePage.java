package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By searchBox = By.xpath("//input[@placeholder='Search for anything']");
    private By searchButton = By.className("gh-search-button__label");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForItem(String itemName) {
        driver.findElement(searchBox).sendKeys(itemName);
        driver.findElement(searchButton).click();
    }
}
