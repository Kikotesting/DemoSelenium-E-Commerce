package custom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Highlighter {
    public static void highlightElement(WebDriver browser, WebElement element)
    {
        JavascriptExecutor javascript=(JavascriptExecutor)browser;

        javascript.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid black;');", element);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        javascript.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
    }
}
