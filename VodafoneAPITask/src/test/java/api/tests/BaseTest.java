package api.tests;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
