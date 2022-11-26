package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    private static final int waitInterval = 3;

    public HomePage(WebDriver desiredBrowser) {
        super(desiredBrowser);
    }
    private By firstProduct = By.xpath("//div[3]/div[2]/div/a[3]");
    private By secondProduct = By.xpath("//div[3]/div[2]/div/a[2]");
    private By searchTextBox = By.id("search-q");
    private By firstSearchProduct = By.xpath("//*/ul[@class='searchSection-searchResult searchSection-searchResult-container']/div[2]//p");

    public void navigateToFirstProduct(){
        browser.findElement(firstProduct).click();
    }

    public void navigateToSecondProduct(){
       browser.findElement(secondProduct).click();
    }

    public void navigateToFirstSearchProduct(String input){
        browser.findElement(searchTextBox).clear();
        browser.findElement(searchTextBox).sendKeys(input);
        browser.findElement(firstSearchProduct).click();
    }


}
