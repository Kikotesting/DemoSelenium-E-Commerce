package basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

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
    public void waitSeconds(int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.withTimeout(Duration.ofSeconds(2));
    }
    public void waitToBeVisible(WebElement element, int seconds) {
        final WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }
    public void waitToBeClickable(WebElement element, int seconds) {
        final WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(element))
        );
    }
    public void waitToBeInvisible(WebElement element, int seconds) {
        final WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public String getTextFromElement(WebElement element) {
        waitToBeVisible(element, 3);
        return element.getText();
    }


/**        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));

        //Fluent wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(15))
            .pollingEvery(Duration.ofSeconds(3))
            .ignoring(NoSuchElementException.class);
 */
}
