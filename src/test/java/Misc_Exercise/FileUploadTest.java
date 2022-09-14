package Misc_Exercise;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;
    @BeforeClass
    void setUp(){
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    @Test
    void fileUploadTest() throws InterruptedException {
        WebElement fileUpload = driver.findElement(By.cssSelector("#file-upload"));
        String absolutePath = System.getProperty("user.dir") + "/resource/SHARKSTeamPicture.jpg";
        fileUpload.sendKeys(absolutePath);
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#file-submit")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#uploaded-files")).getText().contains("SHARKSTeamPicture.jpg"));
        Thread.sleep(5000);
    }

    @AfterClass
    void wrapUp(){
        driver.quit();
    }
}
