package InteractionPage;

import ToolsQAPages.InteractionsPage;
import ToolsQAPages.Selectable_GridPage;
import ToolsQAPages.SelectablePage;
import ToolsQAPages.ToolQAHomePage;
import Utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectableGridPageTest {
    WebDriver driver;
    ToolQAHomePage homePage;
    InteractionsPage interaction;
    SelectablePage selectablePage;
    Selectable_GridPage selectableGridPage;

    @BeforeClass
    void setup() throws InterruptedException {
        homePage = new ToolQAHomePage();
        interaction = new InteractionsPage();
        selectablePage = new SelectablePage();
        selectableGridPage = new Selectable_GridPage();

        driver = WebDriverManager.chromedriver().create();
        DriverUtils.setTimeout(driver, 10000);
        driver.manage().window().maximize();
        driver.get(homePage.pageURL);
        driver.findElement(homePage.interactions).click();
        driver.findElement(interaction.selectable).click();
        driver.findElement(selectablePage.selectableGrid).click();
    }

    @Test
    void testGrid() throws InterruptedException {
        testABox(selectableGridPage.one);
        testABox(selectableGridPage.two);
        testABox(selectableGridPage.three);

        testABox(selectableGridPage.four);
        testABox(selectableGridPage.five);
        testABox(selectableGridPage.six);

        testABox(selectableGridPage.seven);
        testABox(selectableGridPage.eight);
        testABox(selectableGridPage.nine);
    }

    void testABox(By selector) throws InterruptedException {
        WebElement box = driver.findElement(selector);
        box.click();
        Thread.sleep(500);
        Assert.assertTrue(box.getAttribute("class").contains("active"));
        box.click();
        Thread.sleep(500);
        Assert.assertFalse(box.getAttribute("class").contains("active"));
        Thread.sleep(500);
    }

    @AfterClass
    void wrapUp() {
        driver.quit();
    }
}
