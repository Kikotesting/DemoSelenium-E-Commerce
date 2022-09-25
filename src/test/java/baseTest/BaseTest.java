package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    @BeforeAll
    static void beforeAllTests(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void beforeEachTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
    }
    @AfterEach
    void afterEachTests() throws IOException {
        driver.manage().deleteAllCookies();
        takeScreenshot();
        driver.quit();
    }
    void takeScreenshot() throws IOException {
        TakesScreenshot camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        File pathScreenshot = new File(screenshot.getAbsolutePath());
        File pathProject = new File("resources/screenshots");

        System.out.println("Screenshot taken: "+screenshot.getAbsolutePath());
        FileUtils.copyFileToDirectory(pathScreenshot,pathProject);
    }
}
