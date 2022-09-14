package BofACreditCardApplyPageTest;

import BofACreditCardApplyPage.CreditCardPage;
import Utils.BaseMethod;
import Utils.DriverUtils;
import Utils.ExcelUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

public class CreditCardApplyTest extends BaseMethod {
    WebDriver driver;
    CreditCardPage creditCardPage;
    WebDriverWait wait;
    static final String ExcelFilePath = System.getProperty("user.dir") + "/resource/ExcelFile/SmallDataSet.xlsx";

    @BeforeClass
    void setUp() throws InterruptedException {
        driver = DriverUtils.getWebDriver();
        DriverUtils.setTimeout(driver, 10000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        creditCardPage = new CreditCardPage();
        driver.manage().window().maximize();
    }

    @DataProvider(name = "loadFormData")
    public static Object[][] dataLoad() throws Exception {
        return ExcelUtil.ExcelUtils.getTableArray(ExcelFilePath, "Small Data Set");
    }

    @Test(dataProvider = "loadFormData")
    void applyNowForm(double id,String firstName,String name,String gender,String DOB,String SSN,String phone,String email) throws Exception {
        driver.get(creditCardPage.pageUrl);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(creditCardPage.applyNow));
        element.click();

        DriverUtils.scrollToElementBySelector(driver, creditCardPage.firstName);
        driver.findElement(creditCardPage.firstName).sendKeys(firstName);
        driver.findElement(creditCardPage.lastName).sendKeys(name);
        DriverUtils.scrollToElementBySelector(driver, creditCardPage.address);
        Faker faker = new Faker(new Locale("en-US"));
        driver.findElement(creditCardPage.address).sendKeys(faker.address().buildingNumber() + " West Ave");
        driver.findElement(creditCardPage.city).sendKeys(faker.address().city());
        driver.findElement(creditCardPage.state).sendKeys(faker.address().state());
        String state = driver.findElement(creditCardPage.state).getAttribute("data-val");
        Thread.sleep(2000);
        driver.findElement(creditCardPage.zipCode).sendKeys(faker.address().zipCodeByState(state).substring(0, 5));
        Thread.sleep(2000);
        driver.findElement(creditCardPage.phoneNumber).sendKeys(phone);
        Thread.sleep(1000);
        DriverUtils.clickUsingJS(driver, driver.findElement(creditCardPage.phoneNumberType));
        driver.findElement(creditCardPage.phoneNumberType).click();
        Thread.sleep(1000);
        driver.findElement(creditCardPage.email).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(creditCardPage.saveAndContinue).click();
        Thread.sleep(3000);

        DriverUtils.clickUsingJS(driver, driver.findElement(creditCardPage.yesUSCitizen));
        Thread.sleep(1000);
        driver.findElement(creditCardPage.SSN).sendKeys(SSN);
        Thread.sleep(1000);
        driver.findElement(creditCardPage.dualCitizenNo).click();
        Thread.sleep(1000);
        selectByVisibleText(driver.findElement(creditCardPage.countryOfResidence), "United States");
        Thread.sleep(1000);
        driver.findElement(creditCardPage.dateOfBirth).sendKeys(DOB);
        Thread.sleep(2000);
        driver.findElement(creditCardPage.saveAndContinue).click();
        Thread.sleep(3000);

        DriverUtils.scrollToElementBySelector(driver, creditCardPage.employmentStatus);
        selectByVisibleText(driver.findElement(creditCardPage.employmentStatus), "Employed");
        Thread.sleep(1000);
        selectByVisibleText(driver.findElement(creditCardPage.occupation), "Engineer");
        Thread.sleep(1000);
        driver.findElement(creditCardPage.totalAnnualIncome).sendKeys(faker.numerify("120000"));
        Thread.sleep(1000);
        selectByVisibleText(driver.findElement(creditCardPage.sourceOfIncome), "Employment");
        Thread.sleep(1000);
        driver.findElement(creditCardPage.monthlyHousingPayment).sendKeys(faker.numerify("1600"));
        Thread.sleep(2000);
        driver.findElement(creditCardPage.saveAndContinue).click();
        Thread.sleep(5000);

        DriverUtils.clickUsingJS(driver, driver.findElement(creditCardPage.termsAndConditions));
        Thread.sleep(5000);
        DriverUtils.scrollAndClick(driver, creditCardPage.saveAndContinue);
        Thread.sleep(3000);

        String reviewInformation = driver.findElement(creditCardPage.reviewInformationText).getText();
        Assert.assertTrue(reviewInformation.contains("Review your information"));
        Thread.sleep(3000);
    }

    @AfterClass
    void wrapUp() {
        driver.quit();
    }
}
