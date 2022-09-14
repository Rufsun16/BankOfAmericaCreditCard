package BookStoreProfile;

import ToolsQAPages.LoginPage;
import Utils.DriverUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LogInTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    void setUp() {
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage();
        driver.get(loginPage.pageUrl);
    }

    @Test(priority = 1)
    void boxField() throws InterruptedException {
        String userName = DriverUtils.initializeProperties().getProperty("userName");
        String password = DriverUtils.initializeProperties().getProperty("password");
        driver.findElement(loginPage.userName).sendKeys(userName);
        driver.findElement(loginPage.password).sendKeys(password);
        driver.findElement(loginPage.logInButton).click();
        Thread.sleep(1000);

        WebElement profile = driver.findElement(loginPage.logInLogo);
        Assert.assertTrue(profile.isDisplayed());
    }

    @Test(priority = 2)
    void bookStorePage() throws InterruptedException {
        DriverUtils.scrollAndClick(driver, loginPage.bookStore);
        Thread.sleep(2000);

        List<WebElement> elements = driver.findElements(loginPage.booksData);
        Faker faker = new Faker();
        int num = faker.random().nextInt(0,elements.size()-1);
        DriverUtils.scrollToElement(driver, elements.get(num));
        String randomBookName = elements.get(num).getText();
        elements.get(num).click();
        Thread.sleep(2000);

        DriverUtils.scrollAndClick(driver, loginPage.addToYourCollection);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        driver.get(loginPage.profilePageUrl);
        String allBookName =driver.findElement(loginPage.addCartBody).getText();
        Assert.assertTrue(allBookName.contains(randomBookName));
    }

    @Test(priority = 3)
    void checkAddList() throws InterruptedException {
        driver.get(loginPage.bookPageUrl);
        List<WebElement> elements = driver.findElements(loginPage.booksData);
        DriverUtils.scrollToElement(driver, elements.get(elements.size()-1));
        elements.get(elements.size() - 1).click();

        DriverUtils.scrollAndClick(driver, loginPage.addToYourCollection);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        driver.get(loginPage.profilePageUrl);
        elements = driver.findElements(loginPage.booksData);
        Assert.assertEquals(elements.size(),2);
    }

    @AfterClass
    void wrapUp() {
        driver.quit();
    }
}
