package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheeseTask {

    public WebDriver driver;

    public By googleSearchField = By.name("q");
    public By searchResult = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]");

    public CheeseTask(WebDriver driver){
        this.driver=driver;
    }
    public void enterCheeseInSearch() {
        WebElement googleSearch = driver.findElement(googleSearchField);
        googleSearch.click();
        googleSearch.sendKeys("cheese");
        googleSearch.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
