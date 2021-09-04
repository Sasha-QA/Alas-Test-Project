package page;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class DemoqaTask {

    public WebDriver driver;

    public By googleSearchField = By.name("q");
    public By firstSearchResult = By.cssSelector("div[class='TbwUpd NJjxre'] cite[class='iUh30 Zu0yb tjvcx']");
public By demoqaInteractions = By.xpath("//h5[normalize-space()='Interactions']");
public By demoqaDroppableButton = By.xpath("//span[normalize-space()='Droppable']");
public By dropHereBox = By.xpath("//div[@id='simpleDropContainer']//p[contains(text(),'Drop here')]");
public By dragMeBox = By.id("draggable");
public By widgetSection = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > span:nth-child(1) > div:nth-child(1)");
public By toolTips = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(7)");
public By hoverToSeeMeField = By.id("toolTipTextField");


    public DemoqaTask(WebDriver driver){
        this.driver=driver;
    }
    public void enterDemoqaInSearch(){
        WebElement googleSearch = driver.findElement(googleSearchField);
        googleSearch.click();
        googleSearch.sendKeys("demoqa");
        googleSearch.sendKeys(Keys.ENTER);
}
public void clickOnFirstResult(){
        driver.findElement(firstSearchResult).click();
}
public void clickInteractions(){
    JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement interactions = driver.findElement(demoqaInteractions);
    js.executeScript("arguments[0].scrollIntoView();", interactions);
    interactions.click();
}
public void chooseDropabbleOption(){
    WebElement droppable = driver.findElement(demoqaDroppableButton);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", droppable);
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    droppable.click();
}
public void moveDragMeToDropHere(){
    WebElement dragMe = driver.findElement(dragMeBox);
    WebElement dropHere = driver.findElement(dropHereBox);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", dragMe);
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    Actions builder = new Actions(driver);
    Action dragAndDrop = builder.clickAndHold(dragMe).moveToElement(dropHere).release(dropHere).build();
    dragAndDrop.perform();
}
public void takeAScreenshot(){
    TakesScreenshot scr = ((TakesScreenshot) driver);

    File file = scr.getScreenshotAs(OutputType.FILE);

    try {
        FileUtils.copyFile(file, new File("./slika/Skrinsott.jpg"));
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void clickWidgets(){
        WebElement widget = driver.findElement(widgetSection);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", widget);
        widget.click();
}
public void clickToolTips(){
        WebElement tool = driver.findElement(toolTips);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", tool);
    tool.click();
}
public void enterTextInHoverToSeeMeField(){
        WebElement field = driver.findElement(hoverToSeeMeField);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", field);
        field.click();
        field.sendKeys("Sale je zensko");
        String text = field.getText();
        System.out.println(text);
}

}
