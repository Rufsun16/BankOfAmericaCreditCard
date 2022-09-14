package ToolsQAPages;

import org.openqa.selenium.By;

public class LoginPage {
    public String pageUrl = "https://demoqa.com/login";
    public String bookPageUrl = ("https://demoqa.com/books");
    public String profilePageUrl = "https://demoqa.com/profile";
    public By userName = new By.ByCssSelector("#userName");
    public By password = new By.ByCssSelector("#password");
    public By  logInButton = new By.ByCssSelector("#login");
    public By logInLogo = new By.ByCssSelector(".pattern-backgound.playgound-header");
    public By bookStore = new By.ByCssSelector(".element-group:nth-child(6) #item-2");
    public By addToYourCollection = new By.ByCssSelector(".text-right.fullButton");
    public By booksData = new By.ByCssSelector(".mr-2");
    public By addCartBody = new By.ByCssSelector(".rt-tbody");
}
