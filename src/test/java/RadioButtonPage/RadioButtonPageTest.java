package RadioButtonPage;

import ToolsQAPages.ElementsPage;
import ToolsQAPages.RadioButtonPage;
import Utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtonPageTest {
    WebDriver driver;
    ElementsPage elementsPage;
    RadioButtonPage radioButton;

    @BeforeClass
    void setup() throws InterruptedException {
        elementsPage = new ElementsPage();
        radioButton = new RadioButtonPage();

        driver = WebDriverManager.chromedriver().create();
        DriverUtils.setTimeout(driver, 10000);
        driver.manage().window().maximize();
        driver.get(elementsPage.pageURL);
        driver.findElement(elementsPage.elements).click();
        driver.findElement(elementsPage.radioButton).click();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    void yesRadio() {
        WebElement yes = driver.findElement(radioButton.yesRadio);
        if (yes.isEnabled()) {
            DriverUtils.clickUsingJS(driver,yes);
            Assert.assertTrue(driver.findElement(radioButton.textSuccess).getText().equals("Yes"));
        }
    }

    @Test(priority = 2)
    void impressiveRadio() {
        WebElement impressive = driver.findElement(radioButton.impressive);
        if (impressive.isEnabled()) {
            DriverUtils.clickUsingJS(driver,impressive);
            Assert.assertTrue(driver.findElement(radioButton.textSuccess).getText().equals("Impressive"));
        }
    }

    @Test(priority = 3)
    void noRadio() {
        WebElement noRadio = driver.findElement(radioButton.noRadio);
        System.out.println(noRadio.isEnabled());
        Assert.assertFalse(noRadio.isEnabled());
    }

    @AfterClass
    void wrapUp() {
        driver.quit();
    }
}
