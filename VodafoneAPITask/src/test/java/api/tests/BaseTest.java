package api.tests;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
@Listeners({ExtentITestListenerClassAdapter.class})
public class BaseTest {
    @BeforeClass
    public void init(){
        Properties prop = System.getProperties();
        try {
            prop.load(new FileInputStream("src/test/resources/test.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
