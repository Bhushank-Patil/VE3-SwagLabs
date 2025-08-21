package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor for Page Objects
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Initialize ChromeDriver with Password Manager disabled
    public static WebDriver initializeDriver() {
        ChromeOptions options = new ChromeOptions();

        // Disable Google Password Manager pop-up
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    // Click method with explicit wait
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    // Type method with explicit wait
    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    // Get text method with explicit wait
    protected String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}
