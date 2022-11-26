package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver desiredBrowser) {
        super(desiredBrowser);
    }
    private By shoppingBasketItems = By.xpath("//ul[@class='shopingCartContainer-shopingCartItem-list devicesRow']");
    private By vodafoneIcon = By.xpath("//*[@id=\"home\"]/nav/a/div");

    public int getBasketItemsCount(){
        return (browser.findElements(shoppingBasketItems).size());
    }
    public void navigateToHomePage(){
        browser.get("https://eshop.vodafone.com.eg/shop/");
    }
}
