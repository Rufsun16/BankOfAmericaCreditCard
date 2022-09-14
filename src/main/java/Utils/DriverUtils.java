package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class DriverUtils {
    public DriverUtils() {
    }

    public static Properties prop;

    public static void setChromePath() {
        System.setProperty("webdriver.chrome.driver", "Resource//chromedriver.exe");
    }

    public static ChromeOptions enableChromeIncognito() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--incognito");
        DesiredCapabilities d = new DesiredCapabilities();
        d.setCapability(ChromeOptions.CAPABILITY, option);
        return option.merge(d);
    }

    public static void scrollAndClick(WebDriver driver, By cssSelector) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(cssSelector));
        driver.findElement(cssSelector).click();
    }

    public static void scrollToElementBySelector(WebDriver driver, By cssSelector) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(cssSelector));
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void zoomInOrOut(WebDriver driver, double percentageInDecimal) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = ' " + percentageInDecimal + " ' ");
    }

    public static void clickUsingJS(WebDriver driver, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void setTimeout(WebDriver d, int ms) {
        //This timeout is used to specify the amount of time the driver
        // should wait while searching for an element if it is not immediately present.
        d.manage().timeouts().implicitlyWait(Duration.ofMillis(ms));

        //This is used to set the amount of time the WebDriver must wait for an asynchronous
        // script to finish execution before throwing an error.
        d.manage().timeouts().scriptTimeout(Duration.ofMillis(ms));

        //This sets the time to wait for a page to load completely before throwing an error.
        // If the timeout is negative, page loads can be indefinite.
        d.manage().timeouts().pageLoadTimeout(Duration.ofMillis(ms));
    }

    public static Properties initializeProperties() {
        if (prop != null)
            return prop;
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("demoqa.properties");
            prop.load(ip);
        } catch (Exception e) {
            System.out.println("Exception occurred during config initialization. " + e.getMessage());
            Reporter.log("Failed to load properties file. Error: " + e.getMessage());
        }
        return prop;
    }

    public static WebDriver getWebDriver() {
        if (prop == null)
            initializeProperties();
        String browser = prop.getProperty("browser");
        WebDriver driver;
        if (browser == null || browser.equalsIgnoreCase("Chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browser.equalsIgnoreCase("headless")) {
            System.out.println("Setting headless browser");
            var chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1280,800");
            chromeOptions.addArguments("--allow-insecure-localhost");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = WebDriverManager.safaridriver().create();
        } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("mozilla")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = WebDriverManager.edgedriver().create();
        } else {
            driver = WebDriverManager.chromedriver().create();
        }
        return driver;
    }

}
