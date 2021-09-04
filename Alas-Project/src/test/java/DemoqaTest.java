import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.DemoqaTask;

public class DemoqaTest extends BaseTest{

    public WebDriver driver;

    @Test
    public void testDemoqaTask(){
        DemoqaTask dt = new DemoqaTask(createWebDriver());
        dt.enterDemoqaInSearch();
        dt.clickOnFirstResult();
        dt.clickInteractions();
        dt.chooseDropabbleOption();
        dt.moveDragMeToDropHere();//problem
        dt.takeAScreenshot();
        dt.clickWidgets();
        dt.clickToolTips();
        dt.enterTextInHoverToSeeMeField();
    }

}
