package basePage;

import custom.Highlighter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    //Wait elements
    public void waitToBeVisible(WebElement element, int seconds) {
        final WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }
    public void waitToBeClickable(WebElement element, int seconds) {
        final WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element))
        );
    }
    public void waitToBeInvisible(WebElement element, int seconds) {
        final WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void pauseSeconds(Integer seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Get something
    public String getTextFromElement(WebElement element) {
        waitToBeVisible(element, 10);
        return element.getText();
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public void getListElements(WebElement element){
        List<WebElement> links = element.findElements(By.tagName("li"));
        for (int i = 0; i < links.size(); i++){
            Highlighter.highlightElement(driver,links.get(i));
        }
    }
    public void clickOptionFromList(WebElement element,String option){
        List<WebElement> links = element.findElements(By.tagName("i"));
        for (int i = 0; i < links.size(); i++){
            if (links.get(i).getText().equals(option)) {
                System.out.println(links.get(i).getText());
                links.get(i).click();
            }
        }
    }
    public void getOptionFromList(WebElement element,String option){
        List<WebElement> links = element.findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++){
            if (links.get(i).getText().equals(option)) {
                System.out.println(links.get(i).getText());
            }
        }
    }


    //Scroll elements
    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollToPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,arguments[0])",pixels);
    }
    public void scrollEndPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    //Select elements
    public Select selectElement(WebElement element){
        return new Select(element);
    }
    public void selectOptionFromDropdown(WebElement element, String option){
        selectElement(element).getOptions().contains(option);
    }
    public void selectByVisibleTextElement(WebElement element, String valueText){
        selectElement(element).selectByVisibleText(valueText);
    }
    public void selectByValueElement(WebElement element, String value){
        selectElement(element).selectByValue(value);
    }
    public void selectByIndexElement(WebElement element, int index){
        selectElement(element).selectByIndex(index);
    }

    //Hover element
    public void hoverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    public void hoverElementClick(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }

    //Input Fields
    public void setTextToField(WebElement element, String text){
        isElementDisplayed(element);
        element.clear();
        element.sendKeys(text);
    }
}
