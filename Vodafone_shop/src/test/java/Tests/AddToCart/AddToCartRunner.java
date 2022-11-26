package Tests.AddToCart;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@CucumberOptions
        (
                features={"./src/test/java/Tests/AddToCart"},
                glue={"Tests/AddToCart"}
        )
@Listeners({ExtentITestListenerClassAdapter.class})

public class AddToCartRunner extends AbstractTestNGCucumberTests {
        public static WebDriver browser;

        @BeforeClass
        public void setUp() {
                Properties prop = System.getProperties();
                try {
                        prop.load(new FileInputStream("src/test/resources/Test.properties"));
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
                switch (System.getProperty("browserType").toLowerCase()) {
                        case "chrome":
                                WebDriverManager.chromedriver().setup();
                                browser = new ChromeDriver();
                                break;
                        case "firefox":
                                WebDriverManager.firefoxdriver().setup();
                                browser = new FirefoxDriver();
                                break;
                }
                browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                browser.get("https://eshop.vodafone.com.eg/shop/");
                browser.manage().window().maximize();

        }

        @AfterClass
        public void endSession() {
                browser.quit();
        }
}
