package Assignment6TextBox;

import ToolsQAPages.ElementsPage;
import ToolsQAPages.TextBoxPage;
import Utils.DriverUtils;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

public class TextBoxPageTest {
    WebDriver driver;
    ElementsPage elementsPage;
    TextBoxPage textBox;

    @BeforeClass
    void setUp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        elementsPage = new ElementsPage();
        driver.get(elementsPage.pageURL);
    }

    @Test
    void textBox() {
        textBox = new TextBoxPage();
        Faker faker = new Faker(new Locale("en-US"));
        driver.findElement(elementsPage.elements).click();
        driver.findElement(elementsPage.textBox).click();
        DriverUtils.scrollAndClick(driver, textBox.fullName);
        String fullName = faker.name().fullName();
        driver.findElement(textBox.fullName).sendKeys(fullName);
        driver.findElement(textBox.email).sendKeys(faker.name().username() + "007@gmail.com");
        driver.findElement(textBox.currentAddress).sendKeys(faker.address().fullAddress());
        driver.findElement(textBox.permanentAddress).sendKeys(faker.address().fullAddress());
        driver.findElement(textBox.textBoxSubmit).click();
        String submittedItem = driver.findElement(textBox.textBoxSubmittedItem).getText();
        Assert.assertTrue(submittedItem.contains(fullName));
        Assert.assertFalse(submittedItem.isEmpty());
    }

    @AfterClass
    void wrapUp() {
        driver.quit();
    }
}
