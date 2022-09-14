package PracticeFormPage;

import Utils.DriverUtils;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Locale;

public class PracticeFormPageTest {
    static WebDriver driver;

    @BeforeClass
    void setUp() {
        driver = WebDriverManager.chromiumdriver().create();
        DriverUtils.setTimeout(driver, 10000);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        DriverUtils.scrollAndClick(driver, By.cssSelector(".top-card:nth-child(2)"));
        DriverUtils.scrollAndClick(driver, By.cssSelector(".element-group:nth-child(2) .btn"));
    }

    @Test
    void formPage() throws InterruptedException {
        Faker faker = new Faker(new Locale("en-US"));
        driver.findElement(By.cssSelector("#firstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.cssSelector("#lastName")).sendKeys(faker.name().lastName());
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(faker.name().username() + "@gmail.com");
        driver.findElement(By.cssSelector("#genterWrapper .custom-control:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#genterWrapper .custom-control:nth-child(2)")).click();
        driver.findElement(By.cssSelector("#genterWrapper .custom-control:nth-child(3)")).click();
        driver.findElement(By.cssSelector("#userNumber")).sendKeys(faker.phoneNumber().cellPhone());
        WebElement dob = driver.findElement(By.cssSelector("#dateOfBirthInput"));
        Date d = faker.date().birthday(20, 30);
        dob.sendKeys(faker.numerify(d.toString()));
        //  driver.findElement(By.cssSelector("#subjectsContainer")).sendKeys(faker.name().name());
        driver.findElement(By.cssSelector("#hobbiesWrapper .custom-control:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#hobbiesWrapper .custom-control:nth-child(2)")).click();
        driver.findElement(By.cssSelector("#hobbiesWrapper .custom-control:nth-child(3)")).click();
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.cssSelector("#stateCity-wrapper #state .css-1wy0on6")).click();
        driver.findElement(By.cssSelector("#stateCity-wrapper #city .css-1wy0on6")).click();

        Thread.sleep(6000);
    }

    @AfterClass
    void wrapUp() {
        driver.quit();
    }

}

