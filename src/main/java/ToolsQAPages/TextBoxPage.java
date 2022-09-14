package ToolsQAPages;

import org.openqa.selenium.By;

public class TextBoxPage extends ElementsPage {
    public By fullName = new By.ByCssSelector("#userName");
    public By email = new By.ByCssSelector("#userEmail");
    public By currentAddress = new By.ByCssSelector("#currentAddress");
    public By permanentAddress = new By.ByCssSelector("#permanentAddress");
    public By textBoxSubmit = new By.ByCssSelector("#submit");
    public By textBoxSubmittedItem = new By.ByCssSelector(".border");
}
