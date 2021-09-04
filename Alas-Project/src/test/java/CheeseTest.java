import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.CheeseTask;

import javax.annotation.Nullable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheeseTest extends BaseTest{

    public WebDriver driver;

    @Test
    public void testCheeseResultNumber(){

        CheeseTask ct = new CheeseTask(createWebDriver());
        ct.enterCheeseInSearch();

        String actual = driver.findElement(ct.searchResult).getText();//ne mogu da lociram nikako ovaj element
        actual = actual.substring(6, actual.indexOf("result"));
        actual = actual.replaceAll(",", "").trim();
        int actualResult = Integer.parseInt(actual);
        int expected = 777;
        String response = "There is too much cheese on the internet";

        assertEquals(expected,actualResult,response);

    }

}
