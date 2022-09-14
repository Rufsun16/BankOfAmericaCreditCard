package Assignment6TextBox;

import Utils.DriverUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.Locale;

public class ToolsQA {
    static WebDriver driver;

    @BeforeClass
    void setup(){
        DriverUtils.setChromePath();
        driver = new ChromeDriver();
        DriverUtils.setTimeout(driver,10000);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
    }

    @Test (priority = 1)
    void testTitle(){

        Assert.assertEquals(driver.getTitle(),"ToolsQA");
    }

    @Test (priority = 2)
    void testLogo(){
        WebElement el = driver.findElement((By.cssSelector("#app header a img")));
        Assert.assertTrue(el.isDisplayed());
    }

    @Test (priority = 3)
    void validateFooter(){
        WebElement el = driver.findElement(By.cssSelector("footer span"));
        String footerText = el.getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("TOOLSQA.COM"));
    }

    @Test (priority = 4)
    void navigateToElementMenu() throws InterruptedException {
        driver.findElement(By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1)")).click();
        Thread.sleep(6000);
        driver.findElement(By.cssSelector(".element-group:first-child li:first-child")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    void textBoxForm() throws InterruptedException {
        Faker faker = new Faker(new Locale("en-US"));
        String fullName = faker.name().fullName();
        driver.findElement(By.cssSelector("#userName")).sendKeys(fullName);
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(faker.name().username() + "@gmail.com" );
        String curAddress = faker.address().fullAddress();
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys(curAddress);
        String parAddress = faker.address().fullAddress();
        driver.findElement(By.cssSelector("#permanentAddress")).sendKeys(parAddress);
        DriverUtils.scrollAndClick(driver,By.cssSelector("submit"));
      //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("@submit")))
      //driver.findElement(By.cssSelector("#submit")).click();
        String submittedItems = driver.findElement(By.cssSelector(".border")).getText();
        Thread.sleep(5000);
        System.out.println(submittedItems);
        Assert.assertFalse(submittedItems.isEmpty());
        Assert.assertTrue(submittedItems.contains(fullName));
    }

    @AfterClass
    void wrapUp(){
        driver.quit();
    }
}
