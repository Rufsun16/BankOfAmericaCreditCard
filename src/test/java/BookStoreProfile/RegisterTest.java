package BookStoreProfile;

import ToolsQAPages.RegisterBookStorePage;
import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterTest extends RegisterBookStorePage {
    WebDriver driver;
    RegisterBookStorePage registerBookStorePage;

    @BeforeClass
    void setUp(){
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        registerBookStorePage = new RegisterBookStorePage();
        driver.get(registerBookStorePage.pageUrl);
    }

    @Test
    void registerItems() throws InterruptedException{
        DriverUtils.scrollToElementBySelector(driver,registerBookStorePage.register);
        WebElement register = driver.findElement(registerBookStorePage.register);
        register.click();

        test(registerBookStorePage.firstName);
        test(registerBookStorePage.lastName);
        test(registerBookStorePage.userName);
        test(registerBookStorePage.password);
    }
    void test (By selector) throws InterruptedException{
        WebElement firstName = driver.findElement(selector);
        Assert.assertTrue(firstName.getAttribute("class").contains("invalid"));
        Thread.sleep(1000);
    }

    @AfterClass
    void wrapUp(){
        driver.quit();
    }
}
