package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private static final int waitInterval = 10;
    public ProductPage(WebDriver desiredBrowser) {
        super(desiredBrowser);
    }
    private By addToCart = By.xpath("//*[@class='addToBasket-btn']/button[@class='btn btn-red btn-block fontLightEnAr']");
    private By priceTag = By.xpath("//*[@id=\"menu\"]/div");
    private By basket = By.xpath("//a[1][@id='miniCart'][@class='shoppingCartLink']");

    public void addToBasket(){
        waitElement(priceTag, waitInterval);
        browser.findElement(addToCart).click();
    }
    public void navigateToShoppingBasket(){
        browser.findElement(basket).click();
    }
}
