package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    static WebDriver browser;
    BasePage(WebDriver desiredBrowser){

        browser = desiredBrowser;
    }

    public void waitElement(By element, int time){
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
