package InteractionPage;

import Utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectableListPageTest {
    static WebDriver driver;

    @BeforeClass
    void setup() {
        // DriverUtils.setChromePath();
        driver = WebDriverManager.chromedriver().create();
        DriverUtils.setTimeout(driver, 10000);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        DriverUtils.scrollAndClick(driver, By.cssSelector(".top-card:nth-child(5)"));
        DriverUtils.scrollAndClick(driver, By.cssSelector(".element-group:nth-child(5) #item-1"));
        driver.findElement(By.cssSelector("#demo-tab-list")).click();
    }

    @Test
    void testList() throws InterruptedException {
        test("#verticalListContainer :nth-child(1)");
        test("#verticalListContainer :nth-child(2)");
        test("#verticalListContainer :nth-child(3)");
        test("#verticalListContainer :nth-child(4)");
    }

    void test(String selector) throws InterruptedException {
        WebElement el = driver.findElement(By.cssSelector(selector));
        el.click();
        Thread.sleep(500);
        Assert.assertTrue(el.getAttribute("class").contains("active"));
        Thread.sleep(500);
        el.click();
        Assert.assertFalse(el.getAttribute("class").contains("active"));
        Thread.sleep(500);
    }

    @AfterClass
    void wrapUp() {
        driver.quit();
    }
}
