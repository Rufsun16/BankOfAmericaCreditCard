package ToolsQAPages;

import org.openqa.selenium.By;

public class InteractionsPage extends ToolQAHomePage {
    public By sortable = new By.ByCssSelector(".element-group:nth-child(5) #item-0");
    public By selectable = new By.ByCssSelector(".element-group:nth-child(5) #item-1");
    public By resizable = new By.ByCssSelector(".element-group:nth-child(5) #item-2");
    public By droppable = new By.ByCssSelector(".element-group:nth-child(5) #item-3");
    public By dragabble = new By.ByCssSelector(".element-group:nth-child(5) #item-4");

}
