import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.OrangeHRMTask;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrangeTest extends BaseTest{

    public WebDriver driver;

    @Test
    public void addCandidate(){
        OrangeHRMTask orange = new OrangeHRMTask(createWebDriver());
        orange.goToWebpage();
        orange.clickLoginButton();
        orange.clickRecruitmentOption();
        orange.clickCandidatesOption();
        orange.clickAddCandidatesButton();
        orange.addResume();
        orange.enterFirstName();
        orange.enterlastName();
        orange.enterEmail();
        orange.chooseDate();
        orange.clickSaveButton();

        String number = driver.findElement(orange.numberOfCandidates).getText();
        int actual = Integer.parseInt(number);
        int expected = actual + 1;

        assertEquals(actual, expected);

    }

   @Test
   public void deleteCandidate(){
       OrangeHRMTask orange = new OrangeHRMTask(createWebDriver());
       orange.goToWebpage();
       orange.clickLoginButton();
       orange.clickRecruitmentOption();
       orange.clickCandidatesOption();
       orange.clickAddCandidatesButton();
       orange.addResume();
       orange.enterFirstName();
       orange.enterlastName();
       orange.enterEmail();
       orange.chooseDate();
       orange.clickSaveButton();
       orange.searchIconButton();
       orange.searchCandidateText();
       orange.clickSearchCandidateButton();
       orange.clickCheckBox();
       orange.clickThreeDots();
       orange.clickDeleteCandidate();
       orange.clickYesDelete();

       String number = driver.findElement(orange.numberOfCandidates).getText();
       int actual = Integer.parseInt(number);
       int expected = actual - 1;

       assertEquals(actual, expected);
   }

   @Test
    public void logOut(){
       OrangeHRMTask orange = new OrangeHRMTask(createWebDriver());
       orange.goToWebpage();
       orange.clickLoginButton();
       orange.findLogout();
       orange.clickLogout();
   }

}
