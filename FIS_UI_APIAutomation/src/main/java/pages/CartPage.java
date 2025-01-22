package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By cartItemCount = By.xpath("//a[@href='https://cart.ebay.com']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartItemCount() {
        String count = driver.findElement(cartItemCount).getText();
        return Integer.parseInt(count);
    }
}
