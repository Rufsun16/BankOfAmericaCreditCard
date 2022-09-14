package Misc_Exercise;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class JsAlertTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
    }

    @Test
    void alertBoxTest() throws InterruptedException {
        driver.findElement(By.cssSelector("#alertButton")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("#timerAlertButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15000));
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("#confirmButton")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.cssSelector("#confirmResult")).getText().contains("Ok"));

        driver.findElement(By.cssSelector("#confirmButton")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(driver.findElement(By.cssSelector("#confirmResult")).getText().contains("Cancel"));

        driver.findElement(By.cssSelector("#promtButton")).click();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("#promptResult")).getText().contains("Hello"));
    }

    @AfterClass
    void wrapUp(){
        driver.quit();
    }
}
