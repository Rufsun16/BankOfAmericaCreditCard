package Misc_Exercise;

import Utils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class FileDownload {
    WebDriver driver;
    @BeforeClass
    void setUp(){
        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/download");
    }

    @Test
    void fileDownloadTest() throws InterruptedException {
        WebElement fileLink = driver.findElement(By.cssSelector(".example a:nth-child(2)"));
        fileLink.click();
        Thread.sleep(5000);

        String fileName = fileLink.getText();
        String downloadedFilePath = DriverUtils.initializeProperties().getProperty("downloadFolder") + fileName;
        File downloadedFile = new File(downloadedFilePath);
        Assert.assertTrue(downloadedFile.exists());
        downloadedFile.delete();
    }

    @AfterClass
    void wrapUp(){
        driver.quit();
    }
}
