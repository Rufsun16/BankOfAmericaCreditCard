package ToolsQAPages;

import org.openqa.selenium.By;

public class RegisterBookStorePage {
    public String  pageUrl = "https://demoqa.com/register";
    public By firstName = new By.ByCssSelector("#firstname");
    public By lastName = new By.ByCssSelector("#lastname");
    public By userName = new By.ByCssSelector("#userName");
    public By password = new By.ByCssSelector("#password");
    public By register = new By.ByCssSelector("#register");

}
