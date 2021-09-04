import helper.ConfigurationClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    public WebDriver createWebDriver(){
        ConfigurationClass configFileReader = new ConfigurationClass();
        String url = configFileReader.getApplicationUrl();
        String browser = configFileReader.getDriverType();

        switch(browser){
            case ("chrome"):
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case ("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case ("edge"):
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().refresh();
        return driver;
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }

}
