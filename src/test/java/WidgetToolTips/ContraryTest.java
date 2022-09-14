package WidgetToolTips;

import ToolsQAPages.ToolQAHomePage;
import ToolsQAPages.WidgetPage;
import ToolsQAPages.Widget_TooltipPage;
import Utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContraryTest {
    WebDriver driver;
    Widget_TooltipPage tooltipPage;
    ToolQAHomePage toolQAHomePage;
    WidgetPage widgetPage;

    @BeforeClass
    void setUp() {
        toolQAHomePage = new ToolQAHomePage();
        widgetPage = new WidgetPage();
        tooltipPage = new Widget_TooltipPage();

        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get(toolQAHomePage.pageURL);
        DriverUtils.scrollAndClick(driver, toolQAHomePage.widgets);
        DriverUtils.scrollAndClick(driver, widgetPage.toolTips);
    }

    @Test
    void contrary() throws InterruptedException {
        tooltipPage = new Widget_TooltipPage();
        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        DriverUtils.scrollToElementBySelector(driver, tooltipPage.contrary);
        actions.moveToElement(driver.findElement(tooltipPage.contrary));
        actions.click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String element = wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipPage.toolTip)).getText();

        Assert.assertTrue(element.contains("You hovered over the Contrary"));
        Thread.sleep(5000);
    }

    @AfterClass
    void wrapUp() {
        driver.quit();
    }
}
