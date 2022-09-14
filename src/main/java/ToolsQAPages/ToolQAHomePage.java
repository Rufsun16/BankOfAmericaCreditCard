package ToolsQAPages;

import org.openqa.selenium.By;

public class ToolQAHomePage {
    public String pageURL = "https://demoqa.com";
    public By elements = new By.ByCssSelector(".top-card:nth-child(1)");
    public By Forms = new By.ByCssSelector(".top-card:nth-child(2)");
    public By AlertsFrameWindows = new By.ByCssSelector(".top-card:nth-child(3)");
    public By widgets = new By.ByCssSelector(".top-card:nth-child(4)");
    public By interactions = new By.ByCssSelector(".top-card:nth-child(5)");
    public By BookStoreApplication = new By.ByCssSelector(".top-card:nth-child(6)");
    public By pageLogo = new By.ByCssSelector("header img");
    public By pageFooter = new By.ByCssSelector("footer span");

}
