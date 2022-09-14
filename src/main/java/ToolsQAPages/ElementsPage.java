package ToolsQAPages;

import org.openqa.selenium.By;

public class ElementsPage extends ToolQAHomePage {
    public By textBox  = new By.ByCssSelector(".element-group:nth-child(1) #item-0");
    public By checkBox = new By.ByCssSelector(".element-group:nth-child(1) #item-1");
    public By radioButton = new By.ByCssSelector(".element-group:nth-child(1) #item-2");
    public By WebTables = new By.ByCssSelector(".element-group:nth-child(1) #item-3");
    public By Buttons = new By.ByCssSelector(".element-group:nth-child(1) #item-4");
    public By Links = new By.ByCssSelector(".element-group:nth-child(1) #item-5");
    public By BrokenLinks = new By.ByCssSelector(".element-group:nth-child(1) #item-6");
    public By UploadAndDownload = new By.ByCssSelector(".element-group:nth-child(1) #item-7");
    public By DynamicProperties = new By.ByCssSelector(".element-group:nth-child(1) #item-8");
}
