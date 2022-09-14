package WidgetToolTips;

import ToolsQAPages.ToolQAHomePage;
import ToolsQAPages.WidgetPage;
import ToolsQAPages.Widget_TooltipPage;
import Utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ToolTipTest {
    WebDriver driver;
    Widget_TooltipPage tooltipPage;
    ToolQAHomePage toolQAHomePage;
    WidgetPage widgetPage;

    @BeforeClass
    void setUp() {
        tooltipPage = new Widget_TooltipPage();
        toolQAHomePage = new ToolQAHomePage();
        widgetPage = new WidgetPage();

        driver = DriverUtils.getWebDriver();
        driver.manage().window().maximize();
        driver.get(toolQAHomePage.pageURL);
        DriverUtils.scrollAndClick(driver, toolQAHomePage.widgets);
        DriverUtils.scrollAndClick(driver, widgetPage.toolTips);
    }

    @Test
    void testTooltip() throws InterruptedException {
        Thread.sleep(5000);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(tooltipPage.hoverButton));
        actions.click().build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipPage.toolTip));

        Assert.assertEquals(element.getText(), "You hovered over the Button");
        Thread.sleep(5000);
    }

    @AfterClass
    void wrapUp() {
        driver.quit();
    }
}

