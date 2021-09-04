package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrangeHRMTask {

    public WebDriver driver;

    public static final String URL = "https://orangehrm-demo-7x.orangehrmlive.com/";
    public By loginButton = By.className("btn btn-success");
public By recruitmentOption = By.cssSelector("a[class='collapsible-header waves-effect waves-orange active'] span[class='left-menu-title']");
public By candidatesOption = By.id("menu_recruitment_viewCandidates");
public By numberOfCandidates = By.cssSelector("div[id='fromToOf'] div[class='pagination']");
public By addCandidateButton = By.className("large mdi-content-add material-icons");
public By resume = By.name("addCandidate[resume]");
public By firstName = By.id("addCandidate_firstName");
public By lastName = By.name("addCandidate[lastName]");
public By email = By.id("addCandidate_email");
public By saveButton = By.linkText("Save");
public By calendar = By.className("formDateInput datepicker datepicker picker__input valid");
public By searchIcon = By.className("mdi-action-search material-icons");
public By searchText = By.name("nameTxt");
public By searchButton = By.id("searchCandidatesFormBtn");
public By activeVacanciesBox = By.cssSelector("label[for='searchActiveVacancies']");
public By candidateCheckBox = By.cssSelector("label[for='checkbox_154_']");
public By threeDots = By.className("material-icons icons-color handCurser");
public By deleteCandidate = By.id("deleteItemBtn");
public By yesDelete = By.id("candidate-delete-button"); //refresh stranicu posle ovoga

    public OrangeHRMTask(WebDriver driver){
        this.driver=driver;
    }

    public void goToWebpage(){
        driver.get(URL);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickRecruitmentOption(){
        driver.findElement(recruitmentOption).click();
    }
    public void clickCandidatesOption(){
        driver.findElement(candidatesOption).click();
    }
    public void printNumberOfCandidates(){
        WebElement number = driver.findElement(numberOfCandidates);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", number);
        String candidateNumber = number.getText();
        int num = Integer.parseInt(candidateNumber);
        System.out.println(num);
    }
    public void clickAddCandidatesButton(){
        driver.findElement(addCandidateButton).click();
    }

    public void addResume(){
        WebElement CV = driver.findElement(resume);
        CV.click();
        CV.sendKeys("C:\\Users\\Dragan\\Desktop\\OrangeHRM Resume.docx");
    }
 public void enterFirstName(){
        WebElement fname = driver.findElement(firstName);
        fname.click();
        fname.sendKeys("QA");
 }
    public void enterlastName(){
        WebElement lname = driver.findElement(lastName);
        lname.click();
        lname.sendKeys("Automation");
    }
    public void enterEmail(){
        WebElement mail = driver.findElement(email);
        mail.click();
        mail.sendKeys("sasadmoffice@gmail.com");
    }
    public void clickSaveButton(){
        driver.findElement(saveButton).click();
    }
    public void chooseDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date today = Calendar.getInstance().getTime();
        String date = dateFormat.format(today);
        WebElement dateWidget = driver.findElement(calendar);
        List<WebElement> columns=dateWidget.findElements(By.tagName("div"));

        for (WebElement cell : columns)
        {
            if (cell.getText().equals(today))
            {
                cell.click();
                break;
            }
        }

    }

    public void searchIconButton(){
        driver.findElement(searchIcon).click();
    }

    public void searchCandidateText(){
        WebElement search = driver.findElement(searchText);
        search.click();
        search.sendKeys("QA Automation" );
    }

    public void clickVacanciesButton(){
        driver.findElement(activeVacanciesBox).click();
    }

    public void clickSearchCandidateButton(){
        driver.findElement(searchButton).click();

    }

    public void clickCheckBox(){
        driver.findElement(candidateCheckBox).click();
    }

    public void clickThreeDots(){
        driver.findElement(threeDots).click();
    }

    public void clickDeleteCandidate(){
        driver.findElement(deleteCandidate).click();
    }

    public void clickYesDelete(){
        driver.findElement(yesDelete).click();
        driver.navigate().refresh();
    }
}
